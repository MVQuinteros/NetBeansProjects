/*
 * Juego del ahorcado: versión terminada y corregida.
 *
 * Esta clase es una alternativa a JuegoAhorcado.java (que queda intacta) y
 * muestra cómo resolver el juego completo sin recursión:
 *   - comienzo() arma cada partida desde cero.
 *   - jugar() repite turnos mientras queden vidas y la palabra esté oculta.
 *   - perderVida() y determinarVictoria() ya no inician partidas nuevas.
 */
package quinteros.juegoahorcado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * Versión completa del ahorcado, con estado que se reinicia en cada partida.
 *
 * @author Usuario
 */
public class JuegoAhorcadoQuinteros {

    public static final Scanner teclado = new Scanner(System.in);

    private static final int VIDAS_INICIALES = 6;

    private int vidas;
    private final ArrayList<Character> letrasOriginales = new ArrayList<>();
    private final ArrayList<Character> letrasJugadas = new ArrayList<>();
    private final ArrayList<Character> letrasIntentos = new ArrayList<>();

    private final ArrayList<String> facil = new ArrayList<>(
            Arrays.asList("casa", "perro", "mesa", "gato", "flor")
    );
    private final ArrayList<String> medio = new ArrayList<>(
            Arrays.asList("guitarra", "ventana", "planeta", "mochila", "biblioteca")
    );
    private final ArrayList<String> dificil = new ArrayList<>(
            Arrays.asList("prohibicion", "rompecabezas", "extraordinario", "electricidad", "responsabilidad")
    );

    private final Random random = new Random();

    public static void main(String[] args) {
        new JuegoAhorcadoQuinteros().comienzo();
    }

    /**
     * Punto de entrada del juego: repite partidas hasta que el jugador dice "No".
     */
    public void comienzo() {
        informar("AHORCADO!");
        separador();

        boolean seguirJugando = true;
        while (seguirJugando) {
            prepararPartida();
            elegirOrigenPalabra();
            jugar();
            seguirJugando = continuarJuego();
        }

        informar("CERRANDO PROGRAMA...");
    }

    /**
     * Deja el estado limpio antes de cada partida.
     */
    private void prepararPartida() {
        vidas = VIDAS_INICIALES;
        letrasOriginales.clear();
        letrasJugadas.clear();
        letrasIntentos.clear();
    }

    /**
     * Pregunta si la palabra se elige al azar o la escribe el jugador.
     */
    public void elegirOrigenPalabra() {
        while (true) {
            informar("¿Cómo querés obtener la palabra?");
            informar("1. Aleatoria según la dificultad");
            informar("2. Escribirla yo");
            int opcion = traerInt("Ingresá el número de la opción: ");

            if (opcion == 1) {
                elegirModoJuego();
                return;
            }
            if (opcion == 2) {
                cargarPalabra();
                return;
            }
            informar("El número ingresado no es una opción válida, intentá de nuevo.");
        }
    }

    /**
     * Pregunta la dificultad para elegir una palabra al azar.
     */
    public void elegirModoJuego() {
        int opcion = 0;
        while (true) {
            informar("Elegí la dificultad de la palabra aleatoria:");
            informar("1. Fácil");
            informar("2. Media");
            informar("3. Difícil");
            opcion = traerInt("Ingresá el número de la opción: ");

            if (opcion >= 1 && opcion <= 3) {
                break;
            }
            informar("El número ingresado no es una opción válida, intentá de nuevo.");
        }
        definirRandom(opcion);
    }

    /**
     * Asigna la lista de palabras correspondiente a la dificultad elegida.
     */
    public void definirRandom(int op) {
        if (op == 1) {
            informar("¡Elegiste la dificultad fácil! Se seleccionará una palabra acorde.");
            asignarRandom(facil);
        } else if (op == 2) {
            informar("¡Elegiste la dificultad media! Se seleccionará una palabra acorde.");
            asignarRandom(medio);
        } else {
            informar("¡Elegiste la dificultad difícil! Se seleccionará una palabra acorde.");
            asignarRandom(dificil);
        }
    }

    /**
     * Toma una palabra al azar de la lista recibida.
     */
    public void asignarRandom(ArrayList<String> palabras) {
        int indice = random.nextInt(palabras.size());
        String palabra = palabras.get(indice);
        descomponerPalabra(palabra);
    }

    /**
     * Permite que el jugador escriba la palabra secreta.
     */
    public void cargarPalabra() {
        while (true) {
            String palabra = traerString("Ingresá la palabra secreta: ");
            String limpia = normalizar(palabra);

            if (limpia.isEmpty()) {
                informar("La palabra no puede estar vacía.");
                continue;
            }
            if (!limpia.matches("[a-zñ]+")) {
                informar("Solo se permiten letras, sin espacios ni números.");
                continue;
            }

            descomponerPalabra(limpia);
            return;
        }
    }

    /**
     * Separa la palabra en letras y prepara el tablero con guiones bajos.
     */
    public void descomponerPalabra(String palabra) {
        letrasOriginales.clear();
        letrasJugadas.clear();
        letrasIntentos.clear();

        String limpia = normalizar(palabra);
        for (int x = 0; x < limpia.length(); x++) {
            letrasOriginales.add(limpia.charAt(x));
            letrasJugadas.add('_');
        }
    }

