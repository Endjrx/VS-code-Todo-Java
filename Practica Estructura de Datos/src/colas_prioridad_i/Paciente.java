package colas_prioridad_i;

public class Paciente implements Comparable <Paciente>, TiposEmergencias {
    
    /*Atributos para el paciente */
    private String nombre, enfermedad;
    private int edad;

    public Paciente() {
    }

    public Paciente(String nombre, String enfermedad, int edad) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.edad = edad;
    }

    //Getters And Setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnfermedad() {
        return this.enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Paciente paciente_siguiente) {

        if (!this.getEnfermedad().equals(paciente_siguiente.getEnfermedad())) {
            return obtenerMayorPrioridad(paciente_siguiente);
        } 

        if (this.getEdad() != paciente_siguiente.getEdad()) {
            return Integer.compare(this.getEdad(), paciente_siguiente.getEdad());
        }

        return 0; //Son todo igual.
    }


    public int obtenerMayorPrioridad (Paciente paciente_siguiente) {

        int este_paciente = determinarGravedad(this);
        int otro_paciente = determinarGravedad(paciente_siguiente);

        if (este_paciente != otro_paciente) {
            return Integer.compare(este_paciente, otro_paciente);
        } else {
            return 0; //Si son iguales se retorna cero.
        }

    }


    public int determinarGravedad (Paciente paciente_siguiente) {

        switch (paciente_siguiente.getEnfermedad()) {

            case TiposEmergencias.NORMAL:
                return 1;
            case TiposEmergencias.GRAVE:
                return 2;
            case TiposEmergencias.MUY_GRAVE:
                return 3;
            default:
                return Integer.MAX_VALUE;

        }

    }


    @Override
    public String toString () {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nEnfermedad: " + enfermedad;
    }

}
