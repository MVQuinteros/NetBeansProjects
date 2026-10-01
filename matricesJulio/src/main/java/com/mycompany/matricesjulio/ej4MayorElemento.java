package com.mycompany.matricesjulio;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Crear una matriz de n * m filas (cargar n y m por teclado)
 * Imprimir el mayor elemento y la fila y columna donde se almacena
 * 
 */

public class ej4MayorElemento {
    private final Scanner teclado = new Scanner(System.in);
    private int[][] matriz;
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        int entero = teclado.nextInt();
        return entero;
    }
    
    public void definirMatriz(){
        int fila = traerInt("Ingrese la cantidad de filas de la matriz: ");
        int columna = traerInt("Ingrese la cantidad de columnas de la matriz: ");
        matriz=new int[fila][columna];
        cargarMatriz(fila,columna);
    }
    
    public void cargarMatriz(int f, int c){
        for(int x = 0 ; x < f ; x = x + 1){
            for(int y = 0 ; y < c ; y = y + 1){
                matriz[x][y] = traerInt("Ingrese el valor numerico entero de la posicion fila " + x + " y columna " + y + ": ");
            }
        }
        System.out.println();
        buscarMayor(f, c);
    }
    
    public void buscarMayor(int fil, int col){
        int mayor = matriz[0][0];
        int filaMayor = 0;
        int columnaMayor = 0;
        for(int x = 0 ; x < fil ; x = x + 1){
            for(int y = 0 ; y < col ; y = y + 1){
                if(matriz[x][y] > mayor){
                    mayor = matriz[x][y];
                    filaMayor = x;
                    columnaMayor = y;
                }
            }
        }
        informar(mayor, filaMayor, columnaMayor);
    }
    
    public void informar(int m, int f, int c){
        System.out.println("El mayor elemento ingresado es: " + m);
        System.out.println("Y se encuentra en la posición fila " + f + " y la columna " + c);
    }
    
    public static void main(String[] args) {
        System.out.println("Ejericio 4: ");
        System.out.println("Crear una matriz de n * m filas (cargar n y m por teclado)");
        System.out.println("Imprimir el mayor elemento y la fila y columna donde se almacena");
        System.out.println("Resolución: ");
        ej4MayorElemento xd = new ej4MayorElemento();
        xd.definirMatriz();
    }
}
