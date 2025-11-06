import { Link } from "react-router-dom";

export default function HomePage(){
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
        </div>
    )
}