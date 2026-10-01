/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.modelo;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * Confeccionar un programa que permita la carga de los nombres de 5 alumnos y sus notas.
0 * luego ordenAR las notas de mayor a menor. imprimir las notas y los nombres de los alumnos.
 */
public class ej3OrdenamientoVectoresParalelos {
    private static final Scanner teclado = new Scanner(System.in);
    private final int cantidad = 5;
    private final int[] notas = new int[cantidad];
    private final String[] nombres = new String[cantidad];
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine();
        int entero = Integer.parseInt(ingreso);
        return entero;
    }
    
    public String traerString(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine();
        return ingreso;
    }
    
    public void cargarAlumnosNotas(){
        System.out.println("Carga de Alumnos y notas");
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.print(" ");
            System.out.println("Posicion " + x + "------------------------------------");
            nombres[x] = traerString("Ingrese el nombre del estudiante: ");
            notas[x] = traerInt("Ingrese la nota de " + nombres[x] + " : ");
        }
        imprimirVectores("Vectores recien cargados: ");
        ordenarMenorMayor();
    }
    
    public void ordenarMenorMayor(){
        int auxNotas;
        String auxNombres;
        for(int x = 0; x < (cantidad-1) ; x = x + 1){
            for(int y = 0; y < (cantidad-1); y = y + 1){
                if(notas[y] > notas[y+1]){
                    
                    auxNotas = notas[y];
                    auxNombres = nombres[y];
                    
                    nombres[y] = nombres[y+1];
                    notas[y]= notas[y+1];
                    
                    nombres[y+1] = auxNombres;
                    notas[y+1] = auxNotas;
                }
            }     
        }
        imprimirVectores("Vectores Ordenados: ");
    }
    
    public void imprimirVectores(String mjs){
        System.out.println(mjs);
        for(int x = 0; x < cantidad ; x = x + 1){
            System.out.println(nombres[x] + " : " + notas [x]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Sistema de notas y alumnado!!");
        ej3OrdenamientoVectoresParalelos ej3 = new ej3OrdenamientoVectoresParalelos();
        ej3.cargarAlumnosNotas();
    }
}
