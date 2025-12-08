import "./App.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import FollowOrdersPage from "./pages/FollowOrdersPage";
import SignUpPage from "./pages/SignUpPage";
import OrderPage from "./pages/OrderPage";
import AdminLoginPage from "./pages/AdminLoginPage";
import AdminHomePage from "./pages/AdminHomePage";
import AdminKitchenPage from "./pages/AdminKitchenPage";
import AdminManagerPage from "./pages/AdminManagerPage";

import RootLayout from "./components/layouts/RootLayout";
import ErrorPage from "./pages/ErrorPage";
import "bootstrap/dist/css/bootstrap.min.css";
import { AuthProvider } from "./contexts/AuthContext";
import ProtectedRoute from "./protectedRoutes/ProtectedRoute";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    errorElement: <ErrorPage />,
    children: [
      // Rotas Públicas
      { index: true, element: <HomePage /> },
      { path: "/login", element: <LoginPage /> },
      { path: "/signup", element: <SignUpPage /> },
      { path: "/admin-login", element: <AdminLoginPage /> },

      // Rotas Protegidas para Consumidor
      {
        element: <ProtectedRoute allowedRoles={["customer"]} />,
        children: [
          { path: "/order", element: <OrderPage /> },
          { path: "/follow-order", element: <FollowOrdersPage /> },
        ],
      },

      // Rotas Protegidas para  Administrador (Cozinha e Gestor)
      {
        element: <ProtectedRoute allowedRoles={["manager", "kitchen"]} />, // Protects routes for admins/kitchen
        children: [
          { path: "/admin-homepage", element: <AdminHomePage /> },
          { path: "/admin-kitchen", element: <AdminKitchenPage /> },
          { path: "/admin-manager", element: <AdminManagerPage /> },
        ],
      },
    ],
  },
]);

function App() {
  return (
    <AuthProvider>
      <RouterProvider router={router} />
    </AuthProvider>
  );
}
export default App;
