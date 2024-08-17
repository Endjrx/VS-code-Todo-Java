package listas_sencillas_ii;

public class Empleado extends Persona{
    
    /*Atributos propios */
    private String puesto;

    public Empleado (){
    }

    public Empleado(String nombre, int edad, String sexo, String puesto) {
        super(nombre, edad, sexo);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString () {
        return super.toString() + "\nPuesto: " + puesto;
    }

}
