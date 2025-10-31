import { Link } from "react-router-dom";

export default function HomePage(){
    return (
        <div>
            <h3>As minhas funcionalidades</h3>
            <Link to="/contacts">Os meus contactos</Link>
        </div>
    )
}