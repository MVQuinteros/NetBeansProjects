/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.practicas;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class practica2 {
    private static final Scanner teclado = new Scanner(System.in);
    
    private int cantidad = 3;
    
    private int[] vectorEntero1 = new int[cantidad];
    private int[] vectorEntero2 = new int[cantidad];
    
    private float[] vectorFloat1 = new float[cantidad];
    private float[] vectorFloat2 = new float[cantidad];
    
    private int vectorResultadosEnteros[] = new int[cantidad];
    private float vectorResultadosFloat[] = new float[cantidad];
    
    private String[]vectorString1 = new String[cantidad];
    private String[]vectorString2 = new String[cantidad];
    
    public float traerFloat(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine().replace(",",".");
        float flo = Float.parseFloat(ingreso);
        return flo;
    }
    public int traerInt(String mjs){
        System.out.print(mjs);
        int entero = Integer.parseInt(teclado.nextLine());
        return entero;
    }
    public String traerString(String mjs){
        System.out.print(mjs);
        return teclado.nextLine();
    }
    
    public void cargarVectorInt(){
        System.out.println("Carga de vectores entero");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.println("Posicion " + x );
            vectorEntero1[x] = traerInt("Ingrese el numero que quiere cargar en el vector 1: ");
            vectorEntero2[x] = traerInt("Ingrese el numero que quiere cargar en el vector 2: ");
        }
    }
    public void cargarVectorFloat(){
        System.out.println("Carga de vectores float");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.println("Posicion " + x );
            vectorFloat1[x] = traerFloat("Ingrese el nuemro que quiere cargar en el vector 1: ");
            vectorFloat2[x]= traerFloat("Ingrese el nuemro que quiere cargar en el vector 2: ");
        }
    }
    public void cargarVectorString(){
        System.out.println("Carga de vectores string");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.println("Posicion " + x );
            vectorString1[x] = traerString("Ingrese el String numero que quiera cargar en el vector 1: ");
            vectorString2[x] = traerString("Ingrese el String numero que quiera cargar en el vector 2: ");
        }
    }
    
    public void sumarVectores(){
        int sumaEntera = 0;
        float sumaFloat = 0;
        for(int x = 0; x < cantidad ; x = x + 1){
            sumaEntera = sumaEntera + vectorEntero1[x] + vectorEntero2[x];
            sumaFloat = sumaFloat + vectorFloat1[x] + vectorFloat2[x];
        }
        System.out.println("La suma de todos los numeros ingresados en los vectores enteros es de: " + sumaEntera);
        System.out.println("La suma de todos los numeros ingresados en los vectores float es de: " + sumaFloat);
    }
    
    public void sumarGuardarVector(){
        
     // for(int x = 0; x < vectorEntero1.length ; x = x + 1){ Usar .lenght de hecho es re buena tecnica 
     // por si cambia el vector de valor en el futuro. implementar!!
     
        for(int x = 0; x < cantidad ; x = x + 1){
            vectorResultadosEnteros[x] = vectorEntero1[x] + vectorEntero2[x];
            vectorResultadosFloat[x] = vectorFloat1[x] + vectorFloat2[x];
        }
        imprimirVectorResultados();
    }
    
    public void imprimirVectorResultados(){
        System.out.println("Vectores Resultados 1 entero");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.println(" # " + vectorResultadosEnteros[x]);
        }
        System.out.println("Vector resultado 2 float");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.println(" # " + vectorResultadosFloat[x]);
        }
    }
    
    // funcion que ni vimos pero qsy pinto ver con alex ah:
    public void invertirVectorString(){

        int i = 0;
        int j = cantidad - 1;

        while(i < j){

            String aux1 = vectorString1[i];
            vectorString1[i] = vectorString1[j];
            vectorString1[j] = aux1;
            
            String aux2 = vectorString2[i];
            vectorString2[i] = vectorString2[j];
            vectorString2[j] = aux2;

            i = i + 1;
            j = j - 1;
        }
        
        imprimirInvertidos();
    }
    
    public void imprimirInvertidos(){
        System.out.println("Vectores Invertido 1 ");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.print(" # " + vectorString1[x]);
        }
        System.out.println("Vectores Invertido 1 ");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.print(" # " + vectorString2[x]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        practica2 prac = new practica2(); 
        prac.cargarVectorInt();
        prac.cargarVectorFloat();
        prac.cargarVectorString();
        prac.sumarVectores();
        prac.sumarGuardarVector();
        prac.invertirVectorString();
    }
}
