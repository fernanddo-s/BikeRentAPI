<script setup>
import { onMounted, reactive } from 'vue';
import axios from 'axios';

const props = defineProps({
  localizacaoTotem: String,
  idTotem: Number
})

async function getItems(idTotem) {
  try {
    const response = await axios.get(`http://localhost:3012/grupo-1-equipamento/totem/${idTotem}/bicicletas`);
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
  variaveis.bicicletas = await getItems(props.idTotem);
});

</script>

<template>
  <v-data-table :items="variaveis.bicicletas" :headers="variaveis.headers" :hide-default-footer="true">
    <!-- <template v-slot:top>
      <v-toolbar flat>
        <v-toolbar-title>Bicicletas do totem {{ props.localizacaoTotem }}</v-toolbar-title>
        <v-divider class="mx-4" inset vertical></v-divider>
        <v-spacer></v-spacer>
        <v-btn icon="mdi-plus"></v-btn>
      </v-toolbar>
    </template> -->
    <template v-slot:item.actions="{ item }">
      <v-btn>Alugar</v-btn>
      {{ props.idTotem }}
    </template>
  </v-data-table>
</template>
