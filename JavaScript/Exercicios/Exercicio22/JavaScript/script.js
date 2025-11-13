const container = document.querySelector('.button-container');

// Função para gerar cor aleatória
function getRandomColor() {
  return '#' + Math.floor(Math.random() * 16777215).toString(16).padStart(6, '0');
}

// Função para criar um quadrado com botão e display de cor
function createColorBox() {
  const box = document.createElement('div');
  box.className = 'd-flex flex-column align-items-center justify-content-center border rounded p-3 m-2';
  box.style.width = '200px';
  box.style.height = '200px';
  box.style.backgroundColor = '#FFFFFF';

  const button = document.createElement('button');
  button.className = 'btn btn-primary';
  button.textContent = 'Mudar Cor';

  const colorCodeDiv = document.createElement('div');
  colorCodeDiv.className = 'fw-bold mt-2';
  colorCodeDiv.textContent = '#FFFFFF';

  button.addEventListener('click', () => {
    const newColor = getRandomColor();
    box.style.backgroundColor = newColor;
    colorCodeDiv.textContent = newColor;
  });

  box.appendChild(button);
  box.appendChild(colorCodeDiv);
  container.appendChild(box);
}

// Criar dois quadrados
createColorBox();
createColorBox();
