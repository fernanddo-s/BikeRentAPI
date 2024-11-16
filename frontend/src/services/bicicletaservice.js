/**
 * Configurar chamada para api em java
 * configurar token(deixar copiando por enquanto)
 */
import axios from 'axios';

const API_URL = "http://localhost:8080";

export async function getBicicletas(){
  try {
    const response = await axios.get(`${API_URL}/bicicleta`);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar bicicletas:", error);
    return [];
  }
}

export async function create(bicicleta){
  try {
    const response = await axios.post(`${API_URL}/bicicleta`, bicicleta);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar bicicletas:", error);
    return [];
  }
}

export async function update(id, bicicleta){
  try {
    const response = await axios.put(`${API_URL}/bicicleta/${id}`, bicicleta);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar bicicletas:", error);
    return [];
  }
}

export async function apagar(id){
  try {
    const response = await axios.delete(`${API_URL}/bicicleta/${id}`);
    return Array.isArray(response.data) ? response.data : [];
  } catch (error) {
    console.error("Erro ao buscar bicicletas:", error);
    return [];
  }
}
