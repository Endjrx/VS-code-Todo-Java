package datos_user;

import lista_registro.ListaHistorial;

public class Clientes extends Plantilla {
    
    public Clientes (){
    }

    public Clientes (String nombre, String email, char [] contraseña, String id, int edad){
        super(nombre, email, contraseña, id, edad);
    }

    public Clientes (String nombre, String email, char [] contraseña, String id, int edad, double saldo, double prestamo, double deuda, double cuotas, double total){
        
        super(nombre, email, contraseña, id, edad);
        this.saldo = saldo;
        this.cuotas = cuotas;
        this.prestamo = prestamo;
        this.deuda = deuda;
        this.total = total;

        historial = new ListaHistorial();
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getPrestamo() {
        return this.prestamo;
    }

    public void setPrestamo(double prestamo) {
        this.prestamo = prestamo;
    }

    public double getDeuda() {
        return this.deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public double getCuotas() {
        return this.cuotas;
    }

    public void setCuotas(double cuotas) {
        this.cuotas = cuotas;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ListaHistorial getHistorial () {
        return historial;
    }

    private double saldo, prestamo, deuda, cuotas, total;
    private ListaHistorial historial;
}
