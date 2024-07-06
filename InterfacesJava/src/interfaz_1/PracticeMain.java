package interfaz_1;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class PracticeMain {
    public static void main(String[] args) {
        
        Empleado [] empleados = new Empleado [6];

        empleados [0] = new Empleado("Endjrxx", 4001, 19, 7, 2006);
        empleados [1] = new Empleado("Ghost", 2000, 12, 10, 1999);
        empleados [2] = new Empleado("Master Chief", 2320, 1, 2, 2000);
        empleados [3] = new Empleado("Messi", 4001, 22, 10, 1999);

        /*Creamos el objeto y luego lo utilizamos para establecer el incentivo y luego agregamos ese objeto modificado al array */
        Jefatura jefeR = new Jefatura("Samuel", 7600, 2006, 9, 25);
        jefeR.setIncentivo(500);

        empleados [4] = jefeR; 
        empleados [5] = new Jefatura("Adriana", 7200, 2004, 11, 30);; 

        /*Ejemplo de castin:  */
        Jefatura jefa = (Jefatura) empleados [5];
        jefa.setIncentivo(1000);


        Arrays.sort(empleados); //Metodo para organizar el array.
        


        for (Empleado e : empleados) {
            e.subeSueldo(5);
        }

        for (Empleado e: empleados) {

            System.out.println();

            if (e instanceof Empleado){
                
                System.out.println(e.toString());

            } else if (e instanceof Jefatura){

                Jefatura jefes = (Jefatura) e;
                System.out.println(jefes.toString());

            }

        }



    }
}


class Empleado implements Comparable <Empleado>{

    /*Atributos de empleado */
    private String nombre;
    private double salario;
    private Date contrato;
    private static int siguienteID;
    private int id;

    public Empleado(String nombre) {
        this (nombre, 3000, 2000, 01, 01);
    }

    public Empleado(String nombre, double salario, int dia, int mes, int año) {
        this.nombre = nombre;
        this.salario = salario;
        GregorianCalendar calendar = new GregorianCalendar(año, mes, dia);
        this.contrato = calendar.getTime();
        ++siguienteID;
        id = siguienteID;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getContrato() {
        return this.contrato;
    }

    public void setContrato(Date contrato) {
        this.contrato = contrato;
    }

    public int getID (){
        return id;
    }

    @Override
    public int compareTo(Empleado o) {
        if (this.getSalario() < o.getSalario()){
            return -1;
        } 
        
        if (this.getSalario() > o.getSalario()){
            return 1;
        }
        
        return 0;

    }


    public void subeSueldo (double porcentaje){
        salario += (salario*porcentaje/100);
    }

    @Override
    public String toString (){
        return "Nombre: " + nombre + "\nID: " + id + "\nSalario: " + salario + "\nFecha: " + contrato.getTime();
    }

}



class Jefatura extends Empleado {

    /*Declaramos atributo propio */
    private double incentivo;


    /*Constructor */
    public Jefatura (String nombre, double salario, int año, int mes, int dia){
        super(nombre, salario, dia, mes, año);
    }
    

    /*Metodo setter */
    public void setIncentivo (double incentivo){
        this.incentivo = incentivo;
    }

    @Override
    public double getSalario (){
        return super.getSalario() + incentivo;
    }



    @Override
    public String toString (){
        return "Nombre: " + getNombre() + "\nID: " + getID() + "\nSalario: " + this.getSalario() + "\nFecha: " + getContrato().getTime() + "\nIncentivo: " + incentivo;
    }


}