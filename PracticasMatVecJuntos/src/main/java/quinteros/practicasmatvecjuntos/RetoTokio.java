/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * 📝 SIMULACRO DE PARCIAL — 40 MINUTOS

Una empresa desea registrar información sobre las ventas realizadas durante una semana.

Se trabaja con 6 vendedores y 5 días.

Se deberá almacenar el nombre de cada vendedor y la cantidad de ventas realizadas por cada uno durante cada día.

 - Ingresar el nombre de cada vendedor. x 
 - Ingresar la cantidad de ventas realizadas por cada vendedor durante los 5 días. x 
 - Mostrar todos los vendedores junto con las ventas realizadas en cada uno de los 5 días. x 
 - Obtener el total de ventas realizadas por cada vendedor durante la semana. x 
 - Mostrar el total de ventas de cada vendedor. x 
 - Obtener y mostrar el promedio diario de ventas de cada vendedor. x 
 - Mostrar los vendedores cuyo promedio diario sea mayor o igual a 20. x
 - Informar cuántos vendedores tuvieron un promedio diario menor a 20. x
 - Informar el vendedor que realizó la mayor cantidad de ventas durante toda la semana. x
 - Informar el vendedor que realizó la menor cantidad de ventas durante toda la semana. x
 - Informar cuál fue la mayor cantidad de ventas realizadas en un solo día, indicando el vendedor y el número de día. x
 - Informar cuál fue la menor cantidad de ventas realizadas en un solo día, indicando el vendedor y el número de día. x
 - Informar cuántos vendedores tuvieron al menos un día en el que realizaron menos de 10 ventas. x
 - Informar cuántos vendedores realizaron 15 ventas o más durante los 5 días.  x
 - Obtener el promedio general de ventas considerando todos los vendedores y todos los días. x
 - Mostrar los vendedores cuyo promedio individual sea superior al promedio general. x
 - Informar el o los vendedores que tuvieron la mayor cantidad de días con 20 ventas o más.  x 
 - Informar el o los vendedores que tuvieron la mayor cantidad de días con menos de 20 ventas.
 - Ordenar los vendedores de mayor a menor según su total semanal de ventas, manteniendo correctamente relacionada toda la información correspondiente.
 */
public class RetoTokio {
    
    public static final Scanner t = new Scanner(System.in);
    private String[] vendedores = new String[6];
    private int[][] ventas = new int [6][5];
    private int[] acumuladorVentas = new int[6];
    private int[] promIndividual = new int[6];
    
