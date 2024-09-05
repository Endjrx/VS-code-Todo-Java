package pilas_i;

public class MetodosPilas {
    
    private Nodo inicio;
    public MetodosPilas () {
        this.inicio = null;
    }


    //Metodo para agregar datos a la pila
    public void agregarEmpleado (Empleado empleado) {

        Nodo nodo = new Nodo(empleado);
        nodo.setNodoSiguiente(inicio);
        inicio = nodo;

    }


    //Metodo para eliminar datos
    public void vaciarPila () {

        if (inicio == null) System.out.println("No hay datos a eliminar.");
        else {

            while (inicio != null) {
                inicio = inicio.getNodoSiguiente();
            }

            System.out.println("La lista fue vaciada por completa.");
        }

    }


    //Eliminar ultimo dato
    public void eliminarUltimo () {

        if (inicio != null) {
            inicio = inicio.getNodoSiguiente();
        } else System.out.println("No hay datos a eliminar.");

    }


    //Metodo para mostrar los datos
    public void mostrarDatos () {

        if (inicio == null) System.out.println("No hay datos para mostrar.");
        else {

            Nodo temp = inicio;
            while (temp != null) {

                System.out.println(temp.getEmpleado().toString() + "\n");
                temp = temp.getNodoSiguiente();

            } 

        }

    }


    //Metodo para obtener el tamaño de la pila
    public int obtenerTamño () {

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



}
