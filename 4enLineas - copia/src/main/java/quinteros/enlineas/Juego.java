/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.enlineas;

/**
 *
 * @author Usuario
 */
public class Juego {
    
    private Tablero tablero;
    private Jugador jugador;

    void inicio() {
        System.out.println("prueba de 4 en linea");
        tablero = new Tablero();
        jugador = new Jugador();
        
        
        jugador.pedirNombre();
        tablero.definirDificultad();
        tablero.imprimirTablero();
    }  
}
