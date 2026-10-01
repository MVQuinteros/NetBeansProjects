/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.repaso;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Clase Matrices
 * 
 * Aca se agrupan todos los ejercicios de matrices que fui haciendo.
 * Cada metodo es un ejercicio. El metodo main NO esta aca, esta en Menu.
 * 
 * Regla basica de una matriz:
 *   - filas    -> primer indice  [x][?]
 *   - columnas -> segundo indice [?][y]
 *   - se recorre con DOS bucles: uno para filas (x) y otro para columnas (y)
 *
 * @author Usuario
 */
public class Matrices {
    private final Scanner teclado = new Scanner(System.in);

    /**
     * Metodo de apoyo: sirve para pedir un numero entero por teclado.
     * Asi no repito el codigo del Scanner en todos los ejercicios.
     */
    public int traerInt(String mjs){
        int entero;
        System.out.print(mjs);
        entero = teclado.nextInt();
        return entero;
    }

    /**
     * ============ EJERCICIO 14 ============
     * Consigna: crear una matriz de 4 x 4 (filas y columnas iguales)
     * cargarla por teclado y mostrarla en pantalla.
     */
    public void ej14CargarMostrar(){
        int[][] matriz = new int[4][4];
        cargarMatriz(matriz, 4, 4);
        mostrarMatriz(matriz, 4, 4);
    }

    /**
     * ============ EJERCICIO 15 ============
     * Consigna: crear una matriz de filas y columnas DISTINTAS (3 x 5)
     * cargarla por teclado y mostrarla.
     */
    public void ej15MatrizFilasColumnasDistintas(){
        int[][] matrizDistinta = new int[3][5];
        cargarMatriz(matrizDistinta, 3, 5);
        mostrarMatriz(matrizDistinta, 3, 5);
    }

    /**
     * ============ EJERCICIO 16 ============
     * Consigna: crear una matriz de 4 x 4 de STRINGS (textos)
     * y mostrar SOLO la diagonal principal.
     *
     * Truco de la diagonal principal: se recorre con un SOLO bucle
     * y se imprime matriz[x][x], o sea fila y columna iguales.
     */
    public void ej16MostrarDiagonal(){
        String[][] matrizString = new String[4][4];
        for(int x = 0 ; x < 4 ; x = x + 1){
            for(int y = 0 ; y < 4 ; y = y + 1){
                System.out.print("Ingrese el String que quiera cargar en la fila " + x + " y en la columna " + y + ": ");
                matrizString[x][y] = teclado.next();
            }
        }
        System.out.println("La diagonal principal es: ");
        for(int x = 0 ; x < 4 ; x = x + 1){
            System.out.print(matrizString[x][x] + " - ");
        }
        System.out.println();
    }

    /**
     * ============ EJERCICIO 17 ============
     * Consigna: crear una matriz de n * m (filas y columnas las carga el usuario)
     * imprimir la matriz completa y despues la ULTIMA fila.
     */
    public void ej17UltimaFila(){
        int filas = traerInt("Ingresar cantidad de filas: ");
        int columnas = traerInt("Ingresar la cantidad de columnas: ");
        int[][] matriz = new int[filas][columnas];
        cargarMatriz(matriz, filas, columnas);

        System.out.println("MATRIZ COMPLETA");
        mostrarMatriz(matriz, filas, columnas);

        System.out.println("ULTIMA FILA");
        // la ultima fila es la posicion (filas - 1)
        for(int y = 0 ; y < columnas ; y = y + 1){
            System.out.print(matriz[(filas-1)][y] + " ");
        }
        System.out.println();
    }

    /**
     * ============ EJERCICIO 18 ============
     * Consigna: crear una matriz de n * m.
     * Imprimir el MAYOR elemento y la fila y columna donde se almacena.
     *
     * Recorremos TODA la matriz comparando cada valor con el mayor que vamos llevando.
     */
    public void ej18MayorElementoYPosicion(){
        int fila = traerInt("Ingrese la cantidad de filas de la matriz: ");
        int columna = traerInt("Ingrese la cantidad de columnas de la matriz: ");
        int[][] matriz = new int[fila][columna];
        cargarMatriz(matriz, fila, columna);

        // suponemos que el mayor es el primero
        int mayor = matriz[0][0];
        int filaMayor = 0;
        int columnaMayor = 0;
        for(int x = 0 ; x < fila ; x = x + 1){
            for(int y = 0 ; y < columna ; y = y + 1){
                if(matriz[x][y] > mayor){
                    mayor = matriz[x][y];
                    filaMayor = x;
                    columnaMayor = y;
                }
            }
        }
        System.out.println("El mayor elemento ingresado es: " + mayor);
        System.out.println("Y se encuentra en la posicion fila " + filaMayor + " y la columna " + columnaMayor);
    }

