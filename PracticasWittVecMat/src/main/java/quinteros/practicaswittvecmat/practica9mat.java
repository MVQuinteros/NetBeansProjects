/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 *  Cargar una matriz de N x M y hallar el **producto** de todos los elementos del **último renglón**.
 */
public class practica9mat {
    private float[][] mat;
    
    public void delimitarMatriz(){
        int fil = Utilidades.traerInt("Ingresar ");
        int col = Utilidades.traerInt("Ingresar ");
        mat = new float[fil][col];
    }
    
    public void cargarMat(){
        for(int x = 0 ; x < mat.length ; x = x + 1){
            for(int y = 0 ; y < mat[0].length ; y = y + 1){
                mat[x][y]= Utilidades.traerFloat("ingresar valor coordenada fila " + x + " columna "+ y +": ");
            }
        }
    }
    
    public float multiplicarUltimaFila(){
        float producto = 1;
        for(int y = 0 ; y < mat[0].length-1 ; y = y + 1){
            producto = producto * mat[mat.length-1][y];
        }
        return producto;
    }
    
    public void informar(){
        float prod = multiplicarUltimaFila();
        System.out.print("El resultado de la suma de todos los elementos del ultimo renglo es de: " + prod);
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica9mat prac9mat = new practica9mat();
        prac9mat.delimitarMatriz();
        prac9mat.cargarMat();
        prac9mat.informar();
    }
}
