// Reflex game - click appearing blocks
const reflexArea = document.getElementById('reflexArea');
const reflexStart = document.getElementById('reflexStart');
const reflexReset = document.getElementById('reflexReset');
const reflexTime = document.getElementById('reflexTime');
const reflexScore = document.getElementById('reflexScore');

let reflexTimer;
let spawnTimer;
let timeLeft = 30;
let score = 0;

function startReflex(){
  resetReflex();
  timeLeft = 30;
  reflexTime.textContent = timeLeft;
  reflexTimer = setInterval(()=>{
    timeLeft--;
    reflexTime.textContent = timeLeft;
    if(timeLeft<=0){
      endReflex();
    }
  },1000);
  spawnTimer = setInterval(spawnBlock, 800);
}

function spawnBlock(){
  const block = document.createElement('div');
  block.classList.add('reflex-block');
  const areaRect = reflexArea.getBoundingClientRect();
  const maxX = Math.max(areaRect.width - 60, 0);
  const maxY = Math.max(areaRect.height - 60, 0);
  const x = Math.random()*maxX;
  const y = Math.random()*maxY;
  block.style.left = x + 'px';
  block.style.top = y + 'px';
  block.textContent = Math.floor(Math.random()*90)+10;
  block.addEventListener('click', ()=>{
    score += 10;
    reflexScore.textContent = score;
    block.remove();
  });
  reflexArea.appendChild(block);
  // remove after short time
  setTimeout(()=>{ if(block.parentElement) block.remove(); }, 900);
}

function endReflex() {
  clearInterval(reflexTimer);
  clearInterval(spawnTimer);
  reflexArea.innerHTML = '';

  const popupOverlay = document.createElement('div');
  popupOverlay.className = 'popup-overlay active';

  const popupContent = document.createElement('div');
  popupContent.className = 'popup-content';

  popupContent.innerHTML = `
    <h3>Tempo Esgotado!</h3>
    <p>Sua pontuação final foi: ${score}</p>
    <button id="closePopup">Fechar</button>
  `;

  popupOverlay.appendChild(popupContent);
  document.body.appendChild(popupOverlay);

  popupContent.querySelector('#closePopup').addEventListener('click', () => {
    document.body.removeChild(popupOverlay);
    resetReflex(); // Opcional: resetar o jogo ao fechar o popup
  });
}

function resetReflex(){
  clearInterval(reflexTimer);
  clearInterval(spawnTimer);
  reflexArea.innerHTML = '';
  score = 0;
  reflexScore.textContent = score;
  timeLeft = 30;
  reflexTime.textContent = timeLeft;
}

reflexStart.addEventListener('click', startReflex);
reflexReset.addEventListener('click', resetReflex);
// ensure area cleared on load
resetReflex();
