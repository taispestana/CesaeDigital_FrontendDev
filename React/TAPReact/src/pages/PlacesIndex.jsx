import { useState, useEffect } from "react";
import Places from "../components/places/Places";
import globeImg from "../assets/globe.png";
import {updateUserPlaces} from "../https"; 

export default function AvailablePlaces() {
  const [availablePlaces, setAvailablePlaces] = useState([]);
  const [userPlaces, setUserPlaces] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState();

  //codigo que consulta backend e traz os dados de lugares disponiveis para escolha
  useEffect(() => {
    async function fetchPlaces() {
      setIsLoading(true);
      try {
        const response = await fetch("http://localhost:3000/places");
        const resData = await response.json();
        setAvailablePlaces(resData.places);
      } catch (error) {
        setError({
          message:
            error.message || "Could not fetch places, please try again later.",
        });
      }
      setIsLoading(false);
    }

    fetchPlaces();
  }, []);

 //codigo...
  useEffect(() => {
    async function fetchPlaces() {
      setIsLoading(true);
      try {
        const response = await fetch("http://localhost:3000/user-places");
        const resData = await response.json();
        setUserPlaces(resData.places);
      } catch (error) {
        setError({
          message:
            error.message || "Could not fetch user places, please try again later.",
        });
      }
      setIsLoading(false);
    }

    fetchPlaces();
  }, []);

  //funcao que quando clicamos nos lugares disponiveis toma conta do que vamos fazer com esse lugar
  function handleSelectPlace(onSelectPlace) {

    //tomar conta de atualizar visualmente o react
    setUserPlaces((prevPickedPlaces) => {
          if (!prevPickedPlaces){
            prevPickedPlaces = []
          }
          if (prevPickedPlaces.some((place) => place.id === onSelectPlace.id)){
            return prevPickedPlaces
          }
          return[onSelectPlace, ...prevPickedPlaces]
        })

    //enviar o ficheiro para atualizar no backend os lugares escolhidos
    updateUserPlaces([onSelectPlace, ...userPlaces])
  }

  if (error) {
    return (
      <div className="error">
        <h2>Error!</h2>
        <p>{error.message}</p>
      </div>
    );
  }

  return (
    <>
      <div>
        <img src={globeImg} alt="Stylized globe" />
        <h1>PlacePicker</h1>
        <p>
          Create your personal collection of places you would like to visit or
          you have visited.
        </p>
      </div>
      <main>
        <Places
          title="User Places"
          fallbackText="Please Select Places from below"
          places={userPlaces}
          isLoading={isLoading}
          loadingText="Loading..."
        />
        <Places
          title="Available Places"
          fallbackText="No Places Available"
          places={availablePlaces}
          onSelectPlace={handleSelectPlace}
          isLoading={isLoading}
          loadingText="Loading..."
        />
      </main>
    </>
  );
}
