/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * 🔴 EJERCICIO 6 — Parcialito 👹

Una empresa comercial tiene 6 productos y registra la cantidad de unidades vendidas durante 5 meses.

float[] acumulado
Realizar:

A. Cargar nombres de productos y ventas mensuales. x

B. Generar el vector con las ventas acumuladas de cada producto.x

C. Informar el total de unidades vendidas. x

D. Calcular el promedio de unidades vendidas por producto. x

E. Mostrar los productos que estén por debajo del promedio. x

F. Mostrar los productos que estén por encima del promedio. x 

G. Informar el producto con mayor cantidad de unidades vendidas. x

H. Informar el producto con menor cantidad de unidades vendidas. x

I. Informar el mes con mayor cantidad de ventas totales. x 

J. Mostrar los productos que hayan tenido al menos un mes con ventas superiores al promedio general de todas las ventas. x 

K. Ordenar los productos de mayor a menor según sus ventas acumuladas, manteniendo correctamente relacionados los nombres. x
 */
public class practica4juntos {
    public static final Scanner teclado = new Scanner(System.in);
    private String[] producto = new String[6];
    private int[][] unidadesVendidas = new int[6][5];
    private int[] totalVendidoUnidades = new int[6]; 
    private int[] totalVendidoUnidadesXmes = new int[5];
    
    public String traerString(String mjs){
        System.out.println(mjs);
        return teclado.nextLine();
    }
    
    public int traerInt(String mjs){
        int numero;
        System.out.println(mjs);
        numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public void imprimirVector(){
        for(int x = 0 ; x < 6 ; x++){
            informar(producto[x] + " - " + totalVendidoUnidades[x] );
        }
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 6 ; x++){
            producto[x] = traerString("ingrese el nombre del producto: ");
            for(int y = 0 ; y < 5 ; y++){
                unidadesVendidas[x][y] = traerInt("ingrese la cantidad de unidades vendidas en el mes " + (y+1) + ": ");
            }
        }
    }
    
    public void totalVendidoAcumulado(){
        int suma;
        for(int x = 0 ; x < 6 ; x++){
            suma = 0;
            for(int y = 0 ; y < 5 ; y++){
                suma = suma + unidadesVendidas[x][y];
            }
            totalVendidoUnidades[x] = suma;
        }
    }
    
    public void totalVendido(){
        int sumatoria = 0;
        for(int x = 0 ; x < 6 ; x++){
            sumatoria = sumatoria + totalVendidoUnidades[x];
        }
        informar("El total de las unidades vendidas entre estos 5 meses es de: " + sumatoria + " unidades");
        promedioVentasPorProducto(sumatoria);
        sacarPromedioGeneral(sumatoria);
    }
    
    public void promedioVentasPorProducto(int sum){
        int prom;
        prom = sum / 6;
        informar("El promedio de unidades vendidas por producto es de: " + prom);
        mostrarDebajoProm(prom);
    }
    
    public void mostrarDebajoProm(int p){
        for(int x = 0 ; x < 6 ; x++){
            if(totalVendidoUnidades[x] < p){
                informar("El producto "+ producto[x] + " esta por debajo del promedio.");
            }else{
                if(totalVendidoUnidades[x] == p){
                    informar("El producto "+ producto[x]+ " es igual al promedio.(?");
                }else{
                    informar("El producto "+ producto[x]+ " es mayor que el promedio");
                }
            }
        }
    }
    
    public void buscarMayorUniVendidas(){
        int mayorCantidadUnidades = totalVendidoUnidades[0];
        int pos = 0;
        for(int x = 0 ; x < 6 ; x++){
            if(mayorCantidadUnidades < totalVendidoUnidades[x]){
                mayorCantidadUnidades = totalVendidoUnidades[x];
                pos = x;
            }
        }
        informar("el producto " + producto[pos]+ " tiene la mayor cantidad de unidades vendidas. una cantidad de: "+ mayorCantidadUnidades);
    }
    
    public void buscarMenorUniVendidas(){
        int menorCantUnidades = totalVendidoUnidades[0];
        int pos = 0;
        for(int x = 0 ; x < 6 ; x++){
            if(menorCantUnidades > totalVendidoUnidades[x]){
                menorCantUnidades = totalVendidoUnidades[x];
                pos = x;
            }
        }
        informar("el producto " + producto[pos]+ " tiene la menor cantidad de unidades vendidas. una cantidad de: "+ menorCantUnidades);
    }
    
    public void VentaUnidadesXmes(){
        int sumaXmes;
        for(int x = 0 ; x < 5 ; x++){
            sumaXmes = 0;
            for(int y = 0 ; y < 6 ; y++){
                sumaXmes = sumaXmes + unidadesVendidas[y][x];
            }
            totalVendidoUnidadesXmes[x] = sumaXmes;
        }
    }
    
    public void mayorVentaUnidadesXmes(){
        int mayorCantUnidadesVendidasXmes = totalVendidoUnidadesXmes[0];
        int pos = 0;
        for(int x = 0 ; x < 5 ; x++){
            if(totalVendidoUnidadesXmes[x] > mayorCantUnidadesVendidasXmes){
                mayorCantUnidadesVendidasXmes = totalVendidoUnidadesXmes[x];
                pos = x;
            }
        }
        informar("el mes que se vendieron mas unidades de todos los productos ingresados fue el mes " + (pos+1) + 
                " con un total de " + mayorCantUnidadesVendidasXmes + " unidades vendidas");
    }
    
    public void sacarPromedioGeneral(int sum){
        int promGeneral;
        promGeneral = sum / (6*5);
        informar("el promedio general de unidades vendidas es de: " + promGeneral);
        buscarMayorUnidadesVendidasMes(promGeneral);
    }
    
    public void buscarMayorUnidadesVendidasMes(int pg){
        boolean superiorAlMenosUnaVez;
        int contador;
        for(int x = 0 ; x < 6 ; x++){
            superiorAlMenosUnaVez = false;
            contador = 0;
            for(int y = 0 ; y < 5 ; y++){
                if(unidadesVendidas[x][y] > pg){
                    superiorAlMenosUnaVez = true;
                    contador = contador + 1;
                }
            }
            if(superiorAlMenosUnaVez){
                informar("El producto " + producto[x]+ " supero el promedio general en ventas "+ pg + 
                        " un total de "+ contador + " veces");
            }
        }
    }
    
    public void ordenarMayorMenor(){
        int auxUni;
        String auxProd;
        for(int x = 0 ; x < 6-1 ; x++){
            for(int y = 0 ; y < 5 ; y++){
                if(totalVendidoUnidades[y] < totalVendidoUnidades[y+1]){
                    auxUni = totalVendidoUnidades[y];
                    totalVendidoUnidades[y] = totalVendidoUnidades[y+1];
                    totalVendidoUnidades[y+1] = auxUni;
                    
                    auxProd = producto[y];
                    producto[y] = producto[y+1];
                    producto[y+1] = auxProd;
                }
            }
        }
        imprimirVector();
    }
    
    public static void main(String[] args) {
        System.out.println("Practica 4 - ejercicio productos y unidades");
        practica4juntos p = new practica4juntos();
        p.cargarEstructuras();
        p.totalVendidoAcumulado();
        p.totalVendido();
        p.buscarMayorUniVendidas();
        p.buscarMenorUniVendidas();
        p.VentaUnidadesXmes();
        p.mayorVentaUnidadesXmes();
        p.ordenarMayorMenor();
    }
}
