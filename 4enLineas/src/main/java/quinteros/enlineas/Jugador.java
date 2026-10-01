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
public class Jugador {
    
    private final Scanner teclado;
    private String nombre;
    private String simbolo;
    
    public Jugador(String simbolo, Scanner teclado){
        this.simbolo = simbolo;
        this.teclado = teclado;
    }
    
    public void pedirNombre(int numeroJugador){
        System.out.print("Ingresa el nombre del jugador numero " + numeroJugador + ": ");
        nombre = teclado.nextLine();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getSimbolo(){
        return simbolo;
    }
}
