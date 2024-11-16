<script setup>
import { onMounted, reactive } from 'vue';
import { getAllBicicletasByTotem } from '@/services/TotemService';

const props = defineProps({
  localizacaoTotem: String,
  idTotem: Number
})

async function getBicicletas(idTotem) {
  return getAllBicicletasByTotem(idTotem)
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
  variaveis.bicicletas = await getBicicletas(props.idTotem);
});

</script>

<template>
  <v-data-table :items="variaveis.bicicletas" :headers="variaveis.headers" :hide-default-footer="true">
    <template v-slot:item.actions="{ item }">
      <v-btn>Alugar</v-btn>
    </template>
  </v-data-table>
</template>
