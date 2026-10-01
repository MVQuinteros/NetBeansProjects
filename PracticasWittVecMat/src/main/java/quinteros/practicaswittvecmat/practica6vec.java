/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 6. Cargar nombres de N países y su cantidad de habitantes.
 * Ordenar **por habitantes de mayor a menor** (arrastrando el nombre).
 */
public class practica6vec {
    private String[] vectorPaises;
    private int[] vectorHabitantes;
    
    public void definirTamaño(){
        int cantidad = Utilidades.traerInt("Ingrese la cantidad de paises que quiere ingresar: ");
        vectorPaises = new String[cantidad];
        vectorHabitantes = new int[cantidad];
    }
    
    public void cargarPaises(){
        for(int x = 0; x < vectorPaises.length ; x = x + 1){
            vectorPaises[x] = Utilidades.traerString("Ingrese el nombre del Pais: ");
            vectorHabitantes[x] = Utilidades.traerInt("Ingrese la cantidad de habitantes de " + vectorPaises[x] + ": ");
        }
        imprimirVector("Vector ingresado: ");
    }
    
    public void ordenarHabitantes(){
        String auxPais;
        int auxHabitantes;
        for(int x = 0 ; x < (vectorPaises.length - 1) ; x = x + 1){
            for(int y = 0 ; y < (vectorPaises.length -1) ; y = y + 1){
                if(vectorHabitantes[y] < vectorHabitantes[y + 1]){
                    
                    auxHabitantes = vectorHabitantes[y];
                    vectorHabitantes[y] = vectorHabitantes[y + 1];
                    vectorHabitantes[y+1] = auxHabitantes;
                    
                    auxPais = vectorPaises[y];
                    vectorPaises[y] = vectorPaises[y + 1];
                    vectorPaises[y + 1] = auxPais;
                }
            }
        }
        imprimirVector("Vector ordenado mayor a menor: ");
    }
    
    public void imprimirVector(String mjs){
        System.out.println(mjs);
        for(int x = 0 ; x < vectorPaises.length ; x = x + 1 ){
            System.out.println(" - " + vectorPaises[x] + " tiene " + vectorHabitantes[x] + " habitantes.");
        }
    }
}
