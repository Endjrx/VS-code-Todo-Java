package listas_sencillas_ii;

public class Persona {
    
    /*Atributos */
    private String nombre;
    private int edad;
    private String sexo;

    public Persona () {
    }


    public Persona (String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    //Getters and Setters
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

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    @Override
    public String toString () {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nSexo: " + sexo; 
    }

}
