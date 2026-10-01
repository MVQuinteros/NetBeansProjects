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
public class ejOrdenamientoVectoresAlfabeticamente {
    private static final Scanner teclado = new Scanner(System.in);
    
    private static int cantidad = 5;
    private float[] habitantes = new float[cantidad];
    private String[] paises = new String[cantidad];
    
    public float traerFloat(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine().replace(",", ".");
        float flo = Float.parseFloat(ingreso);
        return flo;
    }
    
    public String traerString(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine();
        return ingreso;
    }
    
    public void cargarPaisesHabitantes(){
        System.out.print("Carga de Paises y Habitantes ");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.println(" ");
            System.out.println("posicion " + (x+1) + "-------------------------------------");
            paises[x] = traerString("Ingrese el nombre del pais: ");
            habitantes[x] = traerFloat("Ingrese la cantidad de habitantes de " + paises[x] + " : ");
        }
        imprimirVector("Vector recien cargado: ");
        //ordenarHabitantes();
    }
    
    public void ordenarPaisesAlfabeticamente(){
        String auxPaises;
        float auxHabitantes;
        for(int x = 0; x < cantidad ; x = x + 1){
            for(int y = 0; y < cantidad ; y = y + 1){
                if(paises[y].compareTo(paises[y+1]) > 0){
                // si da negativo se queda, si da 0 es igual, si da positivo va despues
                    auxPaises = paises[y];
                    paises[y] = paises[y+1];
                    paises[y+1] = auxPaises;
                    
                    auxHabitantes = habitantes[y];
                    habitantes[y] = habitantes[y+1];
                    habitantes[y+1] = auxHabitantes; 
                } 
            }
        }
        imprimirVector("Vector ordenado alfabeticamente: ");
    }
    
    public void ordenarHabitantesMenorMayor(){
        float auxHabitantes;
        String auxPaises;
        for(int x = 0 ; x < (cantidad-1) ; x = x + 1){
            for(int y = 0 ; y < (cantidad-1) ; y = y + 1){
                if(habitantes[y] < habitantes[y+1]){
                    auxHabitantes = habitantes[y];
                    habitantes[y] = habitantes[y+1];
                    habitantes[y+1] = auxHabitantes;
                    
                    auxPaises = paises[y];
                    paises[y] = paises[y+1];
                    paises[y+1] = auxPaises;
                }
            }
        }
        imprimirVector("Vector ordenado por habitantes: ");
    }
    
    public void imprimirVector(String mjs){
        System.out.print(" ");
        System.out.println(mjs);
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.println(paises[x] + " = " + habitantes[x]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Carga Paises y Habitantes!!");
        ejOrdenamientoVectoresAlfabeticamente ej4 = new ejOrdenamientoVectoresAlfabeticamente();
        ej4.cargarPaisesHabitantes();
    }
}
