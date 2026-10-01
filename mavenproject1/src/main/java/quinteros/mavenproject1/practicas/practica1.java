/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.mavenproject1.practicas;

import java.util.Scanner;

/**
 *

EJERCICIO

Cargar un vector de n números reales (float).

Mostrar:

mayor número
menor número
promedio
cuántos positivos
cuántos negativos
cuántas veces se repite el mayor


 * @author Usuario
 */
public class practica1 {
    
    private static final Scanner teclado = new Scanner(System.in);
    private float[] vector;
    
    public float traerFloat(String mjs){
        System.out.print(mjs);
        String ingreso = teclado.nextLine().replace(",", ".");
        float flo = Float.parseFloat(ingreso);
        return flo;
    }
    
    public int traerInt(String mjs){
        System.out.print(mjs);
        int num = Integer.parseInt(teclado.nextLine());
        return num;
    }
    
    public void cargarVector(){
        int cant = traerInt("Ingrese la cantidad de numeros float que desea ingresar: ");
        vector = new float[cant]; // definimos el vector de cantidad variable
        for(int x = 0; x < cant; x = x + 1){
            vector[x] = traerFloat("Ingrese el numero " + (x+1) + " : ");
        }
        detectarMayorYRepetidos(cant);
        detectarMenor(cant);
        sacarPromedio(cant);
        contadorPositivosNegativos(cant);
        ordenChequeoMenorMayor(cant);
        ordenChequeoMayorMenor(cant);
        ordenarMenorMayor(cant);
        ordenarMayorMenor(cant);
    }
    
    public void detectarMayorYRepetidos(int cantidad){
        float numMayor = vector[0];
        int repetido = 1;

        for(int x = 1; x < cantidad; x = x + 1){ // importante, siempre que tomemos por hecho que 
            // el primer elemento del vector que es algo, el for debe empezar por 1, 
            //sino lo estariamos contando 2 veces.

            if(vector[x] > numMayor){
                numMayor = vector[x];
                repetido = 1;
            }else if(vector[x] == numMayor){
                repetido = repetido + 1;
            }
        }

        System.out.println("El numero mayor es: " + numMayor);
        System.out.println("Se repite: " + repetido + " veces");
    }
    
    public void detectarMenor(int cantidad){
        float menor = vector[0];
        int direccion = 0;
        
        for(int x = 1; x < cantidad; x = x + 1){
        // empieza en 1 por que ya contamos el 0 como menor!! no olvidar.
            if(vector[x]< menor){
                menor = vector [x];
                direccion = x;
            }
        }
        
        System.out.println("El numero menor es: " + menor);
        System.out.println("Aparece en la direccion: " + direccion);
    }
    
    public void sacarPromedio(int cantidad){
        float promedio;
        float suma = 0;
        
        for(int x = 0; x < cantidad; x = x + 1){
            suma = suma + vector[x];
        }
        promedio = suma / cantidad;
        System.out.println("La suma de todos los numeros del vector es de: " + suma);
        System.out.println("El  promedio de este vector es de: " + promedio);
    }
    
    public void contadorPositivosNegativos(int cantidad){
        int positivos = 0;
        int negativos = 0;
        for(int x = 0; x < cantidad; x = x + 1){
            if(vector[x]<0){
                System.out.println(" - " + vector[x] + " Es Negativo");
                negativos = negativos + 1;
            }else{
                if(vector[x]>0){
                    System.out.println(" - " + vector[x] + " Es positivo");
                    positivos = positivos + 1;
                }else{
                    System.out.println(" - " + vector[x] + " Es 0 xdxd");
                }
            }
        }
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
    }
    
    public void ordenChequeoMenorMayor(int cantidad){ // de menor a mayor
        int direccion = 0;
        
        do{
            if(vector[direccion] <= vector[direccion + 1]){
                direccion = direccion + 1;
                if(direccion == (cantidad-1)){
                    System.out.println("El Vector esta ordenado de menor a mayor");
                }
            }else{
                System.out.println("El Vector esta desordenado");
                direccion = 999;
            }
        }while(direccion < (cantidad-1));
    }
    
    public void ordenChequeoMayorMenor(int cantidad){ // de mayor a menor
        int direccion = 0;
        
        do{
            if(vector[direccion] >= vector[direccion + 1]){
                direccion = direccion + 1;
                if(direccion == (cantidad-1)){
                    System.out.println("El Vector esta ordenado de mayor a menor");
                }
            }else{
                System.out.println("El Vector esta desordenado");
                direccion = 999;
            }
        }while(direccion < (cantidad-1));
    }
    
    public void ordenarMenorMayor(int cantidad){ 
        float aux;
        for(int x = 0; x < (cantidad-1); x = x + 1){
            for(int y = 0; y < (cantidad-1); y = y + 1){
                if(vector[y] > vector[y+1]){
                    aux = vector[y];
                    vector[y] = vector[y+1];
                    vector[y+1] = aux;
                }
            }
        }
        imprimirVectorOrdenado(cantidad, "El vector ordenado de menor a mayor es: ");
    }
    
    public void ordenarMayorMenor(int cantidad){
        float aux;
        for(int x = 0; x < (cantidad-1); x = x + 1){
            for(int y = 0; y < (cantidad-1) ; y = y + 1){
                if(vector[y]< vector[y+1]){
                    aux = vector[y];
                    vector[y] = vector[y+1];
                    vector[y+1] = aux;
                }
            }
        }
        imprimirVectorOrdenado(cantidad, "El vector ordenado de mayor a menor es: ");
    }
    
    public void imprimirVectorOrdenado(int cant, String mjs){
        System.out.println(mjs);
        for(int x = 0; x < cant ; x = x + 1){
            System.out.println(" # " + vector[x]);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        practica1 prac = new practica1(); 
        prac.cargarVector();
    }
}
