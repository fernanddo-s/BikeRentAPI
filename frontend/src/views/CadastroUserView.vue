<script setup>
</script>

<template>
  <section class="classe1">
    <div class="classe2">
      <v-card title="Login">
        <v-card-text >
          <v-text-field type="text" label="Login" clearable=""></v-text-field>
          <v-text-field type="password" label="Senha" clearable=""></v-text-field>
          <a href="">Já tenho cadastro</a>
          <v-btn color="primary" @click="$router.push({ path:'/totens' })">Cadastrar</v-btn>
        </v-card-text>
      </v-card>
    </div>
  </section>
</template>

<style scoped>
.classe1{
  display: flex;
  justify-content: center;
}

.classe2{
  width: 500px;
  height: 300px;
  background-color: rebeccapurple;
}
</style>