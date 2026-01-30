
// 1. FUNCIONALIDADE DOS MODAIS (Setup, Dados e Lógica)

// Adicionar CSS para o Modal
const modalCss = document.createElement('style');
modalCss.innerHTML = `
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
document.head.appendChild(modalCss);

// Criar Estrutura HTML do Modal
const modalOverlay = document.createElement('div');
modalOverlay.className = 'modal-backdrop';
modalOverlay.innerHTML = `
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
document.body.appendChild(modalOverlay);

// Dados dos Cursos (descrição, duração, valor)
const coursesData = {
    "Software Developer": { desc: "Aprenda a desenvolver aplicações web e mobile.", duracao: "12 meses", valor: "€ 4.000" },
    "Web Developer": { desc: "Domine HTML, CSS e JS para criar sites modernos.", duracao: "6 meses", valor: "€ 3.000" },
    "Front-End Developer": { desc: "Domine as tecnologias front-end e crie interfaces incríveis.", duracao: "9 meses", valor: "€ 3.500" },
    "Girls Can Code!": { desc: "Empodere mulheres na área da tecnologia.", duracao: "3 meses", valor: "Gratuito" },
    "Comunicação Digital": { desc: "Estratégias de marketing e gestão de redes sociais.", duracao: "4 meses", valor: "€ 2.500" },
    "Formação de formadores": { desc: "Desenvolva competências pedagógicas para formação.", duracao: "150 horas", valor: "€ 1.200" },
    "default": { desc: "Entre em contato para mais detalhes sobre este curso.", duracao: "Sob consulta", valor: "Sob consulta" }
};

// Lógica de Abrir/Fechar
const modalTitle = document.getElementById('modal-titulo');
const modalDescription = document.getElementById('modal-desc');
const modalDuration = document.getElementById('modal-duracao');
const modalPrice = document.getElementById('modal-valor');
const closeModalBtn = document.querySelector('.modal-close');

// Função para abrir o modal com os dados
function openCourseModal(titulo, descricao) {
    const tituloLimpo = titulo.trim();

    // Tenta encontrar correspondência exata ou usa o default
    const dados = coursesData[tituloLimpo] || coursesData['default'];
    
    // Preencher os dados do modal
    modalTitle.textContent = tituloLimpo;
    modalDescription.textContent = descricao || dados.desc;
    modalDuration.textContent = dados.duracao;
    modalPrice.textContent = dados.valor;
    modalOverlay.style.display = 'flex';
}

// Fechar o modal
closeModalBtn.addEventListener('click', () => modalOverlay.style.display = 'none');
modalOverlay.addEventListener('click', (e) => {
    if (e.target === modalOverlay) modalOverlay.style.display = 'none';
});


// 2. SEÇÃO DE CURSOS (Animações, Imagens e Botões)

// Animação dos cards dos cursos 
const courseCards = document.querySelectorAll('#cursos .card');

courseCards.forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.style.transform = 'scale(1.1)';
    })
    card.addEventListener('mouseleave', () => {
        card.style.transform = 'scale(1.0)';
    })
});

// Garante que todas as imagens dos cards tenham a mesma altura
document.addEventListener('DOMContentLoaded', () => {
    const courseCardImages = document.querySelectorAll('#cursos .card img');

    courseCardImages.forEach(img => {
        img.style.height = '200px'; 
        img.style.objectFit = 'cover'; 
    });
});

// Associar aos Botões "Saiba Mais"
document.querySelectorAll('#cursos .card').forEach(card => {
    const btn = card.querySelector('.btn-primary');
    const tituloEl = card.querySelector('.card-title');
    const descEl = card.querySelector('.card-text');
    
    // Verifica se o botão e o título existem antes de adicionar o evento
    if (btn && tituloEl) {
        btn.style.backgroundColor = '#800080';
        btn.style.borderColor = '#800080';
        btn.style.border = '1px solid #800080';
        btn.addEventListener('click', (e) => {
            e.preventDefault();
            openCourseModal(tituloEl.textContent, descEl ? descEl.textContent : null);
        });
    }
});


// 3. SEÇÃO "SOBRE NÓS" (Carrossel, Imagens e Lista)

// Carrossel de Imagens na Seção "Sobre Nós"
const aboutSection = document.querySelector('#sobre');

