<script setup>
import Header from '@/components/header/Header.vue';
import Totem from '@/components/totem/Totem.vue';
</script>

<template>
  <Header></Header>
  <div class="table">
    <Totem/>
  </div>
</template>

<style scoped>
.table{
  width: 100%;
  justify-content: center;
  display: flex;
}
</style>