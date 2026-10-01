/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.modelo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ej5IntentoProblemaComplejoFutbol {
    
    private static final Scanner teclado = new Scanner(System.in);
    private final Random random = new Random();
    private int cant = 5;
    
    private final String[] equipos = {"Boca Juniors","River Plate" ,"Racing" 
            ,"San lorenzo" ,"Independiente" ,"Estudiantes", "Rosario Central" ,
            "Vélez Sarsfield" ,"Newell's Old Boys" ,"Chacarita"};
    
    private final String[] locales = new String[cant];
    private final String[] visitantes = new String[cant];
    
    public void inicio(){
        mesclarEquipos();
        asignarLocalesVisitantes();
        rotarEquipos();
    }
    
    public void mesclarEquipos(){
        int random1; // Guarda la primera posición aleatoria
        int random2; // Guarda la segunda posición aleatoria
        String aux; // Variable auxiliar para intercambiar equipos

        for(int x = 0; x < 100; x++){

            do{
                 // Genera dos posiciones aleatorias distintas
                random1 = random.nextInt(equipos.length);
                random2 = random.nextInt(equipos.length);
            }while(random1 == random2);  // Si son iguales vuelve a generar números

            aux = equipos[random1]; // Guarda temporalmente el equipo de random1
            equipos[random1] = equipos[random2];
            equipos[random2] = aux;
            
        }
    }
    
    public void asignarLocalesVisitantes(){
        // Recorre las 5 posiciones de locales y visitantes
        for(int x = 0; x < cant; x++){
            // Guarda en locales los primeros 5 equipos
            locales[x] = equipos[x];
            // Guarda en visitantes los últimos 5 equipos
            visitantes[x] = equipos[x + cant];
        }
    }
    
    public void rotarEquipos(){
        String auxEquipoFijo;
        
        for(int x = 0 ; x < visitantes.length ; x = x +1){
            System.out.println(locales[0] + " vs " + visitantes[x]);
        }
        
        for(int t = 1 ; t < (locales.length) ; t = t + 1){
            System.out.println(locales[0]+ " vs " + locales[t]);
        }
        
        auxEquipoFijo = locales[0];
        locales[0] = visitantes[0];
        visitantes[0] = auxEquipoFijo;
        
        System.out.println("Enfrentamientos visitante fijo " + visitantes[0]);

        for(int y = 0 ; y < (visitantes.length-1) ; y = y + 1){
            System.out.println(visitantes[0] + "vs" + locales[y]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("intento 9 de junio lpm!!");
        Ej5IntentoProblemaComplejoFutbol ej5Intento = new Ej5IntentoProblemaComplejoFutbol();
        ej5Intento.inicio();
    }
}
