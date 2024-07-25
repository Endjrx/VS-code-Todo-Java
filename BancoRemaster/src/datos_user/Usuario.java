package datos_user;

public abstract class Usuario {
    
    public Usuario () {
    }

    public Usuario(String nombre, String email, String contraseña, String id, int edad) {
        
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

    public String getContraseña () {
        return contraseña;
    }

    private String nombre, email, id, contraseña;
    private int edad;
}
