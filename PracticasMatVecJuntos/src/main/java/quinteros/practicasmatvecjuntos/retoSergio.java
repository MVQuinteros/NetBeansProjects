/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 * /**Ejercicio avanzado — Rendimiento de alumnos
Una institución tiene N alumnos y registra las notas obtenidas por cada alumno en 5 evaluaciones durante el año.
* 
Realizar un programa en Java que permita:
- Ingresar la cantidad N de alumnos. x
- Cargar el nombre de cada alumno. x 
- Cargar las 5 notas de cada alumno. x 
- Mostrar todas las notas cargadas. x 
- Generar un vector acumulador con la suma total de notas de cada alumno. x 
- Mostrar el total de puntos obtenido por cada alumno. x
- Calcular y mostrar el promedio individual de cada alumno. x 
- Mostrar los alumnos que tienen un promedio mayor o igual a 6. x
- Contar cuántos alumnos tienen un promedio menor a 6. x
- Determinar el alumno con el mayor promedio. x
- Determinar el alumno con el menor promedio. x
- Determinar la nota más alta de toda la matriz, indicando:
    alumno
    número de evaluación
    nota.
    * aca sergio, se re cebo mall. vamos a ver que sale piumba
- Determinar la nota más baja de toda la matriz, indicando:
    alumno
    número de evaluación
    nota.
- Contar cuántos alumnos tuvieron al menos una nota menor a 4. x 
- Contar cuántos alumnos aprobaron todas las evaluaciones, considerando aprobada una nota >= 6. x
- Calcular el promedio general de todas las notas de todos los alumnos. x
- Mostrar los alumnos cuyo promedio individual esté por encima del promedio general. x
- Determinar qué alumno obtuvo la mayor cantidad de notas aprobadas. x 
- Determinar qué alumno obtuvo la mayor cantidad de notas desaprobadas. x
- Ordenar los alumnos de mayor a menor según su promedio, manteniendo correctamente asociados los nombres. x
 */

public class retoSergio {
    public static final Scanner t = new Scanner(System.in);
    private float[][] notas;
    private String[] nombres;
    private float[] acumuladorNotas;
    private float[] acumuladorPromedios;
    private float[] CantEvaluacionesAprobadas;  
    private float[] CantEvaluacionesDesaprobadas;  
    
    public String traerString (String mjs){
        System.out.print(mjs);
        return t.nextLine();
    }
    
