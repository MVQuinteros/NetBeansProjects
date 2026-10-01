/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Utilidades {
    public static final Scanner teclado = new Scanner(System.in);

    public static String traerString(String mjs){
        System.out.print(mjs);
        return teclado.nextLine();
    }

    public static int traerInt(String mjs) {
        int numero = 0;
        boolean valido = false;

        while (valido == false) {
            System.out.print(mjs);

            try {
                numero = teclado.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                teclado.nextLine();
            }
        }

        teclado.nextLine();
        return numero;
    }


    public static float traerFloat(String mjs){
        float numero = 0;
        boolean valido = false;
        String ingreso;
        
        while (valido == false){
            System.out.print(mjs);
            ingreso = teclado.nextLine().replace(",", ".");
            try{
                numero = Float.parseFloat(ingreso);
                valido = true;
            }catch(NumberFormatException e){
                System.out.println("Error: debe ingresar un número float.");
            }
        }
        return numero;
    }
}
