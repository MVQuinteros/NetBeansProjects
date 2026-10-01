/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 
 * 8. **★** Cargar N números enteros y mostrar si **está ordenado** de menor a mayor (sí/no). 
 * (Pista: si en algún momento `v[i] > v[i+1]`, no está ordenado.)
 */
public class practica8vec {
    private float[] vector;
    
    public void completarVector(){
        vector = new float[Utilidades.traerInt("Ingresa el tamaño del vector: ")];
        for(int x = 0 ; x < vector.length ; x = x + 1){
            vector[x] = Utilidades.traerFloat("Ingresa los numeros que desea: ");
        }
    }
    
    public void vectorOrdenado(){
        boolean ordenado = true;
        for(int x = 0 ; x < (vector.length-1) ; x = x + 1){
            if(vector[x] < vector[x + 1]){
                ordenado = false;
            }
        }
        informar(ordenado);
    }
    
    public void informar(boolean or){
        System.out. println();
        if(or == true){
            System.out.println("El vector esta ordenado");
        }else{
            System.out.println("El vector no esta ordenado");
        }
    }
}
