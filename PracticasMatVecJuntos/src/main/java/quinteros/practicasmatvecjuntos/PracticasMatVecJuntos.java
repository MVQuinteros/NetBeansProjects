/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * Ejercicio: Una empresa tiene 5 empleados y desea registrar los sueldos pagados durante los últimos 4 meses.

Se debe confeccionar un programa que permita:

A. Cargar los nombres de los 5 empleados y sus respectivos sueldos de los últimos 4 meses.

B. Generar un vector que contenga el sueldo acumulado de cada empleado durante los 4 meses.

C. Mostrar por pantalla el total abonado por la empresa durante los 4 meses.

D. Calcular el promedio general de todos los sueldos registrados.

E. Mostrar los nombres de los empleados cuyo sueldo acumulado se encuentre por debajo del promedio acumulado por empleado.
 */
public class PracticasMatVecJuntos {
    
    public static final Scanner teclado = new Scanner(System.in);
    private String[] nombres = new String[5];
    private float[][] sueldos = new float[5][4];
    private float[] sueldosAcumulados = new float[5];
    
    public static String traerString(String mjs) {
        System.out.print(mjs);
        return teclado.nextLine();
    }

    public static int traerInt(String mjs) {
        System.out.print(mjs);
        int numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    }

    public static float traerFloat(String mjs) {
        System.out.print(mjs);
        float numero = teclado.nextFloat();
        teclado.nextLine();
        return numero;
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 5 ; x = x + 1){
            nombres[x] = traerString("Ingrese el nombre del empleado n " + x + ": ");
            for(int y = 0 ; y < 4 ; y = y + 1){
                sueldos[x][y] = traerFloat("Ingrese el sueldo del empleado " + nombres[x] + " del mes "+ y +": ");
            }
            System.out.println();
        }
    }
    
    public void sumarSueldos(){
        float sumaAcumulador;
        for(int x = 0 ; x < 5 ; x = x + 1){
            sumaAcumulador = 0;
            for(int y = 0 ; y < 4 ; y = y + 1){
                sumaAcumulador = sumaAcumulador + sueldos[x][y];
            }
            sueldosAcumulados[x] = sumaAcumulador;
        }
    }
    
    public void sumarSueldosAcumulados(){
        float total = 0;
        for(int x = 0 ; x < 5 ; x = x + 1){
            total = total + sueldosAcumulados[x];
        }
        informar("El total abonado por la empresa es de: " + total);
        informar("El promedio general de todos los sueldos registrados es de: " + promedioGeneral(total));
        buscarBajoPromedioPorEmpleado(promedioAcumuladoPorEmpleado());
    }
    
    public void buscarBajoPromedioPorEmpleado(float prom){
        informar("El promedio acumulado por empleado es de: "+ prom);
        for(int x = 0 ; x < 5 ; x = x + 1){
            if(sueldosAcumulados[x]<prom){
                informar("Empleado "+ nombres[x] + " esta por debajo del promedio de sueldos acumulado por empleado con " + sueldosAcumulados[x]);
            }else{
                informar("Empleado "+ nombres[x]+ " esta dentro del promedio de sueldos acumulados por empleado con "+ sueldosAcumulados[x]);
            }
        }
    }
    
    public float promedioAcumuladoPorEmpleado(){
        float promedioPorEmpleado;
        float suma = 0;
        for(int x = 0 ; x < 5 ; x = x + 1){
            suma = suma + sueldosAcumulados[x];
        }
        promedioPorEmpleado = suma / 5;
        return promedioPorEmpleado;
    }
    public float promedioGeneral(float to){
        float prom;
        prom = to / 20;
        return prom;
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        PracticasMatVecJuntos xd = new PracticasMatVecJuntos();
        xd.cargarEstructuras();
        xd.sumarSueldos();
        xd.sumarSueldosAcumulados();
    }
}
