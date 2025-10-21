//  Perguntar ao usuário através do prompt qual dia da
//  semana é e reagir conforme a resposta. Se o usuário
//  responder "Sexta", mostre a mensagem: "Yay,
//  sobrevivemos a mais uma semana!" Caso contrário,
//  exiba uma mensagem a sua escolha. 

let weekDay = prompt('Qual o dia da semana?');

weekDay.toLocaleLowerCase();

if(weekDay === 'segunda'){
    alert('Segunda ... Buhhh')
}
if(weekDay === 'terça'){
    alert('Terça ... Buhhh')
}
if(weekDay === 'quarta'){
    alert('Quarta ... Buhhh')
}
if(weekDay === 'quinta'){
    alert('Quinta ... Buhhh')
}
if(weekDay === 'sexta'){
    alert('Sexta ... Buhhh')
}