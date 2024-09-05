package arboles_i;

public class Estudiante {
    
    /*Atributos */
    private String nombre;
    private int edad;

    /*Constructor */
    public Estudiante (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /*Getters And Setters */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad;
    }

}
