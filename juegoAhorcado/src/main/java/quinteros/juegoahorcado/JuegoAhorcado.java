/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package quinteros.juegoahorcado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class JuegoAhorcado {
    
    public static final Scanner teclado = new Scanner(System.in);
    private int vidas = 6;
    private ArrayList<Character> letrasOriginales = new ArrayList<>();
    private ArrayList<Character> letrasJugadas = new ArrayList<>();
    private ArrayList<Character> letrasIntentos = new ArrayList<>();
    private ArrayList<String> facil = new ArrayList<>(
        Arrays.asList("casa", "perro", "mesa", "gato", "flor")
    );
    private ArrayList<String> medio = new ArrayList<>(
        Arrays.asList("guitarra", "ventana", "planeta", "mochila", "biblioteca")
    );
    private ArrayList<String> dificil = new ArrayList<>(
        Arrays.asList("prohibicion", "rompecabezas", "extraordinario", "electricidad", "responsabilidad")
    );

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
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public void elegirModoJuego(){
        int opcion = 0;
        boolean elegido = true;
        while(elegido){
            informar("Elige la dificultad del la palabra ramdom:");
            informar("1. Facil");
            informar("2. Media");
            informar("3. Dificil");
            opcion = traerInt("Ingrese el numero de la opcion: ");
            if(opcion >=1 && opcion <= 3){
                elegido = false;
            }else{
                informar("El numero ingresado no es una opcion valida, intentelo nuevamente.");
            }
        }
        definirRamdom(opcion);
    }
    
    public void definirRamdom(int op){
        if(op == 1){
            informar("Ha elegido la dificultad facil! se seleccionara una palabra acorde.");
            asignarRamdom(facil);
        }else{
            if(op == 2){
                informar("Ha elegido la dificultad media! se seleccionara una palabra acorde.");
                asignarRamdom(medio);
            }else{
                informar("Ha elegido la dificultad dificil! se seleccionara una palabra acorde.");
                asignarRamdom(dificil);
            }
        }
    }
    
    public void asignarRamdom(ArrayList<String> palabras){
        Random random = new Random();
        int indice;
        String palabra;
        indice = random.nextInt(palabras.size());
        palabra = palabras.get(indice);
        descomponerPalabra(palabra);
    }
    
    public void cargarPalabra() {
        String palabra;
        palabra = traerString("Ingresar una palabra: ");
        descomponerPalabra(palabra);
    }
    
    public void descomponerPalabra(String pala){
        for (int x = 0; x < pala.length(); x = x + 1) {
            letrasOriginales.add(pala.charAt(x));
            letrasJugadas.add('_');
        }
    }
    
    public void imprimirPalabraTablero(){
        for (int x = 0; x < letrasOriginales.size(); x = x + 1) {
            System.out.print((x+1) + " - ");
        }
        for (int x = 0; x < letrasOriginales.size(); x = x + 1) {
            System.out.print(letrasJugadas.get(x) + " - ");
        }
    }
    
    public void ingresoLetra(){
        imprimirPalabraTablero();
        String intento;
        char inte;
        boolean valido = true;
        while(valido){
            intento = traerString("Ingrese una letra: ");
            if(intento.length() == 1){
                inte = intento.charAt(0);
                chequeo(inte);
                valido = false;
            }else{
                informar("por favor, ingrese unicamente una letra");
            } 
        }
    }
    
    public void chequeo(char in){
        int aciertos = 0;
        
        if (letrasIntentos.contains(in)) {
            informar("La letra ingresada ya ha sido jugada con anterioridad.");
            return; // ingresoLetra();
        }
        letrasIntentos.add(in);
        
        for(int x = 0; x < letrasOriginales.size() ; x++){
            if(in == letrasOriginales.get(x)){
                aciertos = aciertos + 1;
                letrasJugadas.set(x, in);
            }
        }
        if(aciertos > 0){
            informar("Haz tenido " + aciertos + " aciertos!");
            determinarVictoria();
        }else{
            informar("No hubo aciertos esta vez, intentalo nuevamente");
            perderVida();
        }
    }
    
    public void determinarVictoria(){
        boolean victoria = true;
        for(int x = 0 ; x < letrasOriginales.size(); x++){
            if(letrasOriginales.get(x) != letrasJugadas.get(x)){
                victoria = false;
            }
        }
        if(victoria){
            informar(" ------------------------ Haz ganado el juego! felicidades! ------------------------ ");
            imprimirPalabraTablero();
            continuarJuego();
        }
    }

    public void perderVida() {
        vidas = vidas - 1;
        if(vidas > 0){
            informar("aun tienes "+ vidas + " vidas.");
            ingresoLetra();
        }else{
            informar("Te Haz quedado sin vidas!");
            informar("Haz perdido! Mejor suerte la proxima!");
            continuarJuego();
        }
    }
    
    public void continuarJuego(){
        boolean respuesta = true;
        int op;
        while(respuesta){
            informar("Quieres jugar nuevamente?");
            informar("1. Si");
            informar("2. No");
            op = traerInt("Ingresa tu numero de opcion: ");
            if(op == 1){
                comienzo();
            }else{
                if(op == 2){
                    respuesta = false;
                    informar("CERRANDO PROGRAMA...");
                }else{
                    informar("debe ingresar una opcion valida, intentelo nuevamente");
                }
            }
        }   
    }
    
    public void comienzo(){
        
    }
    
    public static void main(String[] args) {
        System.out.println("AHORCADO!");
        System.out.println("---------------------------------------------------------------------------");
        JuegoAhorcado ja = new JuegoAhorcado();
        ja.comienzo();
    }
}
