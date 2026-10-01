package com.mycompany.matricesjulio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Crear una matriz de n * m filas (cargar n y m por teclado). Imprimir la matriz completa y la última fila.
 * 
 */

import java.util.Scanner;

public class ejClaseVirtual {
    private final Scanner teclado=new Scanner(System.in);
    private int[][] matriz;
    
    public int traerNumero(String mens) {
        int n;
        System.out.print(mens);
        n = teclado.nextInt();
        return n;
    }
    
    public void cargarMatriz(int fila, int columna) {
        matriz=new int[fila][columna];
        
        for (int x = 0; x < fila; x = x + 1) {
            for (int y = 0; y < columna; y = y + 1) {
                matriz[x][y] = traerNumero("Ingresar valor: ");
            }
        }
        System.out.println();
    }
    
    public void imprimirMatriz(int fila, int columna) {
        System.out.println("MATRIZ COMPLETA");
        for (int x = 0; x < fila; x = x + 1) {
            for (int y = 0; y < columna; y = y + 1) {
                System.out.print(matriz[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void imprimirUltimaFila(int fila, int columna) {
        System.out.println("ULTIMA FILA");
        
        for (int x = 0; x < columna; x = x + 1) {
            System.out.print(matriz[(fila-1)][x] + " ");
        }
    }
    
    public static void main(String[] args) {
        ejClaseVirtual mat = new ejClaseVirtual();
        int filas;
        int columnas;
        
        filas = mat.traerNumero("Ingresar cantidad de filas: ");
        columnas = mat.traerNumero("Ingresar la cantidad de columnas: ");
        
        mat.cargarMatriz(filas, columnas);
        mat.imprimirMatriz(filas, columnas);
        mat.imprimirUltimaFila(filas, columnas);
    }
}



