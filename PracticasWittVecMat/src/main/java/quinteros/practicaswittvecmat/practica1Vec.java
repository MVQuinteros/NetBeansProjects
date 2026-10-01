/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;


/**
 *
 * @author Usuario
 * 1. **★** Cargar N números por teclado en un vector y mostrar:
   a) el vector completo, b) el promedio, c) cuántos son mayores al promedio.
 */
public class practica1Vec {
    private int[] vector;
    
    public void definirVector(){
        int x = Utilidades.traerInt("Ingrese la longitud del vector: ");
        vector = new int[x];
    }
    
    public void cargarVector(){
        System.out.println();
        for(int x = 0 ; x < vector.length ; x = x + 1){
            vector[x]= Utilidades.traerInt("Ingrese el numero entero que desea cargar en la posicion " + (x+1) + " del vector: ");
        }
    }
    
    public void mostrarVector(){
        System.out.println();
        System.out.println("a) Vector completo");
        for(int x = 0 ; x < vector.length ; x = x + 1){
            System.out.println(" - " + vector[x]);
        }
    }
    
    public void mostrarPromedio(){
        System.out.println();
        System.out.println("b) Promedio del vector");
        System.out.println(sacarPromedio());
    }
    
    public float sacarPromedio(){
        //int suma = 0;
        float suma = 0;
        float promedio;
        for(int x = 0 ; x < vector.length ; x = x + 1){
            suma = suma + vector[x];
        }
        promedio = suma / vector.length;
        return promedio;
    }
    
    public void mayorQuePromedio(){
        boolean hayMayores = false;
        System.out.println();
        System.out.println("c) Elementos del vector mayores que el promedio");
        for(int x = 0 ; x < vector.length ; x = x + 1){
            if(vector[x]>sacarPromedio()){
                System.out.print(" - " + vector[x]);
                hayMayores = true;
            }
        }
        if(hayMayores == false){
            System.out.print("No hay numeros mayores que el promedio.");
        }
        
    }
}
