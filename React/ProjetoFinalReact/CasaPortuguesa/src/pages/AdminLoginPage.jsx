import React, { useState, useContext } from "react";
import { Form, Button } from "react-bootstrap";
import { useNavigate, Navigate } from "react-router-dom";
import { AuthContext } from "../contexts/AuthContext";
import "./AdminLoginPage.css";

// Componente para a página de Login de Administradores
export default function AdminLoginPage() {
  const navigate = useNavigate(); // Hook para navegação programática
  // Obtém o objeto 'user' e a função 'adminLogin' do contexto de autenticação
  const { user, adminLogin } = useContext(AuthContext);

  // Se um administrador já estiver logado, redireciona-o para a página inicial do admin
  // Isso evita que um admin logado permaneça na tela de login
  if (user && (user.role === 'kitchen' || user.role === 'manager')) {
    return <Navigate to="/admin-homepage" replace />;
  }

  // Estado para os dados do formulário
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  // Estado para armazenar erros de validação
  const [errors, setErrors] = useState({});

  // Função para validar os dados do formulário
  const validate = () => {
    let newErrors = {};
    // Regex mais robusta para validação de email
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (!formData.email) newErrors.email = "Email é obrigatório.";
    else if (!emailRegex.test(formData.email)) newErrors.email = "O email deve ser um email válido.";

    if (!formData.password) newErrors.password = "Senha é obrigatória.";
    else if (formData.password.length < 6) newErrors.password = "A senha deve ter pelo menos 6 caracteres.";

    setErrors(newErrors); // Atualiza o estado de erros
    return Object.keys(newErrors).length === 0; // Retorna true se não houver erros
  };

  // Lida com a mudança nos campos do formulário
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
    // Limpa o erro do campo atual quando o usuário começa a digitar novamente
    if (errors[name]) {
      setErrors((prevErrors) => ({ ...prevErrors, [name]: null }));
    }
  };

  // Lida com o envio do formulário
  const handleSubmit = async (event) => {
    event.preventDefault(); // Previne o comportamento padrão de recarregar a página
    if (validate()) { // Se a validação passar
      try {
        const authData = {
          email: formData.email.toLowerCase(), // Converte email para minúsculas antes de enviar
          password: formData.password,
        };
        const success = await adminLogin(authData); // Tenta fazer login de administrador
        if (success) {
          navigate('/admin-homepage', { state: { message: "Login de administrador bem-sucedido!" } }); // Redireciona para a home do admin
        }
      } catch (error) {
        // Exibe erros de login
        setErrors({ api: error.message || "Login falhou! Ocorreu um erro inesperado." });
      }
    }
  };

  return (
    <div className="admin-login-container">
      <div className="admin-login-form-wrapper">
        <h1>Login de Administrador</h1>
        {/* O atributo noValidate desativa a validação HTML5 padrão do navegador,
            permitindo que o React Bootstrap e nossa lógica de validação controlem os erros. */}
        <Form onSubmit={handleSubmit} noValidate>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Endereço de Email</Form.Label>
            <Form.Control
              type="email"
              placeholder="Digite o seu email de administrador"
              name="email"
              value={formData.email}
              onChange={handleChange}
              isInvalid={!!errors.email} // Marca o campo como inválido se houver erro
              autoComplete="off" // Tenta desativar o preenchimento automático do navegador
            />
            {/* Exibe a mensagem de feedback de validação */}
            <Form.Control.Feedback type="invalid">{errors.email}</Form.Control.Feedback>
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Senha</Form.Label>
            <Form.Control
              type="password"
              placeholder="Senha de administrador"
              name="password"
              value={formData.password}
              onChange={handleChange}
              isInvalid={!!errors.password} // Marca o campo como inválido se houver erro
            />
            {/* Exibe a mensagem de feedback de validação */}
            <Form.Control.Feedback type="invalid">{errors.password}</Form.Control.Feedback>
          </Form.Group>

          {/* Exibe erros gerais da API, se houver */}
          {errors.api && <p className="text-danger text-center">{errors.api}</p>}

          <Button variant="primary" type="submit" className="w-100 admin-login-button">
            Login
          </Button>
        </Form>
      </div>
    </div>
  );
}
