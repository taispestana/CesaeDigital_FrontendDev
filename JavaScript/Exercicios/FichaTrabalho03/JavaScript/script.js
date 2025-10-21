// 1. Função de Boas-vindas
// Escreva uma função chamada boasVindas que:
// • Receba como parâmetro o nome de uma pessoa.
// • Retorne uma mensagem de boas-vindas personalizada na console.  
 
// function boasVindas(nome){
//     nome = prompt(`Digite o seu nome: `)
//     alert (`Olá, ${nome}! Seja Bem-vinda!`)
// }


// 2. Verificador de Número Primo 
// Escreva uma função chamada ehPrimo que: 
// • Receba um número como parâmetro. 
// • Retorne true se o número for primo ou false caso contrário. 
// • Mostre o resultado na console.

// function ehPrimo(numero){

// for(let i= 2; i< numero; i++){

//     if(numero % i === 0){
//         console.log('Não é primo!')
//         return false;
//     }else{
//         console.log('É primo!')
//         return true;
//     }
// }
// }

// ehPrimo(3);


// 3. Função para Converter Temperaturas 
// Crie uma função chamada converterParaFahrenheit que: 
// • Receba uma temperatura em Celsius. 
// • Retorne a temperatura convertida para Fahrenheit. 
// o Fórmula:  C = (F - 32) * 5/9 

// function conversor (tempCelsius){
//     console.log((tempCelsius* 1.8)+ 32)
// }

// conversor(30)


// 4. Gerador de Senhas Aleatórias 
// Crie uma função chamada gerarSenha que: 
// • Receba o tamanho desejado da senha como parâmetro. 
// • Retorne uma senha aleatória contendo letras, números e caracteres especiais.

// function gerarSenha(tamanhoSenha){

//     let senha = "";
//     let listaCaracteres = "ABCDEabcde1234$@"

//     // Ciclo para iterar o mesmo numero do tamanho da senha
//     for(let i = 0; i < tamanhoSenha; i++){
//         senha += listaCaracteres[Math.floor(Math.random()*listaCaracteres.length)]
//     }
//     console.log(senha)
// }

// gerarSenha(10)


// 5. Contador de Vogais 
// Escreva uma função chamada contarVogais que: 
// • Receba uma string como parâmetro. 
// • Retorne o número de vogais na string (a, e, i, o, u). 
// • Imprima na consola 

// function contarVogais(vogal){

// }


// 6. Calculadora Básica 
// Crie uma função chamada calculadora que: 
// • Receba três parâmetros: dois números e uma operação (soma, subtração, multiplicação ou divisão). 
// • Retorne o resultado da operação. 
// • Imprima na consola  