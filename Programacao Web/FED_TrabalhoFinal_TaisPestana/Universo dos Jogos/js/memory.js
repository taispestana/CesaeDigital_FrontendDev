// Memory game - simple emoji pairs
const memoryBoard = document.getElementById('memoryBoard');
const memoryReset = document.getElementById('memoryReset');
const memoryMoves = document.getElementById('memoryMoves');
const memoryPairs = document.getElementById('memoryPairs');

const icons = ['🍄','⭐','🎮','👾','🚀','🧩','⚡','🎲'];
let cards = [];
let firstCard = null;
let secondCard = null;
let moves = 0;
let foundPairs = 0;
let lockBoard = false;

function initMemory(){
  const selected = icons.concat(icons).slice(0,16); // 8 pairs -> 16
  cards = shuffle(selected);
  memoryBoard.innerHTML = '';
  cards.forEach((icon, idx) => {
    const el = document.createElement('div');
    el.classList.add('memory-card');
    el.dataset.icon = icon;
    el.dataset.index = idx;
    el.textContent = '';
    el.addEventListener('click', onCardClick);
    memoryBoard.appendChild(el);
  });
  moves=0; foundPairs=0; updateMemoryUI();
}

function onCardClick(e){
  if(lockBoard) return;
  const el = e.currentTarget;
  if(el === firstCard) return;
  revealCard(el);
  if(!firstCard){
    firstCard = el;
    return;
  }
  secondCard = el;
  moves++;
  updateMemoryUI();
  if(firstCard.dataset.icon === secondCard.dataset.icon){
    // match
    firstCard.classList.add('flipped');
    secondCard.classList.add('flipped');
    foundPairs++;
    resetSelection();
    updateMemoryUI();
    if(foundPairs === cards.length/2){
      // win
    }
  } else {
    lockBoard = true;
    setTimeout(()=>{
      hideCard(firstCard);
      hideCard(secondCard);
      resetSelection();
      lockBoard = false;
    }, 800);
  }
}

function revealCard(el){
  el.textContent = el.dataset.icon;
  el.classList.add('flipped');
  el.style.pointerEvents = 'none';
}

function hideCard(el){
  el.textContent = '';
  el.classList.remove('flipped');
  el.style.pointerEvents = 'auto';
}

function resetSelection(){
  firstCard = null;
  secondCard = null;
}

function updateMemoryUI(){
  memoryMoves.textContent = moves;
  memoryPairs.textContent = foundPairs;
}

function shuffle(array){
  const arr = array.slice();
  for(let i=arr.length-1;i>0;i--){
    const j = Math.floor(Math.random()*(i+1));
    [arr[i], arr[j]] = [arr[j], arr[i]];
  }
  return arr;
}

memoryReset.addEventListener('click', initMemory);
// init
initMemory();
