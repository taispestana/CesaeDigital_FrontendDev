import React from 'react';
import './SelectedDishesList.css';
import { useNavigate } from "react-router-dom";
import { placeOrder } from "../../https";

// Componente de ícone SVG para a lixeira
const TrashIcon = () => (
  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" className="bi bi-trash3-fill" viewBox="0 0 16 16">
    <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5m-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5M4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06m3.5.013l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06m3.5-.014l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06"/>
  </svg>
);

// Componente para exibir a lista de pratos selecionados (carrinho)
export default function SelectedDishesList({
  dishes, // Lista de pratos no carrinho (com quantidade)
  onRemoveDish, // Função para remover um prato
  onDecrease, // Função para diminuir a quantidade de um prato
  onIncrease, // Função para aumentar a quantidade de um prato
  fallbackText, // Texto a ser exibido se o carrinho estiver vazio
  isLoading, // Indica se os dados estão sendo carregados
  loadingText, // Texto de carregamento
  userEmail, // Email do usuário logado para fazer o pedido
}) {
  const navigate = useNavigate(); // Hook para navegação programática

  // Formatador de preço para moeda EUR
  const priceFormatter = new Intl.NumberFormat("pt-PT", {
    style: "currency",
    currency: "EUR",
  });

  // Calcula o valor total do pedido, considerando a quantidade de cada prato
  const totalAmount = dishes.reduce((total, dish) => total + parseFloat(dish.price) * dish.quantity, 0);

  // Lida com a ação de fazer o pedido
  async function handlePlaceOrder() {
    if (dishes.length === 0) {
      alert("Por favor, selecione alguns itens antes de confirmar o pedido.");
      return;
    }

    try {
      // Envia os itens do carrinho (com quantidades) e o total para o backend
      await placeOrder({ items: dishes, total: totalAmount }, userEmail);
      alert("Pedido realizado com sucesso!");
      navigate("/follow-order"); // Redireciona para a página de acompanhamento de pedidos
    } catch (error) {
      alert(error.message || "Falha ao realizar o pedido. Tente novamente.");
    }
  }

  return (
    <div className="selected-dishes-list">
      <h2>Opções Selecionadas</h2>
      {isLoading && <p className="fallback-text">{loadingText}</p>}
      {!isLoading && (!dishes || dishes.length === 0) && (
        <p className="fallback-text">{fallbackText}</p>
      )}
      {!isLoading && dishes && dishes.length > 0 && (
        <ul>
          {dishes.map((dish) => (
            <li key={dish.id} className="selected-dish-item">
              <div className="item-info">
                <img
                  src={`http://localhost:3000/${dish.image.src.replace("backend/","")}`}
                  alt={dish.image.alt}
                />
                <div className="item-details">
                  <h3>{dish.title}</h3>
                  <p>{priceFormatter.format(dish.price)}</p>
                </div>
              </div>
              <div className="item-actions">
                {/* Controles de quantidade (+/-) */}
                <div className="quantity-controls">
                  <button onClick={() => onDecrease(dish.id)}>-</button>
                  <span>{dish.quantity}</span>
                  <button onClick={() => onIncrease(dish.id)}>+</button>
                </div>
                {/* Botão de remover item (ícone de lixeira) */}
                <button
                  className="btn-remove"
                  onClick={() => onRemoveDish(dish.id)}
                >
                  <TrashIcon />
                </button>
              </div>
            </li>
          ))}
        </ul>
      )}
      <div className="selected-dishes-summary">
        <p>Total: <span>{priceFormatter.format(totalAmount)}</span></p>
        <button className="btn btn--primary" onClick={handlePlaceOrder}>Confirmar Pedido</button>
      </div>
    </div>
  );
}
