<script setup>
import { reactive } from 'vue';
import { useRouter } from 'vue-router';

const variaveis = reactive({
  items: [
    {
      "localizacao": "Rua B, 315",
      "capacidade": 5,
      "descricao": "Totem de bicicletas da Rua B"
    },
    {
      "localizacao": "Av. Voluntários da Pátria, 315",
      "capacidade": 5,
      "descricao": "Totem de bicicletas da Av. Voluntários da Pátria"
    },
    {
      "localizacao": "Rua Josá Júlio Louzada, 315",
      "capacidade": 5,
      "descricao": "Totem de bicicletas da Rua Josá Júlio Louzada"
    },
    {
      "localizacao": "Av. João Jaime, 315",
      "capacidade": 5,
      "descricao": "Totem de bicicletas da Av. João Jaime"
    },
    {
      "localizacao": "Rua Manoel Duca, 315",
      "capacidade": 5,
      "descricao": "Totem de bicicletas da Rua Manoel Duca"
    },
  ],
  headers: [
    { title: "Localização", key: "localizacao" },
    { title: "Capacidade", key: "capacidade" },
    { title: "Descrição", key: "descricao", sortable: false },
    { title: "Ações", key: "actions", sortable: false },
  ],
})
function goTo(){
  this.$router.push({path: 'bicicleta'})
}
</script>

<template>
  <v-data-table :items="variaveis.items" :headers="variaveis.headers" class="data-table">
    <template v-slot:item.actions="{ item }">
      <v-icon class="mr-3" @click="editItem(item)">
        mdi-map-marker
      </v-icon>
      <v-icon @click="$router.push({path: '/bicicleta'})">
        mdi-bicycle
      </v-icon>
    </template>
  </v-data-table>
</template>

<style scoped>
.data-table{
  padding: 0;
  margin: 0;
  border: none;
  width: 90%;
}
</style>