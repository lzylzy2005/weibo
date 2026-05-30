import { createRouter, createWebHistory } from 'vue-router'
import Login from '../Login.vue'
import Weibo from '../Weibo.vue'

const routes = [
  { path: '/', component: Login },
  { path: '/weibo', component: Weibo }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router