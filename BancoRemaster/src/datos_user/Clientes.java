package datos_user;

import lista_registro.Historial;
import lista_registro.ListaHistorial;

public class Clientes extends Plantilla {
    
    public Clientes (){
    }

    public Clientes (String nombre, String email, char [] contraseña, String id, int edad){
        super(nombre, email, contraseña, id, edad);
    }

    public Clientes (String nombre, String email, char [] contraseña, String id, int edad, double saldo, double prestamo, double deuda, double cuotas){
        
        super(nombre, email, contraseña, id, edad);
        this.saldo = saldo;
        this.cuotas = cuotas;
        this.prestamo = prestamo;
        this.deuda = deuda;

        historial = new ListaHistorial();
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
        historial.agregarDatos(new Historial(saldo,prestamo, cuotas, deuda));
    }

    public double getPrestamo() {
        return this.prestamo;
    }

    public void setPrestamo(double prestamo) {
        this.prestamo = prestamo;
        historial.agregarDatos(new Historial(saldo,prestamo, cuotas, deuda));
    }

    public double getDeuda() {
        return this.deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
        historial.agregarDatos(new Historial(saldo,prestamo, cuotas, deuda));
    }

    public double getCuotas() {
        return this.cuotas;
    }

    public void setCuotas(double cuotas) {
        this.cuotas = cuotas;
        historial.agregarDatos(new Historial(saldo,prestamo, cuotas, deuda));
    }

    public ListaHistorial getHistorial () {
        return historial;
    }

    private double saldo, prestamo, deuda, cuotas;
    private ListaHistorial historial;
}
