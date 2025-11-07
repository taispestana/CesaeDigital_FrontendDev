// Snake game (simple) - uses canvas
const canvas = document.getElementById('snakeCanvas');
const ctx = canvas.getContext('2d');
const scale = 20;
const rows = canvas.height / scale;
const cols = canvas.width / scale;

let snake;
let food;
let snakeInterval;

class Snake {
  constructor() {
    this.x = Math.floor(cols/2);
    this.y = Math.floor(rows/2);
    this.xSpeed = 1;
    this.ySpeed = 0;
    this.tail = [];
    this.maxTail = 3;
  }
  draw(){
    ctx.fillStyle = "#00FF00";
    ctx.clearRect(0,0,canvas.width,canvas.height);
    for(let i=0;i<this.tail.length;i++){
      ctx.fillRect(this.tail[i].x*scale, this.tail[i].y*scale, scale, scale);
    }
    ctx.fillRect(this.x*scale, this.y*scale, scale, scale);
  }
  update(){
    this.tail.push({x:this.x, y:this.y});
    while(this.tail.length>this.maxTail) this.tail.shift();
    this.x += this.xSpeed;
    this.y += this.ySpeed;
    // wall collision - game over
    if(this.x<0 || this.x>=cols || this.y<0 || this.y>=rows){
      resetSnake();
    }
    // self collision
    for(let i=0;i<this.tail.length;i++){
      if(this.x===this.tail[i].x && this.y===this.tail[i].y){
        resetSnake();
      }
    }
    // eat food
    if(this.x===food.x && this.y===food.y){
      this.maxTail++;
      placeFood();
      updateScore();
    }
  }
  changeDirection(dir){
    switch(dir){
      case 'Up': if(this.ySpeed===0){this.xSpeed=0; this.ySpeed=-1;} break;
      case 'Down': if(this.ySpeed===0){this.xSpeed=0; this.ySpeed=1;} break;
      case 'Left': if(this.xSpeed===0){this.xSpeed=-1; this.ySpeed=0;} break;
      case 'Right': if(this.xSpeed===0){this.xSpeed=1; this.ySpeed=0;} break;
    }
  }
}

function placeFood(){
  food = { x: Math.floor(Math.random()*cols), y: Math.floor(Math.random()*rows) };
  // avoid placing on snake
  for(let i=0;i<snake.tail.length;i++){
    if(food.x===snake.tail[i].x && food.y===snake.tail[i].y){
      placeFood(); return;
    }
  }
}

function resetSnake(){
  clearInterval(snakeInterval);
  snake = new Snake();
  snake.maxTail = 3;
  placeFood();
  document.getElementById('snakeScore').textContent = 0;
  // re-enable start button
  document.getElementById('snakeStart').disabled = false;
}

function updateScore(){
  let sc = parseInt(document.getElementById('snakeScore').textContent) || 0;
  sc += 10;
  document.getElementById('snakeScore').textContent = sc;
}

function gameLoop(){
  snake.update();
  snake.draw();
  // draw food
  ctx.fillStyle = "#FF0000";
  ctx.fillRect(food.x*scale, food.y*scale, scale, scale);
}

document.addEventListener('keydown', (e)=>{
  const key = e.key;
  if(key==='ArrowUp') snake.changeDirection('Up');
  if(key==='ArrowDown') snake.changeDirection('Down');
  if(key==='ArrowLeft') snake.changeDirection('Left');
  if(key==='ArrowRight') snake.changeDirection('Right');
});

document.getElementById('snakeStart').addEventListener('click', ()=>{
  document.getElementById('snakeStart').disabled = true;
  if(!snake) snake = new Snake();
  snakeInterval = setInterval(gameLoop, 120);
});

document.getElementById('snakeReset').addEventListener('click', ()=>{
  resetSnake();
});

// init
resetSnake();
