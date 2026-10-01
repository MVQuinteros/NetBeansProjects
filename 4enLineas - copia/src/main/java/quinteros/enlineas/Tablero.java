/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.enlineas;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Tablero {
    private final Scanner teclado = new Scanner(System.in);
    private String[][] tablero;
    
    public void definirDificultad(){
        System.out.println("Elige la dificultad del juego: ");
        System.out.println("1. Fácil - (6x6)");
        System.out.println("2. Medio - (8x8)");
        System.out.println("3. Difícil - (10x10)");
        System.out.print("Ingresa una opción: ");
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1 -> definirMatriz(6, 6);
            case 2 -> definirMatriz(8, 8);
            case 3 -> definirMatriz(10, 10);
            default -> {
                System.out.println("Opción inválida.");
            }
        }
    }
    
    public void definirMatriz(int filas, int columnas){
        tablero = new String [filas][columnas];
        cargarTablero(filas, columnas);
    }
    
    public void cargarTablero(int fil, int colum){
        for(int x = 0; x < fil ; x = x + 1){
            for(int y = 0 ; y < colum ; y = y + 1){
                tablero[x][y] = " - ";
            }
        }
    }
    
    public void imprimirTablero(){
        for(int x = 0 ; x < tablero.length ; x = x + 1){
            System.out.print(" " + x + " " + " | ");
        }
        System.out.println();
        for(int x = 0 ; x < tablero.length ; x = x + 1){
            System.out.print("------");
        }
        System.out.println();
        for(int x = 0 ; x < tablero.length ; x = x + 1){
            for(int y = 0 ; y < tablero.length ; y = y + 1){
                System.out.print(tablero[x][y] + " | ");
            }
            System.out.println();
        }
    }
}
