// --- Carrossel de Imagens na Seção "Sobre Nós" ---
const secaoSobre = document.querySelector('#sobre');

if (secaoSobre) {
    const containerCarrossel = document.createElement('div');
    containerCarrossel.style.maxWidth = '100%';
    containerCarrossel.style.height = '300px';
    containerCarrossel.style.marginTop = '20px';
    containerCarrossel.style.borderRadius = '10px';
    containerCarrossel.style.overflow = 'hidden';
    containerCarrossel.style.boxShadow = '0 4px 8px rgba(0,0,0,0.1)';
    
    const imgCarrossel = document.createElement('img');
    imgCarrossel.style.width = '100%';
    imgCarrossel.style.height = '100%';
    imgCarrossel.style.objectFit = 'cover';
    imgCarrossel.style.transition = 'opacity 0.5s';
    
    const imagensSobre = [
        'https://images.unsplash.com/photo-1522071820081-009f0129c71c?auto=format&fit=crop&w=800&q=80', // Pessoas trabalhando
        'https://images.unsplash.com/photo-1531482615713-2afd69097998?auto=format&fit=crop&w=800&q=80', // Reunião
        'https://images.unsplash.com/photo-1498050108023-c5249f4df085?auto=format&fit=crop&w=800&q=80'  // Escritório
    ];
    
    let indiceImg = 0;
    imgCarrossel.src = imagensSobre[0];
    containerCarrossel.appendChild(imgCarrossel);
    secaoSobre.appendChild(containerCarrossel);
    
    setInterval(() => {
        imgCarrossel.style.opacity = '0';
        setTimeout(() => {
            indiceImg = (indiceImg + 1) % imagensSobre.length;
            imgCarrossel.src = imagensSobre[indiceImg];
            imgCarrossel.style.opacity = '1';
        }, 500);
    }, 4000);
}

// Animação dos cards dos cursos 
const cards = document.querySelectorAll('#cursos .card');

cards.forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.style.transform = 'scale(1.1)';
    })
    card.addEventListener('mouseleave', () => {
        card.style.transform = 'scale(1.0)';
    })
});

// Garante que todas as imagens dos cards tenham a mesma altura
document.addEventListener('DOMContentLoaded', () => {
    const cardImages = document.querySelectorAll('#cursos .card img');

    cardImages.forEach(img => {
        img.style.height = '200px'; // Define uma altura fixa para todas as imagens
        img.style.objectFit = 'cover'; // Garante que a imagem cubra a área sem distorcer
    });
});

// Substituir imagem do card "Girls Can Code!"
const imgGirlsCanCode = document.querySelector('img[alt="Curso Girls Can Code!"]');
 
if (imgGirlsCanCode) {
    // Insere a nova URL da imagem
    imgGirlsCanCode.src = "https://images.unsplash.com/photo-1529070538774-1843cb3265df?auto=format&fit=crop&w=800&q=80";

}

// Incluir cursos em mais duas áreas na lista "Sobre Nós"
const listaSobre = document.querySelector('#sobre ul');
 
if (listaSobre) {
    // Criar o item Comunicação Digital
    const item1 = document.createElement('li');
    item1.textContent = 'Comunicação Digital';
    
    // Criar o item Formação de formadores
    const item2 = document.createElement('li');
    item2.textContent = 'Formação de formadores';
 
    // Inserir os itens no final da lista
    listaSobre.appendChild(item1);
    listaSobre.appendChild(item2);
}

// --- Formulário de Contato ---

document.getElementById("formulario-contato").addEventListener('submit', function(event) {
    event.preventDefault();
 
    const mensagensErro = document.querySelectorAll('.erro-validacao');
    mensagensErro.forEach(msg => msg.remove());
 
    const nome = document.getElementById('nome');
    const email = document.getElementById('email');
    const contato = document.getElementById('contatoFormulario');
    const regiao = document.getElementById('regiao');
    const mensagem = document.getElementById('mensagem');
 
    let formularioValido = true;
 
    function exibirErro(campo, texto) {
        const erro = document.createElement('small');
        erro.className = 'erro-validacao';
        erro.textContent = texto;
        erro.style.color = '#dc3545';
        erro.style.fontSize = '12px';
        erro.style.display = 'block';
        campo.parentNode.appendChild(erro);
        formularioValido = false;
    }
 
    // Verificação de Campos em Branco
 
    if (nome.value.trim() === "") {
        exibirErro(nome, '* Campo obrigatório.');
    }
 
    if (email.value.trim() === "") {
        exibirErro(email, '* Campo obrigatório.');
    } else if (!email.checkValidity()) {
        exibirErro(email, '* Insira um e-mail válido.');
    }
 
    if (contato.value.trim() === "") {
        exibirErro(contato, '* Campo obrigatório.');
    }
 
    if (regiao.value === "") {
        exibirErro(regiao, '* Campo obrigatório.');
    }
 
    if (mensagem.value.trim() === "") {
        exibirErro(mensagem, '* Campo obrigatório.');
    }
 
    if (formularioValido) {
        const btn = event.target.querySelector('button');
        btn.style.backgroundColor = '#243C2F';
        btn.textContent = 'Enviado!';
        alert("Formulário enviado com sucesso!");
        event.target.reset();
    }
});

