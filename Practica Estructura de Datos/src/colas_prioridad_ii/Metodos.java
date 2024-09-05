package colas_prioridad_ii;

import javax.swing.JOptionPane;

public class Metodos {
    
    //Atributos
    private Nodo inicio;

    public Metodos () {
        this.inicio = null;
    }


    //Metodo para agregar datos al inicio
    public void agregarAlInicio (Estudiante estudiante) {

        Nodo nodo = new Nodo(estudiante);
        nodo.setNodoSiguiente(inicio);
        inicio = nodo;

    }


    //Metodo para agregar al final
    public void agregarAlFinal (Estudiante estudiante) {

        Nodo nodo = new Nodo(estudiante);
        if (inicio == null) inicio = nodo;
        else {

            Nodo temp = inicio;
            while (true) {

                if (temp.getNodoSiguiente() == null) break;
                temp = temp.getNodoSiguiente();

            }

            temp.setNodoSiguiente(nodo);

        }

    }


    //Agregar en una posicion especifica.
    public void insertar (Estudiante estudiante, int posicion) {

        Nodo nodo = new Nodo(estudiante);
        if (posicion == 0) {
            
            nodo.setNodoSiguiente(inicio);
            inicio = nodo;
            return;

        } else {

            if (posicion <= getTamaño()){

                Nodo temp = inicio;
                for (int i = 0; i < posicion - 1; i++) {
                    temp = temp.getNodoSiguiente();
                }
                nodo.setNodoSiguiente(temp.getNodoSiguiente());
                temp.setNodoSiguiente(nodo);

            } else JOptionPane.showMessageDialog(null, "Usted ha intentado acceder a una posicion no valida.");

        }

    }


    //Establecer orden por prioridad
    public void establecerPrioridad () {

        if (inicio == null) JOptionPane.showMessageDialog(null, "No hay datos para ordenar.");
        else {

            Nodo temp = inicio;
            Nodo aux = inicio.getNodoSiguiente();

            while (temp != null) {
                aux = temp.getNodoSiguiente();

                while (aux != null) {

                    if (temp.getEstudiante().compareTo(aux.getEstudiante()) < 0) {

                        Estudiante tempEstudiante = temp.getEstudiante();
                        temp.setEstudiante(aux.getEstudiante());
                        aux.setEstudiante(tempEstudiante);

                    }
                    aux = aux.getNodoSiguiente();
                }   

                temp = temp.getNodoSiguiente();
            }


        }

    }



    //Metodo para eliminar estudiante
    public void eliminarEstudiante (String nombre) {

        if (inicio == null) JOptionPane.showMessageDialog(null, "La lista se encuentra vacía, no hay estudiantes a elimnar.");
        else {

            if (inicio.getEstudiante().getNombre().equalsIgnoreCase(nombre)) {

                inicio = inicio.getNodoSiguiente();
                JOptionPane.showMessageDialog(null, "Estudiante eliminado con exito.");
                return;

            } else {

                Nodo temp = inicio;
                Nodo aux = temp;

                while (true) {

                    if (!temp.getEstudiante().getNombre().equalsIgnoreCase(nombre)) {

                        if (temp.getNodoSiguiente() == null) {

                            JOptionPane.showMessageDialog(null, "Estudiante a eliminar no encontrado.");
                            break;
    
                        }
    
                        aux = temp;
                        temp = temp.getNodoSiguiente();

                    } else {

                        aux.setNodoSiguiente(temp.getNodoSiguiente());
                        JOptionPane.showMessageDialog(null, "Estudiante eliminado con exito.");
                        break;

                    }


                
                }


            }
            

        }

        

    }

    
    //Metodo para ordetener el tamaño de la lista
    public int getTamaño () {

        int cont = 0;

        if (inicio == null) return 0;
        else {

            Nodo temp = inicio;
            while (temp != null) {

                cont++;
                temp = temp.getNodoSiguiente();

            }

        }

        return cont;
    }


    //Metodo para mostrar datos
    public void mostrarDatos () {

        if (inicio == null) JOptionPane.showMessageDialog(null, "La lista se encuentra vacía.");
        else {

            Nodo temp = inicio;
            while (temp != null) {

                System.out.println(temp.getEstudiante().toString() + "\n");
                temp = temp.getNodoSiguiente();

            }

        }

    }

}
