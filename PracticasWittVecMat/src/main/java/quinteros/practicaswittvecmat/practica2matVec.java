/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 1. Notas de alumnos
Cargar una matriz de N x 3, donde cada fila representa un alumno y las columnas representan sus tres notas.
Cargar además un vector con los nombres de los alumnos.
Calcular y mostrar el promedio de cada alumno junto con su nombre.
 */
public class practica2matVec {
    private String[] alumno;
    private float[][] notas;
    private float[] promedio;
    
    public void inicio(){
        int cantAlumnos = Utilidades.traerInt("Ingresar cuantos alumnos quiere registrar: ");
        alumno = new String[cantAlumnos];
        notas = new float[cantAlumnos][3];
        promedio = new float[cantAlumnos];
    }
    
    public void cargarInfo(){
        float suma = 0;
        for(int x = 0 ; x < alumno.length ; x = x + 1){
            alumno[x] = Utilidades.traerString("Ingrese el nombre completo del alumno numero " + x + ": ");
            for(int y = 0 ; y < 3 ; y = y + 1){
                notas[x][y] = Utilidades.traerFloat("Ingrese la nota numero " +  y + " del alumno " + alumno[x] + ": ");
                suma = suma + notas[x][y];
            }
            promedio[x] = suma / 3;
        }
    }
    
    public void informar(){
        for(int x = 0 ; x < alumno.length ; x = x + 1){
            System.out.println("El estudiante " + alumno[x] + " saco: ");
            for(int y = 0 ; y < 3 ; y = y + 1){
                System.out.println("Examen numero " + x + ": " + notas[x][y]);
            }
            System.out.println("Entonces su promedio es de: " + promedio[x]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica2matVec xd = new practica2matVec();
        xd.inicio();
        xd.cargarInfo();
        xd.informar();
    }
}
