/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.modelo;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * 
 * Cargar un vector de n elementos de tipo entero. 
 * Ordenar posteriormente de menor a mayor. 
 * Metodo imprimir vector desordenado y desordenado.
 * 
 */
public class ej2OrdenamientoVecVariable {
    
    private static final Scanner teclado = new Scanner(System.in);
    private int[] vectorVariable;
    
    public int traerCantidadEntera(String mjs){
        int num;
        System.out.print(mjs);
        num = teclado.nextInt();
        return num;
    }
    
    public void cargarVectorVariable(){
        int cantidad = traerCantidadEntera("Ingresar la longitud del Vector: ");
        vectorVariable = new int [cantidad]; // aprender bien esta linea!!
        
        for(int x = 0; x < cantidad; x = x + 1){
            int num = traerCantidadEntera("Ingrese el elemento numero " + (x+1) + ": ");
            vectorVariable[x] = num;
        }
        imprimirVectorVariable(cantidad, "El Vector Recien ingresado es: ");
        ordenarMenorMayor(cantidad);
        ordenarMayorMenor(cantidad);
    }
    
    public void ordenarMenorMayor(int cant){
        int aux;
        for(int x = 0; x < (cant-1); x = x + 1){
            for(int y = 0; y < (cant-1); y = y + 1){
                if(vectorVariable[y] > vectorVariable[y+1]){
                    aux = vectorVariable[y];
                    vectorVariable[y] = vectorVariable[y+1];
                    vectorVariable[y+1] = aux;
                }
            }
        }
        imprimirVectorVariable(cant, "El vector ordenado de menor a mayor es: ");
    }
    
    public void imprimirVectorVariable(int c, String mjs){
        System.out.println(mjs);
        for(int x = 0; x < c; x = x + 1){
            System.out.println(" - " + vectorVariable[x]);
        }
    }
    
    public void ordenarMayorMenor(int cant){
        int aux;
        for(int x = 0; x < (cant-1); x = x + 1){
            for(int y = 0; y < (cant-1); y = y + 1){
                if(vectorVariable[y] < vectorVariable[y+1]){
                    aux = vectorVariable[y];
                    vectorVariable[y] = vectorVariable[y+1];
                    vectorVariable[y+1] = aux;
                }
            }
        }
        imprimirVectorVariable(cant, "El vector ordenado de mayor a menor es: ");
    }
    
    public static void main(String[] args) {
        System.out.println("Ordenamiento de Vectores (sueldos)!");
        ej2OrdenamientoVecVariable vec = new ej2OrdenamientoVecVariable();
        vec.cargarVectorVariable();
    }
}
