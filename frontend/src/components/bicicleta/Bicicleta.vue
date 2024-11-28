<script setup>
import { onMounted, reactive } from 'vue';
const props = defineProps({
  localizacaoTotem: String,
  idTotem: Number
})

const variaveis = reactive({
  trancas: [
    {
        "id": 2,
        "totem": {
            "id": 3,
            "localizacao": "Rua B, 315",
            "capacidade": 5,
            "descricao": "Totem de bicicletas da Rua B"
        },
        "bicicleta": {
            "id": 3,
            "numero": 1,
            "marca": "Monark02",
            "modelo": "Barra Circular",
            "ano": "2024",
            "status": "DISPONIVEL"
        },
        "numero": 1,
        "localizacao": "Localizada na rua C",
        "anoFabricacao": "2024",
        "modelo": "Modelo 3D",
        "status": "OCUPADA"
    }
],
  headers: [
    { title: "Número Tranca", key: "numero" },
    { title: "Status Tranca", key: "status" },
    { title: "Número Bicileta", key: "bicicleta.numero" },
    { title: "Marca Bicicleta", key: "bicicleta.marca" },
    { title: "Modelo Bicicleta", key: "bicicleta.modelo" },
    { title: "Status Bicicleta", key: "bicicleta.status" },
    { title: "Ações", key: "actions" },
  ]
})


</script>

<template>
  <v-data-table :items="variaveis.trancas" :headers="variaveis.headers" :hide-default-footer="true">
    <template v-slot:item.actions="{ item }">
      <v-btn v-if="item.bicicleta != null">Alugar</v-btn>
      <v-btn v-else>Devolver</v-btn>
    </template>
  </v-data-table>
</template>
