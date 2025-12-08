import { useRouteError } from "react-router-dom";

// Componente para exibir uma página de erro genérica
export default function ErrorPage() {
  const error = useRouteError();
  console.error(error); // Loga o erro no console para depuração

  return (
    <div id="error-page" style={{ textAlign: 'center', padding: '50px' }}>
      <h1>Oops!</h1>
      <p>Desculpe, um erro inesperado ocorreu.</p>
      <p>
        {/* Exibe a mensagem de erro específica */}
        <i>{error.statusText || error.message}</i>
      </p>
    </div>
  );
}
