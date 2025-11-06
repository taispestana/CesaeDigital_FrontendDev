//  1Abre o ficheiro idExercise.html e encontra um html
//  com conteúdo.
//  2 Adiciona um ficheiro JS para o exercício e linka o
//  mesmo ao ficheiro.
//  3 Seleciona a imagem pelo seu id e guarda-a numa
//  variável chamada image.
//  4 Seleciona o h1 pelo seu id e guarda-o numa variável
//  chamada heading.
//  5 Faz console log das duas variáveis para verificar se
//  guardou o pretendido.

// const titulo = document.getElementById('titulo');
// const imagem = document.getElementById('imagem_doc');

// console.log(titulo)
// console.log(imagem)

//  1 Abre o ficheiro todos.html e encontra um html já
//  predefinido.
//  2 Usando os seletores, crie uma variável chamada
//  doneTodos e atribui-lhe todos os que têm a class
//  done.
//  3 Seleciona uma checkbox e guarda-a numa variável
//  chamada checkbox. Vai precisar de usar o atributo
//  type, procura na internet :)
//  4 Faz um console.log() de ambas as variáveis para
//  confirmar que está certo.

// let doneTodos = document.querySelectorAll('.done');

// let checkbox = document.querySelectorAll('[type = "checkbox"]');

// console.log(doneTodos)
// console.log(checkbox)


//  1 Abre o ficheiro pickles.html e encontras um html já
//  predefinido.
//  2 Usando JS, muda o conteúdo do Yammi para Yack.

// document.querySelector("h1").innerText = 'Yack';

//  1 Abre o ficheiro chicken.html e encontra um html já
//  predefinido.
//  2 Usando JS, muda a src da imagem para
//  ‘
//  https://devsprouthosting.com/images/chicken.jpg’.
//  3 Adiciona um botão que diga ‘Ovo ou Galinha’ e muda
//  a imagem ao clicar no botão (através de funções);
//  4 Através de decisões if/else muda a foto tanto para a
//  galinha como para o ovo.(Se estiver a galinha, ao
//  clicar muda para o ovo; se estiver o ovo muda para a
//  galinha);

// function mudarImagem(){

//     const imagemGalinhaOvo = document.getElementById("imagem_galinha");

//     imagemGalinhaOvo.getAttribute("src");

//     if (
//         imagemGalinhaOvo.src === "https://media.istockphoto.com/id/1313823703/pt/foto/one-brown-chicken-egg-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=xwuuodcja84SvjrasjFDoor5Wo_3qT6OZ5VmtDs2RbQ="
//     ){
//         imagemGalinhaOvo.setAttribute("src","https://cdn.pixabay.com/photo/2018/10/05/23/24/chicken-3727097_640.jpg")
//     }else{
//         imagemGalinhaOvo.setAttribute("src","https://media.istockphoto.com/id/1313823703/pt/foto/one-brown-chicken-egg-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=xwuuodcja84SvjrasjFDoor5Wo_3qT6OZ5VmtDs2RbQ=")
//     }
// }

// 1 Abra o ficheiro magicalForest.html
//  EXERCÍCIO
//  2 Adiciona ou usa o ficheiro JS anterior para o exercício
//  3 Usando JS:
//  Selecione a div com o id container e coloca o texto
//  alinhado ao centro;
//  Selecione a imagem e dê uma largura de 150px e um
//  border radius de 50%;

// const container = document.getElementById('container');
// container.style.textAlign= 'center';

// const imagem = document.getElementById('floresta');
// imagem.style.widht = '150px';
// imagem.style.borderRadius = '50%';

// 1 Abra o ficheiro rainbow.html
//  EXERCÍCIO
//  2 Chame o seu arquivo JavaScript
//  3 Pinte os spans:
//  Pegue todos os spans: Use o JavaScript para
//  selecionar todos os elementos <span> da página.
//  Crie um array chamado cores: Faça uma lista com
//  as cores do arco-íris.
//  Para cada span, escolha uma cor da sua lista e
//  pinte o fundo dele com essa cor usando o
//  forEach.

const cores = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];

const spans = document.querySelectorAll('span')

spans.forEach((span, index) =>{
    span.style.backgroundColor = cores[index];
    span.style.color = 'white';
    span.style.padding = '8px 12px';     
    span.style.borderRadius = '6px';      
    span.style.margin = '4px';            
    span.style.display = 'inline-block';
})