/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.repaso;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Clase Vectores
 * 
 * Aca se agrupan todos los ejercicios de vectores (arrays de una dimension)
 * que fui haciendo. Cada metodo es un ejercicio.
 * El metodo main NO esta aca, esta en Menu.
 * 
 * Regla basica de un vector:
 *   - es una lista de elementos, todos del mismo tipo
 *   - se accede con un indice: vector[0], vector[1], vector[2]...
 *   - se recorre con UN solo bucle (for).
 *   - longitud = vector.length
 *
 * @author Usuario
 */
public class Vectores {
    private final Scanner teclado = new Scanner(System.in);

    /**
     * Metodo de apoyo: pide un entero por teclado sin repetir codigo.
     */
    public int traerInt(String mjs){
        System.out.print(mjs);
        int entero = teclado.nextInt();
        teclado.nextLine();
        return entero;
    }

    /**
     * Metodo de apoyo: pide un texto por teclado.
     */
    public String traerString(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine();
        return ingreso;
    }

    /**
     * Metodo de apoyo: pide un float (con coma o punto) por teclado.
     */
    public float traerFloat(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine().replace(",", ".");
        float flo = Float.parseFloat(ingreso);
        return flo;
    }

    /**
     * ============ EJERCICIO 1 ============
     * Consigna: crear un vector donde almacenar 5 sueldos.
     * Ordenar el vector de sueldos de MAYOR a MENOR.
     *
     * Este es el famoso "ordenamiento burbuja":
     *   - dos bucles (uno adentro del otro)
     *   - si el de la izquierda es menor que el de la derecha, se intercambian
     *   - se necesita una variable AUXILIAR para poder intercambiar
     */
    public void ej1OrdenarSueldosMayorMenor(){
        int cant = traerInt("Ingrese cuantos numeros quiere cargar: ");
        float[] sueldos = new float[cant];
        for(int x = 0 ; x < cant ; x = x + 1){
            sueldos[x] = traerFloat("Ingrese elemento " + (x+1) + " : " );
        }

        // ciclamos (cantidad-1) veces porque comparamos de a pares
        float aux;
        for(int y = 0 ; y < (cant-1) ; y = y + 1){
            for(int x = 0 ; x < (cant-1) ; x = x + 1){
                // si el de arriba (izquierda) es menor que el de abajo (derecha)
                // los invertimos para que quede de mayor a menor
                if(sueldos[x] < sueldos[x+1]){
                    aux = sueldos[x];
                    sueldos[x] = sueldos[x+1];
                    sueldos[x+1] = aux;
                }
            }
        }
        System.out.print("El vector ordenado de mayor a menor es: ");
        for(int x = 0 ; x < cant ; x = x + 1){
            System.out.println(" - " + sueldos[x]);
        }
    }

    /**
     * ============ EJERCICIO 2 ============
     * Consigna: cargar un vector de n elementos de tipo entero.
     * Ordenarlo de MENOR a MAYOR y despues de MAYOR a MENOR.
     * Imprimir el vector desordenado y el ordenado.
     *
     * Es lo mismo que el ejercicio 1 pero para ambos sentidos,
     * y mostraba el vector recien cargado antes de ordenar.
     */
    public void ej2OrdenarMenorMayorYMayorMenor(){
        int cantidad = traerInt("Ingresar la longitud del Vector: ");
        int[] vector = new int[cantidad];
        for(int x = 0 ; x < cantidad ; x = x + 1){
            vector[x] = traerInt("Ingrese el elemento numero " + (x+1) + ": ");
        }
        imprimirVector(vector, cantidad, "El Vector recien ingresado es: ");

        // ordenar de menor a mayor
        int aux;
        for(int x = 0 ; x < (cantidad-1) ; x = x + 1){
            for(int y = 0 ; y < (cantidad-1) ; y = y + 1){
                if(vector[y] > vector[y+1]){
                    aux = vector[y];
                    vector[y] = vector[y+1];
                    vector[y+1] = aux;
                }
            }
        }
        imprimirVector(vector, cantidad, "El vector ordenado de menor a mayor es: ");

        // ordenar de mayor a menor (invertimos la condicion del if)
        for(int x = 0 ; x < (cantidad-1) ; x = x + 1){
            for(int y = 0 ; y < (cantidad-1) ; y = y + 1){
                if(vector[y] < vector[y+1]){
                    aux = vector[y];
                    vector[y] = vector[y+1];
                    vector[y+1] = aux;
                }
            }
        }
        imprimirVector(vector, cantidad, "El vector ordenado de mayor a menor es: ");
    }

