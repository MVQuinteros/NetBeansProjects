/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 
 * 4. **★** Cargar N números y **invertirlo** (el primero pasa al final y así sucesivamente). 
 * Mostrar el vector invertido. (Pista: recorrer hasta la mitad e intercambiar `v[i]` con `v[cant-1-i]`.)
 */
public class practica4vec {
    private float[] v;
    
    public void ingreso(){
        for(int x = 0 ; x < v.length ; x = x + 1){
            v[x] = Utilidades.traerFloat("Ingresa float para esta posicion" + (x+1) + " del vector: ");
        }
        informar("El vector actual es: ");
    }
    
    public void longitudVector(){
        v = new float[Utilidades.traerInt("Ingresa el total de elementos que perteneceran al vector: ")];
    }
    
    public void invertir(){
        float aux;
        for(int x = 0 ; x < (v.length /2) ; x = x + 1){
            aux = v[x];
            v[x] = v[v.length-1-x];
            v[v.length-1-x] = aux;
        }
        informar("El vector invertido es: ");
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
        for(int x = 0 ; x < v.length ; x = x + 1){
            System.out.println(" - " + v[x]);
        }
    }
}
