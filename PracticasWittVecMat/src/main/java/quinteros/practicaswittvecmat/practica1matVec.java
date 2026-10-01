/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 1. **★** Estacionamiento: un vector con las horas que estuvo cada auto (N autos) y una tarifa por hora cargada por teclado.
 * Calcular y mostrar cuánto debe pagar cada auto y el total recaudado.
 */
public class practica1matVec {
    private float[] horas;
    private String[] vehiculo;
    private float[] pagoPorAuto;
    private float tarifa = 500;
    
    public void definirVectores(){
        int cantAutos = Utilidades.traerInt("Ingresar la cantidad de autos que desea ingresar: ");
        vehiculo = new String[cantAutos];
        horas = new float[cantAutos];
        pagoPorAuto = new float[cantAutos];
    }
    
    public void cargarInfo(){
        for(int x = 0 ; x < vehiculo.length ; x = x + 1){
            vehiculo[x] = Utilidades.traerString("Ingresar patente del auto: ");
            horas[x] = Utilidades.traerInt("Ingresar las horas que estuvo estacionado: ");
            pagoPorAuto[x] = tarifa * horas[x];
        }
    }
    
    public float totalRecaudado(){
        float recaudacion = 0;
        for(int x = 0 ; x < vehiculo.length ; x = x + 1){
            recaudacion = recaudacion + pagoPorAuto[x];
        }
        return recaudacion;
    }
    
    public void informar(){
        System.out.println("La tarifa de hoy es de: " + tarifa);
        for(int x = 0 ; x < vehiculo.length ; x = x + 1){
            System.out.println(" |     " + vehiculo[x] + "     | " + horas[x] + " | " + pagoPorAuto[x]);
        }
        System.out.println("El total recaudado es de " + totalRecaudado()+ " pesos. ");
    }
    
    public static void main(String[] args) {
        System.out.println("logica redonda");
        practica1matVec xd = new practica1matVec();
        xd.definirVectores();
        xd.cargarInfo();
        xd.informar();
    }
}
