<script setup>
import { onMounted, reactive } from 'vue';
import { getBicicletas } from '@/services/BicicletaService';
import Header from '@/components/header/Header.vue';
import DialogDelete from '@/components/dialogDelete/DialogDelete.vue';
import BicicletaForm from '@/components/forms/BicicletaForm.vue';

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
  variaveis.bicicletas = await getBicicletas();
});

</script>

<template>
  <Header></Header>
  <div class="div">
    <v-data-table :items="variaveis.bicicletas" :headers="variaveis.headers" class="data-table">
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Bicicletas</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <BicicletaForm :icon="'mdi-plus'"></BicicletaForm>
        </v-toolbar>
      </template>
      <template v-slot:item.actions="{ item }">
        <v-icon class="btn-actions" size="x-small">
          <BicicletaForm :bicicleta="item" :icon="'mdi-pencil'" :editando="true"></BicicletaForm>
        </v-icon>
        <v-icon size="x-small">
          <DialogDelete :item-id="item.id" :delete-func="apagarBicicleta"></DialogDelete>
        </v-icon>
      </template>
    </v-data-table>
  </div>
  
</template>

<style scoped>
.div{
  width: 100%;
  display: flex;
  justify-content: center;
}
.data-table{
  padding: 0;
  margin: 0;
  border: none;
  width: 90%;
}
</style>