package pilas_i;

public class Principal {
    
    public static void main(String[] args) {
        
        MetodosPilas metodo = new MetodosPilas();
        
        metodo.agregarEmpleado(new Empleado("Endjrx", 18, 2400));
        metodo.agregarEmpleado(new Empleado("Josué", 20, 5120));
        metodo.agregarEmpleado(new Empleado("Robles", 17, 3210));

        metodo.mostrarDatos();
        System.out.println("\n Cantidad de elemtnos enla pila: " + metodo.obtenerTamño());
        
        metodo.eliminarUltimo();
        
        System.out.println("\nDespues de eliminar al ultimo");
        metodo.mostrarDatos();
        
        metodo.vaciarPila();
        metodo.mostrarDatos();
        System.out.println("\n Cantidad de elemtnos enla pila: " + metodo.obtenerTamño());




    }

}
