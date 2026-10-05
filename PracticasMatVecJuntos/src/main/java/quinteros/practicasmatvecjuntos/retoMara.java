/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicasmatvecjuntos;

import java.util.Scanner;

/**
 *
 * @author Usuario
Una empresa de transporte desea registrar información sobre los kilómetros recorridos por sus vehículos durante una semana.

Se trabaja con 6 vehículos y 5 días.

Se deberá almacenar la patente de cada vehículo y la cantidad de kilómetros recorridos por cada uno durante cada día.

 - Ingresar la patente de cada vehículo. x
 - Ingresar los kilómetros recorridos por cada vehículo durante los 5 días.x 
 - Mostrar todos los vehículos junto con los kilómetros recorridos en cada uno de los 5 días. x 
 - Obtener el total de kilómetros recorridos por cada vehículo durante la semana. x 
 - Mostrar el total de kilómetros recorridos de cada vehículo. x 
 - Obtener y mostrar el promedio diario de kilómetros recorridos de cada vehículo. x 
 - Mostrar los vehículos cuyo promedio diario sea mayor o igual a 100 kilómetros. x 
 - Informar cuántos vehículos tuvieron un promedio diario menor a 100 kilómetros. x
 - Informar el vehículo que recorrió la mayor cantidad de kilómetros durante toda la semana. x
 - Informar el vehículo que recorrió la menor cantidad de kilómetros durante toda la semana. x
 - Informar cuál fue la mayor cantidad de kilómetros recorridos en un solo día, indicando el vehículo y el número de día. x
 - Informar cuál fue la menor cantidad de kilómetros recorridos en un solo día, indicando el vehículo y el número de día. x
 - Informar cuántos vehículos tuvieron al menos un día en el que recorrieron menos de 80 kilómetros. x
 - Informar cuántos vehículos recorrieron 120 kilómetros o más durante los 5 días. x 
 - Obtener el promedio general de kilómetros recorridos considerando todos los vehículos y todos los días. x
 - Mostrar los vehículos cuyo promedio individual sea superior al promedio general. x
 - Informar el o los vehículos que tuvieron la mayor cantidad de días con 100 kilómetros o más. x 
 - Informar el o los vehículos que tuvieron la mayor cantidad de días con menos de 100 kilómetros. x 
 - Ordenar los vehículos de mayor a menor según su total semanal de kilómetros, manteniendo correctamente relacionada toda la información correspondiente.
 - Mostrar nuevamente los vehículos después del ordenamiento, indicando su patente y su total semanal.
 */
public class retoMara {
    private String[] patentes = new String[6];
    private float[][] km = new float[6][5];
    private float[] acumKm = new float[6];
    private float[] promDiarioVehiculo = new float [6];
    private int[] cantDiasSup100 = new int[6];
    private int[] cantDiasInf100 = new int[6];
    public static final Scanner t = new Scanner(System.in);
    
    public void informar(String mjs){
        System.out.println(mjs);
    }
    
    public String traerString(String mjs){
        System.out.println(mjs);
        return t.nextLine();
    }
    
    public float traerFloat(String mjs){
        System.out.print(mjs);
        float n = t.nextFloat();
        t.nextLine();
        return n;
    }
    
    public void cargarEstructuras(){
        for(int x = 0 ; x < 6 ; x++){
            patentes[x] = traerString("Ingresar la patente del vehiculo n° " +(x+1) + ": ");
            for(int y = 0 ; y < 5 ; y++){
                km[x][y]= traerFloat("Ingresar del vehiculo n° " +(x+1) + " sus km recorridos en el dia "+ (y+1) +": ");
            }
        }
    }
    
    public void mostrarKmPtente(){
        for(int x = 0 ; x < 6 ; x++){
            informar(" vehiculo patente: " +patentes[x]+ ":");
            for(int y = 0 ; y < 5 ; y++){
                informar("km recorridos en el dia "+ (y+1) + " son " + km[x][y] );
            }
        }
    }
    
    public void cargaracumKm(){
        float suma;
        for(int x = 0 ; x < 6 ; x++){
            suma = 0;
            for(int y = 0 ; y < 5 ; y++){
                suma = suma + km[x][y];
            }
            acumKm[x] = suma;
        }
    }
    
    public void mostrarKmAcum(){
        for(int x = 0 ; x < 6 ; x++){
            informar(" vehiculo patente: " +patentes[x]+ ": " + acumKm[x]);
        }
    }
    
    public void cargarpromDiarioVehiculo(){
        for(int x = 0 ; x < 6 ; x++){
            promDiarioVehiculo[x] = acumKm[x] / 5;
        }
    }
    
    public void promDiarioMayorIgual100(){
        int cantMenores = 0;
        for(int x = 0 ; x < 6 ; x++){
            if(promDiarioVehiculo[x] >= 100){
            informar("el vehiculo " + patentes[x] + " tiene un promedio " + promDiarioVehiculo[x] + " que es mayor/igual a 100 km.");
            }else{
                informar("el vehiculo " + patentes[x] + " tiene un promedio " + promDiarioVehiculo[x] + " que es menor a 100 km.");
                cantMenores = cantMenores + 1;
            }
        }
        informar("la cantidad de menores a 100km recorridos son de " + cantMenores + " vehiculos");
    }
    
    public void mayorCantKm(){
        float mayor = acumKm[0];
        int pos = 0;
        for(int x = 0 ; x < 6 ; x++){
            if(acumKm[x] > mayor){
                mayor = acumKm[x];
                pos = x;
            }
        }
        informar("el vehiculo con mayores km recoirridos es " + patentes[pos] + " con " + mayor + "km");
    }
    public void menorCantKm(){
        float menor = acumKm[0];
        int pos = 0;
        for(int x = 0 ; x < 6 ; x++){
            if(acumKm[x] < menor){
                menor = acumKm[x];
                pos = x;
            }
        }
        informar("el vehiculo con menores km recoirridos es " + patentes[pos] + " con " + menor + "km");
    }
    
