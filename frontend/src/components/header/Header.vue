<script setup>
import UserMenu from '../menu/UserMenu.vue';
</script>

<template>
  <div class="main-header">
    <v-btn @click="this.$router.push({ path:'/' })" class="home">Home</v-btn>
    <div class="user-menu">
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
  justify-content: space-between;
  align-items: center;
}

.user-menu{
  margin-right: 10px;
}

.home{
  margin-left: 10px;
}
</style>