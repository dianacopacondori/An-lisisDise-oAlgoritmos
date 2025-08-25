/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosproyecto;

import java.util.Arrays;

/**
 *
 * @author cvdia
 */
public class AlgoritmosProyecto {

    public static void main(String[] args) {
        int[] vector1 = {2, 5, 6, 8, 9, 4, 3};
        int[] vector2 = {2, 5, 9, 0, 1, 4, 3};
        int[] vector3 = {2, 5, 6, 8, 9, 4, 3};
        
        Controlador.ordenarBurbuja(vector1, vector2, vector3);
        System.out.println("===Vectores ordenados por método burbuja===");
        System.out.println(Arrays.toString(vector1));
        System.out.println(Arrays.toString(vector2));
        System.out.println(Arrays.toString(vector3));
        
        Controlador.ordenarSeleccion(vector1, vector2, vector3);
        System.out.println("===Vectores ordenados por método Selección===");
        System.out.println(Arrays.toString(vector1));
        System.out.println(Arrays.toString(vector2));
        System.out.println(Arrays.toString(vector3));
        
        Controlador.ordenarInserccion(vector1, vector2, vector3);
        System.out.println("=== Vectores ordenados con Inserción ===");
        System.out.println(Arrays.toString(vector1));
        System.out.println(Arrays.toString(vector2));
        System.out.println(Arrays.toString(vector3));

         
        Controlador objControlador = new Controlador();
        String respuesta = objControlador.compararArreglos(vector1, vector2)
                ? "SON IGUALES" : "SON DIFERENTES";
        System.out.println("Arreglo 1 y Arreglo 2 :" + respuesta);
        objControlador.imprimeDistintos(vector1, vector2);
        System.out.println("");

        respuesta = objControlador.compararArreglos(vector1, vector3)
                ? "SON IGUALES" : "SON DIFERENTES";
        System.out.println("Arreglo 1 y Arreglo 3 :" + respuesta);
        objControlador.imprimeDistintos(vector1, vector3);
    }
    
}