    public void buscarMayorKmXdia(){
        float mayor = km[0][0];
        int pos = 0;
        for(int x = 0 ; x < 6 ; x++){
            for(int y = 0 ; y < 5 ; y++){
                if(km[x][y] > mayor){
                    mayor = km[x][y];
                    pos = y;
                }
            }
        }
        informar("el mayor recorrido de km fue hecho el dia" + (pos+1) + " del vehiculo "+ patentes[pos]
                + " con un total de " + mayor + "km ");
    }
    
    public void buscarMenorKmXdia(){
        float menor = km[0][0];
        int pos = 0;
        for(int x = 0 ; x < 6 ; x++){
            for(int y = 0 ; y < 5 ; y++){
                if(km[x][y] < menor){
                    menor = km[x][y];
                    pos = y;
                }
            }
        }
        informar("el menor recorrido de km fue hecho el dia" + (pos+1) + " del vehiculo "+ patentes[pos]
                + " con un total de " + menor + "km ");
    }
    
    public void AlMenosUnDia80km(){
        boolean AlMenosUnDia;
        int cantVehiculos = 0;
        for(int x = 0 ; x < 6 ; x++){
            AlMenosUnDia = false;
            for(int y = 0 ; y < 5 ; y++){
                if(km[x][y] < 80){
                    AlMenosUnDia = true;
                }
            }
            if(AlMenosUnDia){
                informar("el vehiculo "+ patentes[x] + " tuvo al menos un  dia que recorrio menos de 80 km.");
                cantVehiculos = cantVehiculos + 1;
            }
        }
        informar("la cant de vehiculos que al menos un dia tuvieron un recorrido de menos de 80 km es de: "+ cantVehiculos);
    }
    
    public void Mas120km(){
        int cantVehiculos = 0;
        for(int x = 0 ; x < 6 ; x++){ 
            if(acumKm[x] > 120){
                informar("El vehiculo " + patentes[x]+" recorrio mas de 120 km");
                cantVehiculos = cantVehiculos + 1;
            }
        }
        informar("la cant de vehiculos que tuvieron un recorrido de mas de 120 km es de: "+ cantVehiculos);
    }
    
    public void sacarPromgeneral(){
        float suma = 0; 
        float promGeneral;
        for(int x = 0 ; x < 6 ; x++){
            suma = suma + acumKm[x];
        }
        promGeneral = suma / (6*5);
        informar("el promedio general es de "+ promGeneral);
        promIndSupPromGene(promGeneral);
    }
    
    public void promIndSupPromGene(float pg){
        for(int x = 0 ; x < 6 ; x++){
            if(promDiarioVehiculo[x]>pg){
               informar("el vehiculo " + patentes[x] + " tiene un promedio individual superior al promedio general"); 
            }
        }
    }
    
    //- Informar el o los vehículos que tuvieron la mayor cantidad de días con 100 kilómetros o más.
    
    public void mayorCantDias(){
        int cantDias100;
        float mayor = 0;
        for(int x = 0 ; x < 6 ; x++){
            cantDias100 = 0;
            for(int y = 0 ; y < 5 ; y++){
                if(km[x][y] > 100){
                    cantDias100 = cantDias100 + 1;
                }
            }
            if(mayor < cantDias100){
                mayor = cantDias100;
            }
            if(cantDias100 != 0){
                informar("El vehiculo " + patentes[x] + " tiene " + cantDias100 + " dias superior a 100km");
            }
            cantDiasSup100[x] =  cantDias100;
        }
        informar("vehiculos que tuvieron la mayor cantidad de días con 100 kilómetros o más.");
        for(int x = 0 ; x < 6 ; x++){
            if(mayor == cantDiasSup100[x] ){
                informar("El vehiculo " + patentes[x] +" tiene la mayor cantidad de dias que supero a 100km"
                        + " siendo un total de " + mayor + " dias");
            }
        }
    }
    
    public void menorCantDias(){
        int cantDias100;
        float menor = 0;
        for(int x = 0 ; x < 6 ; x++){
            cantDias100 = 0;
            for(int y = 0 ; y < 5 ; y++){
                if(km[x][y] > 100){
                    cantDias100 = cantDias100 + 1;
                }
            }
            if(menor < cantDias100){
                menor = cantDias100;
            }
            if(cantDias100 != 0){
                informar("El vehiculo " + patentes[x] + " tiene " + cantDias100 + " dias inferior a 100km");
            }
            cantDiasInf100[x] = cantDias100;
        }
        informar("vehiculos que tuvieron la menor cantidad de días con 100 kilómetros o más.");
        for(int x = 0 ; x < 6 ; x++){
            if(menor == cantDiasInf100[x] ){
                informar("El vehiculo " + patentes[x] +" tiene la menor cantidad de dias que su recorrido fue inferior a 100km. "
                        + " siendo un total de " + menor + " dias");
            }
        }
    }
    
    

    public static void main(String[] args) {
        System.out.println("Reto Mara!");
        retoMara p = new retoMara();
        p.cargarEstructuras();
        p.mostrarKmPtente();
        p.cargaracumKm();
        p.mostrarKmAcum();
        p.cargarpromDiarioVehiculo();
        p. promDiarioMayorIgual100();
        p.mayorCantKm();
        p.menorCantKm();
        p. buscarMayorKmXdia();
        p.buscarMenorKmXdia();
        p.AlMenosUnDia80km();
        p.Mas120km();
        p.sacarPromgeneral();
        p.mayorCantDias();
        p.menorCantDias();
    }
}
