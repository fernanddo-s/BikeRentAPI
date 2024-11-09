<script setup>
import UserMenu from '../menu/UserMenu.vue';
</script>

<template>
  <div class="main-header">
    <v-btn>Adicionar</v-btn>
    <v-btn class="btn-click">Remover</v-btn>
    <div class="teste">
      <UserMenu/>
    </div>
  </div>
</template>

<style scoped>
.main-header{
  width: 100%;
  height: 50px;
  background-color: rgb(200, 200, 200);
  display: flex;
  justify-content: end;
  align-items: center;
}
.teste{
  margin-right: 10px;
}
.btn-click{
  margin: 0 10px 0 10px;
}
</style>