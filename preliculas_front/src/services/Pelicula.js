import axios from 'axios';

const API_URL = 'http://localhost:8080/api/peliculas/';

const obtenerPeliculas = async (nombre, director, duracion, genero) => {
  try {
    const response = await axios.get(API_URL, {
      params: { nombre, director, duracion, genero }
    });
    return response.data;
  } catch (error) {
    throw error;
  }
};

export default {
  obtenerPeliculas
};
