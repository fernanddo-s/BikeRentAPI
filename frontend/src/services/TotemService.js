import axios from 'axios';
// import { API_JAVA_URL, API_NODE_URL } from "./baseService"

const API_URL = "http://localhost:8080";

export async function getTotems(){
  try {
    const response = await axios.get(`${API_URL}/totem`);
    return Array.isArray(response.data) ? response.data : [];
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

export async function create(totem){
  try {
    const response = await axios.post(`${API_URL}/totem`, totem);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar totems:", error);
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