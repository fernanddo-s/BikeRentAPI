<script setup>
import { onMounted, reactive } from 'vue';
import TotemForm from '../forms/TotemForm.vue';
import DialogDelete from '../dialogDelete/DialogDelete.vue';
import Bicicleta from '@/components/bicicleta/Bicicleta.vue';
import { getTotems } from '@/services/TotemService';

const variaveis = reactive({
  totems: [],
  headers: [
    { title: "Localização", key: "localizacao" },
    { title: "Capacidade", key: "capacidade" },
    { title: "Descrição", key: "descricao", sortable: false },
    { title: "Ações", key: "actions", sortable: false, align: 'center' },
  ],
  totem:{
    localizacao: '',
    capacidade: '',
    descricao: '',
  },
  dialogDelete:false
})

function novoTotome(totem){
  variaveis.totems.push(totem);
}

onMounted( async () => {
  variaveis.totems = getTotems();
  console.log(variaveis.totems)
})

</script>

<template>
  <v-data-table @update:options="variaveis.totems" :items="variaveis.totems" :headers="variaveis.headers" class="data-table" show-expand="">
    <template v-slot:top>
      <v-toolbar flat>
        <v-toolbar-title>Totens</v-toolbar-title>
        <v-divider class="mx-4" inset vertical></v-divider>
        <v-spacer></v-spacer>
        <totem-form :totem="variaveis.totem" :icon="'mdi-plus'"></totem-form>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-icon class="mr-3 btn-actions">
        mdi-map-marker
      </v-icon>
      <v-icon class="btn-actions">
        mdi-bicycle
      </v-icon>
      <v-icon class="btn-actions" size="x-small">
        <TotemForm :totem="item" :icon="'mdi-pencil'" :editando="true"></TotemForm>
      </v-icon>
      <v-icon size="x-small">
        <DialogDelete :item-id="item.id" :delete-func="apagarTotem"></DialogDelete>
      </v-icon>
    </template>
    <template v-slot:expanded-row="{ columns, item }">
      <tr>
        <td :colspan="columns.length">
          <Bicicleta :localizacao-totem="item.localizacao" :id-totem="item.id"></Bicicleta>
        </td>
      </tr>
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

.btn-actions{
  margin-right: 5px;
}
</style>