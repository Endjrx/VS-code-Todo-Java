package colas_prioridad_ii;

public class Estudiante implements Comparable <Estudiante> {

    //Atributos
    private String nombre;
    private double promedio;
    private int edad; 

    public Estudiante(String nombre, double promedio, int edad) {
        this.nombre = nombre;
        this.promedio = promedio;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPromedio() {
        return this.promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nPromedio: " + promedio;
    }



    @Override
    public int compareTo(Estudiante o) {
        
        if (this.getPromedio() != o.getPromedio()) {
            return Double.compare(this.getPromedio(), o.getPromedio());
        }

        if (this.getEdad() != o.getEdad()) {
            return Integer.compare(this.getEdad(), o.getEdad());
        }

        return 0;
    }   


}
