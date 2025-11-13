// Sem mexer no html, crie 100 botões com um texto a sua escolha
// Os botões devem ser anexados à div container

// Seleciona o container onde os botões serão adicionados
const container = document.querySelector('.button-container');

//funcao para criar botoes
function criarBotao (texto){

    const botao = document.createElement('button'); // cria o elemento botão
    botao.textContent = texto; // texto do botão
    botao.classList.add('btn', 'btn-danger', 'm-1'); // adiciona classes do Bootstrap
    
    return botao;
}

//Criando os 100 botoes
for (let contador = 1; contador <= 100; contador++){
    const meuBotao = criarBotao(`Hello ${contador}`)
    container.appendChild(meuBotao)
}
