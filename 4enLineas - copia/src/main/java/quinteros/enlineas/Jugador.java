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
    
    private final Scanner teclado = new Scanner(System.in);
    
    public void pedirNombre(){
        String[] jugadores = new String[2];
        for(int x = 0; x < 2; x = x + 1){
            System.out.println("Ingresa el nombre del jugador N°" + (x+1) + ": ");
            jugadores[x] = teclado.nextLine();
        }
    }
}
