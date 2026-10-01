/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
🔥 Ejercicio 11 — Parcial de 40 minutos
Una empresa tiene 6 empleados y registra las horas trabajadas durante 5 semanas.

Tenés:

String[] empleados
int[][] horas
int[] totalHoras
int[] totalHorasSemana

Realizar:

A. Cargar nombres y horas de cada empleado durante las 5 semanas. x

B. Calcular el total de horas trabajadas por cada empleado. x

C. Informar el total general de horas trabajadas. x 

D. Calcular el promedio general de horas por empleado. x 

E. Mostrar empleados que estén por debajo del promedio.x 

F. Mostrar empleado con mayor cantidad de horas acumuladas. x

G. Mostrar empleado con menor cantidad de horas acumuladas.x 

H. Calcular el total de horas trabajadas en cada semana. x

I. Informar qué semana tuvo mayor cantidad de horas trabajadas. x

J. Ordenar empleados de mayor a menor cantidad de horas, manteniendo correctamente relacionados los nombres. x 
 */
public class practica7Juntos {
    public static final Scanner teclado = new Scanner (System.in);
    private final String[] empleados = new String[6];
    private final float[][] horasLaburadas = new float[6][5];
    private final float[] horasAcumuladas = new float[6];
    private final float[] horasSemana = new float[5];
    
    public String traerString(String mjs){
        System.out.print(mjs);
        return teclado.nextLine();
    }
    
    public float traerFloat(String mjs){
        System.out.print(mjs);
        float numero = teclado.nextFloat();
        teclado.nextLine();
        return numero;
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 6 ; x++){
            empleados[x]= traerString("Ingrese el nombre del empleado n "+ (x+1) + ": ");
            for(int y = 0 ; y < 5 ; y++){
                horasLaburadas[x][y] = traerFloat("ingrese las horas trabajadas de la semana n " + (y+1)+ ": ");
            }
        }
    }
    
    public void horastrbajadasXeempleado(){
        float suma;
        for(int x = 0 ; x < 6 ; x++){
            suma = 0;
            for(int y = 0 ; y < 5 ; y++){
                suma = suma + horasLaburadas[x][y];
            }
            horasAcumuladas[x] = suma;
        }
    }
    
    public void totalGeneralTrabajado(){
        float sumatoria = 0;
        for(int x = 0 ; x < 6 ; x++){
            sumatoria = sumatoria + horasAcumuladas[x];
        }
        informar("El total general de horas trabajadas es de " + sumatoria + " horas");
        totalXEmpleado(sumatoria);
    }
    
    public void totalXEmpleado(float sum){
        float prom;
        prom = sum/ 6;
        informar("el promedio genral de horas trabajadas por empledado es de " + prom + " horas");
        buscarEmpleadosDebajoProm(prom);
    }
    
    public void buscarEmpleadosDebajoProm(float p){
        for(int x = 0 ; x < 6 ; x++){
            if(horasAcumuladas[x] < p){
                informar("el empleado "+empleados[x] + " esta por debajo del promedio con " + horasAcumuladas[x]);
            }
        }
    }
    
    public void buscarMayorCantHoras(){
        float mayor = horasAcumuladas[0];
        int pos = 0;
        for(int x = 0 ; x < 6 ; x++){
            if(horasAcumuladas[x]> mayor){
                mayor = horasAcumuladas[x];
                pos = x;
            }
        }
        informar("El empleado con mayor horas acumuladas es " + empleados[pos]+ " con un total de "+ mayor);
    }
    
    public void buscarMenorCantHoras(){
        float menor = horasAcumuladas[0];
        int pos = 0;
        for(int x = 0 ; x < 6 ; x++){
            if(horasAcumuladas[x]<  menor){
                menor = horasAcumuladas[x];
                pos = x;
            }
        }
        informar("El empleado con menor horas acumuladas es " + empleados[pos]+ " con un total de "+ menor);
    }
    
    public void totalHorasXsemana(){
        float suma;
        for(int x = 0 ; x < 5 ; x++){
            suma = 0;
            for(int y = 0 ; y < 6 ; y++){
                suma = suma + horasLaburadas[y][x];
            }
            horasSemana[x] = suma;
            informar("el total de horas trabajadas en la semana n " + (x+1) + " es de " + horasSemana[x]);
        }
    }
    
    public void buscarMayorCantHorasXsemana(){
        float mayor = horasSemana[0];
        int pos = 0;
        for(int x = 0 ; x < 5 ; x++){
            if(horasSemana[x]> mayor){
                mayor = horasSemana[x];
                pos = x;
            }
        }
        informar("la semana con mayor cargahoraria es la n" + (pos+1) + " con un total de " + mayor);
    }
    
    public void ordenarMayorMenor(){
        float auxHoras;
        String auxEmpleado;
        for(int x = 0 ; x < 6-1 ; x++){
            for(int y = 0 ; y < 5 ; y++){
                if(horasAcumuladas[y] <  horasAcumuladas[y+1]){
                    auxHoras = horasAcumuladas[y];
                    horasAcumuladas[y] = horasAcumuladas[y+1];
                    horasAcumuladas[y+1] = auxHoras;
                    
                    auxEmpleado = empleados[y];
                    empleados[y] = empleados[y+1];
                    empleados[y+1] = auxEmpleado;
                }
            }
        }
        imprimirVector();
    }
    
    public void imprimirVector(){
        for(int x = 0 ; x < 6 ; x++){
            informar(empleados[x]+" - "+horasAcumuladas[x]);
        }
    }
            
    public static void main(String[] args) {
        System.out.println("Hello World!");
        practica7Juntos p = new practica7Juntos();
        p.cargarEstructuras();
        p.horastrbajadasXeempleado();
        p.totalGeneralTrabajado();
        p.buscarMayorCantHoras();
        p.buscarMenorCantHoras();
        p.totalHorasXsemana();
        p.buscarMayorCantHorasXsemana();
        p.imprimirVector();
        p.ordenarMayorMenor();
    }
}
