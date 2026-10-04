/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * 🔥 Ejercicio 12 — Un poquito más hijo de puta

Una tienda tiene 5 productos y registra las ventas durante 4 semanas.

String[] productos
int[][] ventas
int[] totalProducto
int[] totalSemana

Realizar:

A. Cargar productos y ventas. x

B. Total vendido por producto. x

C. Total vendido por semana. x 

D. Total general. x 

E. Promedio general de todas las ventas. x 

F. Productos cuya venta acumulada esté por encima del promedio de ventas por producto. x 

G. Producto con mayor venta acumulada. x

H. Producto con menor venta acumulada. x 

I. Semana con mayor cantidad de ventas. x

J. Mostrar los productos que tuvieron al menos una semana con ventas superiores al promedio general de todas las ventas. x 

K. Indicar cuántas semanas cada uno de esos productos superó el promedio general. x

L. Ordenar productos de menor a mayor venta acumulada. x 
 */
public class practica8Juntos {
    public static final Scanner tec = new Scanner(System.in);
    private String[] productos = new String[5];
    private int[][] ventas = new int[5][4];
    private int [] ventaAcumulada = new int[5];
    private int [] totalVendidoSemanal = new int [4];
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        int numero = tec.nextInt();
        tec.nextLine();
        return numero;
    }
    
    public String traerString(String mjs){
        System.out.print(mjs);
        return tec.nextLine();
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 5 ; x++){
            productos[x] = traerString("Ingrese el nombre del producto n " + (x+1) + ": ");
            for(int y = 0 ; y < 4 ; y++){
                ventas[x][y] = traerInt("ingrese la venta de este producto en la semana n "+ (y+1) + ": ");
            }
        }
    }
    
    public void cargarVentasAcumuladas(){
        int suma;
        for(int x = 0 ; x < 5 ; x++){
            suma = 0;
            for(int y = 0 ; y < 4 ; y++){
                suma = suma + ventas[x][y];
            }
            ventaAcumulada[x]= suma;
        }
    }
    
    public void cargarTotaltotalVendidoSemanal(){
        int suma;
        for(int x = 0 ; x < 4 ; x++){
            suma = 0;
            for(int y = 0 ; y < 5 ; y++){
                suma = suma + ventas[y][x];
            }
            totalVendidoSemanal[x] = suma;
        }
    }
    
    public void sacarTotalGeneral(){
        int sumatoria = 0;
        for(int x = 0 ; x < 5 ; x++){
            sumatoria = sumatoria + ventaAcumulada[x];
        }
        informar("El total general de las ventas de unidades es de " + sumatoria);
        sacarPromGeneral(sumatoria);
        sacarPromVentasXproducto(sumatoria);
    }
    
    public void sacarPromGeneral(int sum){
        int prom;
        prom = sum / (5*4);
        informar("el promedio generalo de todas las ventas es de " + prom);
        buscarProdVentasSupPromGeneral(prom);
    }
    
    public void sacarPromVentasXproducto(int sum){
        int prom;
        prom = sum / 5;
        informar("el promedio de ventas por producto es de "+ prom);
        buscarProdEncimaProm(prom);
    }
    
    public void buscarProdEncimaProm(int p){
        for(int x = 0 ; x < 5 ; x++){
            if(ventaAcumulada[x] > p){
                informar("El producto "+ productos[x] + " esta ´por ensima del promedio de ventas x producto con "+ ventaAcumulada[x]);
            }
        }
    }
    
    public void buscarProductoMayorVenta(){
        int mayor = ventaAcumulada[0];
        int pos=0;
        for(int x = 0 ; x < 5 ; x++){
            if(ventaAcumulada[x]>mayor){
                mayor= ventaAcumulada[x];
                pos = x;
            }
        }
        informar("El producto "+ productos[pos] + " tiene la mayor cantiad de ventas acumuladas con " + mayor);
    }
    
    public void buscarProdMenorVenta(){
        int menor = ventaAcumulada[0];
        int pos=0;
        for(int x = 0 ; x < 5 ; x++){
            if(ventaAcumulada[x]< menor){
                menor = ventaAcumulada[x];
                pos = x;
            }
        }
        informar("El producto "+ productos[pos] + " tiene la mayor cantiad de ventas acumuladas con " + menor); 
    }
    public void buscarMayorVentasSemana(){
        int mayor = totalVendidoSemanal[0];
        int pos = 0;
        for(int x = 0 ; x < 4 ; x++){
            if( totalVendidoSemanal[x] > mayor){
                mayor =  totalVendidoSemanal[x];
                pos = x;
            }
        }
        informar("La semana numero "+ (pos+1)+ " tiene la mayor cantiad de ventas acumuladas con " + mayor); 
    }
    
    public void buscarProdVentasSupPromGeneral(int p){
        boolean AlmenosUnaVez;
        int veces;
        for(int x = 0 ; x < 5 ; x++){
            AlmenosUnaVez = false;
            veces = 0;
            for(int y = 0 ; y < 4 ; y++){
                if(ventas[x][y] > p){
                    AlmenosUnaVez = true;
                    veces = veces + 1;
                }
            }
            if(AlmenosUnaVez){
                informar("el producto " + productos[x] + " supero el promedio general con su venta unas " +  veces + " veces ");
            }
        }
    }
    
    public void ordenarMenorMayor(){
        int auxVenta;
        String auxProd;
        for(int x = 0 ; x < 5-1 ; x++){
            for(int y = 0 ; y < 4 ; y++){
                if(ventaAcumulada[y] > ventaAcumulada[y+1]){
                    auxVenta = ventaAcumulada[y];
                    ventaAcumulada[y] = ventaAcumulada[y+1];
                     ventaAcumulada[y+1] = auxVenta;
                     
                    auxProd = productos[y];
                    productos[y] = productos[y+1];
                    productos[y+1] = auxProd;
                }
            }
        }
        imprimirVec("----Vectores Ordenados-----");
    }
    
    public void imprimirVec(String mjs){
        System.out.println(mjs);
        for(int x = 0 ; x < 5 ; x++){
            System.out.print("producto: " + productos[x] + " - Venta Acumulada: " + ventaAcumulada[x]);
        }
    }
        
    public static void main(String[] args) {
        System.out.println("Hello World!");
        practica8Juntos p = new practica8Juntos();
        p.cargarEstructuras();
        p.cargarVentasAcumuladas();
        p.cargarTotaltotalVendidoSemanal();
        p.sacarTotalGeneral();
        p.buscarProductoMayorVenta();
        p.buscarProdMenorVenta();
        p.buscarMayorVentasSemana();
        p.imprimirVec("----Vectores sin ordenar-----");
        p.ordenarMenorMayor();
    }         
}