// Verifica se a seção "Sobre Nós" existe antes de criar o carrossel
if (aboutSection) {
    const carouselContainer = document.createElement('div');
    carouselContainer.style.maxWidth = '100%';
    carouselContainer.style.height = '300px';
    carouselContainer.style.marginTop = '20px';
    carouselContainer.style.borderRadius = '10px';
    carouselContainer.style.overflow = 'hidden';
    carouselContainer.style.boxShadow = '0 4px 8px rgba(0,0,0,0.1)';
    
    // Criação do elemento de imagem
    const carouselImage = document.createElement('img');
    carouselImage.style.width = '100%';
    carouselImage.style.height = '100%';
    carouselImage.style.objectFit = 'cover';
    carouselImage.style.transition = 'opacity 0.5s';
    
    // URLs das imagens do carrossel
    const aboutImages = [
        'https://images.unsplash.com/photo-1522071820081-009f0129c71c?auto=format&fit=crop&w=800&q=80', 
        'https://images.unsplash.com/photo-1531482615713-2afd69097998?auto=format&fit=crop&w=800&q=80', 
        'https://images.unsplash.com/photo-1498050108023-c5249f4df085?auto=format&fit=crop&w=800&q=80'  
    ];
    
    // Lógica do carrossel
    let imageIndex = 0;
    carouselImage.src = aboutImages[0];
    carouselContainer.appendChild(carouselImage);
    aboutSection.appendChild(carouselContainer);
    
    // Troca automática de imagens a cada 4 segundos
    setInterval(() => {
        carouselImage.style.opacity = '0';
        setTimeout(() => {
            imageIndex = (imageIndex + 1) % aboutImages.length;
            carouselImage.src = aboutImages[imageIndex];
            carouselImage.style.opacity = '1';
        }, 500);
    }, 4000);
}

// Alterar a imagem
const girlsCanCodeImg = document.querySelector('img[alt="Curso Girls Can Code!"]');
 
// Verifica se a imagem existe antes de alterar o src
if (girlsCanCodeImg) {
    girlsCanCodeImg.src = "https://images.unsplash.com/photo-1529070538774-1843cb3265df?auto=format&fit=crop&w=800&q=80";

}

// Adicionar novos itens na lista da seção "Sobre Nós"
const aboutList = document.querySelector('#sobre ul');
 
// Verifica se a lista existe antes de adicionar os itens
if (aboutList) {

    // Criar o item Comunicação Digital
    const digitalCommItem = document.createElement('li');
    digitalCommItem.textContent = 'Comunicação Digital';
    
    // Criar o item Formação de formadores
    const trainersItem = document.createElement('li');
    trainersItem.textContent = 'Formação de formadores';
 
    // Inserir os itens no final da lista
    aboutList.appendChild(digitalCommItem);
    aboutList.appendChild(trainersItem);
}


// 4. FORMULÁRIO DE CONTATO

// Validação do Formulário de Contato
const contactForm = document.getElementById("formulario-contato");
const formSubmitBtn = contactForm.querySelector('button');
if (formSubmitBtn) {
    formSubmitBtn.style.backgroundColor = '#800080';
    formSubmitBtn.style.borderColor = '#800080';
    formSubmitBtn.style.border = '1px solid #800080';
}

contactForm.addEventListener('submit', function(event) {
    event.preventDefault();
 
    // Remover mensagens de erro anteriores
    const errorMessages = document.querySelectorAll('.erro-validacao');
    errorMessages.forEach(msg => msg.remove());
 
    // Referências aos campos do formulário
    const nameField = document.getElementById('nome');
    const emailField = document.getElementById('email');
    const contactField = document.getElementById('contatoFormulario');
    const regionField = document.getElementById('regiao');
    const messageField = document.getElementById('mensagem');
 
    let isFormValid = true;
 
    // Função para exibir mensagens de erro
    function showError(field, text) {
        const erro = document.createElement('small');
        erro.className = 'erro-validacao';
        erro.textContent = texto;
        erro.style.color = '#dc3545';
        erro.style.fontSize = '12px';
        erro.style.display = 'block';
        field.parentNode.appendChild(erro);
        isFormValid = false;
    }
 
    // Verificação de Campos em Branco
    if (nameField.value.trim() === "") {
        showError(nameField, '* Campo de nome obrigatório.');
    }
 
    if (emailField.value.trim() === "") {
        showError(emailField, '* Campo de e-mail obrigatório.');
    } else if (!emailField.checkValidity()) {
        showError(emailField, '* Insira um e-mail válido.');
    }
 
    if (contactField.value.trim() === "") {
        showError(contactField, '* Campo de contato obrigatório.');
    }
 
    if (regionField.value === "") {
        showError(regionField, '* Campo de região obrigatório.');
    }
 
    if (messageField.value.trim() === "") {
        showError(messageField, '* Campo de mensagem obrigatório.');
    }
 
    // Se o formulário for válido, exibir mensagem de sucesso
    if (isFormValid) {
        const submitBtn = event.target.querySelector('button');
        submitBtn.style.backgroundColor = '#800080';
        submitBtn.style.borderColor = '#800080';
        submitBtn.style.border = '1px solid #800080';
        submitBtn.textContent = 'Enviado!';
        alert("Formulário enviado com sucesso!");
        event.target.reset();
    }
});


// 5. QUIZ INTERATIVO

