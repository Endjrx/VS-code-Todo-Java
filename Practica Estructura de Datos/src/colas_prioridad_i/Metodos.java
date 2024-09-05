package colas_prioridad_i;

import javax.swing.JOptionPane;

public class Metodos {
    
    //Atributos
    private Nodo inicio;
    public Metodos () {
        this.inicio = null;
    }

    //Metodo para agregar datos
    public void agregarPaciente (Paciente paciente) {

        Nodo nodo = new Nodo(paciente);
        if (inicio == null) {

            inicio = nodo;
            return;

        } else  {

            Nodo temp = inicio;
            while (true) {

                if (temp.getNodoSiguiente() == null) break;
                temp = temp.getNodoSiguiente();

            }

            temp.setNodoSiguiente(nodo);

        }   


    }

    //Metodo para mostrar los datos
    public void mostrarDatos () {

        if (inicio == null) JOptionPane.showMessageDialog(null, "No hay pacientes en la lista para mostrar.");
        else {

            Nodo temp = inicio;
            while (temp != null) {
                
                System.out.println(temp.getPaciente().toString() + "\n");
                temp = temp.getNodoSiguiente();

           }

        }

    }


    //Ordenar la lista.
    public void ordenarPrioridad () {

        if (inicio == null) JOptionPane.showMessageDialog(null, "No hay pacientes para ordenar.");
        else {

            Nodo temp = inicio;
            Nodo aux = inicio.getNodoSiguiente();

            while (temp != null) {
                aux = temp.getNodoSiguiente();
                while (aux != null) {
                    
                    if (temp.getPaciente().compareTo(aux.getPaciente()) < 0) {

                        Paciente auxIntercambio = temp.getPaciente();
                        temp.setPaciente(aux.getPaciente());
                        aux.setPaciente(auxIntercambio);

                    }

                    aux = aux.getNodoSiguiente();
                }

                temp = temp.getNodoSiguiente();
            }

        }

    }


}
