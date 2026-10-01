/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 18. **★** Cargar una matriz de N x M y mostrar el **mayor de cada fila** (un número por cada fila).
 */
public class practica10mat {
    private final float[][] mat = new float[4][4];
    
    public void cargar(){
        for(int x = 0 ; x < mat.length ; x = x + 1){
            for(int y = 0 ; y < mat[0].length ; y = y + 1){
                mat[x][y] = Utilidades.traerFloat("Ingresar valor para fila " + x + " columna " + y + ": ");
            }
        }
    }
    
    public void buscarMayor(){
        float mayor = mat[0][0];
        for(int x = 0 ; x < mat.length ; x = x + 1){
            for(int y = 0 ; y < mat[0].length ; y = y + 1){
                if(mat[x][y] > mayor){
                    mayor = mat[x][y];
                }
            }
            System.out.println("El mayor de la fila "+ x + " es: "+ mayor);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica10mat prac10mat = new practica10mat();
        prac10mat.cargar();
        prac10mat.buscarMayor();
    }
}
