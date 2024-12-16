let usuarios = [
  {
    "cpf": "14725836912",
    "login": "user4@mail.com",
    "idade": 22,
    "role": "USER",
    "matricula": "100006",
    "nome": "Usuário Quatro",
    "senha": "senha101"
  },
  {
    "cpf": "96385274136",
    "login": "manager1@mail.com",
    "idade": 45,
    "role": "MANAGER",
    "matricula": "100007",
    "nome": "Manager Um",
    "senha": "manager123"
  },
  {
    "cpf": "74196385274",
    "login": "manager2@mail.com",
    "idade": 38,
    "role": "MANAGER",
    "matricula": "100008",
    "nome": "Manager Dois",
    "senha": "manager456"
  },
  {
    "cpf": "85236974185",
    "login": "user5@mail.com",
    "idade": 27,
    "role": "USER",
    "matricula": "100009",
    "nome": "Usuário Cinco",
    "senha": "senha555"
  },
  {
    "cpf": "36974185236",
    "login": "admin3@mail.com",
    "idade": 50,
    "role": "ADMIN",
    "matricula": "100010",
    "nome": "Admin Três",
    "senha": "admin999"
  }
]

export function getUsuarios(){
  try {
    return usuarios;
  } catch (error) {
    console.error("Erro ao buscar usuarios:", error);
    return [];
  }
}