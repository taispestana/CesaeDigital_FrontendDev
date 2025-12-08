import "./Dishes.css";

// Componente para exibir uma lista de pratos (entradas, principais, sobremesas)
export default function Dishes({
  title, // Título da categoria de pratos
  dishes = [], // Array de pratos a serem exibidos
  fallbackText, // Texto a ser exibido se não houver pratos
  onSelectDish, // Função para adicionar um prato ao carrinho
  isLoading, // Indica se os pratos estão sendo carregados
  loadingText, // Texto de carregamento
  expandedDishId, // ID do prato cuja descrição está expandida
  onToggleDescription = () => {}, // Função para alternar a descrição do prato
}) {
  // Formatador de preço para moeda EUR
  const priceFormatter = new Intl.NumberFormat("pt-PT", {
    style: "currency",
    currency: "EUR",
  });

  return (
    <section className="dishes-category">
      <h2>{title}</h2>
      {isLoading && <p className="fallback-text">{loadingText}</p>}
      {!isLoading && (!dishes || dishes.length === 0) && (
        <p className="fallback-text">{fallbackText}</p>
      )}
      {!isLoading && dishes && dishes.length > 0 && (
        <ul className="dishes">
          {dishes.map((dish) => {
            return (
              <li key={dish.id} className="dish-item">
                <div className="dish-item__media">
                  <img
                    src={`http://localhost:3000/${dish.image.src.replace(
                      "backend/",
                      ""
                    )}`}
                    alt={dish.image.alt}
                  />
                  {/* Overlay com a descrição do prato, visível quando expandido */}
                  <div
                    className={`dish-item__overlay ${
                      expandedDishId === dish.id ? "is-expanded" : ""
                    }`}
                  >
                    <p className="dish-item__description">{dish.description}</p>
                  </div>
                </div>
                <div className="dish-item__body">
                  <h3 className="dish-item__title">{dish.title}</h3>
                  <div className="dish-item__meta">
                    <div className="dish-item__price">
                      <span className="dish-item__price--new">
                        {priceFormatter.format(dish.price)}
                      </span>
                    </div>
                    {/* Botão "Ver mais/menos" para alternar a descrição */}
                    <button
                      className="btn-ver-mais"
                      onClick={() => onToggleDescription(dish.id)}
                    >
                      {expandedDishId === dish.id ? "Ver menos" : "Ver mais"}
                    </button>
                  </div>
                  <div className="dish-item__actions">
                    {/* Botão para adicionar o prato ao carrinho */}
                    <button
                      className="btn btn--primary"
                      onClick={() => onSelectDish(dish)}
                    >
                      Adicionar
                    </button>
                  </div>
                </div>
              </li>
            );
          })}
        </ul>
      )}
    </section>
  );
}
