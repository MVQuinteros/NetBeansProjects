/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correccionEj1;

import java.util.Scanner;
import quinteros.mavenproject1.modelo.ejercicioVector1;

/**
 *
 * @author Usuario
 */
public class correccionEj1 {
    private static final Scanner teclado = new Scanner(System.in);
    private int[] vector;
    
    public int traerNum (String mjs){
        int n;
        System.out.print(mjs);
        n = teclado.nextInt();
        return n;
    }
    
    public void cargarVector(int cant){
        
    }
    
    public void verMenor(int cant){
        int menor = vector[0]; //ya elejimos aca, va a resultar si no se repite y es menor este xdxd
        int repetidas = 1;
        // ciclamos uan vez menos ya que comparamos con otro elemento, si ciclara 
        for(int x = 0; x < (cant-1) ; x = x + 1){
            if(vector[x] == menor){
                repetidas = repetidas + 1;
            }else{
                if(vector[x]< menor){
                    menor = vector[x];
                    repetidas = 1;
                }
            }
        }
        informar(menor, repetidas);
    }
    
    public void informar(int men, int repe){
        System.out.print("El menor es: " + men);
        if(repe > 1){
            System.out.println("y se encuentra repetido " + repe + " veces");
        }else{
            System.out.println("y no se repite nunca");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("XD"); // aca va lo de cantidad. 
    }
}
