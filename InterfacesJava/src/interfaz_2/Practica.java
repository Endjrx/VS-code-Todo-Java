package interfaz_2;

import java.util.Arrays;

public class Practica {
    public static void main(String[] args) {
        
        Empleado [] empleados = new Empleado [6];

        empleados [0] = new Empleado("Endjrxx", 4001, "06/07/2023");
        empleados [1] = new Empleado("Ghost", 2000, "01/02/2022");
        empleados [2] = new Empleado("Master Chief", 2300, "06/07/2017");
        empleados [3] = new Empleado("Messi", 4001, "08/12/2011");

        /*Creamos el objeto y luego lo utilizamos para establecer el incentivo y luego agregamos ese objeto modificado al array */
        Jefatura jefeR = new Jefatura("Samuel", 7600, "31/12/2019");
        jefeR.setIncentivo(500);

        empleados [4] = jefeR; 
        empleados [5] = new Jefatura("Adriana", 7200, "22/10/1999");; 

        /*Ejemplo de castin:  */
        Jefatura jefa = (Jefatura) empleados [5];
        jefa.setIncentivo(1000);

        System.out.println(jefa.tomarDecisiones("Ha tomado la decision de bajar el sueldo a los empleados un 5%"));
        System.out.println("La jefa: " + jefa.getNombre() + " ha obtenido un bonus de: " + jefa.setBonus(500));

        System.out.println("El empleado: " + empleados[1].getNombre() + " ha obtenido un bonus de: " + empleados [1].setBonus(200));

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


class Empleado implements Comparable <Empleado>, Trabajadores{

    /*Atributos de empleado */
    private String nombre, fecha;
    private double salario;
    private static int siguienteID;
    private int id;

    public Empleado() {
    }

    public Empleado(String nombre, double salario, String fecha) {

        this.nombre = nombre;
        this.salario = salario;
        this.fecha = fecha;
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

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha (String fecha) {
        this.fecha = fecha;
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
        return "Nombre: " + nombre + "\nID: " + id + "\nSalario: " + salario + "\nFecha: " + fecha;
    }

    @Override
    public double setBonus(double bonus) {
        return Trabajadores.bonusBase + bonus;
    }

}



class Jefatura extends Empleado implements Jefes {

    /*Declaramos atributo propio */
    private double incentivo;


    /*Constructor */
    public Jefatura (String nombre, double salario, String fecha){
        super(nombre, salario, fecha);
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
        return "Nombre: " + getNombre() + "\nID: " + getID() + "\nSalario: " + this.getSalario() + "\nFecha: " + getFecha() + "\nIncentivo: " + incentivo;
    }


    @Override
    public String tomarDecisiones(String decision) {
        return "Un Jefe ha tomado la decision: " + decision;
    }

    @Override
    public double setBonus (double bonus){
        return Trabajadores.bonusBase + bonus + 2000;
    }

}