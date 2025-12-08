import React, { useContext } from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { AuthContext } from '../contexts/AuthContext';

const ProtectedRoute = ({ allowedRoles }) => {
  const { user } = useContext(AuthContext);

  if (!user) {
    // User not authenticated, redirect to login page
    return <Navigate to="/login" replace />;
  }

  if (allowedRoles && !allowedRoles.includes(user.role)) {
    // User authenticated but not authorized, redirect to unauthorized page or home
    return <Navigate to="/" replace />; // Or a specific unauthorized page
  }

  // User is authenticated and authorized, render the child routes
  return <Outlet />;
};

export default ProtectedRoute;
