
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class parcial1virtual {
    
    private static final Scanner teclado = new Scanner(System.in);
    private final String[] nombre = new String[4];
    private final int[][] sueldosMensuales = new int[4][3];
    private final int[] sueldosAcumulados = new int [4];
    
    public String traerString(String mjs){
        System.out.print(mjs);
        return teclado.nextLine();
    }
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        int numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 4 ; x++){
            nombre[x] = traerString("ingrese el nombre del empleado n°" + (x+1) +": ");
            for(int y =0 ; y < 3 ; y++){
                sueldosMensuales[x][y] = traerInt("ingrese el sueldo del mes n°"+ (y+1)+" del empleado "+ nombre[x]);
            }
        }
    }
    
    public void calcularSueldosAcumulados(){
        int suma;
        for(int x = 0 ; x < 4 ; x++){
            suma = 0;
            for(int y = 0 ; y < 3 ; y++){
                suma = suma + sueldosMensuales[x][y];
            }
            sueldosAcumulados[x] = suma;
        }
    }
    
    public void imprimirAcumulados(){
        System.out.print("sueldos acumulados");
        for(int x = 0 ; x < 4 ; x++){
            System.out.print(nombre[x] + " -  $" + sueldosAcumulados[x]);
        }
    }
    
    public void verBajoElPromedio(){
        int promedio;
        promedio = calcularPromedio();
        System.out.println("Empleados abajo del promedio");
        for(int x = 0 ; x < 4 ; x = x + 1){
            if(sueldosAcumulados[x] < promedio){
                System.out.println(nombre[x] + " - $" + sueldosAcumulados[x]);
            }
        }
    }
    
    public int calcularPromedio(){
        int prom;
        int suma = 0;
        for(int x = 0 ; x < 4 ; x++){
            suma = suma + sueldosAcumulados[x]; 
        }
        prom = suma / 4;
        return prom;
    }
    
    public void ordenarSueldos(){
        
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        parcial1virtual p = new parcial1virtual();
        p.cargarEstructuras();
        p.calcularSueldosAcumulados();
    }
    
    private Scanner teclado=new Scanner(System.in);
    private String[] nombre=new String[4];
    private int[][] sueldosMensuales=new int[4][3];
    private int[] sueldosAcumulados=new int[4];
    
    public void cargarDatos() {
        for (int x = 0; x < 4; x = x + 1) {
            System.out.print("Ingresar el nombre del empleado " + (x+1) + ": ");
            nombre[x] = teclado.next();
            
            for (int y = 0; y < 3; y = y + 1) {
                System.out.print("Ingresar el sueldo " + (y+1) + " de " + nombre[x] + ": ");
                sueldosMensuales[x][y] = teclado.nextInt();
            }
        }
        System.out.println();
    }
    
    public void calcularSueldosAcumulados() {
        int suma = 0;
        
        for (int x = 0; x < 4; x = x + 1) {
            for (int y = 0; y < 3; y = y + 1) {
                suma = suma + sueldosMensuales[x][y];
            }
            sueldosAcumulados[x] = suma;
            suma = 0;
        }
    }
    
    public void imprimirAcumulados() {
        System.out.println("SUELDOS ACUMULADOS");
        for (int x = 0; x < 4; x = x + 1) {
            System.out.println(nombre[x] + " cobro un total acumulado de $" + sueldosAcumulados[x]);
        }
        System.out.println();
    }
    
    public void verBajoElPromedio(int promedio) {
        
        System.out.println("EMPLEADOS ABAJO DEL PROMEDIO DE $" + promedio);
        for (int x = 0; x < 4; x = x + 1) {
            if (sueldosAcumulados[x] < promedio) {
                System.out.println(nombre[x] + " - $" + sueldosAcumulados[x]);
            }
        }
        System.out.println();
    }
    
    public void calcularPromedio() {
        int prom;
        int suma = 0;
        for (int x = 0; x < 4; x = x + 1) {
            suma = suma + sueldosAcumulados[x];
        }
        prom = suma / 4;
        verBajoElPromedio(prom);
    }
    
    
    public static void main(String[] args) {
        Empleados emp=new Empleados();
        emp.cargarDatos();
        emp.calcularSueldosAcumulados();
        emp.imprimirAcumulados();
        emp.calcularPromedio();
        
        
        
        
    }
}

otra version:
package com.mycompany.empleados;

import java.util.Scanner;


public class Empleados {
    private Scanner teclado=new Scanner(System.in);
    private String[] nombre=new String[4];
    private int[][] sueldosMensuales=new int[4][3];
    private int[] sueldosAcumulados=new int[4];
    
    public void cargarDatos() {
        for (int x = 0; x < 4; x = x + 1) {
            System.out.print("Ingresar el nombre del empleado " + (x+1) + ": ");
            nombre[x] = teclado.next();
            
            for (int y = 0; y < 3; y = y + 1) {
                System.out.print("Ingresar el sueldo " + (y+1) + " de " + nombre[x] + ": ");
                sueldosMensuales[x][y] = teclado.nextInt();
            }
        }
        System.out.println();
    }
    
    public void calcularSueldosAcumulados() {
        int suma = 0;
        
        for (int x = 0; x < 4; x = x + 1) {
            for (int y = 0; y < 3; y = y + 1) {
                suma = suma + sueldosMensuales[x][y];
            }
            sueldosAcumulados[x] = suma;
            suma = 0;
        }
    }
    
    public void imprimirAcumulados() {
        System.out.println("SUELDOS ACUMULADOS");
        for (int x = 0; x < 4; x = x + 1) {
            System.out.println(nombre[x] + " cobro un total acumulado de $" + sueldosAcumulados[x]);
        }
        System.out.println();
    }
    
    public void verBajoElPromedio() {
        int promedio;
        promedio = calcularPromedio();
        System.out.println("EMPLEADOS ABAJO DEL PROMEDIO DE $" + promedio);
        for (int x = 0; x < 4; x = x + 1) {
            if (sueldosAcumulados[x] < promedio) {
                System.out.println(nombre[x] + " - $" + sueldosAcumulados[x]);
            }
        }
        System.out.println();
    }
    
    public int calcularPromedio() {
        int prom;
        int suma = 0;
        for (int x = 0; x < 4; x = x + 1) {
            suma = suma + sueldosAcumulados[x];
        }
        prom = suma / 4;
        return prom;
    }
    
    
    public static void main(String[] args) {
        Empleados emp=new Empleados();
        emp.cargarDatos();
        emp.calcularSueldosAcumulados();
        emp.imprimirAcumulados();
        emp.verBajoElPromedio();
        
        
        
        
    }
}
}
