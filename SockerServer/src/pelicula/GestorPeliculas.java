package pelicula;

import java.util.ArrayList;
import java.util.List;

public class GestorPeliculas {

    private static List<Pelicula> listaPeliculas;

    public GestorPeliculas() {
        // Inicializa la lista de películas y agrega algunas películas de ejemplo
        listaPeliculas = new ArrayList<>();
        
        listaPeliculas.add(new Pelicula("1", "El Padrino", "Francis Ford Coppola", 15.5));
        listaPeliculas.add(new Pelicula("2", "Titanic", "James Cameron", 30.0));
        listaPeliculas.add(new Pelicula("3", "Terminator", "James Cameron", 12.75));
        listaPeliculas.add(new Pelicula("4", "Star Wars", "George Lucas", 5.75));
        listaPeliculas.add(new Pelicula("5", "Avatar", "James Cameron", 3.99));
    }

    // Método para agregar una película a la lista
    public void agregarPelicula(Pelicula pelicula) {
        listaPeliculas.add(pelicula);
    }

    // Método para obtener una película por su ID
    public Pelicula obtenerPeliculaPorID(String id) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getId().equalsIgnoreCase(id)) {
                return pelicula;
            }
        }
        return null; // Si no se encuentra una película con el ID proporcionado
    }

    // Método para obtener una película por su título
    public Pelicula obtenerPeliculaPorTitulo(String titulo) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null; // Si no se encuentra una película con el título proporcionado
    }

    // Método para obtener una lista de películas por director
    public List<Pelicula> obtenerPeliculasPorDirector(String director) {
        List<Pelicula> peliculasDirector = new ArrayList<>();

        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getDirector().equalsIgnoreCase(director)) {
                peliculasDirector.add(pelicula);
            }
        }

        if (peliculasDirector.isEmpty()) {
            return new ArrayList<>(); // Devuelve una lista vacía si no se encontraron películas para el director
        } else {
            return peliculasDirector; // Devuelve la lista de películas encontradas
        }
    }

    // Método para verificar si existe una película con un ID específico
    public boolean existePeliculaConID(String id) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getId().equalsIgnoreCase(id)) {
                return true; // La película con el ID proporcionado ya existe
            }
        }
        return false; // No se encontró una película con el ID proporcionado
    }
}

