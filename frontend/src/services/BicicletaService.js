let bicicletas = [
  {
    numero: '001',
    marca: 'Monark',
    modelo: 'Barra Circular',
    ano: '2000',
    status: 'OCUPADA',
  },
  {
    numero: '001',
    marca: 'Monark',
    modelo: 'Barra Circular',
    ano: '2000',
    status: 'OCUPADA',
  },
  {
    numero: '001',
    marca: 'Monark',
    modelo: 'Barra Circular',
    ano: '2000',
    status: 'OCUPADA',
  },
  {
    numero: '001',
    marca: 'Monark',
    modelo: 'Barra Circular',
    ano: '2000',
    status: 'OCUPADA',
  },
]

export function getBicicletas(){
  try {
    return bicicletas;
  } catch (error) {
    console.error("Erro ao buscar bicicletas:", error);
    return [];
  }
}