    public float traerFloat(String mjs){
        System.out.print(mjs);
        float numero = t.nextFloat();
        t.nextLine();
        return numero;
    }
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        int numero = t.nextInt();
        t.nextLine();
        return numero;
    }
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public void definirEstructuras(){
        int cantAlumnos = traerInt("Ingrese la cantidad de alumnos que desea ingresar al sistema: ");
        notas = new float[cantAlumnos][5];
        nombres = new String[cantAlumnos];
        acumuladorNotas = new float [cantAlumnos];
        acumuladorPromedios = new float [cantAlumnos];
        CantEvaluacionesAprobadas = new float [cantAlumnos];
        CantEvaluacionesDesaprobadas = new float [cantAlumnos];
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < nombres.length ; x++){
            nombres[x] = traerString("ingrese el nombre completo del alumno n°" + (x+1) + ": ");
            for(int y = 0 ; y < 5 ; y++){
                notas[x][y]= traerFloat("ingrese la nota del alumno/a " + nombres[x] + " del examen n°" + (y+1)+": ");
            }
        }
    }
    
    public void mostrarNotas(){
        informar("----- las notas cargadas de cada alumno -----");
        for(int x = 0 ; x < nombres.length ; x++){
            informar(nombres[x]);
            for(int y = 0 ; y < 5 ; y++){
                informar("nota n°" + (y+1) + ": " + notas[x][y]);
            }
        }
    }
    
    public void cargarAcumuladorNotas(){
        float suma;
        for(int x = 0 ; x < nombres.length ; x++){
            suma = 0;
            for(int y = 0 ; y < 5 ; y++){
                suma = suma+ notas[x][y];
            }
            acumuladorNotas[x] = suma;
        }
    }
    
    public void mostrarNotasAcumuladas(){
        informar("----- total de puntos obtenidos por cada alumno -----");
        for(int x = 0 ; x < nombres.length ; x++){
            informar("alumno/a: " + nombres[x] + " - puntos: "+ acumuladorNotas[x]);
        }
    }
    
    public void sacarPromedioPorAlumno(){
        for(int x = 0 ; x < nombres.length ; x++){
            acumuladorPromedios[x] = acumuladorNotas[x] / 5;
        }
    }
    
    public void mostrarPromedioPorAlumnos(){
        informar("----- promedios por cada alumno -----");
        for(int x = 0 ; x < nombres.length ; x++){
            informar("alumno/a: " + nombres[x] + " - promedio: "+ acumuladorPromedios[x]);
        }
    }
    
    public void filtrarAlumnosPorPromedio(){
        informar("----- alumnos filtrados por promedio -----");
        int mayoresOiguales6 = 0;
        int menores = 0;
        for(int x = 0 ; x < nombres.length ; x++){
            if(acumuladorPromedios[x] >= 6){
                informar("alumno/a: " + nombres[x] + " - promedio: "+ acumuladorPromedios[x]);
                informar("El alumno tiene un promedio mayor o igual a 6. ");
                mayoresOiguales6 = mayoresOiguales6 + 1;
            }else{
                informar("alumno/a: " + nombres[x] + " - promedio: "+ acumuladorPromedios[x]);
                informar("El alumno tiene un promedio mayor o igual a 6. ");
                menores =menores + 1;
            }
        }
        informar("la cantidad de alumnos que con su promedido superan o igualan la cantidad 6 son: " + mayoresOiguales6);
        informar("la cantidad de alumnos que con su promedido estan por debajo de la cantidad 6 son: " + menores);
    }
    
    public void buscarMayorProm(){
        float mayor = acumuladorPromedios[0];
        String alumnoNombre = nombres[0];
        informar("----- Mayor promedio -----");
        for(int x = 0 ; x < nombres.length ; x++){
            if(mayor < acumuladorPromedios[x]){
                mayor = acumuladorPromedios[x];
                alumnoNombre = nombres[x];
            }
        }
        informar("el alumno con mayor promedio es " + alumnoNombre + " con un promedio de " + mayor);
    }
    
    public void buscarMenorProm(){
        float menor = acumuladorPromedios[0];
        String alumnoNombre = nombres[0];
        informar("----- Menor promedio -----");
        for(int x = 0 ; x < nombres.length ; x++){
            if(menor > acumuladorPromedios[x]){
                menor = acumuladorPromedios[x];
                alumnoNombre = nombres[x];
            }
        }
        informar("el alumno con menor promedio es " + alumnoNombre + " con un promedio de " + menor);
    }
    
    public void buscarMayorNota(){
        informar("----- Buscar Mayor Nota -----");
        float mayor = notas[0][0];
        String nombre = nombres[0];
        int numeroNota = 0;
        for(int x = 0 ; x < nombres.length ; x++){
            for(int y = 0 ; y < 5 ; y++){
                if(mayor< notas[x][y]){
                    mayor = notas[x][y];
                    nombre = nombres[x];
                    numeroNota = y;
                }
            }
        }
        informar("el alumno/a con la mayor nota es " + nombre + " con la evaluacion n°" + (numeroNota+1) +  
                " con la calificacion de " + mayor);
    }
    
    public void buscarMenorNota(){
        informar("----- Buscar Menor Nota -----");
        float menor = notas[0][0];
        String nombre = nombres[0];
        int numeroNota = 0;
        for(int x = 0 ; x < nombres.length ; x++){
            for(int y = 0 ; y < 5 ; y++){
                if(menor > notas[x][y]){
                    menor = notas[x][y];
                    nombre = nombres[x];
                    numeroNota = y;
                }
            }
        }
        informar("el alumno/a con la mayor nota es " + nombre + " con la evaluacion n°" + (numeroNota+1) +  
                " con la calificacion de " + menor);
    }
    
    public void buscarNotasMenor4(){
        int alumnosNotaMenor4 = 0;
        boolean alMenosUnaVez;
        for(int x = 0 ; x < nombres.length ; x++){
            alMenosUnaVez = false;
            for(int y = 0 ; y < 5 ; y++){
                if(notas[x][y]<4){
                    alMenosUnaVez = true;
                }
            }
            if(alMenosUnaVez){
                informar("el alumno/a " + nombres[x] + " al menos una vez se saco una nota menor que 4");
                alumnosNotaMenor4 = alumnosNotaMenor4+1;
            }else{
                informar("el alumno/a " + nombres[x]+ " no tuvo ninguna nota menor que 4");
            }
        }
        informar("La cantidad de alumnos que obtuvieron al menos una vez una nota menor que 4 son " + alumnosNotaMenor4);
    }
    
    public void contarAlumnosAprobados(){
        informar("----- Alumnos que aprobaron todas las evaluaciones -----");
        int contadorAlumnosAprobados = 0;
        int notasMayorIgual6;
        for(int x = 0 ; x < nombres.length ; x++){
            notasMayorIgual6 = 0;
            for(int y = 0 ; y < 5 ; y++){
                if(notas[x][y]>=6){
                    notasMayorIgual6 = notasMayorIgual6+ 1;
                }
            }
            if(notasMayorIgual6 == 5){
                contadorAlumnosAprobados =contadorAlumnosAprobados+1;
            }
        }
        informar("La cantidad de alumnos que aprobaron todas las evaluaciones con notas superiores o iguales a 6 son: " + contadorAlumnosAprobados);
    }
    
    public void calcularPromGeneral(){
        float promGeneral;
        float suma = 0 ;
        for(int x = 0 ; x < nombres.length ; x++){
            suma = suma + acumuladorNotas[x];
        }
        promGeneral = suma / (nombres.length * 5);
        informar("El promedio General de las notas de los alumnos es de "+promGeneral +" en total.");
        buscarAlumnosSuperiorPromGeneral(promGeneral);
    }
    
    public void buscarAlumnosSuperiorPromGeneral(float pg){
        for(int x = 0 ; x < nombres.length ; x++){
            if(pg < acumuladorPromedios[x]){
                informar("El alumno/a "+ nombres[x] + " supera con su promedio individual de " + acumuladorPromedios[x] + 
                        " al promedio general el cual es " + pg);
            }
        }
    }
    
    public void buscarAlumnoMasNotasAprobadas(){
        informar("----- el/los Alumnos que aprobaron mas evaluaciones-----");
        cargarCantEvaluacionesAprobadas();
        float mayor = CantEvaluacionesAprobadas[0];
        for(int x = 0 ; x < nombres.length ; x++){
            if(CantEvaluacionesAprobadas[x] > mayor){
                mayor = CantEvaluacionesAprobadas[x];
            }
        }
        for(int x = 0 ; x < nombres.length ; x++){
            if(CantEvaluacionesAprobadas[x] == mayor){
                informar("el alumno/a " + nombres[x] + " tiene la mayor cantidad de evaluaciones aprobadas. "
                        + "aprobo un total de "+ mayor);
            }
        }
    }
    
    public void cargarCantEvaluacionesAprobadas(){
        int notasMayorIgual6;
        for(int x = 0 ; x < nombres.length ; x++){
            notasMayorIgual6 = 0;
            for(int y = 0 ; y < 5 ; y++){
                if(notas[x][y]>=6){
                    notasMayorIgual6 = notasMayorIgual6  + 1;
                }
            }
            CantEvaluacionesAprobadas[x] = notasMayorIgual6; 
        }
    }
    
    public void buscarAlumnoMasNotasDesaprobadas(){
        informar("----- el/los Alumnos que desaprobaron mas evaluaciones-----");
        cargarCantEvaluacionesDesaprobadas();
        float masDesaprobadas = CantEvaluacionesDesaprobadas[0];
        for(int x = 0 ; x < nombres.length ;x++){
            if(masDesaprobadas < CantEvaluacionesDesaprobadas[x]){
                masDesaprobadas = CantEvaluacionesDesaprobadas[x];
            }
        }
        for(int x = 0 ; x < nombres.length ;x++){
            if(masDesaprobadas == CantEvaluacionesDesaprobadas[x]){
                informar("El alumno/a " + nombres[x] + " desaprobaron la mayor cantidad de evaluaciones desaprobadas. "
                        + "con un total de " + masDesaprobadas +" desaprobadas");
            }
        }
    }
    
    public void cargarCantEvaluacionesDesaprobadas(){
        int notasMenor6;
        for(int x = 0 ; x < nombres.length ; x++){
            notasMenor6 = 0;
            for(int y = 0 ; y < 5 ; y++){
                if(notas[x][y]<6){
                    notasMenor6 = notasMenor6 + 1;
                }
            }
            CantEvaluacionesDesaprobadas[x] =  notasMenor6;
        }
    }
    
    public void ordenarMayorMenorProm(){
        float auxProm;
        String auxNom;
        for(int x = 0 ; x < nombres.length-1 ; x++){
            for(int y = 0 ; y < nombres.length-1  ; y++){
                if(acumuladorPromedios[y] < acumuladorPromedios[y+1]){
                    auxProm = acumuladorPromedios[y];
                    acumuladorPromedios[y] = acumuladorPromedios[y+1];
                    acumuladorPromedios[y+1] = auxProm;
                    
                    auxNom = nombres[y];
                    nombres[y]=nombres[y+1];
                    nombres[y+1] = auxNom;
                }
            }
        }
        mostrarPromedioPorAlumnos();
    }
    
    
    public static void main(String[] args) {
        System.out.println("Reto Sergio!");
        retoSergio s = new retoSergio();
        s.definirEstructuras();
        s.cargarEstructuras();
        s.mostrarNotas();
        s.cargarAcumuladorNotas();
        s.mostrarNotasAcumuladas();
        s.sacarPromedioPorAlumno();
        s.mostrarPromedioPorAlumnos();
        s.filtrarAlumnosPorPromedio();
        s.buscarMayorProm();
        s.buscarMenorProm();
        s.buscarMayorNota();
        s.buscarMenorNota();
        s.buscarNotasMenor4();
        s.contarAlumnosAprobados();
        s.calcularPromGeneral();
        s.buscarAlumnoMasNotasAprobadas();
        s.buscarAlumnoMasNotasDesaprobadas();
        s.ordenarMayorMenorProm();
    }
}
