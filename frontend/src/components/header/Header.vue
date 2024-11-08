<script setup>
import UserMenu from '../menu/UserMenu.vue';
</script>

<template>
  <div class="main-header">
    <v-btn size="small" class="btn-click">Texto do botão</v-btn>
    <UserMenu class="teste"/>
  </div>
</template>

<style scoped>
.main-header{
  width: 100%;
  height: 50px;
  background-color: red;
  display: flex;
  justify-content: end;
  align-items: center;
}

.btn-click{
  margin: 0 10px 0 10px;
}
</style>