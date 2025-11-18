document.addEventListener("DOMContentLoaded", () => {
  const canvas = document.getElementById("snakeCanvas");
  const ctx = canvas.getContext("2d");

  let scale = 20;
  let rows, cols;
  let snake, food, snakeInterval;

  // ---------- CONFIGURA O CANVAS DE FORMA RESPONSIVA ----------
  function resizeCanvas() {
    const containerWidth = canvas.parentElement.clientWidth;

    // igualar proporção dos outros jogos
    const maxWidth = Math.min(containerWidth, 350);

    canvas.width = Math.floor(maxWidth / scale) * scale;
    canvas.height = canvas.width; // sempre quadrado

    rows = canvas.height / scale;
    cols = canvas.width / scale;

    if (snake) {
      resetSnake();
    }
  }

  // Recalcular ao abrir a página e ao mexer na tela
  resizeCanvas();
  window.addEventListener("resize", resizeCanvas);

  // ---------- CLASSE SNAKE ----------
  class Snake {
    constructor() {
      this.x = Math.floor(cols / 2);
      this.y = Math.floor(rows / 2);
      this.xSpeed = 1;
      this.ySpeed = 0;
      this.tail = [];
      this.maxTail = 3;
    }

    draw() {
      ctx.clearRect(0, 0, canvas.width, canvas.height);
      ctx.fillStyle = "#00FF00";

      for (let part of this.tail) {
        ctx.fillRect(part.x * scale, part.y * scale, scale, scale);
      }
      ctx.fillRect(this.x * scale, this.y * scale, scale, scale);

      // comida
      ctx.fillStyle = "red";
      ctx.fillRect(food.x * scale, food.y * scale, scale, scale);
    }

    update() {
      this.tail.push({ x: this.x, y: this.y });
      while (this.tail.length > this.maxTail) this.tail.shift();

      this.x += this.xSpeed;
      this.y += this.ySpeed;

      // colisão paredes
      if (this.x < 0 || this.x >= cols || this.y < 0 || this.y >= rows) {
        resetSnake();
      }

      // colisão com o próprio corpo
      for (let part of this.tail) {
        if (this.x === part.x && this.y === part.y) {
          resetSnake();
        }
      }

      // comer comida
      if (this.x === food.x && this.y === food.y) {
        this.maxTail++;
        updateScore();
        placeFood();
      }
    }
  }

  // ---------- FUNÇÕES AUX ----------
  function placeFood() {
    food = {
      x: Math.floor(Math.random() * cols),
      y: Math.floor(Math.random() * rows),
    };
  }

  function resetSnake() {
    clearInterval(snakeInterval);
    snake = new Snake();
    placeFood();
    document.getElementById("snakeScore").textContent = 0;
    document.getElementById("snakeStart").disabled = false;
  }

  function updateScore() {
    let s = parseInt(document.getElementById("snakeScore").textContent);
    document.getElementById("snakeScore").textContent = s + 10;
  }

  // ---------- GAME LOOP ----------
  function gameLoop() {
    snake.update();
    snake.draw();
  }

  // ---------- CONTROLES ----------
  document.addEventListener("keydown", (e) => {
    if (!snake) return;

    if (e.key === "w" || e.key === "W") snake.changeDirection("Up");
    if (e.key === "s" || e.key === "S") snake.changeDirection("Down");
    if (e.key === "a" || e.key === "A") snake.changeDirection("Left");
    if (e.key === "d" || e.key === "D") snake.changeDirection("Right");
  });

  Snake.prototype.changeDirection = function (dir) {
    if (dir === "Up" && this.ySpeed === 0) {
      this.xSpeed = 0;
      this.ySpeed = -1;
    }
    if (dir === "Down" && this.ySpeed === 0) {
      this.xSpeed = 0;
      this.ySpeed = 1;
    }
    if (dir === "Left" && this.xSpeed === 0) {
      this.xSpeed = -1;
      this.ySpeed = 0;
    }
    if (dir === "Right" && this.xSpeed === 0) {
      this.xSpeed = 1;
      this.ySpeed = 0;
    }
  };

  // ---------- BOTÕES ----------
  document.getElementById("snakeStart").addEventListener("click", () => {
    document.getElementById("snakeStart").disabled = true;
    snakeInterval = setInterval(gameLoop, 120);
  });

  document.getElementById("snakeReset").addEventListener("click", () => {
    resetSnake();
  });

  resetSnake();
});
