import { useState, useEffect } from "react";
import Places from "../components/places/Places";
import globeImg from "../assets/globe.png";

export default function AvailablePlaces() {
  const [availablePlaces, setAvailablePlaces] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState();

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
          title="Available Places"
          fallbackText="No Places Available"
          places={availablePlaces}
          isLoading={isLoading}
          loadingText="Loading..."
        />
      </main>
    </>
  );
}
