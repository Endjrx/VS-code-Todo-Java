package datos_user;

public abstract class Plantilla {
    
    public Plantilla () {
    }

    public Plantilla(String nombre, String email, char [] contraseña, String id, int edad) {
        
        this.nombre = nombre;
        this.email = email;
        this.id = id;
        this.edad = edad;
        this.contraseña = contraseña;

    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }

    public int getEdad() {
        return this.edad;
    }

    public char [] getContraseña () {
        return contraseña;
    }

    private String nombre, email, id;
    private char [] contraseña;
    private int edad;
}
