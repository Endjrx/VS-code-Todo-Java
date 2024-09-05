package lista_sencillamente_enlazada_iii;

import javax.swing.JOptionPane;

public class ListaEstudiantes {
    
    private Nodo inicio;
    public ListaEstudiantes () {
        this.inicio = null;
    }

    //Metodo para agregar datos al inicio de la lista
    public void agregarEstudianteInicio (Estudiante student) {

        Nodo nodo = new Nodo(student);
        nodo.setNodoSiguiente(inicio);
        inicio = nodo;

    }


    //Metodo para agregar datos al final de la lista
    public void agregarEstudianteFinal (Estudiante estudiante) {

        Nodo nodo = new Nodo(estudiante);
        if (inicio == null) {

            inicio = nodo;
            return;

        } else {

            Nodo temp = inicio;
            while (true) {

                if (temp.getNodoSiguiente() == null) break;
                temp = temp.getNodoSiguiente();

            }

            temp.setNodoSiguiente(nodo);

        }

    }



    //Metodo para agregar Datos en un punto especifico
    public void insertarEstudiante (Estudiante estudiante, int posicion) {

        Nodo nodo = new Nodo(estudiante);
        if (posicion == 0) {

            nodo.setNodoSiguiente(inicio);
            inicio = nodo;
            return;


        } else {

            Nodo temp = inicio;
            if (posicion <= getTamañoLista()) {

                for (int i = 0; i < posicion - 1; i++) {
                    temp = temp.getNodoSiguiente();
                }  
                nodo.setNodoSiguiente(temp.getNodoSiguiente());
                temp.setNodoSiguiente(nodo);

            } else System.out.println("Usted ha intentado acceder a una posicion no valida.");

        }

    }


    //Metodo para obtener la cantidad de elementos del array
    public int getTamañoLista () {

        int aux = 0;
        if (inicio == null) return 0;
        else {

            Nodo temp = inicio;
            while (temp != null) {

                aux++;
                temp = temp.getNodoSiguiente();

            }
            
        }

        return aux;
    }



    //Metodo para mostrar los datos
    public void mostrarDatos () {

        if (inicio == null) System.out.println("No hay datos en la lista."); 
        else {

            Nodo temp = inicio;
            while (temp != null) {

                System.out.println(temp.getEstudiante().toString() + "\n");
                temp = temp.getNodoSiguiente();

            }

        }

    }



    //Metodo para eliminar estudiantes
    public void eliminarEstudiante (String nombre) {

        if (inicio == null) {
            
            System.out.println("No hay datos en la lista, por ende no puede eliminar datos.");
            return;

        } else {

           
            if (inicio.getEstudiante().getNombre().equalsIgnoreCase(nombre)) {

                inicio = inicio.getNodoSiguiente(); 
                JOptionPane.showMessageDialog(null, "El estudiante fue eliminado con exito.");
                
            } else {
                
                Nodo temp = inicio.getNodoSiguiente();
                Nodo aux = temp;
                while (true) {
                    
                    if (!temp.getEstudiante().getNombre().equalsIgnoreCase(nombre)) {
                        
                        if (temp.getNodoSiguiente() == null) {

                            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                            break;

                        }

                        aux = temp;
                        temp = temp.getNodoSiguiente();
                        
                    } else {
                        
                        aux.setNodoSiguiente(temp.getNodoSiguiente());
                        JOptionPane.showMessageDialog(null, "El estudiante fue eliminado con exito.");
                        break;

                    }

                }



            }




        }





    }


}
