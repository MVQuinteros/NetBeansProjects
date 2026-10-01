/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Matrices {
    private final Scanner teclado = new Scanner (System.in); 
    private int[][] matrizVariable;
    
    public void cargarMatriz(int fil, int col){
        for(int x = 0 ; x < fil ; x = x + 1){
            for(int y = 0 ; y < col ; y = y + 1){
                System.out.print("Carga de numero en fila " + x + " y columna " + y + ": ");
                matrizVariable[x][y] = teclado.nextInt();
            }
            System.out.println();
        }
    }
    
    public void definirMatriz(){
        System.out.print("Cuantas filas tendra tu matriz? Ingresa: ");
        int filas = teclado.nextInt();
        System.out.println("Cuantas columnas tendra tu matriz? Ingresa: ");
        int columnas = teclado.nextInt();
        matrizVariable = new int [filas][columnas];
        cargarMatriz(filas, columnas);
        mostrarMatriz(filas, columnas);
    }    
    
    public void mostrarMatriz(int fil, int col){
        for(int x = 0 ; x < fil ; x = x + 1){
            for(int y = 0 ; y < col ; y = y + 1){
                System.out.print(matrizVariable[x][y] + " | ");
            }
            System.out.println();
        }
    }
    
    public void mostrarDiagonal(){
        for(int x = 0 ; x < 4 ; x = x + 1){
            System.out.print(matrizVariable[x][x] + " - ");
        }
    }
    
}
