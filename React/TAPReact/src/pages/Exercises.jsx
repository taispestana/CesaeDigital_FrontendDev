import reactLogo from '../assets/react.svg'
import viteLogo from '/vite.svg'
import ReactSubject from "../components/ReactSubject"
import Delete from "../components/Delete"
import FirstComponent from "../components/FirstComponent"
import MainGoal from "../components/MainGoal"
import { CourseGoal } from "../components/CourseGoal"
import { Button } from "../components/Button"
import { Link } from "react-router-dom"
import objectvs from '../data/objectivs'
import course from '../data/course'


export default function Exercises(){

  // funcao para o botao submeter
  function alertPayDate(){
    alert('Atenção à data de pagamento!')
  }

    return (

        <div>
            <div>
                <h3>Os meus exercicios</h3>
            </div>
 <Delete/>
    <ReactSubject/>
    
    <FirstComponent/>
    <MainGoal objetivo = {objectvs[0]}/>
    <MainGoal objetivo = {objectvs[1]}/>
    <MainGoal objetivo = {objectvs[2]}/>
    <MainGoal objetivo = 'Construir uma aplicaçao com servidor!'/>

    <CourseGoal {...course}/>

      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>

      <h1>Front End Developer: React</h1>

    <Button functionForClick={alertPayDate}>Submeter</Button>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
      <Link to="/">Minha homepage</Link>
      </div>
    )
 }