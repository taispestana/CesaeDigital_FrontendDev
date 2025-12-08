import { useState, useContext } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Header.css";
import { AuthContext } from "../contexts/AuthContext";

// Componente do cabeçalho da aplicação
export function Header() {
  const [isOpen, setIsOpen] = useState(false); // Estado para controlar a abertura do menu mobile
  const location = useLocation(); // Hook para obter informações sobre a URL atual
  const navigate = useNavigate(); // Hook para navegação programática
  // Obtém o objeto 'user' e a função 'logout' do contexto de autenticação
  const { user, logout } = useContext(AuthContext);

  // Verifica se a rota atual está na área administrativa
  const isAdminPath = location.pathname.startsWith("/admin");
  // Verifica se a rota atual é a página de login de administrador
  const isAdminLoginPage = location.pathname === "/admin-login";
  // Verifica se um cliente está logado
  const isCustomerLoggedIn = user && user.role === 'customer';
  // Verifica se um administrador (cozinha ou gerente) está logado
  const isAdminLoggedIn = user && (user.role === 'kitchen' || user.role === 'manager');

  // Alterna o estado de abertura do menu mobile
  const toggle = () => setIsOpen(!isOpen);

  // Lida com a ação de logout
  const handleLogout = () => {
    logout(); // Chama a função de logout do contexto
    // Redireciona para a página de login apropriada após o logout
    navigate(isAdminPath ? "/admin-login" : "/");
    if(isOpen) toggle(); // Fecha o menu mobile se estiver aberto
  };

  // Define o destino do link "Início" com base na área atual
  const homeLinkTarget = isAdminPath ? "/admin-homepage" : "/";

  return (
    <nav className="navbar navbar-expand-lg navbar-light navbar-portuguesa fixed-top">
      <div className="container-fluid">
        <div className="container-image">
          {/* Link do logo que leva para a página inicial apropriada */}
          <Link to={homeLinkTarget} className="navbar-brand">
            <img
              src="/src/assets/images/logo.png"
              alt="Casa Portuguesa Logo"
              className="navbar-logo-img"
            />
          </Link>
        </div>

        {/* Botão do menu mobile (hamburger) */}
        <button
          className="navbar-toggler"
          type="button"
          onClick={toggle}
          aria-controls="navbarNav"
          aria-expanded={isOpen}
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div
          className={`collapse navbar-collapse ${isOpen ? "show" : ""}`}
          id="navbarNav"
        >
          <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
            {/* Link "Início":
                - Sempre visível em páginas de cliente.
                - Visível em páginas de admin APENAS se um admin estiver logado E NÃO for a página de login de admin. */}
            {(!isAdminPath || (isAdminLoggedIn && !isAdminLoginPage)) && (
              <li className="nav-item">
                <Link to={homeLinkTarget} className="nav-link" onClick={toggle}>
                  Início
                </Link>
              </li>
            )}

            {/* Links para a área do cliente */}
            {!isAdminPath && (
              <>
                {isCustomerLoggedIn && (
                  <>
                    <li className="nav-item">
                      <Link to="/order" className="nav-link" onClick={toggle}>
                        Fazer Pedido
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link to="/follow-order" className="nav-link" onClick={toggle}>
                        Pedidos
                      </Link>
                    </li>
                  </>
                )}
                <li className="nav-item">
                  {isCustomerLoggedIn ? (
                    <button className="nav-link" onClick={handleLogout}>
                      Sair
                    </button>
                  ) : (
                    <Link to="/login" className="nav-link" onClick={toggle}>
                      Entrar
                    </Link>
                  )}
                </li>
              </>
            )}

            {/* Links para a área administrativa */}
            {/* Exibe links de admin APENAS se estiver numa rota admin E NÃO for a página de login de admin */}
            {isAdminPath && !isAdminLoginPage && (
              <>
                {isAdminLoggedIn ? (
                  <>
                    {/* Link "Cozinha" visível apenas para role 'kitchen' */}
                    {user.role === 'kitchen' && (
                      <li className="nav-item">
                        <Link to="/admin-kitchen" className="nav-link" onClick={toggle}>
                          Cozinha
                        </Link>
                      </li>
                    )}
                    {/* Link "Gerir" visível apenas para role 'manager' */}
                    {user.role === 'manager' && (
                      <li className="nav-item">
                        <Link to="/admin-manager" className="nav-link" onClick={toggle}>
                          Gerir
                        </Link>
                      </li>
                    )}
                    <li className="nav-item">
                      <button className="nav-link" onClick={handleLogout}>
                        Sair
                      </button>
                    </li>
                  </>
                ) : (
                  // Se não for admin logado e não for a página de login de admin (situação rara, mas tratada)
                  <li className="nav-item">
                    <Link to="/admin-login" className="nav-link" onClick={toggle}>
                      Login Admin
                    </Link>
                  </li>
                )}
              </>
            )}
          </ul>
        </div>
      </div>
    </nav>
  );
}
