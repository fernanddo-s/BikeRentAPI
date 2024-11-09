<script setup>
import Header from '@/components/header/Header.vue';
import { reactive } from 'vue';

const variaveis = reactive({
  bicicletas: [
    {
      "numero": 123,
      "marca": "Colli",
      "modelo": "Full Suspension",
      "ano": "2024",
      "status": "NOVA"
    },
    {
      "numero": 123,
      "marca": "Colli",
      "modelo": "Full Suspension",
      "ano": "2024",
      "status": "NOVA"
    },
    {
      "numero": 123,
      "marca": "Colli",
      "modelo": "Full Suspension",
      "ano": "2024",
      "status": "NOVA"
    },
  ],
  headers:[
    { title: "Número", key: "numero" },
    { title: "Marca", key: "marca" },
    { title: "Modelo", key: "modelo" },
    { title: "Ano", key: "ano" },
    { title: "Status", key: "status" },
    { title: "Ações", key: "actions" },
  ]
})

</script>


<template>
  <Header></Header>
  <v-data-table :items="variaveis.bicicletas" :headers="variaveis.headers">
    <template v-slot:item.actions="{ item }">
      <v-btn>Alugar</v-btn>
    </template>
  </v-data-table>
</template>