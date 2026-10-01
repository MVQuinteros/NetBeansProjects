/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 15. Cargar una matriz de N x M y **intercambiar la primera columna con la última**
 * (o la fila 0 con la fila N-1).
 */
public class practica7mat {
    private final String[][] mat = new String[4][4];
    
    public void cargaMatFija(){
        for(int x = 0 ; x < mat.length ; x = x + 1){
            for(int y = 0 ; y < mat[0].length ; y = y + 1){
                mat[x][y]= Utilidades.traerString("Ingresar valor de fila "+ x +" y columna "+ y +": ");
            }
        }
    }
    
    public void imprimirMat(){
        System.out.println();
        for(int x = 0 ; x < mat.length ; x = x + 1){
            for (int y = 0 ; y < mat[0].length ; y = y + 1){
                System.out.print(" | " + mat[x][y] + " | ");
            }
            System.out.println();
        }
    }
    
    public void cambioFila(){
        System.out.println("Cambiamos la primer fila con la ultima");
        String aux;
        for(int y = 0 ; y < mat[0].length ; y = y + 1){
            aux = mat[0][y];
            mat[0][y] = mat[mat.length-1][y];
            mat[mat.length-1][y] = aux; 
        }
        imprimirMat();
    }
    
    public void cambioColumnas(){
        System.out.println("Cambiamos la primer columna con la ultima");
        String aux;
        for(int x = 0 ; x < mat.length ; x = x + 1){
            aux = mat[x][0];
            mat[x][0] = mat[x][mat[0].length-1];
            mat[x][mat[0].length-1] = aux;
        }
        imprimirMat();
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica7mat prac7mat = new practica7mat();
        prac7mat.cargaMatFija();
        prac7mat.imprimirMat();
        prac7mat.cambioFila();
        prac7mat.cambioColumnas();
    }
}
