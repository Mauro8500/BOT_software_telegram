package bo.edu.ucb.ingsoft.movies.dto;

public class MovieList {
    private String nombre;

    public MovieList(String nombre) {
        this.nombre = nombre;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre ;
    }
}
