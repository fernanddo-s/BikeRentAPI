import { createRouter, createWebHistory } from 'vue-router';
import BicicletaView from '@/views/BicicletaView.vue';

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
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