    /**
     * ============ EJERCICIO 3 ============
     * Consigna: cargar los nombres de 5 alumnos y sus notas.
     * Ordenar las notas de mayor a menor.
     * Imprimir las notas y los nombres de los alumnos JUNTOS.
     *
     * Esto son VECTORES PARALELOS: dos vectores que se ordenan juntos,
     * cuando muevo una nota tambien muevo el nombre que va con ella.
     */
    public void ej3NotasAlumnosParalelos(){
        final int cantidad = 5;
        int[] notas = new int[cantidad];
        String[] nombres = new String[cantidad];

        System.out.println("Carga de Alumnos y notas");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            nombres[x] = traerString("Ingrese el nombre del estudiante: ");
            notas[x] = traerInt("Ingrese la nota de " + nombres[x] + " : ");
        }
        imprimirAlumnos(nombres, notas, cantidad, "Vectores recien cargados: ");

        // ordenar notas de mayor a menor, arrastrando los nombres
        int auxNotas;
        String auxNombres;
        for(int x = 0 ; x < (cantidad-1) ; x = x + 1){
            for(int y = 0 ; y < (cantidad-1) ; y = y + 1){
                if(notas[y] < notas[y+1]){
                    // guardo ambos en auxiliares antes de pisarlos
                    auxNotas = notas[y];
                    auxNombres = nombres[y];
                    notas[y] = notas[y+1];
                    nombres[y] = nombres[y+1];
                    notas[y+1] = auxNotas;
                    nombres[y+1] = auxNombres;
                }
            }
        }
        imprimirAlumnos(nombres, notas, cantidad, "Vectores Ordenados: ");
    }

    /**
     * ============ EJERCICIO 4 ============
     * Consigna: cargar 5 paises y su cantidad de habitantes.
     * Ordenar los paises ALFABETICAMENTE (manteniendo cada pais junto a sus habitantes).
     *
     * Para ordenar textos se usa compareTo:
     *   - paises[y].compareTo(paises[y+1]) > 0  ->  el de la izquierda va DESPUES (hay que moverlo)
     *   - da 0 si son iguales, negativo si va antes
     */
    public void ej4PaisesAlfabeticamente(){
        final int cantidad = 5;
        String[] paises = new String[cantidad];
        float[] habitantes = new float[cantidad];

        System.out.println("Carga de Paises y Habitantes ");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            paises[x] = traerString("Ingrese el nombre del pais: ");
            habitantes[x] = traerFloat("Ingrese la cantidad de habitantes de " + paises[x] + " : ");
        }
        imprimirPaises(paises, habitantes, cantidad, "Vector recien cargado: ");

        // ordenar paises alfabeticamente (arrastrando habitantes)
        String auxPaises;
        float auxHabitantes;
        for(int x = 0 ; x < (cantidad-1) ; x = x + 1){
            for(int y = 0 ; y < (cantidad-1) ; y = y + 1){
                if(paises[y].compareTo(paises[y+1]) > 0){
                    auxPaises = paises[y];
                    paises[y] = paises[y+1];
                    paises[y+1] = auxPaises;

                    auxHabitantes = habitantes[y];
                    habitantes[y] = habitantes[y+1];
                    habitantes[y+1] = auxHabitantes;
                }
            }
        }
        imprimirPaises(paises, habitantes, cantidad, "Vector ordenado alfabeticamente: ");
    }

    /**
     * ============ EJERCICIO 5 ============
     * Consigna: cargar un vector de n elementos y
     * buscar el MENOR numero, contando cuantas veces se repite.
     *
     * Tecnica del "menor":
     *   - suponemos que el menor es el primero (vector[0])
     *   - recorremos el vector y si aparece uno mas chico, actualizamos
     */
    public void ej5MenorYRepetidos(){
        int cant = traerInt("Ingrese cuantos numeros quiere cargar: ");
        float[] numeros = new float[cant];
        for(int x = 0 ; x < cant ; x = x + 1){
            System.out.print("Ingrese elemento " + x + " : " );
            numeros[x] = teclado.nextFloat();
        }

        // suponemos que el primero es el menor
        float numMenor = numeros[0];
        // contamos cuantas veces aparece el menor (empieza en 1 porque el primero ya lo es)
        int repetidos = 1;

        // buscar menor
        for(int x = 1 ; x < cant ; x = x + 1){
            if(numeros[x] < numMenor){
                numMenor = numeros[x];
                repetidos = 1;
            }else{
                if(numeros[x] == numMenor){
                    repetidos = repetidos + 1;
                }
            }
        }

        System.out.println("El numero mas chico de los ingresados es: " + numMenor);
        if(repetidos > 1){
            System.out.println("Se repite " + repetidos + " veces");
        }else{
            System.out.println("No se repite");
        }
    }

    /**
     * ============ EJERCICIO 6 ============
     * Consigna: definir un vector de 5 componentes de tipo float que
     * representen las alturas de cinco personas. Obtener el promedio de
     * las mismas. Contar cuantas personas son mas altas que el promedio
     * y cuantas mas bajas.
     *
     * Pasos:
     *   1. cargar las 5 alturas
     *   2. sumar todas para sacar el promedio (promedio = suma / cantidad)
     *   3. recorrer de nuevo comparando cada altura con el promedio
     */
    public void ej6AlturasPromedio(){
        final int cantidad = 5;
        float[] alturas = new float[cantidad];
        System.out.println("Carga de las alturas de 5 personas");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            alturas[x] = traerFloat("Ingrese la altura de la persona " + (x+1) + " (en metros, ej: 1.75): ");
        }

        // calculo el promedio: primero sumo todo
        float suma = 0;
        for(int x = 0 ; x < cantidad ; x = x + 1){
            suma = suma + alturas[x];
        }
        float promedio = suma / cantidad;
        System.out.println("El promedio de alturas es: " + promedio);

        // ahora cuento cuantas son mas altas que el promedio y cuantas mas bajas
        int masAltas = 0;
        int masBajas = 0;
        for(int x = 0 ; x < cantidad ; x = x + 1){
            if(alturas[x] > promedio){
                masAltas = masAltas + 1;
            }else{
                if(alturas[x] < promedio){
                    masBajas = masBajas + 1;
                }
            }
        }
        System.out.println("Personas mas altas que el promedio: " + masAltas);
        System.out.println("Personas mas bajas que el promedio: " + masBajas);
    }

    /**
     * ============ EJERCICIO 7 ============
     * Consigna: se tienen las notas del primer parcial de los alumnos de
     * dos cursos, el curso A y el curso B, cada curso cuenta con 5 alumnos.
     * Realizar un programa que muestre el curso que obtuvo el mayor
     * promedio general.
     *
     * Son DOS vectores (uno por curso). Para cada uno calculo su promedio
     * y al final comparo los dos promedios para saber cual gana.
     */
    public void ej7CursosPromedio(){
        final int cantidad = 5;
        float[] cursoA = new float[cantidad];
        float[] cursoB = new float[cantidad];

        System.out.println("CARGA DEL CURSO A");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            cursoA[x] = traerFloat("Ingrese la nota del alumno " + (x+1) + " del curso A: ");
        }
        System.out.println("CARGA DEL CURSO B");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            cursoB[x] = traerFloat("Ingrese la nota del alumno " + (x+1) + " del curso B: ");
        }

        // promedio del curso A
        float sumaA = 0;
        for(int x = 0 ; x < cantidad ; x = x + 1){
            sumaA = sumaA + cursoA[x];
        }
        float promedioA = sumaA / cantidad;

        // promedio del curso B
        float sumaB = 0;
        for(int x = 0 ; x < cantidad ; x = x + 1){
            sumaB = sumaB + cursoB[x];
        }
        float promedioB = sumaB / cantidad;

        System.out.println("El promedio del curso A es: " + promedioA);
        System.out.println("El promedio del curso B es: " + promedioB);
        if(promedioA > promedioB){
            System.out.println("El curso con mayor promedio general es el A");
        }else{
            if(promedioB > promedioA){
                System.out.println("El curso con mayor promedio general es el B");
            }else{
                System.out.println("Ambos cursos tienen el mismo promedio");
            }
        }
    }

    /**
     * ============ EJERCICIO 8 ============
     * Consigna: permitir cargar 5 nombres de personas y sus respectivas
     * edades. Luego de realizar la carga imprimir los nombres de las
     * personas mayores de edad (mayores o iguales a 18).
     *
     * Son VECTORES PARALELOS: un vector para los nombres y otro para las
     * edades. La posicion x de un vector corresponde a la misma persona
     * en el otro vector.
     */
    public void ej8NombresEdades(){
        final int cantidad = 5;
        String[] nombres = new String[cantidad];
        int[] edades = new int[cantidad];

        System.out.println("Carga de nombres y edades");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            nombres[x] = traerString("Ingrese el nombre de la persona " + (x+1) + ": ");
            edades[x] = traerInt("Ingrese la edad de " + nombres[x] + ": ");
        }

        // recorremos las dos a la vez y mostramos solo los mayores de edad
        System.out.println("Personas mayores de edad: ");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            if(edades[x] >= 18){
                System.out.println(nombres[x]);
            }
        }
    }

    /**
     * ============ EJERCICIO 9 ============
     * Consigna: se desea almacenar los sueldos de operarios. Cuando se
     * ejecuta el programa se debe pedir la cantidad de sueldos a ingresar.
     * Luego crear un vector con dicho tamaño.
     *
     * Aca la CANTIDAD la decide el usuario con un teclado, y recien
     * despues creamos el vector con new. Es la diferencia con los de
     * tamaño fijo (que usan final int).
     */
    public void ej9SueldosDinamico(){
        int cant = traerInt("Ingrese cuantos sueldos quiere cargar: ");
        float[] sueldos = new float[cant];
        for(int x = 0 ; x < cant ; x = x + 1){
            sueldos[x] = traerFloat("Ingrese el sueldo " + (x+1) + ": ");
        }

        System.out.println("Los sueldos cargados son: ");
        for(int x = 0 ; x < cant ; x = x + 1){
            System.out.println(" - " + sueldos[x]);
        }
    }

    /**
     * ============ EJERCICIO 10 ============
     * Consigna: permitir ingresar un vector de n elementos (ingresar n
     * por teclado). Luego imprimir la suma de todos sus elementos.
     *
     * Tecnica del ACUMULADOR: llevo una variable suma que voy
     * incrementando con cada elemento al recorrer el vector.
     */
    public void ej10SumaElementos(){
        int cant = traerInt("Ingrese cuantos numeros quiere cargar: ");
        float[] numeros = new float[cant];
        for(int x = 0 ; x < cant ; x = x + 1){
            numeros[x] = traerFloat("Ingrese el elemento " + (x+1) + ": ");
        }

        float suma = 0;
        for(int x = 0 ; x < cant ; x = x + 1){
            suma = suma + numeros[x];
        }
        System.out.println("La suma de todos los elementos es: " + suma);
    }

    /**
     * ============ EJERCICIO 11 ============
     * Consigna: una empresa tiene dos turnos, manana y tarde, en los que
     * trabajan ocho empleados, cuatro por la manana y cuatro por la tarde.
     * Almacenar los sueldos de los empleados agrupados por turnos.
     * Imprimir los gastos en sueldos de cada turno.
     *
     * Son DOS vectores separados (uno por turno). En cada uno sumo los
     * sueldos para saber cuanto gasta la empresa en ese turno.
     */
    public void ej11SueldosTurnos(){
        final int cantidad = 4;
        float[] manana = new float[cantidad];
        float[] tarde = new float[cantidad];

        System.out.println("CARGA DEL TURNO MANANA");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            manana[x] = traerFloat("Ingrese el sueldo del empleado " + (x+1) + " de manana: ");
        }
        System.out.println("CARGA DEL TURNO TARDE");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            tarde[x] = traerFloat("Ingrese el sueldo del empleado " + (x+1) + " de tarde: ");
        }

        // gasto en sueldos del turno manana
        float gastoManana = 0;
        for(int x = 0 ; x < cantidad ; x = x + 1){
            gastoManana = gastoManana + manana[x];
        }
        // gasto en sueldos del turno tarde
        float gastoTarde = 0;
        for(int x = 0 ; x < cantidad ; x = x + 1){
            gastoTarde = gastoTarde + tarde[x];
        }

        System.out.println("El gasto en sueldos del turno manana es: " + gastoManana);
        System.out.println("El gasto en sueldos del turno tarde es: " + gastoTarde);
    }

    /**
     * ============ EJERCICIO 12 ============
     * Consigna: realizar un programa que pida la carga de dos vectores
     * numericos enteros de 4 elementos. Obtener la suma de los dos
     * vectores, guardar dicho resultado en un tercer vector del mismo
     * tamaño. Sumar componente a componente.
     *
     * EJEMPLO:
     *   vector1 = [1, 2, 3, 4]
     *   vector2 = [5, 6, 7, 8]
     *   suma    = [6, 8, 10, 12]
     *
     * Es decir: suma[0] = vector1[0] + vector2[0], suma[1] = vector1[1] + vector2[1], etc.
     */
    public void ej12SumaDosVectores(){
        final int cantidad = 4;
        int[] vector1 = new int[cantidad];
        int[] vector2 = new int[cantidad];
        int[] suma = new int[cantidad];

        System.out.println("CARGA DEL PRIMER VECTOR");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            vector1[x] = traerInt("Ingrese el elemento " + (x+1) + " del primer vector: ");
        }
        System.out.println("CARGA DEL SEGUNDO VECTOR");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            vector2[x] = traerInt("Ingrese el elemento " + (x+1) + " del segundo vector: ");
        }

        // sumo componente a componente y lo guardo en el tercer vector
        for(int x = 0 ; x < cantidad ; x = x + 1){
            suma[x] = vector1[x] + vector2[x];
        }

        System.out.println("El vector resultante (suma componente a componente) es: ");
        for(int x = 0 ; x < cantidad ; x = x + 1){
            System.out.println(" - " + suma[x]);
        }
    }

    /**
     * ============ EJERCICIO 13 ============
     * Consigna: cargar un vector de 10 elementos y verificar
     * posteriormente si el mismo esta ordenado de menor a mayor.
     *
     * Tecnica de la BANDERA (flag): supongo que esta ordenado y, si en
     * algun momento encuentro un elemento mayor que el siguiente
     * (vector[x] > vector[x+1]), el flag se pone en falso y ahi termina.
     *
     * OJO: el bucle llega hasta (cantidad-1) y uso vector[x+1], porque
     * no puedo comparar el ultimo con uno que no existe.
     */
    public void ej13EstaOrdenado(){
        final int cantidad = 10;
        int[] vector = new int[cantidad];
        for(int x = 0 ; x < cantidad ; x = x + 1){
            vector[x] = traerInt("Ingrese el elemento " + (x+1) + ": ");
        }

        // bandera: al principio suponemos que esta ordenado
        boolean ordenado = true;
        for(int x = 0 ; x < (cantidad-1) ; x = x + 1){
            if(vector[x] > vector[x+1]){
                ordenado = false;   // encontramos un desorden -> ya no esta ordenado
            }
        }

        if(ordenado){
            System.out.println("El vector esta ordenado de menor a mayor");
        }else{
            System.out.println("El vector NO esta ordenado de menor a mayor");
        }
    }

    /**
     * ============ EJERCICIO 14 (SUGERIDO, no del profe) ============
     * Consigna: cargar un vector de n elementos y permitir BUSCAR un
     * numero. Decir si existe y, si existe, en que posicion esta.
     *
     * ESTE NO ES DEL PROGRAMA DEL PROFE: me lo sugirieron como opcion
     * interesante para tener a mano en el parcial. No es obligatorio
     * pero es un clasico de busqueda lineal.
     *
     * Tecnica:
     *   - uso una BANDERA (boolean) para saber si aparecio o no
     *   - recorro el vector y cuando encuentro el numero, guardo la
     *     posicion y detengo la busqueda (no hace falta seguir)
     */
    public void ej14BuscarNumero(){
        int cant = traerInt("Ingrese cuantos numeros quiere cargar: ");
        float[] numeros = new float[cant];
        for(int x = 0 ; x < cant ; x = x + 1){
            numeros[x] = traerFloat("Ingrese el elemento " + (x+1) + ": ");
        }
        float buscado = traerFloat("Ingrese el numero que quiere buscar: ");

        boolean encontrado = false;
        int posicion = -1;   // -1 significa "no encontrado todavia"
        for(int x = 0 ; x < cant ; x = x + 1){
            if(numeros[x] == buscado){
                encontrado = true;
                posicion = x;   // guardo la primera posicion donde aparece
                break;          // salgo del bucle, ya no sigo buscando
            }
        }

        if(encontrado){
            System.out.println("El numero " + buscado + " existe en el vector");
            System.out.println("Se encuentra en la posicion: " + posicion);
        }else{
            System.out.println("El numero " + buscado + " NO existe en el vector");
        }
    }

    /**
     * ============ EJERCICIO 15 (SUGERIDO, no del profe) ============
     * Consigna: cargar un vector de n elementos y INVERTIRLO (el primero
     * pasa al final, el segundo al anteultimo, etc.). Mostrar el vector
     * invertido.
     *
     * ESTE NO ES DEL PROGRAMA DEL PROFE: me lo sugirieron como opcion
     * interesante para tener a mano en el parcial.
     *
     * Truco: NO hace falta crear otro vector. Recorro hasta la MITAD
     * e intercambio v[i] con v[cant-1-i] usando un AUXILIAR.
     *
     * EJEMPLO:
     *   1 2 3 4
     *   ↓
     *   4 3 2 1
     */
    public void ej15InvertirVector(){
        int cant = traerInt("Ingrese cuantos numeros quiere cargar: ");
        float[] numeros = new float[cant];
        for(int x = 0 ; x < cant ; x = x + 1){
            numeros[x] = traerFloat("Ingrese el elemento " + (x+1) + ": ");
        }

        // recorro hasta la mitad e intercambio el primero con el ultimo
        float aux;
        for(int x = 0 ; x < (cant/2) ; x = x + 1){
            aux = numeros[x];
            numeros[x] = numeros[cant-1-x];
            numeros[cant-1-x] = aux;
        }

        System.out.println("El vector invertido es: ");
        for(int x = 0 ; x < cant ; x = x + 1){
            System.out.println(" - " + numeros[x]);
        }
    }

    // ==================================================================
    // METODO DE PRACTICA (no es un ejercicio exacto, es una HERRAMIENTA)
    // ==================================================================

    /**
     * Herramienta de practica: llenar un vector con numeros al AZAR
     * usando Random para no tener que cargar los datos a mano.
     *
     * random.nextInt(valorMaximo) devuelve un entero entre 0 y valorMaximo-1.
     * Si le sumo 1 -> numeros entre 1 y valorMaximo.
     */
    public void practicaVectorConRandom(){
        Random random = new Random();
        int cant = traerInt("Ingrese cuantos numeros quiere cargar: ");
        int valorMaximo = traerInt("Ingrese el valor maximo que puede tomar cada numero: ");
        int[] vector = new int[cant];
        for(int x = 0 ; x < cant ; x = x + 1){
            vector[x] = random.nextInt(valorMaximo) + 1;
        }
        imprimirVector(vector, cant, "Vector cargado al azar: ");
    }

    // METODOS DE APOYO: los uso para imprimir sin repetir codigo.

    public void imprimirVector(int[] vector, int cant, String mjs){
        System.out.println(mjs);
        for(int x = 0 ; x < cant ; x = x + 1){
            System.out.println(" - " + vector[x]);
        }
    }

    public void imprimirAlumnos(String[] nombres, int[] notas, int cant, String mjs){
        System.out.println(mjs);
        for(int x = 0 ; x < cant ; x = x + 1){
            System.out.println(nombres[x] + " : " + notas[x]);
        }
    }

    public void imprimirPaises(String[] paises, float[] habitantes, int cant, String mjs){
        System.out.println(mjs);
        for(int x = 0 ; x < cant ; x = x + 1){
            System.out.println(paises[x] + " = " + habitantes[x]);
        }
    }
}
