/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * 🟠 EJERCICIO 5 — Hoteles y ocupación
Una cadena tiene 5 hoteles y registra la cantidad de habitaciones ocupadas durante 4 semanas.

String[] hoteles
float[][] ocupacion
float[] totalOcupacion
Realizar:

A. Cargar hoteles y ocupación semanal.x

B. Generar el vector con el total de habitaciones ocupadas por hotel. x 

C. Informar el total de habitaciones ocupadas por la cadena. x

D. Calcular el promedio de ocupación por hotel. x

E. Mostrar los hoteles con ocupación por debajo del promedio. x

F. Mostrar el hotel con mayor ocupación acumulada. x

G. Informar qué semana tuvo la mayor ocupación total. x

H. Ordenar los hoteles de menor a mayor ocupación acumulada. x
 */
public class practica5juntos {
    public static final Scanner teclado = new Scanner(System.in);
    
    private final String[] hotel = new String[5];
    private final int[][] habitacionesOcupadas = new int[5][4];
    private final int[] OcupadasXhotel = new int[5];
    private final int[] OcupadasXsemana = new int[4];
    
    public String traerString(String mjs){
        System.out.print(mjs);
        return teclado.nextLine();
    }
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        int numero = teclado.nextInt();
        teclado.nextLine();
        return  numero;
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 5 ; x++){
            hotel[x] = traerString("Ingrese el nombre del hotel n " + (x+1) +": " );
            for(int y = 0 ; y < 4 ; y++){
                habitacionesOcupadas[x][y] = traerInt("Ingrese la cantidad de habitaciones ocupadas de la semana n "+ (y+1)+ ": ");
            }
        }
    }
    
    public void totalHabitacionesXhotel(){
        int suma;
        for(int x = 0 ; x < 5 ; x++){
            suma = 0;
            for(int y = 0 ; y < 4 ; y++){
                suma = suma + habitacionesOcupadas[x][y];
            }
            OcupadasXhotel[x]= suma;
        }
    }
    
    public void totalOcupadoTodosHoteles(){
        int sumatoria = 0;
        for(int x = 0 ; x < 5 ; x++){
            sumatoria = sumatoria + OcupadasXhotel[x] ;
        }
        informar("el total de las habitaciones ocupadas por la cadena en todos los hoteles es de: "+ sumatoria);
        sacarPromOcupacionXhotel(sumatoria);
    }
    
    public void sacarPromOcupacionXhotel(int sum){
        int promedioXhotel;
        promedioXhotel = sum / 5;
        informar("El promedio de ocupacion por hotel es de " + promedioXhotel);
        buscarHotelesDebajoProm(promedioXhotel);
    }
    
    public void buscarHotelesDebajoProm(int p){
        for(int x = 0 ; x < 5 ; x++){
            if (OcupadasXhotel[x]< p){
                informar("el hotel " + hotel [x] + " esta por debajo del promedio de ocupacion por hotel con " + OcupadasXhotel[x]);
            }
        }
    }
    
    public void buscarMayorOcupacionAcumulada(){
        int mayorOcu = OcupadasXhotel[0];
        int pos = 0;
        for(int x = 0 ; x < 5 ; x++){
            if(mayorOcu < OcupadasXhotel[x]){
                mayorOcu = OcupadasXhotel[x];
                pos = x;
            }
        }
        informar("el hotel "+ hotel[pos] +" tiene la mayor ocupacion acumulada con un total de " + mayorOcu);
    }
    
    public void llenarOcuSemanal(){
        int sumaSemanal;
        for(int x = 0 ; x < 4 ; x++){
            sumaSemanal = 0;
            for(int y = 0 ; y < 5 ; y++){
                sumaSemanal = sumaSemanal + habitacionesOcupadas[y][x];
            }
            OcupadasXsemana[x] = sumaSemanal;
        }
        buscarMayorOcuSemanal();
    }
    public void buscarMayorOcuSemanal(){
        int mayorOcuSemanal = OcupadasXsemana[0];
        int pos = 0;
        for(int x = 0 ; x < 4 ; x++){
            if(OcupadasXsemana[x] > mayorOcuSemanal){
                mayorOcuSemanal = OcupadasXsemana[x];
                pos = x;
            }
        }
        informar("La semana con mayor ocupacion es "+ (pos+1) + " con un  total de " + mayorOcuSemanal + " habitaciones ocupadas");
    }
    
    public void ordenarMenorMayor(){
        int auxOcu;
        String auxHotel;
        for(int x = 0 ; x < 5-1 ; x++){
            for(int y = 0 ; y < 4 ; y++){
                if(OcupadasXhotel[y] > OcupadasXhotel[y+1]){
                    auxOcu = OcupadasXhotel[y];
                    OcupadasXhotel[y] = OcupadasXhotel[y+1];
                    OcupadasXhotel[y+1] = auxOcu;
                    
                    auxHotel = hotel[y];
                    hotel[y] = hotel[y+1];
                    hotel[y+1] = auxHotel;
                }
            }
        }
        imprimirVectores();
    }
    
    public void imprimirVectores(){
        for(int x = 0 ; x < 5 ; x++){
            informar(hotel[x]+ " - "+ OcupadasXhotel[x]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        practica5juntos p = new practica5juntos();
        p.cargarEstructuras();
        p.totalHabitacionesXhotel();
        p.totalOcupadoTodosHoteles();
        p.buscarMayorOcupacionAcumulada();
        p.llenarOcuSemanal();
        p.ordenarMenorMayor();
    }
}
