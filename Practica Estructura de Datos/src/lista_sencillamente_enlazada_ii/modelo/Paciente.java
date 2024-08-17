package lista_sencillamente_enlazada_ii.modelo;

public class Paciente {
    
    /*Atributos */
    private String nombre, descripcion, telefono, ciudad, cedula, sexo;
    private int edad;

    /*Constructor */
    public Paciente() {
    }

    public Paciente(String nombre, String cedula, String telefono, String ciudad, String descripcion, String sexo, int edad) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edad = edad;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.cedula = cedula;
        this.sexo = sexo;

    }

    /*Getters And Setters */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCedula() {
        return this.cedula;
    }
    
    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    @Override
    public String toString () {
        return "Nombre: " + nombre + "\nDescripcion Medica: " + descripcion;
    }

}
