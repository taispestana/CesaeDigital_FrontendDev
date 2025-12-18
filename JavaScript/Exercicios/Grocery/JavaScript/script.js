const form = document.getElementById('grocery-form');
const list = document.getElementById('grocery-list');

form.addEventListener('submit', function(e) {

    e.preventDefault();

    const item = document.getElementById('item').value;
    const quantidade = document.getElementById('quantidade').value;

    //criar um novo elemento

    const novoItem = document.createElement('li'); //criar um novo item na lista
    novoItem.classList.add("list-group"); //adiciona uma nova lista
    novoItem.textContent = `${quantidade} - ${item} `; //texto que vai aparecer
    list.appendChild(novoItem);

    //limpar os campos do formulário
    form.reset();
});