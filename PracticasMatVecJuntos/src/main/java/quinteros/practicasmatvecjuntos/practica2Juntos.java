/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * 
 * Ejercicio — Ventas de una empresa

Una empresa tiene 6 vendedores y desea registrar las ventas realizadas durante los últimos 5 meses.

Se debe confeccionar un programa que permita:

A. Cargar los nombres de los 6 vendedores y sus respectivas ventas de los 5 meses.

B. Generar un vector que contenga el total vendido por cada vendedor durante los 5 meses.

C. Mostrar por pantalla el total vendido por la empresa durante los 5 meses.

D. Calcular y mostrar el promedio general de todas las ventas registradas.

E. Mostrar los nombres de los vendedores cuyo total acumulado de ventas se encuentre por debajo del promedio acumulado por vendedor.

F. Mostrar el nombre del vendedor que obtuvo el mayor total acumulado de ventas y cuál fue dicho total.

G. Determinar cuál fue el mes con mayor cantidad de ventas, considerando la suma de las ventas de todos los vendedores en cada mes.

H. Mostrar los nombres de los vendedores que hayan tenido al menos un mes en el que su venta haya sido superior al promedio general de todas las ventas registradas.

Condiciones
6 vendedores.
5 meses.
Utilizar una matriz para almacenar las ventas.
Utilizar un vector para los acumulados.
Resolver mediante ciclos for.
No utilizar break.
No es necesario realizar validaciones de los datos ingresados.
 * 
 */
public class practica2Juntos {
    public static final Scanner teclado = new Scanner(System.in);
    private String[] empleados = new String[6];
    private float[][] ventas = new float[6][5];
    private float[] totalVendidoPorEmpleado = new float[6];
    
    public static String traerString(String mjs){
        System.out.print(mjs);
        return teclado.nextLine();
    }
    
    public static int traerInt(String mjs){
        System.out.print(mjs);
        int numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    }
    
    public static float traerFloat(String mjs){
        System.out.print(mjs);
        float numero = teclado.nextFloat();
        teclado.nextLine();
        return numero;
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 6 ; x = x + 1){
            empleados[x] = traerString("ingrese el nombre del empleado n" + (x+1) + ": ");
            for(int y = 0 ; y < 5 ; y = y + 1){
                ventas[x][y] = traerFloat("ingrese las el total vendido en nel mes " + (x+1) + " del empleado " + empleados[x]);
            }
        }
    }
    
    public void totalVendidoPorEmpleado(){
        float suma;
        for(int x = 0 ; x < 6 ; x = x + 1){
            suma = 0;
            for(int y = 0 ; y < 5 ; y = y + 1){
                suma = suma + ventas[x][y];
            }
            totalVendidoPorEmpleado[x] = suma;
        }
    }
    
    public float totalVendidoEmpresa(){
        float totalVendido = 0;
        for(int x = 0 ; x < 6 ; x = x + 1){
            totalVendido = totalVendido + totalVendidoPorEmpleado[x];
        }
        return totalVendido;
    }
    
    public float ventasRegistradas(){
        float to = totalVendidoEmpresa();
        float promedio = to / (6*5);
        return promedio;
    }
    
    public float promedioVentasPorVendedor(){
        float suma = 0;
        for(int x = 0 ; x < 6 ; x = x + 1){
            suma = suma + totalVendidoPorEmpleado[x];
        }
        float prom;
        return prom = suma/6;
    }
    
    public void debajoPromedioPorEmpleado(){
        float pro = promedioVentasPorVendedor();
        for(int x = 0 ; x < 6 ; x = x + 1){
            if(pro>totalVendidoPorEmpleado[x]){
                informar("El empleado " + empleados[x] + " esta por debajop del promedio de las ventas por empleado.");
            }
        }
    }
    
    public void mayorVentas(){
        float mayor = totalVendidoPorEmpleado[0];
        int pocicion = 0;
        for(int x = 0 ; x < 6 ; x = x + 1){
            if(totalVendidoPorEmpleado[x] > mayor){
                mayor = totalVendidoPorEmpleado[x];
                pocicion = x;
            }
        }
        informar("El empleado con mayor ventas es " + empleados[pocicion]+ " con un total recaudado de " + mayor);
    }
    
    public void mayorMesVentas(){
        float mesMayor = 0;
        int mes = 0;
        float sumaMes;
        for(int x = 0 ; x < 5 ; x = x + 1){
            sumaMes = 0;
            for(int y = 0 ; y < 6 ; y = y + 1){
                sumaMes = sumaMes + ventas[y][x];
            }
            if(sumaMes > mesMayor){
                mesMayor = sumaMes;
                mes = x;
            }
        }
        informar("El mes con mayor cantidad de ventas fue el mes " + (mes+1) + " con $" + mesMayor);
    }
    
    public void ventaSuperiorPromGral(){
        float prom = ventasRegistradas();
        int porEncimaProm;
        for(int x = 0 ; x < 6 ; x = x + 1){
            porEncimaProm = 0;
            for(int y = 0 ; y < 5 ; y = y + 1){
                if(ventas[x][y] > prom){
                    porEncimaProm = porEncimaProm + 1;
                }
            }
            if(porEncimaProm > 0){
                informar("El vendedor " + empleados[x] + " vendio " 
                            + porEncimaProm + " veces superando el promedio general de " + prom);
            }else{
                informar("El vendedor " + empleados[x] + " no realizo ventas por encima del promedio general de " + prom);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        practica2Juntos xd = new practica2Juntos();
        xd.cargarEstructuras();
        xd.totalVendidoPorEmpleado();
    }
}
