package bo.edu.ucb.ingsoft.movies.dto;

public class ActorsList {
    private String nombre;
    private String apellido;

    public ActorsList(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }


    @Override
    public String toString() {
        return   nombre + apellido ;
    }

}
