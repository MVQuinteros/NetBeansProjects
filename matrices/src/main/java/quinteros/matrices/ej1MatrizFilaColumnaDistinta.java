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
public class ej1MatrizFilaColumnaDistinta {
        private static final Scanner teclado = new Scanner(System.in);
    private final int[][] matrizDistinta = new int[3][5];
    
    public void cargarMatriz(){
        for(int x = 0 ; x < 3 ; x = x + 1){
            for(int y = 0 ; y < 5 ; y = y + 1){
                System.out.print("Carga de numero en fila " + x + " y columna " + y + ": ");
                matrizDistinta[x][y] = teclado.nextInt();
            }
            System.out.println();
        }
    }
    
    public void mostrarMatriz(){
        for(int x = 0 ; x < 3 ; x = x + 1){
            for(int y = 0 ; y < 5 ; y = y + 1){
                System.out.print(matrizDistinta[x][y] + " - ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("lol!");
        ej1MatrizFilaColumnaDistinta ej1MatrizDistinta = new ej1MatrizFilaColumnaDistinta();
        ej1MatrizDistinta.cargarMatriz();
        ej1MatrizDistinta.mostrarMatriz(); 
    }
}