    public String traerString(String mjs){
        System.out.print(mjs);
        return t.nextLine();
    }
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        int num = t.nextInt();
        t.nextLine();
        return num;
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
    }

    public void sacarPromVentasPorVendedor(){
        int prom;
        int suma = 0;
        for(int x = 0 ; x < 6 ; x++){
            suma = suma + acumuladorVentas[x];
        }
        prom = suma / 6;
        informar("El promedio de ventas por vendedor es de: " + prom);
    }    
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 6 ; x++){
            vendedores[x]= traerString("Ingrese el nombre completo del vendedor n°" + (x+1) + ": ");
            for(int y = 0 ; y < 5 ; y++){
                ventas[x][y]= traerInt("Ingrese la venta n°"  + (y+1) + " del vendedor " + vendedores[x] + ": ");
            }
        }
    }
    
    public void imprimirVendedoresVentas(){
        for(int x = 0 ; x < 6 ; x++){
            informar("El vendedor n°" + (x+1) + " se llama " + vendedores[x]);
            for(int y = 0 ; y < 5 ; y++){
                informar("venta n°"  + (y+1) + ": " + ventas[x][y]);
            }
        }
    }
    
    public void cargarAcumuladorVentas(){
        int suma;
        for(int x = 0 ; x < 6 ; x++){
            suma = 0;
            for(int y = 0 ; y < 5 ; y++){
                suma = suma + ventas[x][y];
            }
            acumuladorVentas[x] = suma;
        }
    }
    
    public void mostrarVentasPorVendedor(){
        for(int x = 0 ; x < 6 ; x++){
            informar(vendedores[x] +" -  venta acumulada: " + acumuladorVentas[x]);
        }
    }
    
    public void promedioPorVendedorIndividual(){
        for(int x = 0 ; x < 6 ; x++){
            promIndividual[x] = acumuladorVentas[x] / 5;
        }
    }
    
    public void buscarVendedoresMayorMenor20(){
        for(int x = 0 ; x < 6 ; x++){
            if(promIndividual[x]>=20){
                informar("el vendedor "+vendedores[x] + " tienen un promedio individual superior o igual a 20. tiene exactamente: "+promIndividual[x]);
            } else{
                informar("el vendedor "+vendedores[x] + " tienen un promedio individual superior o igual a 20. tiene exactamente: "+promIndividual[x]);
            }
        }
    }
    
    public void buscarMayoresVentas(){
        int mayor = acumuladorVentas[0];
        for(int x = 0 ; x < 6 ; x++){
            if(mayor < acumuladorVentas[x]){
                mayor = acumuladorVentas[x];
            }
        }
        for(int x = 0 ; x < 6 ; x++){
            if(mayor == acumuladorVentas[x]){
                informar("El vendedor " + vendedores[x] + " tiene de las mayores ventas con un total de "+ mayor);
            }
        }
    }
    
    public void buscarMenoresVentas(){
        int menor = acumuladorVentas[0];
        for(int x = 0 ; x < 6 ; x++){
            if(menor > acumuladorVentas[x]){
                menor = acumuladorVentas[x];
            }
        }
        for(int x = 0 ; x < 6 ; x++){
            if(menor == acumuladorVentas[x]){
                informar("El vendedor " + vendedores[x] + " tiene de las menores ventas con un total de "+ menor);
            }
        }
    }
    
    public void buscarMayorCantVentas(){
        int mayor = ventas[0][0];
        int numeroVenta = 0;
        String nombre = vendedores[0];
        for(int x = 0 ; x < 6 ; x++){
            for(int y = 0 ; y < 5 ; y++){
                if(mayor < ventas[x][y]){
                    mayor = ventas[x][y];
                    numeroVenta = y;
                    nombre = vendedores[x];
                }
            }
        }
        informar("La mayor venta registrada fue la n°"+(numeroVenta+1)+" del vendedor " + nombre + " con un total de "+ mayor +" ventas");
    }
    
    public void buscarMenorCantVentas(){
        int menor = ventas[0][0];
        int numeroVenta = 0;
        String nombre = vendedores[0];
        for(int x = 0 ; x < 6 ; x++){
            for(int y = 0 ; y < 5 ; y++){
                if(menor > ventas[x][y]){
                    menor = ventas[x][y];
                    numeroVenta = y;
                    nombre = vendedores[x];
                }
            }
        }
        informar("La menor venta registrada fue la n°"+(numeroVenta+1)+" del vendedor " + nombre + " con un total de "+ menor +" ventas");
    }
    
    public void mostrarVendedor10(){
        boolean alMenosUnaVez;
        for(int x = 0 ; x < 6 ; x++){
            alMenosUnaVez = false;
            for(int y = 0 ; y < 5 ; y++){
                if(ventas[x][y] < 10){
                    alMenosUnaVez = true;
                }
            }
            if(alMenosUnaVez){
                informar("el vendedor " + vendedores[x] + " al menos una vez tuvo ventas debajo de 10.");
            }else{
                informar("el vendedor " + vendedores[x] + " no tuvo ventas debajo de 10.");
            }
        }
    }
    
    public void vendedores15ventasRegistradas(){
        boolean ventas15 ;
        int ven;
        for(int x = 0 ; x < 6 ; x++){
            ventas15 = false;
            ven = 0;
            for(int y = 0 ; y < 5 ; y++){
                if(ventas[x][y] >= 15){
                    ventas15 = true;
                    ven = ven + 1;
                }
            }
            if(ventas15){
                informar("el vendedor " + vendedores[x] + " tuvo " + ven + " ventas que superaron o igualaron las 15");
            }
        }
        
    }
    
    public void buscarPromGeneralVentasd(){
        int suma = 0;
        int promGeneral;
        for(int x = 0 ; x < 6 ; x++){
            suma =  suma + acumuladorVentas[x];
        }
        promGeneral = suma / (6*5);
        informar("el promedio general de ventas es de " + promGeneral);
         buscarPromIndSupPromGene(promGeneral);
    }
    
    public void buscarPromIndSupPromGene(int promGene){
        for(int x = 0 ; x < 6 ; x++){
            if(promIndividual[x]> promGene){
                informar("el vendedor "+vendedores[x] + " tienen un promedio individual superior al promedio general" + promGene +". tiene exactamente: "+promIndividual[x]);
            } else{
                informar("el vendedor "+vendedores[x] + " tienen un promedio individual inferior al promedio general" + promGene +". tiene exactamente: "+promIndividual[x]);
            }
        }
    }
    
    public void buscarVentasSup20(){
        int cantVent;
        int 
        for(int x = 0 ; x < 6 ; x++){
            cantVent = 0;
            for(int y = 0 ; y < 5 ; y++){
                if(ventas[x][y] >= 20){
                    cantVent = cantVent + 1;
                }
            }
            informar("el vendedor tuvo " + cantVent + " ventas superiores o igaules a 20");
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("Reto Sergio!");
        RetoTokio r = new RetoTokio();
        r.cargarEstructuras();
        r.imprimirVendedoresVentas();
        r.cargarAcumuladorVentas();
        r.mostrarVentasPorVendedor();
        r.sacarPromVentasPorVendedor();
        r.promedioPorVendedorIndividual();
        r.buscarVendedoresMayorMenor20();
        r.buscarMayoresVentas();
        r.buscarMenoresVentas();
        r.buscarMayorCantVentas();
        r.buscarMenorCantVentas();
    }
}
