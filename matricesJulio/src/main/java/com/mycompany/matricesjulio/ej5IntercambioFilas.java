/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matricesjulio;

import java.util.Scanner;

/**
 * Ejercicio 5:
 * Crear una matriz de n * m filas (cargar n y m por teclado)
 * Intercambiar la primer fila con la segundo. Imprimir luego la matriz.
 */
public class ej5IntercambioFilas {
    private Scanner teclado = new Scanner(System.in);
    private float[][] matriz;
    
    public int traerInt(String mjs){
        int entero;
        System.out.print(mjs);
        entero = teclado.nextInt();
        return entero;
    }
    
    public void definirMatriz(){
        int fila = traerInt("Ingresar cantidad de filas: ");
        int columna = traerInt("Ingresar cantidad de columnas: ");
        matriz = new float[fila][columna];
        cargarMatriz(fila,columna);
    }
    
    public void cargarMatriz(int fil, int col){
        for(int x = 0 ; x < fil ; x = x + 1){
            for(int y = 0 ; y < col ; y = y + 1){
                matriz[x][y] = traerInt("Ingresar valor numerico float para la posicion fila " + x + " y columna " + y + ": ");
            }
            System.out.println();
        }
        System.out.println();
        imprimirMatriz(fil,col);
        intercambio(fil,col);
    }
    
    public void imprimirMatriz(int f, int c){
        for(int x = 0 ; x < f ; x = x + 1){
            for(int y = 0 ; y < c ; y = y + 1){
                System.out.print(matriz[x][y] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void intercambio(int f, int c){
        float aux0;
        float aux1;
        for(int y = 0 ; y < c ; y = y + 1){
            aux0 = matriz[0][y];
            aux1 = matriz[1][y];
            
            matriz[0][y] = matriz[1][y];
            matriz[1][y] = matriz[0][y];
            
            matriz[0][y] = aux1;
            matriz[1][y] = aux0;
        }
        imprimirMatriz(f,c);
    }
    
    public static void main(String[] args) {
        System.out.println("Ejericio 5: ");
        System.out.println("Crear una matriz de n * m filas (cargar n y m por teclado)");
        System.out.println("Intercambiar la primer fila con la segundo. Imprimir luego la matriz.");
        System.out.println("Resolución: ");
        ej5IntercambioFilas lol = new ej5IntercambioFilas();
        lol.definirMatriz();
    }
}
