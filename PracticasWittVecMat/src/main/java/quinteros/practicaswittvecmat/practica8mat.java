/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 16. **★** Cargar una matriz de N x M y **transponerla**: 
 * mostrar la matriz donde las filas y columnas se invierten (el elemento `[i][j]` pasa a `[j][i]`).
 */
public class practica8mat {
    private final String[][] matFija = new String[3][5];
    private final String[][] matTranspuesta = new String[5][3];
    
    public void carga(){
        for(int x = 0 ; x < matFija.length ; x = x + 1){
            for( int y = 0 ; y < matFija[0].length ; y = y + 1){
                matFija[x][y]=Utilidades.traerString("Ingresar valor coodenada fila " + x + " columna " + y + ": ");
            }
        }
    }
    
    public void imprimirMat(){
        System.out.println("matriz fija se supone");
        for(int x = 0 ; x < matFija.length; x = x + 1){
            for(int y = 0 ; y < matFija[0].length ; y = y + 1){
                System.out.print(" - " + matFija[x][y]);
            }
            System.out.println();
        }
    }
    
    public void imprimirMatTranspuesta(){
        System.out.println("matriz cambiada se supone");
        for(int x = 0 ; x < matTranspuesta.length; x = x + 1){
            for(int y = 0 ; y < matTranspuesta[0].length ; y = y + 1){
                System.out.print(" - " + matTranspuesta[x][y]);
            }
            System.out.println();
        }
    }
    
    public void invertirFilasColumnas(){
        for(int x = 0 ; x < matFija.length ; x = x + 1){ // 5
            for(int y = 0 ; y < matFija[0].length ; y = y + 1){ //3
                matTranspuesta[y][x] = matFija[x][y];
            }
        }
        imprimirMatTranspuesta();
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica8mat prac8mat = new practica8mat();
        prac8mat.carga();
        prac8mat.imprimirMat();
        prac8mat.invertirFilasColumnas();
    }       
}
