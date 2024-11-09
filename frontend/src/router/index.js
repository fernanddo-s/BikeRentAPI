import { createRouter, createWebHistory } from 'vue-router'

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
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
