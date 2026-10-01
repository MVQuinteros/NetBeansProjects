/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * Una empresa tiene 5 fábricas y registra la cantidad producida durante 3 meses.
Realizar:

A. Cargar los nombres de las fábricas y su producción mensual.x

B. Generar el vector con la producción acumulada de cada fábrica. x

C. Informar la producción total de la empresa. x

D. Calcular el promedio de producción por fábrica. x

E. Mostrar las fábricas que produjeron por encima del promedio. x

F. Mostrar las fábricas que produjeron por debajo del promedio. x

G. Informar la fábrica con mayor producción acumulada. x

H. Ordenar el vector de producción acumulada de mayor a menor, manteniendo asociado el nombre de cada fábrica. x

👀 Este último ya mete ordenamiento + vector paralelo, que es justo un pasito más.
 */
public class practica3juntos {
    public static Scanner teclado = new Scanner(System.in);
    private final String[] fabrica = new String[5];
    private final float[][] produccion = new float[5][3];
    private final float[] totalProduccion = new float[5];
    
    public String traerString(String mjs){
        System.out.print(mjs);
        return teclado.nextLine();
    }
    
    public float traerFloat(String mjs){
        float numero;
        System.out.print(mjs);
        numero = teclado.nextFloat();
        teclado.nextLine();
        return numero;
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 5 ; x++){
            fabrica[x] = traerString("Ingrese el nombre de la fabrica: ");
            for(int y = 0 ; y < 3 ; y++){
                produccion[x][y] = traerFloat("Ingrese el monto de la produccion de la fabrica " + fabrica[x] + " mes "+ (y+1) + ": ");
            }
        }
    }
    
    public void produccionAcumulada(){
        float suma;
        for(int x = 0 ; x < 5 ; x++){
            suma = 0;
            for(int y = 0 ; y < 3 ; y++){
                suma = suma + produccion[x][y];
            }
            totalProduccion[x] = suma;
        }
    }
    
    public void produccionTotalEmpresa(){
        float sumatoria = 0;
        for(int x = 0 ; x < 5 ; x++){
            sumatoria = sumatoria + totalProduccion[x];
        }
        informar("El total recaudado de las fabricas por la empresa es de " + sumatoria);
        promedioProdPorFabrica(sumatoria);
    }
    
    public void promedioProdPorFabrica(float sum){
        float prom;
        prom = sum / 5;
        informar("El promedio de produccion por fabrica es de " + prom);
        prodEncimaProm(prom);
    }
    
    public void prodEncimaProm(float pro){
        for(int x = 0 ; x < 5 ; x++){
            if(totalProduccion[x] > pro){
                informar("La fabrica " + fabrica[x] + " esta por encima del promedio con "+ totalProduccion[x]);
            }else{
                informar("La fabrica " + fabrica[x] + " esta por debajo del promedio con "+ totalProduccion[x]);
            }
        }
    }
    
    public void fabricaMayorProd(){
        float mayorProduccion = totalProduccion[0];
        int pos = 0;
        for(int x = 0 ; x < 5 ; x++){
            if(mayorProduccion < totalProduccion[x]){
                mayorProduccion = totalProduccion[x];
                pos = x;
            }
        }
        informar("la fabrica con mayor produccion acumulada es la fabrica "+ fabrica[pos] + " con " + mayorProduccion);
    }
    
    public void mayorMenorTotalProd(){
        float auxProd;
        String auxFab;
        for(int x = 0 ; x < 5-1 ; x++){
            for(int y = 0 ; y < 5-1 ; y++){
                if(totalProduccion[y] < totalProduccion[y+1]){
                    auxProd = totalProduccion[y];
                    totalProduccion[y] = totalProduccion[y+1];
                    totalProduccion[y+1] = auxProd;
                    
                    auxFab = fabrica[y];
                    fabrica[y] = fabrica[y+1];
                    fabrica[y+1] = auxFab;
                }
            }
        }
        informar("El total produccion acumulado ordenado de mayor a menor: ");
        imprimirVector();
    }
    
    public void imprimirVector(){
        for(int x = 0 ; x < 5 ; x++){
            informar(fabrica [x] + " - " + totalProduccion[x]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Practica 3 - ejercicio fabricas y produccion");
        practica3juntos prac = new practica3juntos();
        prac.cargarEstructuras();
        prac.produccionAcumulada();
        prac.produccionTotalEmpresa();
        prac.fabricaMayorProd();
        prac.mayorMenorTotalProd();
    }
}
