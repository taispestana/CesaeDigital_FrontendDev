import React, { useContext } from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { AuthContext } from '../contexts/AuthContext';

const ProtectedRoute = ({ allowedRoles }) => {
  const { user } = useContext(AuthContext);

  if (!user) {
    // Usuario nao autenticado, redireciona para pagina de login
    return <Navigate to="/login" replace />;
  }

  if (allowedRoles && !allowedRoles.includes(user.role)) {
    // Usuario autenticado mas nao autorizado, redireciona para pagina inicial
    return <Navigate to="/" replace />; 
  }

  // Usuario autenticado e autorizado, renderiza para a rota protegida
  return <Outlet />;
};

export default ProtectedRoute;
