import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import MainGoal from './components/MainGoal'
import FirstComponent from './components/FirstComponent'
import objectvs from './data/objectivs'
import { CourseGoal } from './components/CourseGoal'
import course from './data/course'
import { Button } from './components/Button'
import Login from './components/Login'
import Discount from './components/Discount'
import ReactSubject from './components/ReactSubject'
import Delete from './components/Delete'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import HomePage from './pages/HomePage'
import Contacts from './pages/Contacts'
import RootLayout from './components/layouts/RootLayout'

let mySubject = "React";

const subjects = ['JS','CSS','React','Bases de dados']

function getRandomForSubject(max){
  return Math.floor(Math.random() * max);
}

mySubject = subjects[getRandomForSubject(4)];

// Criaçao do objeto e suas propriedades
let product = {
  name: 'caneta',
  price: 5,
  color: 'amarelo'
};

const router = createBrowserRouter([
  {path:'/',
    element: <RootLayout/>,
    children:[
  {path:'/', element: <HomePage/>},
  {path:'/contacts', element: <Contacts/>}]
    }
]);

function App() {

  return <RouterProvider router={router}/>

  const [count, setCount] = useState(0)

  // variaveis sem estado
  // let chosenSubject = 'Escolha a matéria';

  // estados do react -> useState()
  const [chosenSubject, setChosenSubject] = useState('Escolha a matéria:');

  // funcao para o botao submeter
  function alertPayDate(){
    alert('Atenção à data de pagamento!')
  }

  // funcao que vai tomar conta do clique das materias
  function getSubject(subject){
    // alert('matéria completa de ' + subject);
    setChosenSubject('a materia é: '+ subject);
  }

  return (
    <>
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
    </>
  )
}
export default App