    /**
     * ============ EJERCICIO 19 ============
     * Consigna: crear una matriz de n * m.
     * Intercambiar la primer fila con la segunda. Imprimir luego la matriz.
     *
     * OJO: en mi version original el intercambio estaba mal (pisaba valores).
     * La forma correcta es guardar el valor de la fila 0 en un AUXILIAR
     * antes de reescribirlo.
     */
    public void ej19IntercambiarFilas(){
        int fila = traerInt("Ingresar cantidad de filas: ");
        int columna = traerInt("Ingresar cantidad de columnas: ");
        float[][] matriz = new float[fila][columna];
        for(int x = 0 ; x < fila ; x = x + 1){
            for(int y = 0 ; y < columna ; y = y + 1){
                System.out.print("Ingresar valor numerico float para la posicion fila " + x + " y columna " + y + ": ");
                matriz[x][y] = teclado.nextFloat();
            }
            System.out.println();
        }
        System.out.println("MATRIZ ORIGINAL");
        mostrarMatrizFloat(matriz, fila, columna);

        // INTERCAMBIO de la fila 0 con la fila 1.
        // Guardamos en un auxiliar el valor que vamos a pisar.
        for(int y = 0 ; y < columna ; y = y + 1){
            float aux = matriz[0][y];
            matriz[0][y] = matriz[1][y];
            matriz[1][y] = aux;
        }
        System.out.println("MATRIZ CON LA PRIMER FILA Y LA SEGUNDA INTERCAMBIADAS");
        mostrarMatrizFloat(matriz, fila, columna);
    }

    /**
     * ============ EJERCICIO 20 ============
     * Consigna: crear una matriz de n * m.
     * Imprimir los cuatro valores que estan en los VERTICES (esquinas).
     */
    public void ej20Vertices(){
        int fila = traerInt("Ingresar cantidad de filas: ");
        int columna = traerInt("Ingresar cantidad de columnas: ");
        float[][] matriz = new float[fila][columna];
        for(int x = 0 ; x < fila ; x = x + 1){
            for(int y = 0 ; y < columna ; y = y + 1){
                System.out.print("Ingresar valor numerico float para la posicion fila " + x + " y columna " + y + ": ");
                matriz[x][y] = teclado.nextFloat();
            }
            System.out.println();
        }
        System.out.println("Vertice superior izquierdo: " + matriz[0][0]);
        System.out.println("Vertice superior derecho: " + matriz[0][(columna-1)]);
        System.out.println("Vertice inferior izquierdo: " + matriz[(fila-1)][0]);
        System.out.println("Vertice inferior derecho: " + matriz[(fila-1)][(columna-1)]);
    }

    /**
     * ============ EJERCICIO 21 ============
     * Consigna: usar el atributo .length para recorrer la matriz
     * sin tener que pasar filas y columnas por parametro.
     *
     * Esto lo aprendimos con el tablero del 4 en linea:
     *   - matriz.length  -> cantidad de FILAS
     *   - matriz[0].length -> cantidad de COLUMNAS
     */
    public void ej21RecorrerConLength(){
        int filas = traerInt("Ingresar cantidad de filas: ");
        int columnas = traerInt("Ingresar cantidad de columnas: ");
        int[][] matriz = new int[filas][columnas];
        for(int x = 0 ; x < matriz.length ; x = x + 1){
            for(int y = 0 ; y < matriz[0].length ; y = y + 1){
                System.out.print("Carga de numero en fila " + x + " y columna " + y + ": ");
                matriz[x][y] = teclado.nextInt();
            }
            System.out.println();
        }
        // para mostrarla:
        for(int x = 0 ; x < matriz.length ; x = x + 1){
            for(int y = 0 ; y < matriz[0].length ; y = y + 1){
                System.out.print(matriz[x][y] + " | ");
            }
            System.out.println();
        }
    }

    // ==================================================================
    // METODO DE PRACTICA (no es un ejercicio exacto, es una HERRAMIENTA)
    // ==================================================================

    /**
     * Herramienta de practica: llenar una matriz con numeros al AZAR
     * usando Random (como hicimos en el ejercicio de futbol) para no
     * tener que cargar los datos a mano cuando queremos probar.
     *
     * random.nextInt(valorMaximo) devuelve un entero entre 0 y valorMaximo-1.
     * Si le sumo 1 -> numeros entre 1 y valorMaximo.
     */
    public void practicaMatrizConRandom(){
        Random random = new Random();
        int filas = traerInt("Ingresar cantidad de filas: ");
        int columnas = traerInt("Ingresar cantidad de columnas: ");
        int valorMaximo = traerInt("Ingresar el valor maximo que puede tomar cada numero: ");
        int[][] matriz = new int[filas][columnas];
        for(int x = 0 ; x < filas ; x = x + 1){
            for(int y = 0 ; y < columnas ; y = y + 1){
                matriz[x][y] = random.nextInt(valorMaximo) + 1;
            }
        }
        System.out.println("Matriz cargada al azar: ");
        mostrarMatriz(matriz, filas, columnas);
    }

    // VERSIONES DE APOYO: metodos que reutilizo para cargar/mostrar
    // matrices de enteros y de float. Los nombre descriptivos para que
    // se entienda que hacen y los reutilizo en varios ejercicios.

    public void cargarMatriz(int[][] matriz, int fil, int col){
        for(int x = 0 ; x < fil ; x = x + 1){
            for(int y = 0 ; y < col ; y = y + 1){
                System.out.print("Carga de numero en fila " + x + " y columna " + y + ": ");
                matriz[x][y] = teclado.nextInt();
            }
            System.out.println();
        }
    }

    public void mostrarMatriz(int[][] matriz, int fil, int col){
        for(int x = 0 ; x < fil ; x = x + 1){
            for(int y = 0 ; y < col ; y = y + 1){
                System.out.print(" - " + matriz[x][y] + " - ");
            }
            System.out.println();
        }
    }

    public void mostrarMatrizFloat(float[][] matriz, int fil, int col){
        for(int x = 0 ; x < fil ; x = x + 1){
            for(int y = 0 ; y < col ; y = y + 1){
                System.out.print(matriz[x][y] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
