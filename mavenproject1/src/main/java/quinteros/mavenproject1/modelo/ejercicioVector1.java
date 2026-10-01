/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.modelo;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ejercicioVector1 {
    private static final Scanner teclado = new Scanner(System.in);
    private float[] numeros;
    
    public int delimitarVector(){
        System.out.print("Ingrese cuantos numeros quiere cargar: ");
        int num = teclado.nextInt();
        teclado.nextLine();
        return num;
    }
    
    public void cargarVector(){
        int cant = delimitarVector();
        numeros = new float[cant]; // nueva linea agregada con ayuda de alex. 
        //me habia faltado crear el vector xdxd re lol
        for(int x = 0; x < cant; x = x + 1){
            System.out.print("Ingrese elemento " + x + " : " );
            numeros[x] = teclado.nextFloat();
        }
        DetectarMenorYRepetidos(cant);
    }
    
    public void DetectarMenorYRepetidos(int cantidad){ // aca habia flahseado float, es un entero este
        // igual la logica estama mal.
        /*for(int x = 0; x < cantidad; x = x + 1){
            //if (numeros[x]<numeros[x+1]){
            // no comparar con x+1. porque cuando x llega al último elemento, x+1 se sale del vector.
            if (numeros[x]<numeros[x]){
                numMenor = numeros[x];
            }
            if(numeros[x] == numeros[x+1]){
                System.out.print("Se repitio el numero: " + numeros[x]);
                repetidos = x+1;
            }
        }*/
        
        // SUPONEMOS que el primero es el menor
        float numMenor = numeros[0];
        // CONTAR REPETICIONES DEL MENOR
        int repetidos = 1;

        // BUSCAR MENOR
        for (int x = 1; x < cantidad; x++) {

            if (numeros[x] < numMenor) {

                numMenor = numeros[x];
                repetidos = 1;
                
            } else{
                if (numeros[x] == numMenor) {
                    repetidos++;
                }
            }
        }
        informar(numMenor, repetidos);
    }
    
    public void informar(float men, int repe){
        // cambiar un poco la logica 
        
        System.out.println("El numero mas chico de los ingresados es: " + men);
        
        // System.out.print("Hay en total" + repetidos + " numeros repetidos");
        
        if(repe > 1){
            System.out.println("Se repite " + repe + " veces");
        }else{
            System.out.println("No se repite");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("XD");
        ejercicioVector1 vec = new ejercicioVector1();
        vec.cargarVector();
    }
}
