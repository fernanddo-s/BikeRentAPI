<!-- Mostrar trancas com bicicletas
  Mudar o comportamento para pode alugar ou devolver bicicleta
-->
<script setup>
import { onMounted, reactive } from 'vue';
import { getAllTrancasByTotem } from '@/services/TotemService';

const props = defineProps({
  localizacaoTotem: String,
  idTotem: Number
})

const variaveis = reactive({
  bicicletas: [], 
  trancas: [],
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

onMounted(async () => {
  variaveis.trancas = await getAllTrancasByTotem(props.idTotem);
});

</script>

<template>
  <v-data-table :items="variaveis.trancas" :headers="variaveis.headers" :hide-default-footer="true">
    <template v-slot:item.actions="{ item }">
      <v-btn v-if="item.bicicleta != null">Alugar</v-btn>
      <v-btn v-else>Devolver</v-btn>
    </template>
  </v-data-table>
</template>
