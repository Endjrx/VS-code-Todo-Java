package listas_sencillas_ii;

import javax.swing.JOptionPane;

/*-------------------------------------LISTA----------------------------------- */
public class ListaEmpresa {

    public ListaEmpresa () {
        this.inicio = null;
    }


    /*---------------METODO PARA AGREGAR DATOS A LA LISTA SENCILLA---------------- */
    public void agregaDatos  (Persona persona) {

        Nodo nodo = new Nodo(persona);
        if (inicio == null) {
            this.inicio = nodo;
        } else {

            Nodo temp = inicio;
            while (true){

                if (temp.getNodoSiguiente() == null) {
                    break;
                }

                temp = temp.getNodoSiguiente();

            }

            temp.setNodoSiguiente(nodo);

        }


    }


    /*---------------------------METODO PARA MOSTRAR LOS DATOS------------------------- */
    public void mostrarDatos () {

        if (inicio == null) {

            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía.....");
            return;

        } else {

            String msj = "";

            Nodo temp = inicio;
            while (temp != null) {

                if (temp.getPersona() instanceof Empleado) {
                    
                    Empleado empleado = (Empleado) temp.getPersona();
                    msj += empleado.toString() + "\n\n";

                } else if (temp.getPersona() instanceof Jefe) {

                    Jefe jefe = (Jefe) temp.getPersona();
                    msj += jefe.toString() + "\n\n";

                }

                temp = temp.getNodoSiguiente();

            }

            JOptionPane.showMessageDialog(null, msj);

        }

    }


    /*--------------------------METODO PARA REMOVER LOS DATOS DE LA LISTA---------------------------------- */
    public void removerDatos (String nombre) {

        if (inicio == null) {

            JOptionPane.showMessageDialog(null, "La lista se encuent vacía....");
            return;

        } else {

            Nodo temp = inicio;
            Nodo aux = temp;

            if (inicio.getPersona().getNombre().equals(nombre)) {

                inicio = inicio.getNodoSiguiente(); 
                JOptionPane.showMessageDialog(null, "Dato eliminado con exito....");
                return;

            } else {

                while (true) {

                    if (!temp.getPersona().getNombre().equals(nombre)) {

                        if (temp.getNodoSiguiente() == null) {

                            JOptionPane.showMessageDialog(null, "Usuario no encontrado....");
                            break;

                        }

                        aux = temp;
                        temp = temp.getNodoSiguiente();

                    } else {

                        JOptionPane.showMessageDialog(null, "Dato eliminado con exito....");
                        aux.setNodoSiguiente(temp.getNodoSiguiente());
                        break;

                    }


                }



            }



        }
        

    }


    public Nodo getNodoInicio () {
        return inicio;
    }


    private Nodo inicio;
}


/*-------------------------NODOS DE LA LISTA------------------- */
class Nodo {

    private Persona persona;
    private Nodo siguiente;

    public Nodo () {
    } 

    public Nodo(Persona persona) {
        this.persona = persona;
        this.siguiente = null;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Nodo getNodoSiguiente() {
        return this.siguiente;
    }

    public void setNodoSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
