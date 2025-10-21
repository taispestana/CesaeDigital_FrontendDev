//Ex01
// let numero1 = 144, numero2=5;
// raizQuadrada1 = Math.sqrt(numero1);
// raizQuadrada2 = Math.sqrt(numero2)
// console.log(`A raiz quadrada de 144 é ${raizQuadrada1} e 5 elevado ao quadrado é ${raizQuadrada2}.`);

//Ex02
// let numero = 7.56789;
// let arredondado = Math.round(numero);
// let paraBaixo = Math.floor(numero);
// let paraCima = Math.ceil(numero);
// console.log(`Número original: ${numero}
// Arredondado para o inteiro mais próximo: ${arredondado}
// Arredondado para baixo: ${paraBaixo}
// Arredondado para cima: ${paraCima}`);

//Ex03
// let aleatorio = Math.random();
// console.log(aleatorio);
// let entre0e100 = Math.random() * 100;
// console.log(entre0e100);
// let inteiro0a100 = Math.floor(Math.random()* 100);
// console.log(inteiro0a100);
// let entre1e10 = Math.floor(Math.random() * 10) + 1;
// console.log(entre1e10);

//Ex04
// let numeros = [45, 12, 78, 4, 90];
// let maior = Math.max(...numeros);
// let menor = Math.min(...numeros);
// console.log(`O maior número da lista é ${maior} e o menor número é ${menor}.`);

//Ex05
let catetoA = 3;
let catetoB = 4;

let hipotenusa = Math.sqrt((catetoA ** 2) + (catetoB ** 2));

console.log(`A hipotenusa do triângulo é ${hipotenusa}.`);