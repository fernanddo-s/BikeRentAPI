<!-- fazer um componente com icon de lixeira -->

<script setup>
import { reactive } from 'vue';

const variaveis = reactive({
  dialogDelete: false,
})

const props = defineProps({
  itemId: Number,
  deleteFunc:{
    type:Function
  },
})

</script>

<template>
  <div class="pa-4 text-center">
    <v-dialog v-model="variaveis.dialogDelete" max-width="500">
      <template v-slot:activator="{ props: activatorProps }">
        <v-icon
          class="mr-3 btn-actions" color="error"
          v-bind="activatorProps"
        >mdi-delete</v-icon>
      </template>

      <v-card>
        <v-card-title class="text-h5">Tem certeza de que deseja excluir este item?</v-card-title>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn text="Não" @click="variaveis.dialogDelete = false"></v-btn>
          <v-btn color="primary" text="Sim" @click="props.deleteFunc(props.itemId), variaveis.dialogDelete = false"></v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>