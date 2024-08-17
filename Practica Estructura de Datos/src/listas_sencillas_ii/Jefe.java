package listas_sencillas_ii;

public class Jefe extends Persona {
    
    /*Atributos propios */
    private String cargo;

    public Jefe () {
    }

    public Jefe(String nombre, int edad, String sexo, String cargo) {
        super(nombre, edad, sexo);
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString () {
        return super.toString() + "\nCargo: " + cargo;
    }

}
