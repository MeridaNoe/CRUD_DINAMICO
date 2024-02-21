import axios from 'axios';

const API_URL = 'http://localhost:8080/api/peliculas/genero';

const obtenerGeneros = async (nombre) => {
  try {
    const response = await axios.get(API_URL, {
      params: { nombre }
    });
    return response.data;
  } catch (error) {
    throw error;
  }
};

export default {
    obtenerGeneros
};
