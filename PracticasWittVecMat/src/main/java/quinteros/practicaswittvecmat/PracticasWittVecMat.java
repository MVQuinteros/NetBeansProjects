/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package quinteros.practicaswittvecmat;


/**
 *
 * @author Usuario
 */
public class PracticasWittVecMat {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        // ejercicio 1
        practica1Vec prac1vec = new practica1Vec();
        prac1vec.definirVector();
        prac1vec.cargarVector();
        prac1vec.mostrarVector();
        prac1vec.mostrarPromedio();
        prac1vec.mayorQuePromedio();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        //ejercicio 2
        practica2Vec prac2vec = new  practica2Vec();
        prac2vec.definirVec();
        prac2vec.cargarNum();
        prac2vec.informar();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
         
        //ejercicio 3
        practica3Vec prac3vec = new practica3Vec();
        prac3vec.definicion();
        prac3vec.carga();
        prac3vec.repeticiones();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica4vec prac4vec = new practica4vec();
        prac4vec.longitudVector();
        prac4vec.ingreso();
        prac4vec.invertir();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica5vec prac5vec = new practica5vec();
        prac5vec.definirVector();
        prac5vec.cargarNombresNotas();
        prac5vec.informar();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica6vec prac6vec = new practica6vec();
        prac6vec.definirTamaño();
        prac6vec.cargarPaises();
        prac6vec.ordenarHabitantes();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica7vec prac7vec = new practica7vec();
        prac7vec.tamañoVector();
        prac7vec.cargarVectorEdades();
        prac7vec.clasificarEdades();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica8vec prac8vec = new practica8vec();
        prac8vec.completarVector();
        prac8vec.vectorOrdenado();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("                                          Matrices                                          ");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica1mat prac1mat = new practica1mat();
        prac1mat.definirMatriz();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica2mat prac2mat = new practica2mat();
        prac2mat.tamañoMatriz();
        prac2mat.cargarMatriz();
        prac2mat.sumarColumna();
        prac2mat.sumarFila();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica3mat prac3mat = new practica3mat();
        prac3mat.definir();
        prac3mat.cargarMatrizString();
        prac3mat.buscarDiagonalPrincipal();
        prac3mat.buscarDiagonalSecundaria();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica4mat prac4mat = new practica4mat();
        prac4mat.definirMatriz();
        prac4mat.cargar();
        prac4mat.mostrarFilas();
        prac4mat.mostrarColumnas();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica5mat prac5mat = new practica5mat();
        prac5mat.delimitacionMatriz();
        prac5mat.cargaMatriz();
        prac5mat.confirmarCuadrado();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        
        practica6mat prac6mat = new practica6mat();
        prac6mat.definirMat();
        prac6mat.carga();
        prac6mat.informar();
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
    }
}
