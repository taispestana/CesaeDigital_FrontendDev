import { Container } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { useState, useEffect, useCallback, useContext } from "react";
import { AuthContext } from "../contexts/AuthContext";
import Dishes from "../components/dishes/Dishes";
import SelectedDishesList from "../components/selected-dishes/SelectedDishesList";
import { updateUserDishes, fetchUserDishes } from "../https";

import "./OrderPage.css";

// Componente para a página de criação de pedidos
export default function OrderPage() {
  // Obtém o objeto 'user' do contexto de autenticação
  const { user } = useContext(AuthContext);

  // Estados para armazenar os pratos disponíveis por categoria
  const [availableStarters, setAvailableStarters] = useState([]);
  const [availableDesserts, setAvailableDesserts] = useState([]);
  const [availableDishes, setAvailableDishes] = useState([]);
  // Estado para armazenar os pratos selecionados pelo usuário (carrinho)
  const [userDishes, setUserDishes] = useState([]);
  // Estado para controlar o carregamento
  const [isLoading, setIsLoading] = useState(false);
  // Estado para armazenar mensagens de erro
  const [error, setError] = useState();
  // Estado para controlar qual prato tem a descrição expandida
  const [expandedDishId, setExpandedDishId] = useState(null);

  // Efeito para buscar todos os pratos disponíveis do backend ao montar o componente
  useEffect(() => {
    async function getAvailableDishes() {
      setIsLoading(true);
      try {
        const response = await fetch("http://localhost:3000/dishes");
        const resData = await response.json();
        // Filtra os pratos por categoria e atualiza os estados
        setAvailableStarters(resData.dishes.filter(item => item.category === "entrada") || []);
        setAvailableDishes(resData.dishes.filter(item => item.category === "principal") || []);
        setAvailableDesserts(resData.dishes.filter(item => item.category === "sobremesa") || []);
      } catch (error) {
        setError({ message: error.message || "Não foi possível carregar os pratos." });
      }
      setIsLoading(false);
    }
    getAvailableDishes();
  }, []); // Executa apenas uma vez ao montar

  // Função memoizada para buscar o carrinho do usuário do backend
  const getUserDishes = useCallback(async () => {
    if (!user?.email) return; // Não busca se o usuário não estiver logado
    setIsLoading(true);
    try {
      const dishes = await fetchUserDishes(user.email);
      // Garante que cada prato no carrinho tenha uma propriedade 'quantity' (padrão 1)
      const dishesWithQuantity = dishes.map(dish => ({ ...dish, quantity: dish.quantity || 1 }));
      setUserDishes(dishesWithQuantity);
    } catch (error) {
      setError({ message: error.message || "Não foi possível carregar o carrinho." });
    } finally {
      setIsLoading(false);
    }
  }, [user]); // Recria a função apenas se o objeto 'user' mudar

  // Efeito para buscar o carrinho do usuário ao montar ou quando 'getUserDishes' muda
  useEffect(() => {
    getUserDishes();
  }, [getUserDishes]);

  // Efeito para atualizar o carrinho do usuário no backend sempre que 'userDishes' mudar
  useEffect(() => {
    // Só atualiza se não estiver carregando e o usuário estiver logado
    if (!isLoading && user?.email) {
      updateUserDishes(userDishes, user.email);
    }
  }, [userDishes, isLoading, user]);

  // Lida com a expansão/colapso da descrição de um prato
  function handleToggleDescription(dishId) {
    setExpandedDishId((prevId) => (prevId === dishId ? null : dishId));
  }

  // Lida com a seleção de um prato para adicionar ao carrinho
  function handleSelectDish(selectedDish) {
    setUserDishes((prevDishes) => {
      const existingDish = prevDishes.find((dish) => dish.id === selectedDish.id);
      if (existingDish) {
        // Se o prato já existe, incrementa a quantidade
        return prevDishes.map((dish) =>
          dish.id === selectedDish.id ? { ...dish, quantity: dish.quantity + 1 } : dish
        );
      } else {
        // Se o prato não existe, adiciona-o com quantidade 1
        return [{ ...selectedDish, quantity: 1 }, ...prevDishes];
      }
    });
  }

  // Lida com a diminuição da quantidade de um prato no carrinho
  function handleDecreaseQuantity(dishId) {
    setUserDishes((prevDishes) => {
      const existingDish = prevDishes.find((dish) => dish.id === dishId);
      if (existingDish && existingDish.quantity > 1) {
        // Diminui a quantidade se for maior que 1
        return prevDishes.map((dish) =>
          dish.id === dishId ? { ...dish, quantity: dish.quantity - 1 } : dish
        );
      } else {
        // Se a quantidade for 1, remove o prato do carrinho
        return prevDishes.filter((dish) => dish.id !== dishId);
      }
    });
  }

  // Lida com o aumento da quantidade de um prato no carrinho
  function handleIncreaseQuantity(dishId) {
    setUserDishes((prevDishes) => {
      return prevDishes.map((dish) =>
        dish.id === dishId ? { ...dish, quantity: dish.quantity + 1 } : dish
      );
    });
  }

  // Lida com a remoção completa de um prato do carrinho
  function handleRemoveDishes(dishId) {
    setUserDishes((prevDishes) => prevDishes.filter((dish) => dish.id !== dishId));
  }

  // Exibe mensagem de erro se houver
  if (error) {
    return <div className="error"><h2>Erro!</h2><p>{error.message}</p></div>;
  }

  return (
    <Container className="order-container">
      <div>
        <h1>Página de Criação de Pedido</h1>
        <p>Escolha a melhor combinação para o seu pedido</p>
      </div>
      <main className="order-main-content">
        <div className="available-dishes-section">
          {/* Componentes Dishes para cada categoria, passando as props de manipulação */}
          <Dishes
            title="Entradas"
            dishes={availableStarters}
            onSelectDish={handleSelectDish}
            expandedDishId={expandedDishId}
            onToggleDescription={handleToggleDescription}
          />
          <Dishes
            title="Pratos Principais"
            dishes={availableDishes}
            onSelectDish={handleSelectDish}
            expandedDishId={expandedDishId}
            onToggleDescription={handleToggleDescription}
          />
          <Dishes
            title="Sobremesas"
            dishes={availableDesserts}
            onSelectDish={handleSelectDish}
            expandedDishId={expandedDishId}
            onToggleDescription={handleToggleDescription}
          />
        </div>
        <div className="selected-dishes-sidebar">
          {/* Componente SelectedDishesList (carrinho), passando as props de manipulação */}
          <SelectedDishesList
            dishes={userDishes}
            onRemoveDish={handleRemoveDishes}
            onDecrease={handleDecreaseQuantity}
            onIncrease={handleIncreaseQuantity}
            isLoading={isLoading}
            userEmail={user?.email}
          />
        </div>
      </main>
    </Container>
  );
}
