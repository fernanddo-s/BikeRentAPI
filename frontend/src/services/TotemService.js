import axios from 'axios';

const API_URL = "http://localhost:8080";

let totems = [
  {
      "id": 1,
      "localizacao": "Rua da Água, 410",
      "capacidade": 10,
      "descricao": "Totem de bicicletas"
  },
  {
    "id": 2,
    "localizacao": "Rua do Luis Fernando, 315",
    "capacidade": 5,
    "descricao": "Totem de bicicletas da Rua B"
  },
  {
      "id": 3,
      "localizacao": "Rua B, 315",
      "capacidade": 5,
      "descricao": "Totem de bicicletas da Rua B"
  },
  {
      "id": 4,
      "localizacao": "Novo Totem",
      "capacidade": 10,
      "descricao": "Totem para testar o id"
  }
]

export function getTotems(){
  try {
    return totems;
  } catch (error) {
    console.error("Erro ao buscar totems:", error);
    return [];
  }
}

export async function getAllBicicletasByTotem(idTotem){
  try {
    const response = await axios.get(`${API_URL}/totem/${idTotem}/bicicletas`);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar totems:", error);
    return [];
  }
}

export async function getAllTrancasByTotem(idTotem){
  try {
    const response = await axios.get(`${API_URL}/totem/${idTotem}/trancas`);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar totems:", error);
    return [];
  }
}

export function create(totem){
  try {
    console.log(totem.localizacao)
    totems.push(totem);
    console.log(totems)
    return totems;
  } catch (error) {
    console.error("Erro ao criar totem:", error);
    return [];
  }
}

export async function update(id, totem){
  try {
    const response = await axios.put(`${API_URL}/totem/${id}`, totem);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar totems:", error);
    return [];
  }
}

export async function apagar(id){
  try {
    const response = await axios.delete(`${API_URL}/totem/${id}`);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar totems:", error);
    return [];
  }
}