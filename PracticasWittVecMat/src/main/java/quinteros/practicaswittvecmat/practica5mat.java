/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 13. **★** Cargar una matriz de N x M y detectar si es **simétrica** (que `m[i][j] == m[j][i]` para todos).
 * Es decir `matriz[i][j].equals(matriz[j][i])` si son strings, o `==` si son números.
 */
public class practica5mat {
    private int[][] matrizxd;
    
    public void delimitacionMatriz(){
        int fil = Utilidades.traerInt("Ingresar la cantidad de filas: ");
        int col = Utilidades.traerInt("Ingresa la cantidad de columnas: ");
        matrizxd = new int[fil][col];
    }
    
    public void cargaMatriz(){
        for(int x = 0 ; x < matrizxd.length ; x = x + 1){
            for(int y = 0 ; y < matrizxd[0].length ; y = y + 1){
                matrizxd[x][y] = Utilidades.traerInt("ingresar el valor de la fila " + x + " y columna " + y + ": ");
            }
        }
    }
    
    public void confirmarCuadrado(){
        if(matrizxd.length == matrizxd[0].length){
            System.out.println("La Matriz es cuadrada! ");
            informarSimetria();
        }else{
            System.out.println("No se puede analizar su simetria, matriz ingresada no es cuadrada.");
            System.out.print("Tiene " + matrizxd.length + " filas y tiene " + matrizxd[0].length + " columnas. ");
        }
    }
    
    public boolean confirmarSimetria(){
        boolean simetria = false;
        for(int x = 0 ; x < matrizxd.length ; x = x + 1){
            for(int y = 0 ; y < matrizxd[0].length ; y = y + 1){
                if(matrizxd[x][y] == matrizxd[y][x]){ // matriz[i][j].equals(matriz[j][i]) si son strings
                    simetria = true;
                }else{
                    simetria = false;
                    break;
                }
            }
        }
        return simetria;
    }
    
    public void informarSimetria(){
        boolean sim = confirmarSimetria();
        if(sim == true){
            System.out.println("La matriz es totalmente Simetrica. sus valores estan en espejo.");
        }else{
            System.out.println("La matriz no es Simetrica, basta con que un valor no coincida para saber que no es simetrica en su totalidad.");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica5mat prac5mat = new practica5mat();
        prac5mat.delimitacionMatriz();
        prac5mat.cargaMatriz();
        prac5mat.confirmarCuadrado();
    }
}