// Quiz Interativo 
// 1. Criar estrutura do Quiz
const quizContainer = document.createElement('div');
quizContainer.style.maxWidth = '600px';
quizContainer.style.margin = '50px auto';
quizContainer.style.padding = '20px';
quizContainer.style.backgroundColor = '#f9f9f9';
quizContainer.style.borderRadius = '10px';
quizContainer.style.boxShadow = '0 4px 8px rgba(0,0,0,0.1)';
quizContainer.style.textAlign = 'center';
quizContainer.style.fontFamily = 'Arial, sans-serif';

const tituloQuiz = document.createElement('h2');
tituloQuiz.textContent = 'Quiz de Conhecimentos';
tituloQuiz.style.color = '#333';
quizContainer.appendChild(tituloQuiz);

const areaConteudo = document.createElement('div');
quizContainer.appendChild(areaConteudo);

// Insere o quiz antes da seção de contato para melhor fluxo
const secaoContato = document.getElementById('contato');
if (secaoContato) {
    secaoContato.parentNode.insertBefore(quizContainer, secaoContato);
} else {
    document.body.insertBefore(quizContainer, document.querySelector('footer'));
}

// 2. Dados do Quiz
const perguntas = [
    {
        pergunta: "O que significa a sigla HTML?",
        opcoes: ["Hyper Text Markup Language", "Home Tool Markup Language", "Hyperlinks and Text Markup Language"],
        correta: 0
    },
    {
        pergunta: "Qual linguagem é usada para estilizar páginas web?",
        opcoes: ["Java", "CSS", "Python"],
        correta: 1
    },
    {
        pergunta: "O JavaScript é executado principalmente no:",
        opcoes: ["Servidor", "Navegador (Cliente)", "Banco de Dados"],
        correta: 1
    }
];

let indiceAtual = 0;
let pontuacao = 0;

// 3. Funções de Lógica
function carregarPergunta() {
    const q = perguntas[indiceAtual];
    areaConteudo.innerHTML = ''; // Limpa conteúdo anterior

    const p = document.createElement('p');
    p.textContent = q.pergunta;
    p.style.fontSize = '1.2em';
    p.style.margin = '20px 0';
    areaConteudo.appendChild(p);

    q.opcoes.forEach((opcao, index) => {
        const btn = document.createElement('button');
        btn.textContent = opcao;
        btn.style.display = 'block';
        btn.style.width = '100%';
        btn.style.padding = '10px';
        btn.style.margin = '5px 0';
        btn.style.cursor = 'pointer';
        btn.style.backgroundColor = '#fff';
        btn.style.border = '1px solid #ccc';
        btn.style.borderRadius = '5px';
        
        btn.addEventListener('mouseenter', () => btn.style.backgroundColor = '#e0e0e0');
        btn.addEventListener('mouseleave', () => btn.style.backgroundColor = '#fff');
        
        btn.addEventListener('click', () => {
            if (index === q.correta) {
                pontuacao++;
                alert("Correto!");
            } else {
                alert("Incorreto!");
            }
            indiceAtual++;
            if (indiceAtual < perguntas.length) {
                carregarPergunta();
            } else {
                mostrarResultado();
            }
        });
        areaConteudo.appendChild(btn);
    });
}

function mostrarResultado() {
    areaConteudo.innerHTML = `
        <h3>Quiz Finalizado!</h3>
        <p>Você acertou <strong>${pontuacao}</strong> de <strong>${perguntas.length}</strong> perguntas.</p>
    `;
    
    const btnReiniciar = document.createElement('button');
    btnReiniciar.textContent = 'Reiniciar Quiz';
    btnReiniciar.style.marginTop = '15px';
    btnReiniciar.style.padding = '10px 20px';
    btnReiniciar.style.backgroundColor = '#243C2F';
    btnReiniciar.style.color = 'white';
    btnReiniciar.style.border = 'none';
    btnReiniciar.style.borderRadius = '5px';
    btnReiniciar.style.cursor = 'pointer';
    
    btnReiniciar.addEventListener('click', () => {
        indiceAtual = 0;
        pontuacao = 0;
        carregarPergunta();
    });
    
    areaConteudo.appendChild(btnReiniciar);
}

// Iniciar o Quiz
carregarPergunta();

