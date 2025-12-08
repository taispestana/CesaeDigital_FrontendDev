import fs from "node:fs/promises";
import bodyParser from "body-parser";
import express from "express";
import multer from "multer";
import path from "node:path";

const app = express();

app.use((req, res, next) => {
  res.setHeader("Access-Control-Allow-Origin", "*");
  res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
  res.setHeader("Access-Control-Allow-Headers", "Content-Type");

  if (req.method === 'OPTIONS') {
    return res.sendStatus(200);
  }

  next();
});

const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, "images");
  },
  filename: (req, file, cb) => {
    cb(null, `${Date.now()}-${file.originalname}`);
  },
});

const upload = multer({ storage: storage });

app.use("/images", express.static("images"));
app.use(bodyParser.json());


app.get("/dishes", async (req, res) => {
  const fileContent = await fs.readFile("./data/dishes.json");
  const dishesData = JSON.parse(fileContent);
  res.status(200).json({ dishes: dishesData });
});

app.post("/dishes", upload.single("image"), async (req, res) => {
  if (!req.file) {
    return res.status(400).json({ message: "Nenhum arquivo de imagem fornecido." });
  }

  const newDish = {
    id: Date.now().toString(),
    title: req.body.title,
    description: req.body.description,
    price: parseFloat(req.body.price),
    category: req.body.category,
    image: {
      src: `images/${req.file.filename}`,
      alt: req.body.imageAlt,
    },
  };

  try {
    const fileContent = await fs.readFile("./data/dishes.json");
    const dishesData = JSON.parse(fileContent);
    dishesData.push(newDish);
    await fs.writeFile("./data/dishes.json", JSON.stringify(dishesData, null, 2));
    res.status(201).json({ message: "Prato adicionado com sucesso!", dish: newDish });
  } catch (error) {
    console.error("Falha ao adicionar prato:", error);
    res.status(500).json({ message: "Falha ao adicionar prato." });
  }
});

app.delete("/dishes/:id", async (req, res) => {
  const dishId = req.params.id;

  try {
    const fileContent = await fs.readFile("./data/dishes.json");
    let dishesData = JSON.parse(fileContent);

    const initialLength = dishesData.length;
    dishesData = dishesData.filter((dish) => dish.id !== dishId);

    if (dishesData.length === initialLength) {
      return res.status(404).json({ message: "Prato não encontrado." });
    }

    await fs.writeFile("./data/dishes.json", JSON.stringify(dishesData, null, 2));
    res.status(200).json({ message: "Prato excluído com sucesso!" });
  } catch (error) {
    console.error("Falha ao excluir prato:", error);
    res.status(500).json({ message: "Falha ao excluir prato." });
  }
});


app.get("/user/dishes", async (req, res) => {
  const userEmail = req.query.userEmail;
  if (!userEmail) {
    return res.status(400).json({ message: "Email do usuário é obrigatório." });
  }

  try {
    const fileContent = await fs.readFile("./data/user-dishes.json");
    const allUserDishes = JSON.parse(fileContent);
    const dishesForUser = allUserDishes[userEmail] || [];
    res.status(200).json({ dishes: dishesForUser });
  } catch (error) {
    console.error("Falha ao carregar pratos do usuário:", error);
    res.status(500).json({ message: "Falha ao carregar pratos do usuário." });
  }
});

app.put("/user/dishes", async (req, res) => {
  const { dishes, userEmail } = req.body;
  if (!userEmail) {
    return res.status(400).json({ message: "Email do usuário é obrigatório." });
  }

  try {
    const fileContent = await fs.readFile("./data/user-dishes.json");
    const allUserDishes = JSON.parse(fileContent);
    allUserDishes[userEmail] = dishes;
    await fs.writeFile("./data/user-dishes.json", JSON.stringify(allUserDishes, null, 2));
    res.status(200).json({ message: "Pratos do usuário atualizados!" });
  } catch (error) {
    console.error("Falha ao atualizar pratos do usuário:", error);
    res.status(500).json({ message: "Falha ao atualizar pratos do usuário." });
  }
});

