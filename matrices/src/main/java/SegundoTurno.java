
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 * vector nombre, 4
 * matriz media mensual 4 y 3
 * vector media trimestral 4
 */
public class SegundoTurno {
    private static final Scanner teclado = new Scanner(System.in);
    private String[] nombre = new String[4];
    private float [] mediaTrimestral = new float[4];
    private float [][] mediaMensual = new float [4][3];
    
    public void cargarPais(){
        for(int x = 0 ; x < 4 ; x = x + 1){
            System.out.print("Cargar pais " + (x+1) + ": ");
            nombre[x]= teclado.next();
            cargarTemperatura(x);
        }
    }  
    
    public void cargarTemperatura(int indicePais){
        for(int x = 0 ; x < 3 ; x = x + 1){
            System.out.print("Cargar temperatura " + (x+1) + ": ");
            mediaMensual[indicePais][x] = teclado.nextFloat();
        }
    }
    // esta bien asi, otra forma pero podes meter todo en uno, lo toma por valido xdxd. god entonces. 
    public void calcularMedias(){
        float sumaMediaMensual = 0;
        for(int x = 0 ; x < 4 ; x = x + 1){
            //posibilidad interesante pero grasa pero valida jajaja
            //sumaMediaMensual = mediaMensual[x][0] + mediaMensual[x][1] + mediaMensual[x][2];
            sumaMediaMensual=0;
            for(int y = 0 ; y < 3 ; x = x + 1){
                sumaMediaMensual = sumaMediaMensual + mediaMensual[x][y];
            }
        }
        
    }
    
}
