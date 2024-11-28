import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import("@/views/HomeView.vue"),
  },
  {
    path: '/bicicleta',
    name: 'bicicleta',
    component: () => import("@/views/BicicletaView.vue")
  },
  {
    path: '/usuarios',
    name: 'usuarios',
    component: () => import("@/views/UsersView.vue")
  },
  {
    path: '/login',
    name: 'login',
    component: () => import("@/views/LoginView.vue")
  },
  {
    path: '/singin',
    name: 'singin',
    component: () => import("@/views/CadastroUser.vue")
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
