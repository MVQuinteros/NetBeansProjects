/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.repaso;

import java.util.Scanner;

/**
 *
 * Clase Menu
 * 
 * Este es el programa PRINCIPAL. Aca esta el metodo main.
 * 
 * La idea es tener TODO junto en un solo proyecto para poder estudiar:
 *   - la clase Vectores  -> todos los ejercicios de vectores
 *   - la clase Matrices  -> todos los ejercicios de matrices
 *   - esta clase Menu    -> elige cual ejercicio probar
 * 
 * Asi no tenemos que abrir un proyecto distinto por cada ejercicio.
 * 
 * Si queres probar un ejercicio especifico, elegi su numero en el menu.
 * Con 0 se sale del programa.
 *
 * @author Usuario
 */
public class Menu {
    private final Scanner teclado = new Scanner(System.in);
    private final Vectores vectores = new Vectores();
    private final Matrices matrices = new Matrices();

    public void mostrarMenu(){
        System.out.println("==============================================");
        System.out.println("   REPASO PARCIAL - VECTORES Y MATRICES");
        System.out.println("==============================================");
        System.out.println();
        System.out.println("VECTORES:");
        System.out.println("  1. Ordenar sueldos de mayor a menor");
        System.out.println("  2. Ordenar vector de menor a mayor y viceversa");
        System.out.println("  3. Notas y nombres de alumnos (vectores paralelos)");
        System.out.println("  4. Paises ordenados alfabeticamente");
        System.out.println("  5. Menor numero y cuantas veces se repite");
        System.out.println("  6. Alturas: promedio y cuantas mas altas/bajas");
        System.out.println("  7. Cursos A y B: el de mayor promedio general");
        System.out.println("  8. Nombres y edades: imprimir mayores de edad");
        System.out.println("  9. Sueldos de operarios (cantidad por teclado)");
        System.out.println(" 10. Vector de n elementos: suma total");
        System.out.println(" 11. Sueldos por turnos (manana y tarde)");
        System.out.println(" 12. Suma de dos vectores componente a componente");
        System.out.println(" 13. Verificar si un vector esta ordenado");
        System.out.println(" 14. [SUGERIDO] Buscar un numero en el vector");
        System.out.println(" 15. [SUGERIDO] Invertir un vector");
        System.out.println();
        System.out.println("MATRICES:");
        System.out.println(" 16. Cargar y mostrar matriz 4x4");
        System.out.println(" 17. Matriz con filas y columnas distintas (3x5)");
        System.out.println(" 18. Mostrar la diagonal principal de una matriz");
        System.out.println(" 19. Mostrar la ultima fila de una matriz");
        System.out.println(" 20. Mayor elemento y su posicion");
        System.out.println(" 21. Intercambiar la primer fila con la segunda");
        System.out.println(" 22. Mostrar los cuatro vertices");
        System.out.println(" 23. Recorrer matriz con .length");
        System.out.println();
        System.out.println("HERRAMIENTAS (de practica, usan Random, no son del parcial):");
        System.out.println(" 24. Llenar un vector al azar con Random");
        System.out.println(" 25. Llenar una matriz al azar con Random");
        System.out.println();
        System.out.println("  0. Salir");
        System.out.println();
    }

    public void ejecutar(){
        int opcion;
        do{
            mostrarMenu();
            System.out.print("Ingrese una opcion: ");
            opcion = teclado.nextInt();
            System.out.println();

            switch(opcion){
                // VECTORES
                case 1 -> vectores.ej1OrdenarSueldosMayorMenor();
                case 2 -> vectores.ej2OrdenarMenorMayorYMayorMenor();
                case 3 -> vectores.ej3NotasAlumnosParalelos();
                case 4 -> vectores.ej4PaisesAlfabeticamente();
                case 5 -> vectores.ej5MenorYRepetidos();
                case 6 -> vectores.ej6AlturasPromedio();
                case 7 -> vectores.ej7CursosPromedio();
                case 8 -> vectores.ej8NombresEdades();
                case 9 -> vectores.ej9SueldosDinamico();
                case 10 -> vectores.ej10SumaElementos();
                case 11 -> vectores.ej11SueldosTurnos();
                case 12 -> vectores.ej12SumaDosVectores();
                case 13 -> vectores.ej13EstaOrdenado();
                case 14 -> vectores.ej14BuscarNumero();
                case 15 -> vectores.ej15InvertirVector();
                // MATRICES
                case 16 -> matrices.ej14CargarMostrar();
                case 17 -> matrices.ej15MatrizFilasColumnasDistintas();
                case 18 -> matrices.ej16MostrarDiagonal();
                case 19 -> matrices.ej17UltimaFila();
                case 20 -> matrices.ej18MayorElementoYPosicion();
                case 21 -> matrices.ej19IntercambiarFilas();
                case 22 -> matrices.ej20Vertices();
                case 23 -> matrices.ej21RecorrerConLength();
                // HERRAMIENTAS (usan RANDOM: una de vector y otra de matriz)
                case 24 -> vectores.practicaVectorConRandom();
                case 25 -> matrices.practicaMatrizConRandom();
                // SALIR
                case 0 -> System.out.println("Chau! Suerte en el parcial ;)");
                default -> System.out.println("Opcion invalida. Elegi un numero del menu.");
            }
            System.out.println();
        }while(opcion != 0);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.ejecutar();
    }
}
