/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quinteros.practicaswittvecmat;

/**
 *
 * @author Usuario
 * 
 * 5. **★** Cargar los nombres de N alumnos y sus notas. Mostrar:
   - el promedio de notas,
   - el nombre del alumno con la nota más alta,
   - la nota más baja.
   * 
 */
public class practica5vec {
    
    private String[] vectorNombres;
    private Float[] vectorNotas;
    
    public void definirVector(){
        int cantidad = Utilidades.traerInt("Ingrese la cantidad de alumnos que desea registrar: ");
        vectorNombres = new String[cantidad];
        vectorNotas = new Float[cantidad];
    }
    
    public void cargarNombresNotas(){
        for(int x = 0 ; x < vectorNombres.length ; x = x + 1){
            vectorNombres[x] = Utilidades.traerString("Ingresa el nombre del alumno/a: ");
            vectorNotas[x]= Utilidades.traerFloat("Ingresa la nota del alumno/a " + vectorNombres[x]+ " :");
        }
    }
    
    public String sacarPromedioNotas(){
        float promedio;
        float sumaNotas = 0;
        for(int x = 0 ; x < vectorNotas.length ; x = x + 1){
            sumaNotas = sumaNotas + vectorNotas[x];
        }
        promedio = sumaNotas / vectorNotas.length;
        return "El promedio de las notas cargadas es de: " + promedio;
    }
    
    public String notaAlta(){
        float notaAlta = vectorNotas[0];
        String nombreAlumno = vectorNombres[0];
        for(int x = 0 ; x < vectorNotas.length ; x = x + 1){
            if(vectorNotas[x] > notaAlta){
                notaAlta = vectorNotas[x];
                nombreAlumno = vectorNombres[x];
            }
        }
        return "La nota mas alta es " + notaAlta + " y pertenece al alumno/a " + nombreAlumno;
    }
    
    public String notaBaja(){
        float notaBaja = vectorNotas[0];
        String nombreAlumno = vectorNombres[0];
        for(int x = 0 ; x < vectorNotas.length ; x = x + 1){
            if(vectorNotas[x] < notaBaja){
                notaBaja = vectorNotas[x];
                nombreAlumno = vectorNombres[x];
            }
        }
        return "La nota mas baja registrada es de " + notaBaja + " y pertenece al alumno/a " + nombreAlumno;
    }
    
    public void informar(){
        System.out.println(sacarPromedioNotas());
        System.out.println(notaAlta());
        System.out.println(notaBaja());
    }
    
    
    
}
