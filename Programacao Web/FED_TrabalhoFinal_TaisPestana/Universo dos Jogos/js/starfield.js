const canvas = document.getElementById("starfield");
const ctx = canvas.getContext("2d");

let stars = [];
let shootingStars = [];
let width, height;

function resize() {
  width = canvas.width = window.innerWidth;
  height = canvas.height = window.innerHeight;
}
window.addEventListener("resize", resize);
resize();

// Cria estrelas fixas
for (let i = 0; i < 200; i++) {
  stars.push({
    x: Math.random() * width,
    y: Math.random() * height,
    size: Math.random() * 2 + 1,
    brightness: Math.random() * 0.5 + 0.5,
    twinkleSpeed: Math.random() * 0.02 + 0.005,
    angle: Math.random() * Math.PI * 2,
  });
}

// Função para desenhar estrelas com 5 pontas
function drawStar(x, y, spikes, outerRadius, innerRadius, brightness) {
  let rot = Math.PI / 2 * 3;
  let step = Math.PI / spikes;
  ctx.beginPath();
  ctx.moveTo(x, y - outerRadius);
  for (let i = 0; i < spikes; i++) {
    ctx.lineTo(x + Math.cos(rot) * outerRadius, y + Math.sin(rot) * outerRadius);
    rot += step;
    ctx.lineTo(x + Math.cos(rot) * innerRadius, y + Math.sin(rot) * innerRadius);
    rot += step;
  }
  ctx.lineTo(x, y - outerRadius);
  ctx.closePath();
  ctx.fillStyle = `rgba(255, 255, 255, ${brightness})`;
  ctx.fill();
}

// Criar uma nova estrela cadente
function spawnShootingStar() {
  const startX = Math.random() * width;
  const startY = Math.random() * height * 0.4;

  shootingStars.push({
    x: startX,
    y: startY,
    size: Math.random() * 3 + 2, // tamanho da estrela cadente
    length: Math.random() * 200 + 200, // comprimento do rastro
    speed: Math.random() * 12 + 10, // velocidade da estrela
    opacity: 1,
    angle: (Math.random() * 20 + 60) * (Math.PI / 180), // ângulo diagonal mais natural
  });

  // Próxima estrela cadente entre 5 e 12 segundos
  setTimeout(spawnShootingStar, Math.random() * 7000 + 5000);
}
spawnShootingStar();

function draw() {
  ctx.clearRect(0, 0, width, height);

  // Fundo estrelado
  stars.forEach(star => {
    star.angle += star.twinkleSpeed;
    let brightness = star.brightness + Math.sin(star.angle) * 0.3;
    drawStar(star.x, star.y, 5, star.size, star.size / 2, brightness);
  });

  // Estrelas cadentes
  shootingStars.forEach((s, i) => {
    const tailX = s.x - Math.cos(s.angle) * s.length;
    const tailY = s.y - Math.sin(s.angle) * s.length;

    // Rastro gradiente
    const gradient = ctx.createLinearGradient(s.x, s.y, tailX, tailY);
    gradient.addColorStop(0, `rgba(255, 255, 255, ${s.opacity})`);
    gradient.addColorStop(1, `rgba(255, 255, 255, 0)`);

    ctx.strokeStyle = gradient;
    ctx.lineWidth = 3;
    ctx.beginPath();
    ctx.moveTo(s.x, s.y);
    ctx.lineTo(tailX, tailY);
    ctx.stroke();

    // Corpo brilhante da estrela
    drawStar(s.x, s.y, 5, s.size * 2, s.size, s.opacity);

    // Movimento diagonal
    s.x += Math.cos(s.angle) * s.speed;
    s.y += Math.sin(s.angle) * s.speed;
    s.opacity -= 0.01;

    // Remove quando sai da tela ou desaparece
    if (s.x > width + 200 || s.y > height + 200 || s.opacity <= 0) {
      shootingStars.splice(i, 1);
    }
  });

  requestAnimationFrame(draw);
}

draw();
