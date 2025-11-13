import "./App.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import HomePage from "./pages/HomePage";
import Contacts from "./pages/Contacts";
import RootLayout from "./components/layouts/RootLayout";
import Error from "./pages/Error";
import Subject from "./pages/Subject";
import Exercises from "./pages/Exercises";
import Courses from "./pages/Courses";
import Course from "./pages/Course";
import ShoppingList from "./pages/ShoppingPage";
import Christmasgifts from "./pages/Christmasgifts";
import AvailablePlaces from "./pages/PlacesIndex";

let mySubject = "React";

const subjects = ["JS", "CSS", "React", "Bases de dados"];

function getRandomForSubject(max) {
  return Math.floor(Math.random() * max);
}

mySubject = subjects[getRandomForSubject(4)];

// Criaçao do objeto e suas propriedades
let product = {
  name: "caneta",
  price: 5,
  color: "amarelo",
};

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    errorElement: <Error />,
    children: [
      { path: "/", element: <HomePage /> },
      { path: "/contacts", element: <Contacts /> },
      { path: "/subject", element: <Subject /> },
      { path: "/exercises", element: <Exercises /> },
      { path: "/courses", element: <Courses /> },
      { path: "/course/:course_name", element: <Course /> },
      { path: "/shoppinglist", element: <ShoppingList /> },
      { path: "/christmasgifts", element: <Christmasgifts /> },
      { path: "/places", element: <AvailablePlaces /> },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}
export default App;
