import { useState, createContext } from "react";

// Cria o contexto de autenticação que será usado em toda a aplicação
export const AuthContext = createContext();
 
// Provedor de autenticação que gerencia o estado do usuário logado
export const AuthProvider = ({ children }) => {
  // Estado do usuário, inicializado a partir do localStorage para persistência
  const [user, setUser] = useState(() => {
    const storedUser = localStorage.getItem('user');
    return storedUser ? JSON.parse(storedUser) : null;
  });

  // Função de login para usuários comuns (clientes)
  const login = async (authData) => {
    // Envia credenciais para o endpoint de login
    const response = await fetch("http://localhost:3000/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(authData),
    });
 
    if (!response.ok) {
      const errorData = await response.json();
      throw new Error(errorData.message || "Falha na autenticação.");
    }
 
    const data = await response.json();

    // Verifica se o usuário é um administrador e lança um erro específico para redirecionamento
    if (data.role === 'kitchen' || data.role === 'manager') {
      const adminError = new Error("Utilizador administrador detectado. A redirecionar...");
      adminError.code = 'ADMIN_USER_REDIRECT'; // Código customizado para identificar este erro
      throw adminError;
    }

    // Garante que apenas clientes possam logar por este caminho
    if (data.role !== 'customer') {
      throw new Error("Acesso negado. Este login é apenas para clientes.");
    }

    // Salva os dados do usuário autenticado (email, nome, role)
    const authenticatedUser = { email: authData.email, name: data.name, role: data.role };
    setUser(authenticatedUser);
    localStorage.setItem('user', JSON.stringify(authenticatedUser)); // Persiste no localStorage
    return true;
  };

  // Função de login para administradores (cozinha ou gerente)
  const adminLogin = async (authData) => {
    // Usa o mesmo endpoint de login, mas com validação de role diferente
    const response = await fetch("http://localhost:3000/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(authData),
    });

    if (!response.ok) {
      const errorData = await response.json();
      throw new Error(errorData.message || "Falha na autenticação.");
    }

    const data = await response.json();

    // Garante que apenas usuários com role 'kitchen' ou 'manager' possam logar
    if (data.role !== 'kitchen' && data.role !== 'manager') {
      throw new Error("Acesso negado. Você não tem privilégios de administrador.");
    }

    // Salva os dados do usuário administrador autenticado
    const authenticatedUser = { email: authData.email, name: data.name, role: data.role };
    setUser(authenticatedUser);
    localStorage.setItem('user', JSON.stringify(authenticatedUser));
    return true;
  };
 
  // Função de logout que limpa o estado do usuário e o localStorage
  const logout = () => {
    setUser(null);
    localStorage.removeItem('user');
  };
 
  return (
    <AuthContext.Provider value={{ user, login, adminLogin, logout }}>
      {children}
    </AuthContext.Provider>
  );
};