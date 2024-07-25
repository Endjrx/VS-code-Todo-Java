package lista_registro;

public class Historial {
    
    public Historial() {
    }

    public Historial(double saldo, double prestamo, double cuota, double deuda) {
    
        this.saldo = saldo;
        this.prestamo = prestamo;
        this.cuota = cuota;
        this.deuda = deuda;

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

    public double getCuota() {
        return this.cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getDeuda() {
        return this.deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }


    private double saldo, prestamo, cuota, deuda;
}
