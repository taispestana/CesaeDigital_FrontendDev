import React, { useState, useContext, useEffect } from "react";
import { Form, Button } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../contexts/AuthContext";
import "./LoginPage.css";

// Componente para a página de Login de Clientes
export default function LoginPage() {
  const navigate = useNavigate(); // Hook para navegação programática
  const { login } = useContext(AuthContext); // Obtém a função de login do contexto de autenticação

  // Estado para os dados do formulário
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  // Estado para armazenar erros de validação
  const [errors, setErrors] = useState({});
  // Estado para controlar o redirecionamento de administradores
  const [isRedirecting, setIsRedirecting] = useState(false);

  // Efeito para gerenciar o timer de redirecionamento
  useEffect(() => {
    let timer;
    if (isRedirecting) {
      timer = setTimeout(() => {
        navigate('/admin-login'); // Redireciona para o login de admin após 3 segundos
      }, 3000);
    }
    return () => clearTimeout(timer); // Limpa o timer se o componente for desmontado
  }, [isRedirecting, navigate]);

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
        const success = await login(authData); // Tenta fazer login
        if (success) {
          navigate("/", { state: { message: "Login realizado com sucesso!" } }); // Redireciona para a home em caso de sucesso
        }
      } catch (error) {
        // Se for um erro de redirecionamento de admin, exibe mensagem e inicia o timer
        if (error.code === 'ADMIN_USER_REDIRECT') {
          setErrors({ api: "É um administrador. A redirecionar para a página de login correta..." });
          setIsRedirecting(true);
        } else {
          // Exibe outros erros de login
          setErrors({ api: error.message || "Login falhou! Ocorreu um erro inesperado." });
        }
      }
    }
  };

  return (
    <div className="login-container">
      <div className="login-form-wrapper">
        <h1>Login</h1>
        {/* O atributo noValidate desativa a validação HTML5 padrão do navegador,
            permitindo que o React Bootstrap e nossa lógica de validação controlem os erros. */}
        <Form onSubmit={handleSubmit} noValidate>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Endereço de Email</Form.Label>
            <Form.Control
              type="email"
              placeholder="Digite o seu email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              isInvalid={!!errors.email} // Marca o campo como inválido se houver erro
              disabled={isRedirecting} // Desabilita o campo durante o redirecionamento
              autoComplete="off" // Tenta desativar o preenchimento automático do navegador
            />
            {/* Exibe a mensagem de feedback de validação */}
            <Form.Control.Feedback type="invalid">{errors.email}</Form.Control.Feedback>
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Senha</Form.Label>
            <Form.Control
              type="password"
              placeholder="Senha"
              name="password"
              value={formData.password}
              onChange={handleChange}
              isInvalid={!!errors.password} // Marca o campo como inválido se houver erro
              disabled={isRedirecting} // Desabilita o campo durante o redirecionamento
            />
            {/* Exibe a mensagem de feedback de validação */}
            <Form.Control.Feedback type="invalid">{errors.password}</Form.Control.Feedback>
          </Form.Group>

          {/* Exibe erros gerais da API, se houver */}
          {errors.api && (
            <p className="text-danger text-center">{errors.api}</p>
          )}

          <Button variant="primary" type="submit" className="w-100 login-button" disabled={isRedirecting}>
            {isRedirecting ? "A redirecionar..." : "Login"} {/* Texto do botão muda durante o redirecionamento */}
          </Button>
        </Form>

        <p className="mt-3 text-center">
          Não está registado? <Link to="/signup">Registe-se aqui</Link>
        </p>
      </div>
    </div>
  );
}
