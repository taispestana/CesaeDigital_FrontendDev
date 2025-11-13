import { Link } from "react-router-dom";

export default function HomePage() {
  return (
    <div>
      <h3>As minhas funcionalidades</h3>
      <Link to="/contacts">Os meus contactos</Link>
      <br />
      <Link to="/subject">Os meus subjects</Link>
      <br />
      <Link to="/exercises">Os meus exercicios</Link>
      <br />
      <Link to="/courses">Os meus cursos</Link>
      <br />
      <Link to="/shoppingList">A minha lista de compras</Link>
      <br />
      <Link to="/christmasgifts">A minha lista de Presentes de Natal</Link>
      <br />
      <Link to="/places">O meu PLACE</Link>
    </div>
  );
}
