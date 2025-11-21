import { Link, useLocation } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "../contexts/AuthContext";

export default function HomePage() {
  const location = useLocation();
  const message = location.state?.message;
  const {logout, user} = useContext(AuthContext);

  return (
    <div>
      {message && <p>{message}</p>}
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
      <br />
      <Link to="/swpeople">StarWars Personagens</Link>
      <br />
      <Link to="/swmovies">StarWars Filmes</Link> <br />

      {(user && user.role === 'student') &&
      <Link to="/courses">Cursos do Cesae</Link> }
      <br />
      
      {!user ?
      <div>
        <Link to="/login">Login</Link> <br />
        <Link to="/register">Registro</Link> <br />
      </div> :
      <button onClick={logout}>Logout</button>
      }
      
    </div>
  );
}
