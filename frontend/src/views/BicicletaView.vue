<script setup>
import Header from '@/components/header/Header.vue';
import { onMounted, reactive } from 'vue';
import axios from 'axios';

const props = defineProps({
  localizacaoTotem: String
})

async function getItems() {
  try {
    const response = await axios.get("http://localhost:3012/grupo-1-equipamento/bicicleta");
    console.log(response.data);
    return Array.isArray(response.data) ? response.data : []; 
  } catch (error) {
    console.error("Erro ao buscar dados:", error);
    return []; 
  }
}

const variaveis = reactive({
  bicicletas: [], 
  headers: [
    { title: "Número", key: "numero" },
    { title: "Marca", key: "marca" },
    { title: "Modelo", key: "modelo" },
    { title: "Ano", key: "ano" },
    { title: "Status", key: "status" },
    { title: "Ações", key: "actions" },
  ]
})

onMounted(async () => {
  variaveis.bicicletas = await getItems();
});

</script>

<template>
  <Header />
  <v-data-table :items="variaveis.bicicletas" :headers="variaveis.headers">
    <template v-slot:item.actions="{ item }">
      <v-btn>Alugar</v-btn>
    </template>
  </v-data-table>
</template>
