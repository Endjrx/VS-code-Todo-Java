package lista_sencillamente_enlazada_ii.modelo;

public class ListaPacientes {
    
    private Nodo inicio;
    public ListaPacientes () {
        this.inicio = null;
    }



    //Metodo para agregar al final
    public void agregarPacienteFinal (Paciente paciente) {

        Nodo nodo = new Nodo(paciente);
        if (inicio == null) {
            inicio = nodo;
        } else {

            Nodo temp = inicio;
            while (true) {

                if (temp.getNodoSiguiente() == null) break;
                temp = temp.getNodoSiguiente ();

            }

            temp.setNodoSiguiente(nodo);

        }

    }



    //Metodo para agregar al Inicio
    public void agregarInicio (Paciente paciente) {

        Nodo nodo = new Nodo(paciente);
        nodo.setNodoSiguiente(inicio);
        inicio = nodo;

    }




    //Agregar Posicion Especificas
    public void insertarPaciente (Paciente paciente, int posicion) {

        Nodo nodo = new Nodo(paciente);
        if (posicion == 0) {

            nodo.setNodoSiguiente(inicio);
            inicio = nodo;

        } else {

            Nodo temp = inicio;
            if (posicion <= obtenerTamaño()) {

                for (int i = 0; i < posicion - 1; i++) {
                    temp = temp.getNodoSiguiente();
                }

                nodo.setNodoSiguiente(temp.getNodoSiguiente());
                temp.setNodoSiguiente(nodo);

            } else System.out.println("Usted ha intentado acceder a un rango no valido de la lista!");

        }

    }




    //Metodo para eliminar pacientes
    public void eliminarPacientes (String cedula) {

        if (inicio == null) System.out.println("No hay pacientes a eliminar");
        else {

            Nodo temp = inicio;
            Nodo aux = temp;

            if (temp.getPaciente().getCedula().equals(cedula)) inicio = inicio.getNodoSiguiente();
            else {

                while (true) {

                    if (!temp.getPaciente().getCedula().equals(cedula)) {

                        if (temp.getNodoSiguiente() == null) break;
                        aux = temp;
                        temp = temp.getNodoSiguiente();

                    } else {

                        aux.setNodoSiguiente(temp.getNodoSiguiente());
                        System.out.println("Paciente eliminado con exito de la lista de espera.");
                        break;

                    }



                }


            }



        }

    }

    
    

    //Metodo para obtener tamaño de la lista.
    public int obtenerTamaño () {

        int cont = 0;
        if (inicio == null) {
            return 0;
        } else {

            Nodo temp = inicio;
            while (temp != null) {

                cont++;
                temp = temp.getNodoSiguiente();

            }

        }

        return cont;
    }



    //Metodo para buscar usuario
    public void buscarUsuario (String buscar) {

        if (inicio == null) {
            return;
        } else {

            Nodo temp = inicio;
            while (temp != null) {

                

            }

        }

    }
    

    public Nodo getInicio() {
        return this.inicio;
    }


}