// Quiz Interativo 
const quizWrapper = document.createElement('div');
quizWrapper.style.maxWidth = '600px';
quizWrapper.style.margin = '50px auto';
quizWrapper.style.padding = '20px';
quizWrapper.style.backgroundColor = '#f9f9f9';
quizWrapper.style.borderRadius = '10px';
quizWrapper.style.boxShadow = '0 4px 8px rgba(0,0,0,0.1)';
quizWrapper.style.textAlign = 'center';
quizWrapper.style.fontFamily = 'Arial, sans-serif';

// 1. Estrutura do Quiz
const quizHeader = document.createElement('h2');
quizHeader.textContent = 'Quiz de Conhecimentos';
quizHeader.style.color = '#333';
quizWrapper.appendChild(quizHeader);

// Área para perguntas e opções
const quizContent = document.createElement('div');
quizWrapper.appendChild(quizContent);

// Insere o quiz antes da seção de contato
const contactSection = document.getElementById('contato');
if (contactSection) {
    contactSection.parentNode.insertBefore(quizWrapper, contactSection);
} else {
    document.body.insertBefore(quizWrapper, document.querySelector('footer'));
}

// Dados do Quiz
const quizQuestions = [
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

let currentQuestionIndex = 0;
let currentScore = 0;

// Funções de Lógica
function loadQuestion() {
    const q = quizQuestions[currentQuestionIndex];
    quizContent.innerHTML = ''; 

    // Pergunta
    const p = document.createElement('p');
    p.textContent = q.pergunta;
    p.style.fontSize = '1.2em';
    p.style.margin = '20px 0';
    quizContent.appendChild(p);

    // Opções
    q.opcoes.forEach((opcao, index) => {
        const btn = document.createElement('button');
        btn.textContent = opcao;
        btn.style.display = 'block';
        btn.style.width = '100%';
        btn.style.padding = '10px';
        btn.style.margin = '5px 0';
        btn.style.cursor = 'pointer';
        btn.style.backgroundColor = '#fff';
        btn.style.border = '1px solid #800080';
        btn.style.borderRadius = '5px';
        
        // Efeitos de hover
        btn.addEventListener('mouseenter', () => btn.style.backgroundColor = '#e0e0e0');
        btn.addEventListener('mouseleave', () => btn.style.backgroundColor = '#fff');
        
        // Verificação da resposta
        btn.addEventListener('click', () => {
            if (index === q.correta) {
                currentScore++;
                alert("Correto!");
            } else {
                alert("Incorreto!");
            }
            currentQuestionIndex++;
            if (currentQuestionIndex < quizQuestions.length) {
                loadQuestion();
            } else {
                displayResult();
            }
        });
        quizContent.appendChild(btn);
    });
}

// Mostrar Resultado
function displayResult() {
    quizContent.innerHTML = `
        <h3>Quiz Finalizado!</h3>
        <p>Você acertou <strong>${currentScore}</strong> de <strong>${quizQuestions.length}</strong> perguntas.</p>
    `;
    
    // Botão para reiniciar o quiz
    const restartBtn = document.createElement('button');
    restartBtn.textContent = 'Reiniciar Quiz';
    restartBtn.style.marginTop = '15px';
    restartBtn.style.padding = '10px 20px';
    restartBtn.style.backgroundColor = '#800080';
    restartBtn.style.color = 'white';
    restartBtn.style.border = '1px solid #800080';
    restartBtn.style.borderRadius = '5px';
    restartBtn.style.cursor = 'pointer';
    
    restartBtn.addEventListener('click', () => {
        currentQuestionIndex = 0;
        currentScore = 0;
        loadQuestion();
    });
    
    quizContent.appendChild(restartBtn);
}

// Iniciar o Quiz
loadQuestion();


// 6. UTILITÁRIOS (Botão Voltar ao Topo)
  
// Botão "Voltar ao Topo"
const backToTopBtn = document.createElement('button');
backToTopBtn.textContent = 'Voltar ao Topo';
backToTopBtn.style.position = 'fixed';
backToTopBtn.style.bottom = '20px';
backToTopBtn.style.right = '20px';
backToTopBtn.style.display = 'none';
backToTopBtn.style.padding = '10px 15px';
backToTopBtn.style.backgroundColor = '#800080';
backToTopBtn.style.color = '#fff';
backToTopBtn.style.border = '1px solid #800080';
backToTopBtn.style.borderRadius = '5px';
backToTopBtn.style.cursor = 'pointer';
backToTopBtn.style.zIndex = '1000';

document.body.appendChild(backToTopBtn);

backToTopBtn.addEventListener('click', () => {
    window.scrollTo({ top: 0, behavior: 'smooth' });
});

// Mostrar o botão ao rolar a página
window.addEventListener('scroll', () => {
    if (window.scrollY > 300) {
        backToTopBtn.style.display = 'block';
    } else {
        backToTopBtn.style.display = 'none';
    }
});
