/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 7. Cargar N edades y contar cuántas personas tienen:
   - menos de 18, entre 18 y 60, más de 60.
 */
public class practica7vec {
    private int[] vectorEdades;
    
    public void tamañoVector(){
        vectorEdades = new int [Utilidades.traerInt("Ingresa la cantidad de edades que va a ingresar: ")];
    }
    public void cargarVectorEdades(){
        System.out.println();
        for(int x = 0 ; x < vectorEdades.length ; x = x + 1){
            vectorEdades[x] = Utilidades.traerInt("Ingresa la edad de la persona " + (x+1) + ": ");
        }
    }
    public void clasificarEdades(){
        int menores18 = 0;
        int entre18y60 = 0;
        int mayores60 = 0;
        for(int x = 0 ; x < vectorEdades.length ; x = x + 1){
            if(vectorEdades[x]<18){
                menores18 = menores18 + 1;
            }else{
                if(vectorEdades[x] <= 60){
                    entre18y60 = entre18y60 + 1;
                }else{
                    mayores60 = mayores60 + 1;
                }
            }
        }
        informar(menores18, entre18y60, mayores60);
    }
    public void informar(int men18, int men60, int may60){
        System.out.print("Edades clasificadas: ");
        System.out.println("Las personas menores de 18 años son: " + men18);
        System.out.println("Las personas que tienen entre 18 y 60 años son: " +  men60);
        System.out.println("Las personas mayores de 60 son: " + may60);
    }
}
