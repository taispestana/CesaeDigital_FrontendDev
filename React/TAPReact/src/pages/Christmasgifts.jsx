import { Button } from "../components/Button";
import { useState } from "react";
import { Link } from "react-router-dom";
import { GIFTS } from "../data/christmasgifts";
import "./Christmasgifts.css";

export default function Christmasgifts() {
  const [pessoaSelecionada, setpessoaSelecionada] = useState(null);
  const [presentesAnimados, setPresentesAnimados] = useState([]);

  function mostrarPresente(pessoa) {
    setpessoaSelecionada(pessoa);
    gerarChuvaDePresentes();
  }

  function gerarChuvaDePresentes() {
    const gifts = [];
    for (let i = 0; i < 20; i++) {
      gifts.push({
        id: i,
        style: {
          left: `${Math.random() * 90}vw`, // posição horizontal aleatória
          animationDuration: `${2 + Math.random() * 3}s`, // velocidade diferente
        },
      });
    }
    setPresentesAnimados(gifts);

    setTimeout(() => setPresentesAnimados([]), 5000);
  }

  const listaPresente = pessoaSelecionada ? GIFTS[pessoaSelecionada] : null;

  return (
    <div className="christmas-page">
      <h2>Prendas de Natal deste Ano</h2>

      <menu className="gift-menu">
        <Button
          functionForClick={() => mostrarPresente("tais")}
          isActive={pessoaSelecionada === "tais" ? "active" : ""}
        >
          Tais
        </Button>

        <Button
          functionForClick={() => mostrarPresente("macau")}
          isActive={pessoaSelecionada === "macau" ? "active" : ""}
        >
          Macau
        </Button>
      </menu>

      <div className="gift-content">
        {!pessoaSelecionada && (
          <p>Escolha uma pessoa acima para ver as prendas!</p>
        )}

        {pessoaSelecionada && !listaPresente && (
          <p>Erro: não foi possível carregar as prendas</p>
        )}

        {pessoaSelecionada && listaPresente && listaPresente.length === 0 && (
          <p>{pessoaSelecionada} ainda não tem prendas atribuídas.</p>
        )}

        {pessoaSelecionada && listaPresente && listaPresente.length > 0 && (
          <ul>
            {listaPresente.map((gift, index) => (
              <li key={index}>
                <strong>{gift.pessoa}</strong>: {gift.presente} — {gift.preco}€
              </li>
            ))}
          </ul>
        )}
      </div>

      {presentesAnimados.map((gift) => (
        <span key={gift.id} className="gift-fall" style={gift.style}>
          🎁
        </span>
      ))}
      <Link to="/">Minha homepage</Link>
    </div>
  );
}
