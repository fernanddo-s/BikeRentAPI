import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/totens',
    name: 'totens',
    component: () => import('@/views/TotemView.vue'),
  },
  {
    path: '/bicicletas',
    name: 'bicicletas',
    component: () => import('@/views/BicicletaView.vue'),
  },
  {
    path: '/usuarios',
    name: 'usuarios',
    component: () => import('@/views/UsersView.vue'),
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/LoginView.vue'),
  },
  {
    path: '/singin',
    name: 'singin',
    component: () => import('@/views/CadastroUserView.vue'),
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
