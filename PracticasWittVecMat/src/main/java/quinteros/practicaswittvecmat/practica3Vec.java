/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 
 * 3. Cargar N números y mostrar **cuántas veces se repite** el primer elemento.
 */
public class practica3Vec {
    private float[] vec;
    
    public void definicion(){
        vec = new float[Utilidades.traerInt("Ingrese el largo del vector: ")];
    }
    
    public void carga(){
        for(int x = 0 ; x < vec.length ; x = x + 1){
            vec[x] = Utilidades.traerFloat("Ingrese el valor numerico de la posicion " + (x+1) + " del vector: ");
        }
    }
    
    public void repeticiones(){
        float primerValor = vec[0];
        int repetidos = 0;
        // for(int x = 0 ; x < vec.length ; x = x + 1){ empezar desde el 1, sino explota todo
        //     if(primerValor == vec[x+1]){ por esta linea en especifico explotaba, con length no usas -1. 
        for(int x = 1 ; x < vec.length ; x = x + 1){
            if(primerValor == vec[x]){
                repetidos = repetidos + 1;
            }
        }
        if(repetidos == 0){
            System.out.print("No hay repeticiones en el vector del numero " + primerValor);
        }else{
            System.out.print("El primer valor se repite " + repetidos + " en todo el vector");
        }
    }
    
}
