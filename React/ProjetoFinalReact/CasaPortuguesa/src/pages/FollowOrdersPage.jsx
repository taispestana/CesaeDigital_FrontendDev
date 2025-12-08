import React, { useState, useEffect, useCallback, useContext } from 'react';
import { Container } from "react-bootstrap";
import { AuthContext } from '../contexts/AuthContext';
import './FollowOrdersPage.css';
import { fetchOrders } from '../https';

// Componente para a página de acompanhamento de pedidos do cliente
export default function FollowOrdersPage() {
  // Obtém o objeto 'user' do contexto de autenticação para verificar o login
  const { user } = useContext(AuthContext);
  const [orders, setOrders] = useState([]); // Estado para armazenar os pedidos do usuário
  const [isLoading, setIsLoading] = useState(true); // Estado para controlar o carregamento
  const [error, setError] = useState(null); // Estado para armazenar mensagens de erro

  // Função memoizada para buscar os pedidos do usuário
  const getOrders = useCallback(async () => {
    // Se o usuário não estiver logado (sem email), exibe uma mensagem de erro
    if (!user?.email) {
      setError({ message: "Precisa estar autenticado para ver os seus pedidos." });
      setIsLoading(false);
      return;
    }

    setIsLoading(true); // Inicia o estado de carregamento
    setError(null); // Limpa erros anteriores
    try {
      // Busca os pedidos do backend usando o email do usuário logado
      const fetchedOrders = await fetchOrders(user.email);
      // Ordena os pedidos por data de criação (mais recente primeiro)
      const sortedOrders = fetchedOrders.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt));
      setOrders(sortedOrders); // Atualiza o estado com os pedidos ordenados
    } catch (err) {
      setError({ message: err.message || "Não foi possível carregar os seus pedidos." });
    } finally {
      setIsLoading(false); // Finaliza o estado de carregamento
    }
  }, [user]); // A função é recriada apenas se o objeto 'user' mudar

  // Efeito para buscar os pedidos quando o componente é montado ou 'getOrders' muda
  useEffect(() => {
    getOrders();
  }, [getOrders]);

  // Determina a classe CSS para o status do pedido na linha do tempo
  const getStatusClass = (orderStatus, currentStatus) => {
    const statuses = ["Criado", "Confecção", "Entregue"];
    const orderIndex = statuses.indexOf(orderStatus); // Posição do status atual do pedido
    const currentIndex = statuses.indexOf(currentStatus); // Posição do status na linha do tempo

    // Se o status na linha do tempo já foi alcançado ou ultrapassado, marca como 'active'
    return currentIndex <= orderIndex ? "active" : "";
  };

  return (
    <Container className="follow-orders-container">
      <h1>Acompanhamento de Pedidos</h1>
      {error && <p className="error-message">{error.message}</p>}

      {isLoading && <p className="loading-message">A carregar pedidos...</p>}

      {/* Exibe mensagem se não houver pedidos e não estiver carregando nem com erro */}
      {!isLoading && !error && orders.length === 0 && (
        <p className="no-orders-message">Ainda não fez nenhum pedido.</p>
      )}

      {/* Renderiza a lista de pedidos se não estiver carregando nem com erro */}
      {!isLoading && !error && (
        <div className="orders-list">
          {orders.map((order) => (
            <div key={order.id} className="order-card">
              <div className="order-header">
                <h3>Pedido #{order.id}</h3>
                <p>Total: €{order.total.toFixed(2)}</p>
              </div>
              <div className="order-items">
                <h4>Itens:</h4>
                <ul>
                  {order.items.map((item) => (
                    <li key={item.id}>
                      {item.title} (x{item.quantity}) - €{(item.price * item.quantity).toFixed(2)} {/* Exibe quantidade e preço total do item */}
                    </li>
                  ))}
                </ul>
              </div>
              <div className="order-timeline">
                {/* Linha do tempo do status do pedido */}
                <div className={`timeline-step ${getStatusClass(order.status, "Criado")}`}>
                  <div className="timeline-icon"></div>
                  <p>Criado</p>
                </div>
                <div className={`timeline-step ${getStatusClass(order.status, "Confecção")}`}>
                  <div className="timeline-icon"></div>
                  <p>Confecção</p>
                </div>
                <div className={`timeline-step ${getStatusClass(order.status, "Entregue")}`}>
                  <div className="timeline-icon"></div>
                  <p>Entregue</p>
                </div>
              </div>
              <p className="order-date">Data do Pedido: {new Date(order.createdAt).toLocaleString()}</p>
            </div>
          ))}
        </div>
      )}
    </Container>
  );
}
