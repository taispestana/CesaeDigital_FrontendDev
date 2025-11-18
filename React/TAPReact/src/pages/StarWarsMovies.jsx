import { useEffect, useState } from "react";

export default function StarWarsMovies() {
  const [movies, setMovies] = useState([]);
  const [error, setError] = useState();
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    async function fetchMovies() {
      setIsLoading(true);

      try {
        const response = await fetch("https://swapi.dev/api/films");

        if (!response.ok) {
          throw new Error("Falha ao buscar filmes");
        }

        const resData = await response.json();
        setMovies(resData.results);
      } catch (err) {
        setError(err.message);
      }

      setIsLoading(false);
    }

    fetchMovies();
  }, []);

  if (isLoading) {
    return <p>Carregando filmes...</p>;
  }

  if (error) {
    return <p>Erro: {error}</p>;
  }

  return (
    <div style={{ padding: "2rem" }}>
      <h1>Filmes de Star Wars</h1>

      {movies.length === 0 && <p>Nenhum filme encontrado...</p>}

      <ul style={{ listStyle: "none", padding: 0 }}>
        {movies.map((movie) => (
          <li key={movie.episode_id} style={{ marginBottom: "2rem" }}>
            <h2>{movie.title}</h2>
            <p>
              <b>Data de lançamento:</b> {movie.release_date}
            </p>
            <p style={{ whiteSpace: "pre-wrap" }}>{movie.opening_crawl}</p>
            <hr />
          </li>
        ))}
      </ul>
    </div>
  );
}
