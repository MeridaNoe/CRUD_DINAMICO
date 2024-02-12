<template>
  <div>
    <h1>Listado de Películas</h1>
    <b-button @click="modalShow = !modalShow" variant="primary" class="btn-add-movie">
      <b-icon icon="plus"></b-icon>
    </b-button>
    <div class="container mt-5">
      <div class="row equal-height-cards">
        <div class="col-md-4" v-for="(pelicula, index) in peliculasService" :key="index">
          <div class="card text-center">
            <div class="card-body">
              <h5 class="card-title">Pelicula: {{ pelicula.nombre }}</h5>
              <p class="card-text">Director: {{ pelicula.director }}</p>
              <p class="card-text">Duración: {{ pelicula.duracion }}</p>
              <p class="card-text">Género: {{ pelicula.genero }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <b-modal v-model="modalShow" @hide="borrar">
      <h1>Registrar película</h1>
      <b-form @submit.prevent="crearPelicula">
        <b-spinner v-if="loading" label="Cargando..." variant="primary"
          style="position: absolute; top: calc(50% - 1.5rem); right: calc(50% - 1.5rem);"></b-spinner>

        <b-form-group label="Nombre de la película" label-for="name-input"
          invalid-feedback="No se aceptan caracteres especiales">
          <b-form-input id="name-input" v-model="nombre" pattern="[a-zA-Z0-9\s]+" required></b-form-input>
        </b-form-group>
        <b-form-group label="Director" label-for="director-input" invalid-feedback="No se aceptan caracteres especiales">
          <b-form-input id="director-input" v-model="director" pattern="[a-zA-Z0-9\s]+" required></b-form-input>
        </b-form-group>
        <b-form-group label="Duración de la película" label-for="duracion-input" invalid-feedback="Duración requerida">
          <b-form-select id="duracion-input" v-model="duracion" :options="opciones" required></b-form-select>
        </b-form-group>
        <b-form-group label="Género" label-for="genero-input" invalid-feedback="Género requerido">
          <b-form-select id="genero-input" v-model="selected" :options="generos" required></b-form-select>
        </b-form-group>
        <b-button :disabled="loading" type="submit" variant="primary" style="margin-top: 10px;">
          <span v-if="loading">
            <b-spinner variant="primary" label="Registrando película..."></b-spinner>
          </span>
          <span v-else>Registrar película</span>
        </b-button>
        <div v-if="error" class="text-danger">{{ error }}</div>
      </b-form>
    </b-modal>
  </div>
</template>

<script>
import PeliculaService from "../services/Pelicula";
import PostPelicula from "../services/PostPelicula";
import GeneroService from "../services/Genero";

export default {
  name: 'Peliculas',
  data() {
    return {
      modalShow: false,
      peliculasService: [],
      nombre: '',
      director: '',
      duracion: '',
      selected: null,
      generos: [],
      error: '',
      loading: false,
      opciones: ['01:00:00', '02:00:00', '03:00:00']
    };
  },
  mounted() {
    this.obtenerPeliculas();
    this.obtenerGeneros();
  },
  methods: {
    async obtenerPeliculas() {
      try {
        const data = await PeliculaService.obtenerPeliculas();
        this.peliculasService = data;
      } catch (error) {
        console.error(error);
      }
    },
    async obtenerGeneros() {
      try {
        const data = await GeneroService.obtenerGeneros();
        this.generos = data.map(genero => ({ value: genero, text: genero }));
      } catch (error) {
        console.error(error);
      }
    },
    async crearPelicula() {
      try {
        const { nombre, director, duracion, selected } = this;
        const genero = selected ? selected.value : null;
        this.loading = true;
        await PostPelicula.crearPelicula(nombre, director, duracion, selected);
        this.modalShow = false;
        this.borrar();
        this.obtenerPeliculas();
        this.loading = false;
      } catch (error) {
        this.loading = false;
        console.error(error);
      }
    },
    borrar() {
      this.nombre = '';
      this.director = '';
      this.duracion = '';
      this.selected = null;
    }
  }
};
</script>

<style>
.card {
  height: 225px !important;
  justify-content: center;
  align-items: center;
  flex: 1;
  border-color: white !important;
  box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2) !important;
  padding: 2px;
  margin-top: 5px;
}

.card-img-wrapper {
  height: 190px;
  overflow: hidden;
}

.card-img-top {
  width: 100%;
  height: auto;
}

.btn-add-movie {
  position: absolute;
  top: 10px;
  right: 10px;
}
</style>
