/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 12. Cargar una matriz de N x M y mostrar los elementos de la **primera fila**, 
 * la **última fila**, la **primera columna** y la **última columna** (el "borde" de la matriz).
 */
public class practica4mat {
    private int[][] matriz;
    
    public void definirMatriz(){
        int fila = Utilidades.traerInt("Ingresar la cantidad de filas: ");
        int columna = Utilidades.traerInt("Ingresar la cantidad de columnas: ");
        matriz = new int[fila][columna];
    }
    
    public void cargar(){
        for(int x = 0 ; x < matriz.length ; x = x + 1){
            for(int y = 0 ; y < matriz[0].length ; y = y + 1){
                matriz[x][y] = Utilidades.traerInt("Ingresar un numero para la pocision fila " + x + " columna " + y + ": "); 
            }
        }
    }
    
    public void mostrarFilas(){
        System.out.println("Primer Fila:");
        for(int y = 0 ; y < matriz[0].length ; y = y + 1){
            System.out.println("- " + matriz[0][y]);
        }
        System.out.println("Ultima Fila:");
        for(int y = 0 ; y < matriz[0].length ; y = y + 1){
            System.out.println(" - " + matriz[matriz.length-1][y]);
        }
    }
    
    public void mostrarColumnas(){
        System.out.println("Primer Columna:");
        for(int x = 0 ; x < matriz.length ; x = x + 1){
            System.out.println(" - " + matriz[x][0]);
        }
        System.out.println("Ultima Columna:");
        for(int x = 0 ; x < matriz.length ; x = x + 1){
            System.out.println(" - " + matriz[x][matriz[0].length-1]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica4mat prac4mat = new practica4mat();
        prac4mat.definirMatriz();
        prac4mat.cargar();
        prac4mat.mostrarFilas();
        prac4mat.mostrarColumnas();
    }
}
