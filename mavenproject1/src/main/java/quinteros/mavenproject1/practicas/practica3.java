/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.practicas;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class practica3 {
    private static final Scanner teclado = new Scanner(System.in);
    
    private final int cantidad = 5;
    private final int[] edades = new int[cantidad];
    private final String[] nombres = new String[cantidad];
    private final float[] sueldos = new float[cantidad];
    private final char[] turnos = new char[cantidad];
    
    // mostrar mayores de edad.
    // empleados por turno. 
    // gasto total en los sueldos
    // detectar sueldo mayor y mostrar quien lo cobra
    
    public char traerChar(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine().toUpperCase();
        char caracter = ingreso.charAt(0);
        return caracter;
    }
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine();
        int entero = Integer.parseInt(ingreso);
        return entero;
    }
    
    public float traerFloat(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine().replace(",", ".");
        float flo = Float.parseFloat(ingreso);
        return flo;
    }
    
    public String traerString(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine();
        return ingreso;
    }
    
    public void cargarEmpleados(){
        System.out.println("Empresa!!");
        for(int x = 0; x < cantidad; x = x + 1){
            System.out.println(" ");
            System.out.println("-------------- Posicion " + x + " ---------------------");
            nombres[x] = traerString("Ingrese el nombre del empleado: ");
            edades[x] = traerInt("Ingrese la edad de " + nombres[x] + ": ");
            turnos[x] = traerChar("Ingrese el turno de " + nombres[x] + ": ");
            sueldos[x] =traerFloat("Ingrese el sueldo de " + nombres[x] + ": ");
        }
    }
    
    public void detectarMayoresEdad(){
        System.out.println("Mayores de Edad -------------------------------------------");
        int cantidadMayorEdad = 0;
        for(int x = 0; x < cantidad ; x = x + 1){
            if(edades[x] > 18){
                cantidadMayorEdad = cantidadMayorEdad + 1;
                System.out.println(nombres[x] + " tiene " + edades[x]);
            }
        }
        System.out.println("La cantidad de mayores de edad es de: " + cantidadMayorEdad);
    }
    
    public void clasificarEmpleadosTurnos(){
        System.out.println("Empleados por turnos ---------------------------------------");
        int turnoM = 0;
        int turnoN = 0;
        int turnoT = 0;
        for(int x = 0; x < cantidad; x = x + 1){
            if(turnos[x] == 'M'){
                turnoM = turnoM + 1;
                System.out.println(nombres[x] + " pertenece al turno mañana");
            }else{
                if(turnos[x] == 'N'){
                    turnoN = turnoN + 1;
                    System.out.println(nombres[x] + " pertenece al turno noche");
                }else{
                    turnoT = turnoT + 1;
                    System.out.println(nombres[x] + " pertenece al turno tarde");
                }
            }
        }  
        mostrarCantidadTurnos(turnoM, turnoN, turnoT);
    }
    
    public void mostrarCantidadTurnos(int M, int N, int T){
        if(M != 0){
            System.out.println("Los empleados del turno mañana son: " + M);
        }
        if(N != 0){
            System.out.println("Los empleados del turno noche son: " + N);
        }
        if(T != 0){
            System.out.println("Los empleados del turno tarde son: " + T);
        }
    }
    
    public void gastoSueldos(){
        float totalGasto = 0;
        for(int x = 0; x < cantidad ; x = x + 1){
            totalGasto = totalGasto + sueldos[x];
        }
        System.out.println("El total de los gastos en sueldos es de: " + totalGasto);
    }
    
    public void detectarSueldoMayor(){
        float sueldoMayor = sueldos[0];
        int direccion = 0;
        for(int x = 1 ; x < cantidad ; x = x + 1){
            if(sueldoMayor < sueldos[x]){
                sueldoMayor = sueldos[x];
                direccion = x;
            }
        }
        System.out.println("El sueldo mayor lo cobra " + nombres[direccion] + " y es de $" + sueldoMayor);
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        practica3 prac = new practica3();
        prac.cargarEmpleados();
        prac.detectarMayoresEdad();
        prac.clasificarEmpleadosTurnos();
        prac.gastoSueldos();
        prac.detectarSueldoMayor();
    }
}
