/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.enlineas;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Juego {
    
    private final Scanner teclado = new Scanner(System.in);
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;

    void inicio() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("      BIENVENIDOS AL 4 EN LINEA             ");
        System.out.println("============================================");
        System.out.println();
        tablero = new Tablero(teclado);
        
        jugador1 = new Jugador(" X ", teclado);
        jugador2 = new Jugador(" O ", teclado);
        jugador1.pedirNombre(1);
        jugador2.pedirNombre(2);
        
        tablero.definirDificultad();
        
        jugar();
    }
    
    void jugar(){
        int jugadorActual = 0;
        boolean partidaTerminada = false;
        
        while(partidaTerminada == false){
            Jugador jugador = obtenerJugadorActual(jugadorActual);
            
            System.out.println();
            System.out.println("------------------------------------");
            System.out.println("Turno de " + jugador.getNombre() + " (ficha " + jugador.getSimbolo() + ")");
            System.out.println("------------------------------------");
            tablero.imprimirTablero();
            
            colocarFicha(jugador);
            
            if(tablero.huboGanador(jugador.getSimbolo())){
                System.out.println();
                tablero.imprimirTablero();
                System.out.println("------------------------------------");
                System.out.println("¡Gano " + jugador.getNombre() + "!");
                System.out.println("------------------------------------");
                partidaTerminada = true;
            } else if(tablero.estaLleno()){
                System.out.println();
                tablero.imprimirTablero();
                System.out.println("------------------------------------");
                System.out.println("¡Empate!");
                System.out.println("------------------------------------");
                partidaTerminada = true;
            } else {
                jugadorActual = 1 - jugadorActual;
            }
        }
    }
    
    Jugador obtenerJugadorActual(int jugadorActual){
        if(jugadorActual == 0){
            return jugador1;
        } else {
            return jugador2;
        }
    }
    
    void colocarFicha(Jugador jugador){
        boolean fichaColocada = false;
        while(fichaColocada == false){
            int columna = pedirColumna();
            if(columna < 0 || columna >= tablero.getColumnas()){
                System.out.println("Columna fuera de rango. Elegi un numero entre 0 y " + (tablero.getColumnas() - 1) + ".");
            } else if(tablero.colocarFicha(columna, jugador.getSimbolo()) == false){
                System.out.println("Esa columna esta llena. Elegi otra columna.");
            } else {
                fichaColocada = true;
            }
        }
    }
    
    int pedirColumna(){
        int columna = 0;
        boolean numeroValido = false;
        while(numeroValido == false){
            System.out.print("  Elegi una columna (0 a " + (tablero.getColumnas() - 1) + "): ");
            if(teclado.hasNextInt()){
                columna = teclado.nextInt();
                numeroValido = true;
            } else {
                System.out.println("Eso no es un numero valido. Escribi un numero entero.");
                teclado.next();
            }
        }
        return columna;
    }
}
