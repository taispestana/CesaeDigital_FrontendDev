import React, { useState, useEffect } from "react";
import { Form, Button } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import "./SignUpPage.css";

// Componente para a página de Registo de Novos Utilizadores
export default function SignUpPage() {
  // Estado para os dados do formulário de registo
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    confirmPassword: "",
  });

  // Estado para armazenar erros de validação
  const [errors, setErrors] = useState({});
  // Estado para controlar o redirecionamento após o registo bem-sucedido
  const [isRedirecting, setIsRedirecting] = useState(false);
  const navigate = useNavigate(); // Hook para navegação programática

  // Efeito para gerenciar o timer de redirecionamento após o registo
  useEffect(() => {
    let timer;
    if (isRedirecting) {
      timer = setTimeout(() => {
        navigate('/login'); // Redireciona para a página de login após 3 segundos
      }, 3000);
    }
    return () => clearTimeout(timer); // Limpa o timer se o componente for desmontado
  }, [isRedirecting, navigate]);

  // Função para validar os dados do formulário
  const validate = () => {
    let newErrors = {};
    // Regex para validação de email
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (!formData.name) newErrors.name = "Nome é obrigatório.";
    if (!formData.email) {
      newErrors.email = "Email é obrigatório.";
    } else if (!emailRegex.test(formData.email)) {
      newErrors.email = "Email inválido."; // Mensagem de erro para email inválido
    }
    if (!formData.password) {
      newErrors.password = "Senha é obrigatória.";
    } else if (formData.password.length < 6) {
      newErrors.password = "A senha deve ter pelo menos 6 caracteres.";
    }
    if (!formData.confirmPassword) {
      newErrors.confirmPassword = "Confirmação de senha é obrigatória.";
    } else if (formData.confirmPassword !== formData.password) {
      newErrors.confirmPassword = "As senhas não coincidem.";
    }

    setErrors(newErrors); // Atualiza o estado de erros
    return Object.keys(newErrors).length === 0; // Retorna true se não houver erros
  };

  // Lida com a mudança nos campos do formulário
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
    // Limpa o erro do campo atual quando o usuário começa a digitar novamente
    if (errors[name]) setErrors((prevErrors) => ({ ...prevErrors, [name]: null }));
  };

  // Lida com o envio do formulário de registo
  const handleSubmit = async (event) => {
    event.preventDefault(); // Previne o comportamento padrão de recarregar a página
    if (validate()) { // Se a validação passar
      try {
        const user = {
          name: formData.name,
          email: formData.email.toLowerCase(), // Converte email para minúsculas antes de enviar
          password: formData.password,
          role: 'customer', // Define a role padrão como 'customer'
        };

        const response = await fetch("http://localhost:3000/signup", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(user),
        });

        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.message || "Falha no registo.");
        }

        setErrors({}); // Limpa erros anteriores
        setIsRedirecting(true); // Inicia o redirecionamento

      } catch (error) {
        setErrors({ api: error.message }); // Exibe erros da API
      }
    }
  };

  return (
    <div className="signup-container">
      <div className="signup-form-wrapper">
        <h1>Registo</h1>
        {isRedirecting ? (
          // Exibe mensagem de sucesso e redirecionamento
          <div className="text-center">
            <p className="text-success">Utilizador registado com sucesso!</p>
            <p>A redirecionar para a página de login...</p>
          </div>
        ) : (
          // Formulário de registo
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="formName">
              <Form.Label>Nome</Form.Label>
              <Form.Control
                type="text"
                placeholder="Digite o seu nome"
                name="name"
                value={formData.name}
                onChange={handleChange}
                isInvalid={!!errors.name} // Marca o campo como inválido se houver erro
              />
              <Form.Control.Feedback type="invalid">{errors.name}</Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3" controlId="formEmail">
              <Form.Label>Endereço de Email</Form.Label>
              <Form.Control
                type="email"
                placeholder="Digite o seu email"
                name="email"
                value={formData.email}
                onChange={handleChange}
                isInvalid={!!errors.email} // Marca o campo como inválido se houver erro
              />
              <Form.Control.Feedback type="invalid">{errors.email}</Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3" controlId="formPassword">
              <Form.Label>Senha</Form.Label>
              <Form.Control
                type="password"
                placeholder="Senha"
                name="password"
                value={formData.password}
                onChange={handleChange}
                isInvalid={!!errors.password} // Marca o campo como inválido se houver erro
              />
              <Form.Control.Feedback type="invalid">{errors.password}</Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3" controlId="formConfirmPassword">
              <Form.Label>Confirme a Senha</Form.Label>
              <Form.Control
                type="password"
                placeholder="Confirme a sua senha"
                name="confirmPassword"
                value={formData.confirmPassword}
                onChange={handleChange}
                isInvalid={!!errors.confirmPassword} // Marca o campo como inválido se houver erro
              />
              <Form.Control.Feedback type="invalid">{errors.confirmPassword}</Form.Control.Feedback>
            </Form.Group>

            {errors.api && <p className="text-danger text-center">{errors.api}</p>}

            <Button variant="primary" type="submit" className="w-100 signup-button">
              Registar
            </Button>

            <p className="mt-3 text-center">
              Já tem uma conta? <Link to="/login">Faça login aqui</Link>
            </p>
          </Form>
        )}
      </div>
    </div>
  );
}
