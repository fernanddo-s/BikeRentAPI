let totens = [
  {
    id: 1,
    localizacao: "Rua da Água, 410",
    capacidade: 10,
    descricao: "Totem de bicicletas"
  },
  {
    id: 2,
    localizacao: "Rua do Luis Fernando, 315",
    capacidade: 5,
    descricao: "Totem de bicicletas da Rua B"
  },
  {
    id: 3,
    localizacao: "Rua B, 315",
    capacidade: 5,
    descricao: "Totem de bicicletas da Rua B"
  },
  {
    id: 4,
    localizacao: "Novo Totem",
    capacidade: 10,
    descricao: "Totem para testar o id"
  }
]

export function getTotens(){
  try {
    return totens;
  } catch (error) {
    console.error("Erro ao buscar totens:", error);
    return [];
  }
}


// export async function getAllBicicletasByTotem(idTotem){
//   try {
//     const response = await axios.get(`${API_URL}/totem/${idTotem}/bicicletas`);
//     return Array.isArray(response.data) ? response.data : [];
//   } catch (error) {
//     console.error("Erro ao buscar totems:", error);
//     return [];
//   }
// }

// export async function getAllTrancasByTotem(idTotem){
//   try {
//     const response = await axios.get(`${API_URL}/totem/${idTotem}/trancas`);
//     return Array.isArray(response.data) ? response.data : [];
//   } catch (error) {
//     console.error("Erro ao buscar totems:", error);
//     return [];
//   }
// }

export function create(totem){
  try {
    totens.push({id: 0, descricao: totem.descricao, capacidade: totem.capacidade, localizacao: totem.localizacao});
    return totens;
  } catch (error) {
    console.error("Erro ao criar totem:", error);
    return [];
  }
}
