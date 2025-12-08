import React, { useState, useEffect, useCallback } from 'react';
import { Container } from "react-bootstrap";
import './AdminKitchenPage.css';
import { fetchAdminOrders, updateOrderStatus } from '../https';

// Componente para a página da Cozinha Administrativa
export default function AdminKitchenPage() {
  const [orders, setOrders] = useState([]); // Estado para armazenar os pedidos
  const [isLoading, setIsLoading] = useState(true); // Estado para controlar o carregamento
  const [error, setError] = useState(null); // Estado para armazenar mensagens de erro
  const [isInitialLoad, setIsInitialLoad] = useState(true); // Flag para controlar o carregamento inicial

  // Função memoizada para buscar todos os pedidos para a cozinha
  const getAdminOrders = useCallback(async () => {
    // Define isLoading como true apenas no carregamento inicial ou se não houver pedidos
    if (!isInitialLoad && orders.length > 0) {
      // Não é necessário definir isLoading(true) novamente se já carregado e não for o carregamento inicial
    } else {
      setIsLoading(true);
    }
    setError(null); // Limpa erros anteriores
    try {
      const fetchedOrders = await fetchAdminOrders(); // Busca todos os pedidos do backend
      // Ordena os pedidos primeiro por status (Criado, Confecção, Entregue) e depois por ID
      const sortedOrders = fetchedOrders.sort((a, b) => {
        const statusOrder = { "Criado": 1, "Confecção": 2, "Entregue": 3 };
        const statusComparison = statusOrder[a.status] - statusOrder[b.status];

        if (statusComparison === 0) {
          return parseInt(a.id) - parseInt(b.id); // Ordena por ID se o status for o mesmo
        }
        return statusComparison;
      });
      setOrders(sortedOrders); // Atualiza o estado com os pedidos ordenados
    } catch (err) {
      setError({ message: err.message || "Não foi possível carregar os pedidos." });
    } finally {
      setIsLoading(false); // Finaliza o estado de carregamento
      setIsInitialLoad(false); // Marca que o carregamento inicial foi concluído
    }
  }, [isInitialLoad, orders.length]); // A função é recriada apenas se essas dependências mudarem

  // Efeito para buscar os pedidos e configurar um intervalo de atualização
  useEffect(() => {
    getAdminOrders(); // Busca os pedidos na montagem do componente
    const interval = setInterval(getAdminOrders, 10000); // Atualiza os pedidos a cada 10 segundos
    return () => clearInterval(interval); // Limpa o intervalo ao desmontar o componente
  }, [getAdminOrders]);

  // Lida com a atualização do status de um pedido
  const handleUpdateStatus = async (orderId, currentStatus) => {
    let newStatus;
    // Define o próximo status com base no status atual
    if (currentStatus === "Criado") newStatus = "Confecção";
    else if (currentStatus === "Confecção") newStatus = "Entregue";
    else return; // Não faz nada se o status já for "Entregue"

    try {
      await updateOrderStatus(orderId, newStatus); // Atualiza o status no backend
      alert(`Estado do pedido ${orderId} atualizado para ${newStatus}!`);
      getAdminOrders(); // Atualiza a lista de pedidos após a alteração
    } catch (err) {
      setError({ message: err.message || "Falha ao atualizar o estado do pedido." });
    }
  };

  // Retorna a classe CSS apropriada para o status do pedido
  const getStatusClass = (status) => {
    switch (status) {
      case "Criado": return "status-criado";
      case "Confecção": return "status-confeccao";
      case "Entregue": return "status-entregue";
      default: return "";
    }
  };

  // Formatador de preço para moeda EUR
  const priceFormatter = new Intl.NumberFormat("pt-PT", {
    style: "currency",
    currency: "EUR",
  });

  return (
    <Container className="admin-kitchen-container">
      <h1>Pedidos para a Cozinha</h1>
      {error && <p className="error-message">{error.message}</p>}

      {isLoading && orders.length === 0 && <p className="loading-message">A carregar pedidos...</p>}
      {!isLoading && orders.length === 0 && !error && (
        <p className="no-orders-message">Nenhum pedido pendente.</p>
      )}

      <div className="orders-grid">
        {!isLoading && !error && orders.map((order) => (
          <div key={order.id} className={`order-kitchen-card ${getStatusClass(order.status)}`}>
            <div className="order-kitchen-header">
              <h3>Pedido #{order.id}</h3>
              <span className={`order-status ${getStatusClass(order.status)}`}>{order.status}</span>
            </div>
            <p className="order-kitchen-email">Cliente: {order.userEmail}</p>
            <p className="order-kitchen-date">Data: {new Date(order.createdAt).toLocaleString()}</p>
            <div className="order-kitchen-items">
              <h4>Itens:</h4>
              <ul>
                {order.items.map((item) => (
                  // Exibe o título do item e a quantidade
                  <li key={item.id}>{item.title} (x{item.quantity})</li>
                ))}
              </ul>
            </div>
            <p className="order-kitchen-total">Total: {priceFormatter.format(order.total)}</p>
            <div className="order-kitchen-actions">
              {/* Botões de ação para mudar o status do pedido */}
              {order.status === "Criado" && (
                <button
                  className="btn btn--primary"
                  onClick={() => handleUpdateStatus(order.id, order.status)}
                >
                  Mover para Confecção
                </button>
              )}
              {order.status === "Confecção" && (
                <button
                  className="btn btn--primary btn--deliver"
                  onClick={() => handleUpdateStatus(order.id, order.status)}
                >
                  Marcar como Entregue
                </button>
              )}
            </div>
          </div>
        ))}
      </div>
    </Container>
  );
}
