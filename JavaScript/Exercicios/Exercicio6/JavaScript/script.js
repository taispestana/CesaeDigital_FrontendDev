// Crie um array de planetas: Mercúrio, Vénus, Terra,
//  Mart, Jupiter, Saturno, Urano, Neptuno, Plutão.
// Mart foi escrito mal. Substitui pelo nome correto,
//  Marte.
//  Ups, o planeta Plutão foi removido do Sistema Solar..
//  Utilizando os métodos dos arrays, remove o planeta
//  da lista.

let planetas = ['Mercúrio','Vénus','Terra','Mart','Jupiter','Saturno','Urano','Neptuno','Plutão'];

//Corrige a gaveta de indice 3
planetas[3] = "Marte"

//Retirar plutao
planetas.pop();

//Adicionar um novo planeta no inicio do Array
planetas.unshift('Narnia');
console.log(planetas);

