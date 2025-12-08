import { Carousel, Button, Container } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "../contexts/AuthContext";
import "./HomePage.css";

// Componente para a página inicial da aplicação
export default function HomePage() {
  const navigate = useNavigate(); // Hook para navegação programática
  // Obtém o objeto 'user' do contexto de autenticação para verificar o status de login
  const { user } = useContext(AuthContext);
  // Verifica se um cliente está logado
  const isCustomerLoggedIn = user && user.role === 'customer';

  // Lida com o clique no botão "Faça o seu pedido"
  const handleOrderClick = () => {
    if (isCustomerLoggedIn) {
      navigate("/order"); // Se logado, vai para a página de pedidos
    } else {
      navigate("/login"); // Se não logado, vai para a página de login
    }
  };

  return (
    <Container fluid className="homepage-container text-center p-0">
      <div className="carousel-wrapper">
        {/* Carrossel de imagens */}
        <Carousel fade controls={false}>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src="./../../backend/images/entrada1.png"
              alt="Entrada de pão com azeitonas da casa"
            />
          </Carousel.Item>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src="./../../backend/images/prato3.png"
              alt="Bifinhos ao Molho de Vinho do Porto"
            />
          </Carousel.Item>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src="./../../backend/images/sobremesa2.png"
              alt="Sobremesa de sericaia com doce de ameixa"
            />
          </Carousel.Item>
        </Carousel>
        <div className="carousel-caption-center">
          <h1>Bem-vindo à Casa Portuguesa</h1>
        </div>
      </div>

      <div className="cta-section mt-5">
        <p className="lead mb-4">
          Na Casa Portuguesa, celebramos o sabor, a tradição e o conforto de uma
          verdadeira casa portuguesa. Aqui, cada prato é preparado com
          ingredientes frescos, receitas autênticas e aquele toque de afeto que
          transforma a refeição em memória. Sinta-se em casa e saboreie o
          melhor da gastronomia nacional.
        </p>
        <h2 className="title-portuguese">Encomende os nossos pratos</h2>
        {/* Botão "Faça o seu pedido" com lógica condicional de navegação */}
        <Button size="lg" className="mt-3 btn-red-portuguesa" onClick={handleOrderClick}>
          Faça o seu pedido
        </Button>

        <div className="about-us-section mt-5">
          <h3 className="title-portuguese">🍽️ Sobre Nós</h3>
          <p className="lead">
            Na Casa Portuguesa, acreditamos que a boa comida aproxima pessoas. O
            nosso restaurante nasceu da vontade de preservar a essência da
            gastronomia nacional, com pratos preparados de forma artesanal,
            utilizando ingredientes frescos e selecionados.
          </p>
          <p className="lead">
            Somos apaixonados pelos sabores que atravessam gerações — desde as
            receitas mais simples até aos pratos emblemáticos que fazem parte da
            cultura portuguesa. O nosso compromisso é proporcionar uma
            experiência que combina qualidade, conforto e o charme típico das
            casas portuguesas.
          </p>
        </div>
      </div>
    </Container>
  );
}
