import { useState } from 'react'
import './App.css'
import MainGoal from './components/MainGoal'
import FirstComponent from './components/FirstComponent'
import objectvs from './data/objectivs'
import { CourseGoal } from './components/CourseGoal'
import course from './data/course'
import { Button } from './components/Button'
import Login from './components/Login'
import Discount from './components/Discount'
import Delete from './components/Delete'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import HomePage from './pages/HomePage'
import Contacts from './pages/Contacts'
import RootLayout from './components/layouts/RootLayout'
import Error from './pages/Error'
import Subject from './pages/Subject'
import Exercises from './pages/Exercises'
import Courses from './pages/Courses'
import Course from './pages/Course'
import ShoppingList from './pages/ShoppingPage'
import Christmasgifts from './pages/Christmasgifts'

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
    errorElement: <Error/>,
    children:[
  {path:'/', element: <HomePage/>},
  {path:'/contacts', element: <Contacts/>},
  {path:'/subject', element: <Subject/>},
  {path:'/exercises', element: <Exercises/>},
  {path:'/courses', element: <Courses/>},
  {path:'/course/:course_name', element: <Course/>},
  {path:'/shoppinglist', element: <ShoppingList/>},
  {path:'/christmasgifts', element: <Christmasgifts/>}]}
]);

function App() {

  return <RouterProvider router={router}/>

  const [count, setCount] = useState(0)

  // variaveis sem estado
  // let chosenSubject = 'Escolha a matéria';

  // estados do react -> useState()
  const [chosenSubject, setChosenSubject] = useState('Escolha a matéria:');

}
export default App
