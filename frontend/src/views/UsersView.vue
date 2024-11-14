<script setup>
import Header from '@/components/header/Header.vue';
import { reactive } from 'vue';

const variaveis = reactive({
  users: [
    {
      "cpf": "00900900909",
      "login": "admin@mail.com",
      "idade": 23,
      "role": "ADMIN",
      "matricula": "479528",
      "nome": "ADMIN do Sistema",
      "senha": "admin123"
    }
  ],
  headers: [
    { title: 'CPF', key: 'cpf'},
    { title: 'Matricula', key: 'matricula' },
    { title: 'Nome', key: 'nome' },
    { title: 'Tipo de Acesso', key: 'role' }
  ]
})

</script>

<template>
<Header></Header>
<v-data-table :items="variaveis.users" :headers="variaveis.headers">

</v-data-table>
</template>