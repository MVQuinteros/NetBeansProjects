/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 
 * 2. **★** Cargar N números. Mostrar el **mayor** y el **menor**, y en qué posición está cada uno.
 */
public class practica2Vec {
    private float[] vectorFloat;
    
    public void definirVec(){
        int cant = Utilidades.traerInt("Ingrese la cantidad de elementos que va a tener el vector: ");
        vectorFloat = new float[cant];
    }
    
    public void cargarNum(){
        for(int x = 0 ; x < vectorFloat.length ; x = x + 1){
            vectorFloat[x] = Utilidades.traerFloat("Ingresa un numero en la posicion " + (x+1) + " del vector:");
        }
    }
    
    public String encontrarMayor(){
        float elementoMayor = vectorFloat[0];
        int posicion = 0;
        for(int x = 0 ; x < vectorFloat.length ; x = x + 1){
            if(vectorFloat[x] > elementoMayor){
                elementoMayor = vectorFloat[x];
                posicion = x;
            }
        }
        return elementoMayor + " que esta en la posicion " + (posicion + 1);
    }
    
    public String encontrarMenor(){
        float elementoMenor = vectorFloat[0];
        int posicion = 0; 
        for(int x = 0 ; x < vectorFloat.length ; x = x + 1){
            if(vectorFloat[x] < elementoMenor){
                elementoMenor = vectorFloat[x];
                posicion = x; 
            }
        }
        return elementoMenor + " que esta en la posicion " + (posicion + 1); 
    }
    
    public void informar(){
        System.out.println("Elemento mayor de todo el vector: ");
        System.out.println(encontrarMayor());
        System.out.println("Elemento menor de todo el vector: ");
        System.out.print(encontrarMenor());
    }
}
