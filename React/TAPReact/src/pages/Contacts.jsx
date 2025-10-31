import Card from "../components/Card"
import userData from "../data/userData"
import { Link } from "react-router-dom"

export default function Contacts(){
    return (
        <div>
            <div>
                <h3>Os meus contactos</h3>
            </div>
        <div id="card-row">
            <Card firstName = 'Cristina'
               lastName = 'Correia'
               title = 'Gestora Pedagógica'/>

               <Card firstName = 'Antonio'
               lastName = 'Silva'
               title = 'Gestor'/>

                <Card {...userData}/>
        </div>
        <Link to="/">Minha homepage</Link>
        </div>
    )
}