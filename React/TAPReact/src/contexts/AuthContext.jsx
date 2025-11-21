import { useState, createContext, useEffect } from "react";

export const AuthContext = createContext();
 
export const AuthProvider = ({ children }) => {
  // Inicializa o estado 'user' a partir do localStorage
  const [user, setUser] = useState(() => {
    const storedUser = localStorage.getItem('user');
    return storedUser ? JSON.parse(storedUser) : null;
  });

 
  const login = async (authData) => {
    console.log(authData)
    const response = await fetch("http://localhost:3000/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(authData),
    });
 
    if (!response.ok) {
      throw new Error("Failed to authenticate");
    }
 
    const data = await response.json(); // O backend retorna { name: ..., role: ... }
    const authenticatedUser = { name: data.name, role: data.role };
    setUser(authenticatedUser);
    localStorage.setItem('user', JSON.stringify(authenticatedUser)); // Guarda o utilizador no localStorage
    return true;
  };
 
  const logout = () => {
    setUser(null);
    localStorage.removeItem('user'); // Remove o utilizador do localStorage
  };
 
  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};