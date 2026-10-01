/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.matrices;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ej1CargaMostrar {
    private static final Scanner teclado = new Scanner(System.in);
    private final int[][] matriz = new int[4][4];
    
    public void cargarMatriz(){
        for(int x = 0 ; x < 4 ; x = x + 1){
            for(int y = 0 ; y < 4 ; y = y + 1){
                System.out.print("Carga de numero en fila " + x + " y columna " + y + ": ");
                matriz[x][y] = teclado.nextInt();
            }
            System.out.println();
        }
    }
    
    public void mostrarMatriz(){
        for(int x = 0 ; x < 4 ; x = x + 1){
            for(int y = 0 ; y < 4 ; y = y + 1){
                System.out.print(" - " + matriz[x][y] + " - ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("xd!");
        Ej1CargaMostrar ej1 = new Ej1CargaMostrar();
        ej1.cargarMatriz();
        ej1.mostrarMatriz(); 
    }
}
