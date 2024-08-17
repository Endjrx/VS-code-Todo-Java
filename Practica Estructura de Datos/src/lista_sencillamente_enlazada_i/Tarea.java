package lista_sencillamente_enlazada_i;

public class Tarea {
    
    /*Constructor por defecto */
    public Tarea () {
    }

    /*Constructor */
    public Tarea (String tarea, String descripcion) {
        this.tarea = tarea; 
        this.descripcion = descripcion;
    }

    //Getters and Setters (Metodos accesores)
    public String getNombreTarea() {
        return this.tarea;
    }

    public void setNombreTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString () {
        return "Tarea: " + tarea + "\nDescripcion: " + descripcion; 
    }

    private String tarea, descripcion;
}
