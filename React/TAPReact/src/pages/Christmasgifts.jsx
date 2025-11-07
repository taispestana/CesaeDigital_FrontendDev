import { Button } from "../components/Button";
import { useState } from "react";

export default function Christmasgifts(){

      const [selectedPerson, setSelectedPerson] = useState(null);

      function mostrarPresente(pessoa) {
        setSelectedPerson(pessoa);
      }

      const listaPresente = selectedPerson ? GIFTS [selectedPerson] : null;

    return(

        <div className="christmas-container">
      <h2>Gestão de Prendas de Natal</h2>

      <menu className="gift-menu">
        <Button
          functionForClick={() => mostrarPresente("tais")}
          className={selectedPerson === "tais" ? "active" : ""}
        >
          Tais
        </Button>

        <Button
          functionForClick={() => mostrarPresente("macau")}
          className={selectedPerson === "macau" ? "active" : ""}
        >
          Macau
        </Button>
      </menu>

      <div className="gift-content">
        {!selectedPerson && <p>Escolha um responsável para ver as prendas</p>}

        {selectedPerson && !listaPresente && (
          <p>Erro: não foi possível carregar as prendas</p>
        )}

        {selectedPerson && listaPresente && listaPresente.length === 0 && (
          <p>{selectedPerson} ainda não tem prendas atribuídas.</p>
        )}

        {selectedPerson && listaPresente && listaPresente.length > 0 && (
          <ul>
            {listaPresente.map((gift, index) => (
              <li key={index}>
                <strong>{gift.pessoa}</strong>: {gift.presente} — {gift.preco}€
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
    
    )
}