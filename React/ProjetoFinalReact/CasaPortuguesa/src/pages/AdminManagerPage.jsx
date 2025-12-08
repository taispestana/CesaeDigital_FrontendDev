import { Container } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { useState, useEffect, useCallback } from "react";
import NewDishForm from "../components/new-dish/NewDishForm";
import { addNewDish, deleteDish } from "../https"; // Importa funções da API

import "./AdminManagerPage.css";

// Componente para a página de Gerenciamento Administrativo
export default function AdminManagerPage() {
  // Estado para controlar se um prato está sendo adicionado (para desabilitar botões, etc.)
  const [isAddingDish, setIsAddingDish] = useState(false);
  // Estado para armazenar mensagens de erro
  const [error, setError] = useState(null);
  // Estado para armazenar a lista de todos os pratos disponíveis
  const [availableDishes, setAvailableDishes] = useState([]);
  // Estado para controlar o carregamento da lista de pratos
  const [isLoadingDishes, setIsLoadingDishes] = useState(false);
  // Estado para controlar qual aba está ativa ('add' para adicionar, 'manage' para remover)
  const [activeTab, setActiveTab] = useState('add');

  // Função memorizada para buscar todos os pratos do backend
  const fetchAllDishes = useCallback(async () => {
    setIsLoadingDishes(true); // Inicia o carregamento
    try {
      const response = await fetch("http://localhost:3000/dishes");
      const resData = await response.json();
      setAvailableDishes(resData.dishes || []); // Atualiza a lista de pratos
    } catch (err) {
      setError({ message: err.message || "Falha ao carregar a lista de pratos." });
    } finally {
      setIsLoadingDishes(false); // Finaliza o carregamento
    }
  }, []);

  // Efeito para buscar os pratos na montagem e configurar listeners para eventos de atualização
  useEffect(() => {
    fetchAllDishes(); // Busca inicial dos pratos

    // Listeners para atualizar a lista de pratos quando um prato é adicionado ou removido
    const handleDishChange = () => {
      fetchAllDishes();
    };
    window.addEventListener('dishAdded', handleDishChange);
    window.addEventListener('dishRemoved', handleDishChange);

    // Função de limpeza para remover os listeners ao desmontar o componente
    return () => {
      window.removeEventListener('dishAdded', handleDishChange);
      window.removeEventListener('dishRemoved', handleDishChange);
    };
  }, [fetchAllDishes]); // Executa quando fetchAllDishes muda (apenas uma vez, pois é useCallback sem deps)

  // Lida com a adição de um novo prato
  async function handleAddNewDish(newDishData) {
    setIsAddingDish(true); // Inicia o estado de adição
    setError(null); // Limpa erros anteriores
    try {
      await addNewDish(newDishData); // Chama a função da API para adicionar o prato
      alert("Prato adicionado com sucesso!");
      window.dispatchEvent(new Event('dishAdded')); // Dispara evento para atualizar outras partes da app
      setActiveTab('manage'); // Muda para a aba de gerenciar após adicionar
    } catch (err) {
      setError({ message: err.message || "Falha ao adicionar o prato." });
    } finally {
      setIsAddingDish(false); // Finaliza o estado de adição
    }
  }

  // Lida com a remoção de um prato existente
  async function handleRemoveDish(dishId) {
    setError(null); // Limpa erros anteriores
    try {
      await deleteDish(dishId); // Chama a função da API para remover o prato
      alert("Prato removido com sucesso!");
      window.dispatchEvent(new Event('dishRemoved')); // Dispara evento para atualizar outras partes da app
    } catch (err) {
      setError({ message: err.message || "Falha ao remover o prato." });
    }
  }

  return (
    <Container className="admin-manager-container">
      <div>
        <h1>Página de Gestor Admin</h1>
        {error && <p className="error-message">{error.message}</p>} {/* Exibe erros gerais */}
      </div>

      {/* Abas para alternar entre adicionar e remover pratos */}
      <div className="admin-tabs">
        <button
          className={`tab-button ${activeTab === 'add' ? 'active' : ''}`}
          onClick={() => setActiveTab('add')}
        >
          Adicionar Prato
        </button>
        <button
          className={`tab-button ${activeTab === 'manage' ? 'active' : ''}`}
          onClick={() => setActiveTab('manage')}
        >
          Remover Pratos
        </button>
      </div>

      {/* Renderiza o formulário de adicionar prato se a aba 'add' estiver ativa */}
      {activeTab === 'add' && (
        <NewDishForm onAddDish={handleAddNewDish} />
      )}

      {/* Renderiza a seção de remover pratos se a aba 'manage' estiver ativa */}
      {activeTab === 'manage' && (
        <section className="manage-dishes-section">
          <h2>Remover Pratos Existentes</h2>
          {isLoadingDishes && <p>A carregar pratos...</p>}
          {!isLoadingDishes && availableDishes.length === 0 && (
            <p>Nenhum prato disponível para gerenciar.</p>
          )}
          {!isLoadingDishes && availableDishes.length > 0 && (
            <ul className="dish-management-list">
              {availableDishes.map((dish) => (
                <li key={dish.id} className="dish-management-item">
                  <div className="dish-info">
                    <img
                      src={`http://localhost:3000/${dish.image.src.replace("backend/", "")}`}
                      alt={dish.image.alt}
                    />
                    <span>{dish.title} - €{dish.price}</span>
                  </div>
                  <button
                    className="btn btn--remove"
                    onClick={() => handleRemoveDish(dish.id)}
                  >
                    Remover
                  </button>
                </li>
              ))}
            </ul>
          )}
        </section>
      )}
    </Container>
  );
}
