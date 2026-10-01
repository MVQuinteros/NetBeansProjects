/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 11. **★** Cargar una matriz cuadrada (N x N) y mostrar únicamente la **diagonal principal** y la **diagonal secundaria**.
 */
public class practica3mat {
    private String[][] matrizString;
    
    public void definir(){
        int cubo = Utilidades.traerInt("Ingrese el tamaño de la matriz: ");
        matrizString = new String[cubo][cubo];
    }
    
    public void cargarMatrizString(){
        for(int x = 0 ; x < matrizString.length ; x = x + 1){
            for(int y = 0 ; y < matrizString[0].length ; y = y + 1){
                matrizString[x][y] = Utilidades.traerString("Ingrese la palabra que quiera poner en la fila " + x + " y en la columna " + y ); 
            }
        }
    }
    
    public void buscarDiagonalPrincipal(){
        for(int x = 0 ; x < matrizString.length ; x = x + 1){
            System.out.print(matrizString[x][x] + " - ");
        }
    }
    
    public void buscarDiagonalSecundaria(){
        for(int x = 0 ; x < matrizString.length ; x = x + 1){
            System.out.print(matrizString[x][matrizString.length - 1 - x] + " - ");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica3mat prac3mat = new practica3mat();
        prac3mat.definir();
        prac3mat.cargarMatrizString();
        prac3mat.buscarDiagonalPrincipal();
        prac3mat.buscarDiagonalSecundaria();
    }
}
