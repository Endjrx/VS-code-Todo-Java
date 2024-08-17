package listas_sencillas;


public class ListaPrincipal {
    public static void main(String[] args) {
        
        ListaEmpleados lista = new ListaEmpleados();

        lista.mostrarDatos(); //Como no hay datos, debería imprimir que no hay datos

        lista.agregarDatos(new Empleado("Endi", 18));
        lista.agregarDatos(new Empleado("Leo", 20));
        lista.agregarDatos(new Empleado("Jose David", 18));

        lista.mostrarDatos();
        lista.eliminarEmpleados("Endi");
        lista.mostrarDatos();

        System.out.println("El tamaño de la lista es: " + lista.obtenerTamaño());

    }
}


class Empleado {

    private String nombre;
    private int edad;

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Getter and Setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString () {
        return "Nombre: " + nombre + "\nEdad: " + edad;
    }

}




class Nodo {

    private Empleado empleado;
    private Nodo siguiente;

    public Nodo (Empleado empleado) {
        this.empleado = empleado;
        this.siguiente = null;
    }

    //Getters and Setters
    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Nodo getNodoSiguiente() {
        return this.siguiente;
    }

    public void setNodoSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}




class ListaEmpleados {

    private Nodo inicio;

    public ListaEmpleados () {
        this.inicio = null;
    }

    //Metodo para agregar datos:
    public void agregarDatos (Empleado empleado) {
        
        Nodo nodo = new Nodo(empleado);
        if (inicio == null) {

            this.inicio = nodo;
            System.out.println("Primer Dato Agregado Con Exito...\n");
            return;

        } else {

            Nodo aux = inicio;
            while (true) {

                if (aux.getNodoSiguiente() == null) {
                    break;
                }

                aux = aux.getNodoSiguiente();
            }

            aux.setNodoSiguiente(nodo);

        }

    }


    //Metodo para mostrar datos: 
    public void mostrarDatos () {

        if (inicio == null) {

            System.out.println("La lista se encuentra vacia....\n");
            return;

        } else {

            Nodo temp = inicio;
            while (temp != null) {

                System.out.println(temp.getEmpleado().toString() + "\n");
                temp = temp.getNodoSiguiente();

            }


        }

    }


    //Metodo para remover empleados
    public void eliminarEmpleados (String nombre) {
        
        if (inicio == null) {

            System.out.println("La lista se encuentra vacia");
            return;

        } else {

            Nodo temp = inicio;
            Nodo aux = temp;

            if (temp.getEmpleado().getNombre().equals(nombre)) {
                
                inicio = temp.getNodoSiguiente();
                System.out.println("El usuario fue eliminado con exito...");

            } else {

                while (true) {


                    if (!temp.getEmpleado().getNombre().equals(nombre)) {

                        if (temp.getNodoSiguiente() == null) {

                            System.out.println("El usuario no fue encontrado....\n");
                            break;

                        }

                        aux = temp;
                        temp = temp.getNodoSiguiente();

                    }

                     else {

                        aux.setNodoSiguiente(temp.getNodoSiguiente());
                        System.out.println("El usuario fue eliminado con exito...");
                        break;

                    }


                }



            }



        }

        return;

    }


    //Metodo contador para determinar el tamaño de la lista.
    public int obtenerTamaño (){

        if (inicio == null) {
            return 0;
        } else {

            int cont = 0; //Para almacenar el numero de vueltas que da el array
            Nodo temp = inicio;

            while (temp != null) {

                cont ++;
                temp = temp.getNodoSiguiente();

            }

            return cont;

        }

    }


}