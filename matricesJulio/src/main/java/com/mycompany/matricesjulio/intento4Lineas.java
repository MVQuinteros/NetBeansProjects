/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matricesjulio;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class intento4Lineas {
    private Scanner teclado = new Scanner(System.in); 
    private String[][] tablero = new String[6][6]; 
    
    public String traerString(String mjs){
        System.out.print(mjs);
        String res = teclado.nextLine();
        return res;
    }
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        int res = teclado.nextInt();
        return res;
    }
    
    public void cargarMatriz(){
        for(int x = 0; x < 8 ; x = x + 1){
            for(int y = 0 ; y < 6 ; y = y + 1){
                tablero[x][y] = " - ";
            }
        }
    }
    
    public void imprimirMatriz(){
        System.out.println(" 1  -  2  -  3  -  4  -  5  -  6  -  7  -  8  ");
        for(int x = 0 ; x < 6 ; x = x + 1){
            for(int y = 0 ; y < 6 ; y = y + 1){
                System.out.print(tablero[x][y] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void jugador1(){
        int columnaSeleccionada = traerInt("Ingrese la columna donde quiere tirar su ficha (0-6): ");
        tirarFicha(columnaSeleccionada);
    }
    
    public void tirarFicha(int cs){
        for(int x = 0 ; x < 6 ; x = x + 1){
            if(" - ".equals(tablero[x][cs])){
                
            }
        }
        
    }
    
    public void juego(){
        cargarMatriz();
        imprimirMatriz();
    }
         
    public static void main(String[] args) {
        System.out.println("Ejericio tp: ");
        System.out.println("au no hay consigna xdxd");
        System.out.println("Resolución: ");
        intento4Lineas intento = new intento4Lineas();
        intento.juego();
    }
}