    /**
     * Muestra la palabra descubierta hasta el momento, las letras usadas y las vidas.
     */
    public void imprimirPalabraTablero() {
        StringBuilder palabra = new StringBuilder();
        for (Character letra : letrasJugadas) {
            palabra.append(letra).append(' ');
        }
        informar("Palabra: " + palabra.toString().trim());

        if (!letrasIntentos.isEmpty()) {
            StringBuilder usadas = new StringBuilder();
            for (Character letra : letrasIntentos) {
                usadas.append(letra).append(' ');
            }
            informar("Letras usadas: " + usadas.toString().trim());
        }

        informar("Vidas restantes: " + vidas);
    }

    /**
     * Pide una letra hasta que sea válida y no haya sido jugada antes.
     */
    public void ingresoLetra() {
        char letra;
        while (true) {
            String intento = traerString("Ingresá una letra: ");

            if (intento.length() != 1) {
                informar("Por favor, ingresá una sola letra.");
                continue;
            }

            letra = Character.toLowerCase(intento.charAt(0));
            String normalizada = normalizar(String.valueOf(letra));

            if (normalizada.length() != 1 || !Character.isLetter(normalizada.charAt(0))) {
                informar("El carácter ingresado no es una letra válida.");
                continue;
            }

            letra = normalizada.charAt(0);
            if (letrasIntentos.contains(letra)) {
                informar("La letra '" + letra + "' ya fue jugada. Probá con otra.");
                continue;
            }

            break;
        }

        letrasIntentos.add(letra);
        chequeo(letra);
    }

    /**
     * Revisa si la letra está en la palabra y actualiza el tablero o las vidas.
     */
    public void chequeo(char in) {
        int aciertos = 0;

        for (int x = 0; x < letrasOriginales.size(); x++) {
            if (letrasOriginales.get(x).charValue() == in) {
                aciertos = aciertos + 1;
                letrasJugadas.set(x, in);
            }
        }

        if (aciertos > 0) {
            informar("¡Bien! La letra '" + in + "' aparece " + aciertos
                    + (aciertos == 1 ? " vez." : " veces."));
        } else {
            perderVida();
        }
    }

    /**
     * Indica si ya se descubrieron todas las letras de la palabra.
     */
    public boolean determinarVictoria() {
        if (letrasOriginales.isEmpty() || letrasJugadas.size() != letrasOriginales.size()) {
            return false;
        }
        for (int x = 0; x < letrasOriginales.size(); x++) {
            if (!letrasOriginales.get(x).equals(letrasJugadas.get(x))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Descuenta una vida. Ya no llama a ingresoLetra(): de eso se encarga jugar().
     */
    public void perderVida() {
        vidas = vidas - 1;

        if (vidas > 0) {
            informar("Esa letra no está en la palabra. Te quedan " + vidas
                    + (vidas == 1 ? " vida." : " vidas."));
        } else {
            informar("¡Te quedaste sin vidas!");
        }
    }

    /**
     * Pregunta si el jugador quiere empezar otra partida.
     */
    public boolean continuarJuego() {
        while (true) {
            informar("¿Querés jugar nuevamente?");
            informar("1. Sí");
            informar("2. No");
            int op = traerInt("Ingresá el número de la opción: ");

            if (op == 1) {
                return true;
            }
            if (op == 2) {
                return false;
            }
            informar("Debe ingresar una opción válida, intentá de nuevo.");
        }
    }

    /**
     * Ciclo principal de una partida: tablero, letra, tablero...
     */
    private void jugar() {
        while (vidas > 0 && !determinarVictoria()) {
            imprimirPalabraTablero();
            ingresoLetra();
        }

        System.out.println();
        imprimirPalabraTablero();

        if (determinarVictoria()) {
            informar("------------------------ ¡Has ganado el juego! ¡Felicidades! ------------------------");
        } else {
            informar("¡Has perdido! La palabra era: " + palabraComoTexto());
        }
    }

    /**
     * Reconstruye la palabra secreta para mostrarla al perder.
     */
    private String palabraComoTexto() {
        StringBuilder palabra = new StringBuilder();
        for (Character letra : letrasOriginales) {
            palabra.append(letra);
        }
        return palabra.toString();
    }

    /**
     * Pasa todo a minúsculas y quita tildes/diéresis para comparar sin problemas.
     * La "ñ" se conserva porque es una letra distinta en español.
     */
    private String normalizar(String texto) {
        String minusculas = texto.trim().toLowerCase(Locale.ROOT);
        StringBuilder resultado = new StringBuilder(minusculas.length());

        for (int x = 0; x < minusculas.length(); x++) {
            char c = minusculas.charAt(x);
            switch (c) {
                case 'á' -> resultado.append('a');
                case 'é' -> resultado.append('e');
                case 'í' -> resultado.append('i');
                case 'ó' -> resultado.append('o');
                case 'ú', 'ü' -> resultado.append('u');
                default -> resultado.append(c);
            }
        }
        return resultado.toString();
    }

    public static String traerString(String mjs) {
        System.out.print(mjs);
        return teclado.nextLine().trim();
    }

    public static int traerInt(String mjs) {
        while (true) {
            System.out.print(mjs);
            try {
                int numero = teclado.nextInt();
                teclado.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                teclado.nextLine();
            }
        }
    }

    public void informar(String mjs) {
        System.out.println(mjs);
    }

    private void separador() {
        informar("---------------------------------------------------------------------------");
    }
}
