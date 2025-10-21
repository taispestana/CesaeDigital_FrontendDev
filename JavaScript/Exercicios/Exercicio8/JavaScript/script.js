// Cria um objeto chamado product com as seguintes
//  propriedades:
//  nome e dá uma valor a sua escolha.
//  inStock, como verdadeiro.
//  Price com o valor 1.99
//  Colors, com um array de vermelho, azul e verde
//  Imprime na consola os seguintes valores:
//  Price
//  Cor Verde
// Ups, a inflação chegou a nossa loja. Muda o valor do
//  produto para 2.55.

//Criar objeto
let product = {
    name: 't-shirt', 
    inStock: true,
    price:1.99, 
    colors: ['Vermelho', 'Azul', 'Verde']
};

console.log(product.price);
console.log(product.colors[2]);

product.price = 2.55;

console.log(product.price);
console.log(product);