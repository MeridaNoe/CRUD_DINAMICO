import VueRouter from "vue-router";
import Vue from "vue";

Vue.use(VueRouter);

const routes = [
  //la ruta base
  {
    path: "/",
    component: () => import("../components/Peliculas.vue"),
  },

];

const router = new VueRouter({
  mode: "history", // Habilita el modo Historial
  fallback: "true", //Sirve para hacer un modo hibrido
  routes,
});
export default router;