app.get("/orders", async (req, res) => {
  const userEmail = req.query.userEmail;
  if (!userEmail) {
    return res.status(400).json({ message: "Email do usuário é obrigatório." });
  }
  try {
    const fileContent = await fs.readFile("./data/orders.json");
    const ordersData = JSON.parse(fileContent);
    const userOrders = ordersData.filter(order => order.userEmail === userEmail);
    res.status(200).json({ orders: userOrders });
  } catch (error) {
    console.error("Falha ao carregar pedidos:", error);
    res.status(500).json({ message: "Falha ao carregar pedidos." });
  }
});

app.get("/admin/orders", async (req, res) => {
  try {
    const fileContent = await fs.readFile("./data/orders.json");
    const ordersData = JSON.parse(fileContent);
    res.status(200).json({ orders: ordersData });
  } catch (error) {
    console.error("Falha ao carregar todos os pedidos para o admin:", error);
    res.status(500).json({ message: "Falha ao carregar todos os pedidos." });
  }
});

app.post("/orders", async (req, res) => {
  const { items, total, userEmail } = req.body;

  if (!items || items.length === 0 || total === undefined || !userEmail) {
    return res.status(400).json({ message: "Dados do pedido inválidos ou email do usuário ausente." });
  }

  const newOrder = {
    id: Date.now().toString(),
    userEmail: userEmail,
    items: items,
    total: total,
    status: "Criado",
    createdAt: new Date().toISOString(),
  };

  try {
    const fileContent = await fs.readFile("./data/orders.json");
    const ordersData = JSON.parse(fileContent);
    ordersData.push(newOrder);
    await fs.writeFile("./data/orders.json", JSON.stringify(ordersData, null, 2));

    const userDishesFileContent = await fs.readFile("./data/user-dishes.json");
    const allUserDishes = JSON.parse(userDishesFileContent);
    allUserDishes[userEmail] = [];
    await fs.writeFile("./data/user-dishes.json", JSON.stringify(allUserDishes, null, 2));

    res.status(201).json({ message: "Pedido realizado com sucesso!", order: newOrder });
  } catch (error) {
    console.error("Falha ao criar pedido:", error);
    res.status(500).json({ message: "Falha ao criar pedido." });
  }
});

app.put("/orders/:id/status", async (req, res) => {
  const orderId = req.params.id;
  const { status } = req.body;

  if (!status) {
    return res.status(400).json({ message: "Status é obrigatório." });
  }

  try {
    const fileContent = await fs.readFile("./data/orders.json");
    let ordersData = JSON.parse(fileContent);

    const orderIndex = ordersData.findIndex(order => order.id === orderId);

    if (orderIndex === -1) {
      return res.status(404).json({ message: "Pedido não encontrado." });
    }

    ordersData[orderIndex].status = status;
    await fs.writeFile("./data/orders.json", JSON.stringify(ordersData, null, 2));

    res.status(200).json({ message: "Status do pedido atualizado com sucesso!", order: ordersData[orderIndex] });
  } catch (error) {
    console.error("Falha ao atualizar status do pedido:", error);
    res.status(500).json({ message: "Falha ao atualizar status do pedido." });
  }
});

app.get("/users", async (req, res) => {
  const fileContent = await fs.readFile("./data/users.json");
  const users = JSON.parse(fileContent);
  res.status(200).json({ users });
});


app.post("/signup", async (req, res) => {
  const fileContent = await fs.readFile("./data/users.json");
  const users = JSON.parse(fileContent);

  const newUser = req.body;
  users.push(newUser);

  await fs.writeFile("./data/users.json", JSON.stringify(users, null, 2));
  res.status(200).json({ message: "User Inserted!" });
});


app.post("/login", async (req, res) => {
  const fileContent = await fs.readFile("./data/users.json");
  const users = JSON.parse(fileContent);

  const email = req.body.email;
  const password = req.body.password;

  const login = users.find((u) => u.email === email && u.password === password);

  if (!login) {
    return res.status(422).json({
      message: "Invalid credentials.",
      errors: { credentials: "Invalid email or password entered." },
    });
  }

  const AuthUser = {
    name: login.name,
    role: login.role,
  };

  res.json(AuthUser);
});


app.use((req, res, next) => {
  res.status(404).json({ message: "404 - Não Encontrado" });
});

app.listen(3000);
