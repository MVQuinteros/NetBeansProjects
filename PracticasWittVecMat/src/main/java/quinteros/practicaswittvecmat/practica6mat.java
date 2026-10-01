/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 14. **★** Cargar una matriz de N x M y **contar cuántos ceros** tiene. 
 * Decir si es una "matriz cero" (todos ceros) o no.
 */
public class practica6mat {
    private int[][] mat;
    
    public void definirMat(){
        int fil = Utilidades.traerInt("Ingresar la cantidad de filas: ");
        int col = Utilidades.traerInt("Ingresar la cantidad de columnas: ");
        mat = new int[fil][col];
    }
    
    public void carga(){
        for(int x = 0 ; x < mat.length ; x = x + 1){
            for(int y = 0 ; y < mat[0].length ; y = y + 1){
                mat[x][y] = Utilidades.traerInt("Ingresar valor fila " + x + " columna " + y + ": ");
            }
        }
    }
    
    public int conteoCeros(){
        int cantCeros = 0;
        for(int x = 0 ; x < mat.length ; x = x + 1){
            for(int y = 0 ; y < mat[0].length ; y = y + 1){
                if(mat[x][y] == 0){
                    cantCeros = cantCeros + 1;
                }
            }
        }
        return cantCeros;
    }
    
    public void informar(){
        int cantElementos = mat.length * mat[0].length;
        int ceros = conteoCeros();
        if(0 == ceros){
            System.out.println("La matriz no contiene ceros.");
        }else{
            if(cantElementos == ceros){
                System.out.println("La matriz contiene en su totalidad 0.");
                System.out.println("La cantidad de 0 en la matriz es de: " + ceros);
            }else{
                System.out.println("La matriz no solo contiene ceros.");
                System.out.println("La cantidad de 0 en la matriz es de: " + ceros);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica6mat prac6mat = new practica6mat();
        prac6mat.definirMat();
        prac6mat.carga();
        prac6mat.informar();
    }
}
