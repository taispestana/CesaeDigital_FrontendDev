import React, { useState } from 'react';
import './NewDishForm.css';

// Componente de formulário para adicionar um novo prato
export default function NewDishForm({ onAddDish }) {
  // Estado para armazenar os dados do novo prato
  const [dishData, setDishData] = useState({
    title: '',
    description: '',
    price: '',
    image: {
      alt: ''
    },
    category: 'principal'
  });
  // Estado para armazenar o arquivo de imagem selecionado
  const [selectedFile, setSelectedFile] = useState(null);

  // Lida com a mudança nos campos de texto e select do formulário
  function handleChange(event) {
    const { name, value } = event.target;
    // Lógica específica para atualizar o 'alt' da imagem
    if (name === 'imageAlt') {
      setDishData((prevData) => ({
        ...prevData,
        image: { ...prevData.image, alt: value },
      }));
    } else {
      // Atualiza outros campos do dishData
      setDishData((prevData) => ({
        ...prevData,
        [name]: value,
      }));
    }
  }

  // Lida com a seleção do arquivo de imagem
  function handleFileChange(event) {
    setSelectedFile(event.target.files[0]); // Armazena o arquivo selecionado
  }

  // Lida com o envio do formulário
  function handleSubmit(event) {
    event.preventDefault(); // Previne o comportamento padrão de recarregar a página

    // Validação básica dos campos obrigatórios
    if (!dishData.title || !dishData.description || !dishData.price || !selectedFile) {
      alert('Por favor, preencha todos os campos obrigatórios (Título, Descrição, Preço e Imagem).');
      return; // Impede o envio se a validação falhar
    }

    // Cria um objeto FormData para enviar dados do formulário, incluindo o arquivo
    const dataToSend = new FormData();
    dataToSend.append('title', dishData.title);
    dataToSend.append('description', dishData.description);
    dataToSend.append('price', dishData.price);
    dataToSend.append('category', dishData.category);
    dataToSend.append('imageAlt', dishData.image.alt);
    dataToSend.append('image', selectedFile); // Adiciona o arquivo de imagem

    // Chama a função onAddDish passada via props para enviar os dados
    onAddDish(dataToSend);

    // Limpa o formulário após o envio
    setDishData({
      title: '',
      description: '',
      price: '',
      image: {
        alt: ''
      },
      category: 'principal'
    });
    setSelectedFile(null); // Limpa o arquivo selecionado
    event.target.reset(); // Reseta o formulário HTML
  }

  return (
    <form className="new-dish-form" onSubmit={handleSubmit}>
      <h2>Adicionar Novo Prato</h2>
      <div className="form-control">
        <label htmlFor="title">Título</label>
        <input
          type="text"
          id="title"
          name="title"
          value={dishData.title}
          onChange={handleChange}
          required // Campo obrigatório
        />
      </div>
      <div className="form-control">
        <label htmlFor="description">Descrição</label>
        <textarea
          id="description"
          name="description"
          rows="3"
          value={dishData.description}
          onChange={handleChange}
          required // Campo obrigatório
        ></textarea>
      </div>
      <div className="form-control">
        <label htmlFor="price">Preço (€)</label>
        <input
          type="number"
          id="price"
          name="price"
          step="0.01" // Permite valores decimais
          value={dishData.price}
          onChange={handleChange}
          required // Campo obrigatório
        />
      </div>

      <div className="form-control">
        <label htmlFor="imageFile">Carregar Imagem do Computador</label>
        <input
          type="file"
          id="imageFile"
          name="imageFile"
          accept="image/*" // Aceita apenas arquivos de imagem
          onChange={handleFileChange}
          required // Campo obrigatório
        />
      </div>

      <div className="form-control">
        <label htmlFor="imageAlt">Texto Alternativo da Imagem</label>
        <input
          type="text"
          id="imageAlt"
          name="imageAlt"
          value={dishData.image.alt}
          onChange={handleChange}
          required // Campo obrigatório
        />
      </div>
      <div className="form-control">
        <label htmlFor="category">Categoria</label>
        <select
          id="category"
          name="category"
          value={dishData.category}
          onChange={handleChange}
        >
          <option value="entrada">Entrada</option>
          <option value="principal">Principal</option>
          <option value="sobremesa">Sobremesa</option>
        </select>
      </div>
      <div className="form-actions">
        <button type="submit" className="btn btn--primary">
          Adicionar Prato
        </button>
      </div>
    </form>
  );
}
