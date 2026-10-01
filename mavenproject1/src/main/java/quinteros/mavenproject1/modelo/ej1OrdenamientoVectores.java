/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.modelo;

import java.util.Scanner;

/**
 *
 * Se debe crear un vector donde almacenar 5 sueldos.
 * Ordenar el vector de sueldos de mayor a menor.
 * 
 * @author Usuario
 */
public class ej1OrdenamientoVectores {
    
    private static final Scanner teclado = new Scanner(System.in);
    private float[] sueldos;
    
    
    public int delimitarVector(){
        System.out.print("Ingrese cuantos numeros quiere cargar: ");
        int num = teclado.nextInt();
        teclado.nextLine();
        return num;
    }
    
    public void cargarSueldos(){
        int cant = delimitarVector();
        sueldos = new float[cant]; // nueva linea agregada con ayuda de alex.
        // ahi se crea el fucking vector
        for(int x = 0; x < cant; x = x + 1){
            System.out.print("Ingrese elemento " + (x+1) + " : " );
            sueldos[x] = teclado.nextFloat();
            teclado.nextLine();
        }
        verOrden(cant);
    }
    
    public void verOrden(int cantidad){ // ciclamos 4 veces ya que comparamos piso con piso.
        float aux;
        
        for(int y = 0; y < (cantidad-1); y = y + 1){
            for(int x = 0; x < (cantidad-1); x = x + 1){
                if(sueldos[x]< sueldos[x+1]){
                    aux = sueldos[x];
                    sueldos[x] = sueldos[x+1];
                    sueldos[x+1] = aux;
                } // si el de arriba es menor que el de abajo, se gira true
            }
        }
        informar(cantidad);
    }
    
    public void informar(int canti){
        System.out.print("El vector ordenado es: ");
        for(int x = 0; x < canti ; x = x + 1){
            System.out.println(" - " + sueldos[x]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Ordenamiento de Vectores (sueldos)!");
        ej1OrdenamientoVectores vec = new ej1OrdenamientoVectores();
        vec.cargarSueldos();
    }
}
