import ReactSubject from "../components/ReactSubject"
import { Button } from "../components/Button"
import Discount from "../components/Discount"
import Login from "../components/Login"
import { Link } from "react-router-dom"
import { useState } from "react"

export default function Subject(){

  const [chosenSubject, setChosenSubject] = useState('Escolha a matéria:');

   // funcao que vai tomar conta do clique das materias
  function getSubject(subject){
    // alert('matéria completa de ' + subject);
    setChosenSubject('a materia é: '+ subject);
  }

    return (
        <div>
            <div>
                <h3>Os meus ReactSubject</h3>
            </div>
    <ReactSubject/>
    
    <h3>Eventos Dinamicos</h3>
      <menu>
        <Button functionForClick={() => getSubject('JS')}>Materia JS</Button>
        <Button functionForClick={() => getSubject('React')}>Materia React</Button>
        <Button functionForClick={() => getSubject('SQL')}>Materia SQL</Button>

        <div>
          {chosenSubject}
        </div>

        <Discount/>

        <Login/>
      </menu>
      <Link to="/">Minha homepage</Link>
      </div>
    
    )}