// Botão "Voltar ao Topo"
const btnTopo = document.createElement('button');
btnTopo.textContent = 'Voltar ao Topo';
btnTopo.style.position = 'fixed';
btnTopo.style.bottom = '20px';
btnTopo.style.right = '20px';
btnTopo.style.display = 'none';
btnTopo.style.padding = '10px 15px';
btnTopo.style.backgroundColor = '#2b68f6ff';
btnTopo.style.color = '#fff';
btnTopo.style.border = 'none';
btnTopo.style.borderRadius = '5px';
btnTopo.style.cursor = 'pointer';
btnTopo.style.zIndex = '1000';

document.body.appendChild(btnTopo);

btnTopo.addEventListener('click', () => {
    window.scrollTo({ top: 0, behavior: 'smooth' });
});

window.addEventListener('scroll', () => {
    if (window.scrollY > 300) {
        btnTopo.style.display = 'block';
    } else {
        btnTopo.style.display = 'none';
    }
});

// --- Funcionalidade dos Modais (Pop-ups) ---

// 1. Injetar CSS para o Modal
const styleModal = document.createElement('style');
styleModal.innerHTML = `
    .modal-backdrop {
        position: fixed; top: 0; left: 0; width: 100%; height: 100%;
        background: rgba(0,0,0,0.6); display: none; justify-content: center; align-items: center; z-index: 2000;
    }
    .modal-content {
        background: white; padding: 25px; border-radius: 10px; width: 90%; max-width: 500px;
        position: relative; text-align: center; box-shadow: 0 5px 15px rgba(0,0,0,0.3);
        font-family: Arial, sans-serif;
    }
    .modal-close {
        position: absolute; top: 10px; right: 15px; font-size: 28px; cursor: pointer; color: #333;
    }
    .modal-info p { margin: 10px 0; font-size: 1.1em; color: #555; }
    .modal-info strong { color: #333; }
`;
document.head.appendChild(styleModal);

// 2. Criar Estrutura HTML do Modal
const modalContainer = document.createElement('div');
modalContainer.className = 'modal-backdrop';
modalContainer.innerHTML = `
    <div class="modal-content">
        <span class="modal-close">&times;</span>
        <h2 id="modal-titulo" style="margin-bottom: 15px; color: #243C2F;"></h2>
        <div class="modal-info">
            <p id="modal-desc"></p>
            <p><strong>Duração:</strong> <span id="modal-duracao"></span></p>
            <p><strong>Valor:</strong> <span id="modal-valor"></span></p>
        </div>
    </div>
`;
document.body.appendChild(modalContainer);

// 3. Dados dos Cursos (Simulação)
const infoCursos = {
    "Software Developer": { desc: "Aprenda a desenvolver aplicações web e mobile.", duracao: "12 meses", valor: "€ 4.000" },
    "Web Developer": { desc: "Domine HTML, CSS e JS para criar sites modernos.", duracao: "6 meses", valor: "€ 3.000" },
    "Front-End Developer": { desc: "Domine as tecnologias front-end e crie interfaces incríveis.", duracao: "9 meses", valor: "€ 3.500" },
    "Girls Can Code!": { desc: "Empodere mulheres na área da tecnologia.", duracao: "3 meses", valor: "Gratuito" },
    "Comunicação Digital": { desc: "Estratégias de marketing e gestão de redes sociais.", duracao: "4 meses", valor: "€ 2.500" },
    "Formação de formadores": { desc: "Desenvolva competências pedagógicas para formação.", duracao: "150 horas", valor: "€ 1.200" },
    "default": { desc: "Entre em contato para mais detalhes sobre este curso.", duracao: "Sob consulta", valor: "Sob consulta" }
};

// 4. Lógica de Abrir/Fechar
const mTitulo = document.getElementById('modal-titulo');
const mDesc = document.getElementById('modal-desc');
const mDuracao = document.getElementById('modal-duracao');
const mValor = document.getElementById('modal-valor');
const mClose = document.querySelector('.modal-close');

function abrirModal(titulo, descricao) {
    const tituloLimpo = titulo.trim();
    // Tenta encontrar correspondência exata ou usa o default
    const dados = infoCursos[tituloLimpo] || infoCursos['default'];
    
    mTitulo.textContent = tituloLimpo;
    mDesc.textContent = descricao || dados.desc;
    mDuracao.textContent = dados.duracao;
    mValor.textContent = dados.valor;
    modalContainer.style.display = 'flex';
}

mClose.addEventListener('click', () => modalContainer.style.display = 'none');
modalContainer.addEventListener('click', (e) => {
    if (e.target === modalContainer) modalContainer.style.display = 'none';
});

// 5. Associar aos Botões "Saiba Mais"
document.querySelectorAll('#cursos .card').forEach(card => {
    const btn = card.querySelector('.btn-primary');
    const tituloEl = card.querySelector('.card-title');
    const descEl = card.querySelector('.card-text');
    
    if (btn && tituloEl) {
        btn.addEventListener('click', (e) => {
            e.preventDefault();
            abrirModal(tituloEl.textContent, descEl ? descEl.textContent : null);
        });
    }
});
