import React, { useContext } from "react";
import { Container, Button } from "react-bootstrap";
import { Link, Navigate } from "react-router-dom";
import { AuthContext } from "../contexts/AuthContext";
import "./AdminHomePage.css";

// Componente para a página inicial da área administrativa
export default function AdminHomePage() {
  // Obtém o objeto 'user' do contexto de autenticação para verificar a role
  const { user } = useContext(AuthContext);

  // Se o usuário não estiver logado ou não tiver uma role de administrador,
  // redireciona para a página de login de administrador.
  if (!user || (user.role !== 'kitchen' && user.role !== 'manager')) {
    return <Navigate to="/admin-login" replace />;
  }

  return (
    <Container fluid className="admin-homepage-container text-center p-0">
      <div className="admin-homepage-content">
        <h1>Bem-vindo {user.name}!</h1> {/* Mensagem de boas-vindas ao administrador */}
        <p className="lead">
          Esta é a página inicial da área administrativa. Utilize o link de navegação abaixo. {/* Mensagem de orientação */}
        </p>
        <div className="admin-navigation-buttons mt-5">
          {/* Botão "Cozinha" visível apenas para usuários com a role 'kitchen' */}
          {user.role === 'kitchen' && (
            <Link to="/admin-kitchen">
              <Button size="lg" className="btn btn--primary admin-btn me-3">
                Cozinha
              </Button>
            </Link>
          )}

          {/* Botão "Gerir" visível apenas para usuários com a role 'manager' */}
          {user.role === 'manager' && (
            <Link to="/admin-manager">
              <Button size="lg" className="btn btn--primary admin-btn">
                Gerir
              </Button>
            </Link>
          )}
        </div>
      </div>
    </Container>
  );
}
