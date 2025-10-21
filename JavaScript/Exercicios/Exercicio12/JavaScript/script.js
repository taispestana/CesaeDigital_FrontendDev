// Utilizando os loops e as condições que já aprendemos,
//  construa uma lista de compras
// Dicas: 
// A lista é um array.
//  Fazer prompt para o utilizador adicionar items na
//  lista, e adicionar esses items ao array.
//  Criar uma variável "código" e se o utilizador
//  digitar isso, o ciclo acaba e a lista aparece. Por
//  exemplo, se digitar 'fim', deixam de aparecer
//  prompts.


//Criar objeto
//Iniciar com um array vazio
let listaCompras = [];

let palavraCodigo = "fim";

let novoItem = "";

while(novoItem != palavraCodigo){

    novoItem = prompt(`Adicione um novo item a sua lista e use a palavra ${palavraCodigo} para terminar a sua lista`)


    if(novoItem === palavraCodigo){
        break;
    }else{
        listaCompras.push(novoItem)
        console.log(`${novoItem} adicionado a sua lista`)
    }
}

console.log(listaCompras)
