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
    private final Scanner teclado;
    private String[][] tablero;
    
    public Tablero(Scanner teclado){
        this.teclado = teclado;
    }
    
    public void definirDificultad(){
        boolean dificultadElegida = false;
        while(dificultadElegida == false){
            System.out.println("Elige la dificultad del juego: ");
            System.out.println("1. Facil - (6x6)");
            System.out.println("2. Medio - (8x8)");
            System.out.println("3. Dificil - (10x10)");
            System.out.print("Ingresa una opcion: ");
            int opcion;
            if(teclado.hasNextInt()){
                opcion = teclado.nextInt();
            } else {
                System.out.println("Eso no es un numero. Escribí 1, 2 o 3.");
                teclado.next();
                continue;
            }
            switch (opcion) {
                case 1 -> {
                    definirMatriz(6, 6);
                    dificultadElegida = true;
                }
                case 2 -> {
                    definirMatriz(8, 8);
                    dificultadElegida = true;
                }
                case 3 -> {
                    definirMatriz(10, 10);
                    dificultadElegida = true;
                }
                default -> {
                    System.out.println("Opcion invalida. Elegi 1, 2 o 3.");
                }
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
    
    public int getFilas(){
        return tablero.length;
    }
    
    public int getColumnas(){
        return tablero[0].length;
    }
    
    public boolean colocarFicha(int columna, String simbolo){
        if(columna < 0 || columna >= getColumnas()){
            return false;
        }
        for(int x = getFilas() - 1; x >= 0; x = x - 1){
            if(tablero[x][columna].equals(" - ")){
                tablero[x][columna] = simbolo;
                return true;
            }
        }
        return false;
    }
    
    public boolean huboGanador(String simbolo){
        for(int x = 0; x < getFilas(); x = x + 1){
            for(int y = 0; y < getColumnas(); y = y + 1){
                if(tablero[x][y].equals(simbolo)){
                    if(contarEnDireccion(x, y, 0, 1, simbolo) >= 4){
                        return true;
                    }
                    if(contarEnDireccion(x, y, 1, 0, simbolo) >= 4){
                        return true;
                    }
                    if(contarEnDireccion(x, y, 1, 1, simbolo) >= 4){
                        return true;
                    }
                    if(contarEnDireccion(x, y, 1, -1, simbolo) >= 4){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean estaLleno(){
        for(int x = 0; x < getFilas(); x = x + 1){
            for(int y = 0; y < getColumnas(); y = y + 1){
                if(tablero[x][y].equals(" - ")){
                    return false;
                }
            }
        }
        return true;
    }
    
    private int contarEnDireccion(int x, int y, int pasoX, int pasoY, String simbolo){
        int contador = 1;
        int nuevaX = x + pasoX;
        int nuevaY = y + pasoY;
        while(nuevaX >= 0 && nuevaX < getFilas() && nuevaY >= 0 && nuevaY < getColumnas()){
            if(tablero[nuevaX][nuevaY].equals(simbolo)){
                contador = contador + 1;
                nuevaX = nuevaX + pasoX;
                nuevaY = nuevaY + pasoY;
            } else {
                return contador;
            }
        }
        return contador;
    }
}
