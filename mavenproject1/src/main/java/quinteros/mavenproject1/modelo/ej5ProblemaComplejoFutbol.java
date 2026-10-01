/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.modelo;

//import java.util.Random;
//import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ej5ProblemaComplejoFutbol {
    private final Random random = new Random();
    private final int cant = 5;
    private final int cantGoles = 7;
    // vectores
    
    private final String[] equiposOriginal = {"Boca Juniors","River Plate","Racing","San lorenzo",
        "Independiente","Estudiantes","Rosario Central",
        "Vélez Sarsfield","Newell's Old Boys","Chacarita"};
    
    private final String[] equipos = {"Boca Juniors","River Plate" ,"Racing", 
        "San lorenzo" ,"Independiente" ,"Estudiantes", "Rosario Central" ,
        "Vélez Sarsfield" ,"Newell's Old Boys" ,"Chacarita"};
    
    private final int[] puntos = new int[10];
    private final int[] partidosGanados = new int[10];
    private final int[] partidosEmpatados = new int[10];
    private final int[] partidosPerdidos = new int[10];
    private final int[] partidosJugados = new int[10];
    private final int[] golesFavor = new int[10];
    private final int[] golesContra = new int[10];
    private final int[] diferenciaGoles = new int[10];
    
    private final String[] locales = new String[cant];
    private final String[] visitantes = new String[cant];
    private final int[] localesGoles = new int[cant];
    private final int[] visitantesGoles = new int [cant];
    
    public void marcarGoles(){
        for(int x = 0; x < cant; x = x + 1){
            localesGoles[x] = random.nextInt(cantGoles);
            visitantesGoles[x] = random.nextInt(cantGoles);
        }
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
    
    public String resultadoPartido(int pos){

        if(localesGoles[pos] > visitantesGoles[pos]){
            return "L";
        }else{
            if(localesGoles[pos] < visitantesGoles[pos]){
                return "V";
            }else{
                return "E";
            }
        }
    }
    
    public void imprimirEstadistica(int [] vec){
        for(int x = 0 ; x < equipos.length ; x = x + 1){
            System.out.println(equiposOriginal[x] + ": " + vec[x]);
        }
    }
    
    public void ordenarPartidosGanados(){
        String auxEquipo;
        int auxGanados;
        for(int x = 0; x < (equipos.length-1); x = x +1){
            for(int y = 0 ; y < (equipos.length-1) ; y = y + 1){
                if(partidosGanados[y]< partidosGanados[y+1]){
                    auxGanados = partidosGanados[y];
                    partidosGanados[y] = partidosGanados[y+1];
                    partidosGanados[y+1] = auxGanados;
                    
                    auxEquipo = equipos[y];
                    equipos[y] = equipos[y+1];
                    equipos[y+1] = auxEquipo;
                }
            }
        }
        imprimirEstadistica(partidosGanados);
    }
    
    public void ordenarPartidosPerdidos(){
        int auxPerdidos;
        String auxEquipo;
        for(int x = 0; x < (equipos.length-1); x = x +1){
            for(int y = 0 ; y < (equipos.length-1) ; y = y + 1){
                if(partidosPerdidos[y] < partidosPerdidos[y+1]){
                    auxPerdidos = partidosPerdidos[y];
                    partidosPerdidos[y] = partidosPerdidos[y+1];
                    partidosPerdidos[y+1] = auxPerdidos;
                    
                    auxEquipo = equipos[y];
                    equipos[y] = equipos[y+1];
                    equipos[y+1] = auxEquipo;
                }
            }
        }
        imprimirEstadistica(partidosPerdidos);
    }
    
    public void ordenarPartidosEmpatados(){
        int auxEmpatados;
        String auxEquipo;
                for(int x = 0; x < (equipos.length-1); x = x +1){
            for(int y = 0 ; y < (equipos.length-1) ; y = y + 1){
                if(partidosEmpatados[y] < partidosEmpatados[y+1]){
                    auxEmpatados = partidosEmpatados[y];
                    partidosEmpatados[y] = partidosEmpatados[y+1];
                    partidosEmpatados[y+1] = auxEmpatados;
                    
                    auxEquipo = equipos[y];
                    equipos[y] = equipos[y+1];
                    equipos[y+1] = auxEquipo;
                }
            }
        }
        imprimirEstadistica(partidosEmpatados);
    }
        
    public void ordenarPuntaje(){
        int aux;
        String auxEquipo;
        for(int x = 0 ; x < (equipos.length-1) ; x = x + 1){
            for(int y = 0 ; y < (equipos.length-1) ; y = y + 1){
                if(puntos[y] < puntos[y+1]){
                    aux = puntos[y];
                    puntos[y] = puntos[y+1];
                    puntos[y+1] = aux;
                    
                    auxEquipo = equipos[y];
                    equipos[y] = equipos[y+1];
                    equipos[y+1] = auxEquipo;
                }
            }
        }
        imprimirEstadistica(puntos);
    }
    
    public void imprimirTabla(){
        System.out.println();
        System.out.println("POS EQUIPO                 PTS PJ PG PE PP GF GC DG");

        for(int x = 0; x < equiposOriginal.length; x = x + 1){
            System.out.printf("%2d %-20s %3d %2d %2d %2d %2d %2d %2d %3d%n",
                    x + 1,
                    equiposOriginal[x],
                    puntos[x],
                    partidosJugados[x],
                    partidosGanados[x],
                    partidosEmpatados[x],
                    partidosPerdidos[x],
                    golesFavor[x],
                    golesContra[x],
                    diferenciaGoles[x]
            );
        }
    }
    
    /**
    * Rota los equipos para generar la siguiente fecha.
    * El primer equipo queda fijo y el resto gira una posición.
    */
    public void rotarEquipos() {
        
       String aux = equipos[equipos.length - 1];

       for (int x = equipos.length - 1; x > 1;  x = x - 1) {
           equipos[x] = equipos[x - 1];
       }

       equipos[1] = aux;
    }
    
/**
    * Asigna los enfrentamientos de una fecha.
    * Los primeros 5 equipos son locales y los últimos 5 visitantes.
    */
    public void generarFecha() {

       for (int x = 0; x < cant;  x = x + 1) {
           locales[x] = equipos[x];
           visitantes[x] = equipos[equipos.length - 1 - x];
       }
    }
    
    /**
    * Muestra todos los partidos de una fecha.
    */
    public void mostrarFecha(int nroFecha) {

        System.out.println();
        System.out.println("FECHA " + nroFecha);

        for (int x = 0; x < cant;  x = x + 1) {

            String resultado;

            resultado = resultadoPartido(x);

            System.out.println(
                   locales[x] + " " + localesGoles[x] + " | " + resultado + " | " 
                   + visitantesGoles[x] + " " + visitantes[x]
            );
        }
    }
    
    /**
    * Devuelve la posición de un equipo dentro del vector equipos.
    */
    public int buscarEquipo(String nombre) {
       for (int x = 0; x < equiposOriginal.length;  x = x + 1) {
           if (equiposOriginal[x].equals(nombre)) {
               return x;
           }
       }
       return -1;
    }
    
    /**
    * Actualiza puntos, ganados, empatados y perdidos.
    */
    public void actualizarTabla() {

       int posLocal;
       int posVisitante;

       for (int x = 0; x < cant;  x = x + 1) {

           posLocal = buscarEquipo(locales[x]);
           posVisitante = buscarEquipo(visitantes[x]);

           if (localesGoles[x] > visitantesGoles[x]) {

               puntos[posLocal] = puntos[posLocal] + 3;
               partidosGanados[posLocal]= partidosGanados[posLocal] + 1;
               partidosPerdidos[posVisitante]= partidosPerdidos[posVisitante] + 1;

           } else if (localesGoles[x] < visitantesGoles[x]) {

               puntos[posVisitante]= puntos[posVisitante] + 3;
               partidosGanados[posVisitante] = partidosGanados[posVisitante] + 1;
               partidosPerdidos[posLocal] = partidosPerdidos[posLocal] + 1;

           } else {

               puntos[posLocal]= puntos[posLocal] + 1;
               puntos[posVisitante] = puntos[posVisitante] + 1;

               partidosEmpatados[posLocal] = partidosEmpatados[posLocal] + 1;
               partidosEmpatados[posVisitante] = partidosEmpatados[posVisitante] + 1;
           }
       }
    }
    
    /**
    * Genera el campeonato completo de ida y vuelta.
    */
    public void jugarCampeonato() {

       mesclarEquipos();

       for (int fecha = 1; fecha <= 18; fecha = fecha + 1) {

           generarFecha();

           marcarGoles();

           mostrarFecha(fecha);

           actualizarTabla();

           imprimirTabla();

           rotarEquipos();
       }
    }
    
    public static void main(String[] args) {
        System.out.println("ya no se");
        quinteros.mavenproject1.modelo.ej5ProblemaComplejoFutbol ej5Problema = new quinteros.mavenproject1.modelo.ej5ProblemaComplejoFutbol();
        ej5Problema.jugarCampeonato();
    }
        
    public void imprimirTops(){
        // for(int x = 0 ; x < 18 ; x = x + 1){
            System.out.println(" ");
            System.out.println("---TOPS---");
            System.out.println(" - Partidos ganados: ");
            ordenarPartidosGanados();
            ordenarPartidosPerdidos();
            ordenarPartidosEmpatados();
        }
    }  
}
    


