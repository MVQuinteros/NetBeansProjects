/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 *  **★** Cargar una matriz de N x M y mostrar la **suma de cada fila** y la **suma de cada columna**.
 */
public class practica2mat {
    private float[][] matrizSumas;
    
    public void tamañoMatriz(){
        int filas = Utilidades.traerInt("Ingresar la cantidad de filas: ");
        int columnas = Utilidades.traerInt("Ingresar la cantidad de columnas: ");
        matrizSumas = new float[filas][columnas];
    }
    
    public void cargarMatriz(){
        for(int x = 0 ; x < matrizSumas.length ; x = x + 1){
            for(int y = 0 ; y < matrizSumas[0].length ; y = y + 1){
                matrizSumas[x][y] = Utilidades.traerFloat("Ingresar el valor en la posicion fila " + x + " y columna "+ y + ": ");
            }
        }
    }
    
    public void sumarFila(){
        float sumaFila;
        for(int x = 0 ; x < matrizSumas.length ; x = x + 1){
            sumaFila = 0;
            for(int y = 0 ; y < matrizSumas[0].length ; y = y + 1){
                sumaFila = sumaFila + matrizSumas[x][y];
            }
            System.out.println("La suma de todos los valores de la fila "+ x + " es de: "+ sumaFila);
        }
    }
    
    public void sumarColumna(){
        float sumaColumna;
        for(int y = 0 ; y < matrizSumas[0].length ; y = y + 1){
            sumaColumna = 0;
            for(int x = 0 ; x < matrizSumas.length ; x = x + 1 ){
                sumaColumna = sumaColumna + matrizSumas[x][y];
            }
            System.out.println("La suma de cada columna " + y + " es de: " + sumaColumna);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("xd re lol test logica redonda");
        practica2mat prac2mat = new practica2mat();
        prac2mat.tamañoMatriz();
        prac2mat.cargarMatriz();
        prac2mat.sumarColumna();
        prac2mat.sumarFila();
    }
}
