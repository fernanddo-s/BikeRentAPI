<script setup>
import { reactive } from 'vue';


const variaveis = reactive({
  items:[
    { title: 'Listar Usuários' },
    { title: 'Informações da Conta' },
    { title: 'Sair' }
  ]
})

</script>

<template>
  <v-menu>
    <template v-slot:activator="{ props }">
      <v-btn color="primary" dark v-bind="props" prepend-icon="mdi-account">Conta</v-btn>
    </template>
    <v-list>
      <v-list-item v-for="(item, index) in variaveis.items" :key="index">
        <v-list-item-title>{{ item.title }}</v-list-item-title>
      </v-list-item>
      <a href="" >ppp</a>
      <v-btn @click="$router.push({ path:'/usuarios' })" >Usuários</v-btn>
    </v-list>
  </v-menu>

</template>