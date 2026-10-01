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
public class ej2MostrarDiagonalMatriz {
    private final static Scanner teclado = new Scanner(System.in);
    private final String[][] matrizString = new String[4][4];
    
    public void cargarMatrizString(){
        for(int x = 0 ; x < 4 ; x = x + 1){
            for(int y = 0 ; y < 4 ; y = y + 1){
                System.out.print("Ingrese el String que quiera cargar en la fila " + x + " y en la columna " + y + ": ");
                matrizString[x][y]= teclado.nextLine();
            }
        }
    }
    
    public void mostrarDiagonal(){
        for(int x = 0 ; x < 4 ; x = x + 1){
            System.out.print(matrizString[x][x] + " - ");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("portobello!");
        ej2MostrarDiagonalMatriz ej2DiagonalMatrizString = new ej2MostrarDiagonalMatriz();
        ej2DiagonalMatrizString.cargarMatrizString();
        ej2DiagonalMatrizString.mostrarDiagonal(); 
    }           
}
