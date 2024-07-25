package datos_user;

public class Clientes extends Usuario {
    
    public Clientes (){
    }

    public Clientes (String nombre, String email, String contraseña, String id, int edad){
        super(nombre, email, contraseña, id, edad);
    }

}
