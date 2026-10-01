/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 
 * 9. **★** Cargar una matriz de N x M y mostrar:
   - la suma de todos sus elementos,
   - el promedio.
   * 
 */
public class practica1mat {
    private int[][] matriz;
    
    public void definirMatriz(){
        int filas = Utilidades.traerInt("Ingrese la cantidad de filas que tendra su matriz: ");
        int columnas = Utilidades.traerInt("ingrese la cantidad de columnas que tendra su matriz: ");
        matriz = new int[filas][columnas];
        llenarMatriz(filas,columnas);
    }
    
    public void llenarMatriz(int fil, int col){
        System.out.println();
        for(int x = 0 ; x < fil ; x = x + 1){
            for(int y = 0 ; y < col ; y = y + 1){
                matriz[x][y] = Utilidades.traerInt("Ingresa un numerico entero para la pocicion fila " + x + " columna " + y + ": ");
            }
        }
        sumarElementos(fil,col);
    }
    
    public void sumarElementos(int fi, int co){
        int suma = 0;
        int cantElementos = 0;
        for(int x = 0 ; x < fi ; x = x + 1){
            for(int y = 0 ; y < co ; y = y + 1){
                suma = suma + matriz[x][y];
                cantElementos = cantElementos + 1;
            }
        }
        System.out.println("El resultado de la suma de todos sus elementos es: " + suma);
        System.out.println("El promedio de la matriz es de: " + sacarProm(suma, cantElementos));
    }
    
    public float sacarProm(int suma, int cantElementos){
        float promedio = (float) suma / cantElementos;
        return promedio;
    }
}
