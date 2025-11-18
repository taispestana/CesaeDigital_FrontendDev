import { useEffect, useState } from "react";

export default function StarWarsPeople() {
  const [people, setPeople] = useState([]);

  useEffect(() => {
    fetch("https://swapi.dev/api/people")
      .then((response) => response.json())
      .then((resData) => {
        setPeople(resData.results);
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <div>
      {(!people || people.length === 0) && (
        <p className="fallback-text">Ups, não temos personagens disponíveis</p>
      )}

      {people && people.length > 0 && (
        <ul className="places">
          {people.map((item) => (
            <li key={item.name} className="place-item">
              <p>
                <b>{item.name}</b>: {item.birth_year}, {item.gender}
              </p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
