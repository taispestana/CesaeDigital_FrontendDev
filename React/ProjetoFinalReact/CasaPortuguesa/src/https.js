// Funções para interagir com a API de backend

// Busca os pratos selecionados por um utilizador específico
export async function fetchUserDishes(userEmail) {
  const response = await fetch(`http://localhost:3000/user/dishes?userEmail=${userEmail}`);
  const resData = await response.json();

  if (!response.ok) {
    throw new Error(resData.message || "Falha ao carregar pratos do utilizador.");
  }

  return resData.dishes;
}

// Atualiza os pratos selecionados de um utilizador no backend
export async function updateUserDishes(userDishes, userEmail) {
  const response = await fetch("http://localhost:3000/user/dishes", {
    method: "PUT",
    body: JSON.stringify({ dishes: userDishes, userEmail: userEmail }),
    headers: {
      "Content-Type": "application/json",
    },
  });

  const data = await response.json();
  if (!response.ok) {
    // Este log pode ser útil para depuração do backend, mas não é um erro fatal para o frontend.
    // console.log("Falha ao atualizar pratos do utilizador.");
  }

  return data.message;
}

// Adiciona um novo prato ao menu (usado por administradores)
export async function addNewDish(dishData) {
  let headers = {};
  let body;

  // Lida com FormData (para upload de arquivos) ou JSON
  if (dishData instanceof FormData) {
    body = dishData;
  } else {
    body = JSON.stringify(dishData);
    headers["Content-Type"] = "application/json";
  }

  const response = await fetch("http://localhost:3000/dishes", {
    method: "POST",
    body: body,
    headers: headers,
  });

  const data = await response.json();
  if (!response.ok) {
    throw new Error(data.message || "Falha ao adicionar novo prato.");
  }

  return data.message;
}

// Remove um prato do menu (usado por administradores)
export async function deleteDish(dishId) {
  const response = await fetch(`http://localhost:3000/dishes/${dishId}`, {
    method: "DELETE",
  });

  const data = await response.json();
  if (!response.ok) {
    throw new Error(data.message || "Falha ao remover prato.");
  }

  return data.message;
}

// Busca os pedidos de um utilizador específico pelo seu email
export async function fetchOrders(userEmail) {
  // Validação para garantir que o email foi fornecido
  if (!userEmail) {
    throw new Error("Email do utilizador é necessário para buscar os pedidos.");
  }

  // Adiciona um timestamp para evitar cache do navegador
  const timestamp = new Date().getTime();
  const response = await fetch(`http://localhost:3000/orders?userEmail=${userEmail}&_=${timestamp}`);

  if (!response.ok) {
    // Se o backend retornar 404 (Não Encontrado), significa que não há pedidos para o utilizador,
    // então retorna um array vazio em vez de lançar um erro.
    if (response.status === 404) {
      return [];
    }
    const resData = await response.json();
    throw new Error(resData.message || "Falha ao carregar pedidos.");
  }

  const resData = await response.json();
  return resData.orders || []; // Garante que sempre retorna um array
}

// Busca todos os pedidos para a área administrativa
export async function fetchAdminOrders() {
  const response = await fetch("http://localhost:3000/admin/orders");
  const resData = await response.json();

  if (!response.ok) {
    throw new Error(resData.message || "Falha ao carregar todos os pedidos.");
  }

  return resData.orders;
}

// Atualiza o estado de um pedido (usado pela cozinha/gerente)
export async function updateOrderStatus(orderId, newStatus) {
  const response = await fetch(`http://localhost:3000/orders/${orderId}/status`, {
    method: "PUT",
    body: JSON.stringify({ status: newStatus }),
    headers: {
      "Content-Type": "application/json",
    },
  });

  const data = await response.json();
  if (!response.ok) {
    throw new Error(data.message || "Falha ao atualizar estado do pedido.");
  }

  return data.message;
}

// Realiza um novo pedido
export async function placeOrder(orderData, userEmail) {
  const response = await fetch("http://localhost:3000/orders", {
    method: "POST",
    // Envia os dados do pedido e o email do utilizador
    body: JSON.stringify({ ...orderData, userEmail: userEmail }),
    headers: {
      "Content-Type": "application/json",
    },
  });

  const data = await response.json();
  if (!response.ok) {
    throw new Error(data.message || "Falha ao realizar pedido.");
  }

  return data.message;
}
