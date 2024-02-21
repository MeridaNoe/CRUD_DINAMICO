import axios from "axios";

const API_URL = "http://localhost:8080/api/peliculas/post";

const crearPelicula = async (nombre, director, duracion, genero) => {
  try {
    const response = await axios.post(API_URL, {
      nombre,
      director,
      duracion,
      genero,
    });
    return response.data;
  } catch (error) {
    throw error;
  }
};

export default {
  crearPelicula,
};
