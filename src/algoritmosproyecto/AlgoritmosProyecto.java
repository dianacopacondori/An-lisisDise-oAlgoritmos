/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosproyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AlgoritmosProyecto {

    public static void main(String[] args) throws IOException {
        int[] vector1 = {2, 5, 6, 8, 9, 4, 3, 11};
        int[] vector2 = {2, 5, 9, 0, 1, 4, 3, 10, 12};
        int[] vector3 = {2, 5, 6, 8, 9, 4, 3, 11};

        Scanner consola = new Scanner(System.in);
        System.out.println("----MENU----");
        System.out.println("1. Ordenación interna (vectores)"
                + "\n2. Ordenacion externa (archivos)");
        int opcion = consola.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Elige método interno:");
                System.out.println("1. Burbuja\n2. Selección\n3. Inserción");
                int interno = consola.nextInt();
                switch (interno) {
                    case 1:
                        Controlador.ordenarBurbuja(vector1, vector2, vector3);
                    case 2:
                        Controlador.ordenarSeleccion(vector1, vector2, vector3);
                    case 3:
                        Controlador.ordenarInserccion(vector1, vector2, vector3);
                    default:
                        System.out.println("Opción no válida.");
                }
                System.out.println("\nVectores ordenados:");
                System.out.println("Vector 1: " + Arrays.toString(vector1));
                System.out.println("Vector 2: " + Arrays.toString(vector2));
                System.out.println("Vector 3: " + Arrays.toString(vector3));

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
                break;
            case 2:
                System.out.println("=== ORDENACIÓN EXTERNA ===");
                System.out.println("1. Mezcla Natural");
                System.out.println("2. Mezcla Equilibrada Múltiple");
                System.out.println("3. Método Polifásico");
                System.out.println("4. Ordenación externa simple (Collections.sort)");
                int externo = consola.nextInt();

                try {
                    File entrada = new File("datos.txt");
                    File salida = new File("ordenado.txt");

                    switch (externo) {
                        case 1: {
                            // Mezcla Natural
                            OrdenacionExterna.NaturalMergeSort(entrada, salida);
                            System.out.println("Mezcla Natural completada. Revisa 'ordenado.txt'");

                        }
                        case 2: {
                            // Mezcla Natural
                            NaturalMergeSort.ordenar(entrada, salida);
                            System.out.println("Mezcla Natural completada. Revisa 'ordenado.txt'");

                        }
                        case 3: {
                            // Mezcla Equilibrada Múltiple
                            MezclaEquilibradaMultiple.ordenar(entrada, salida, 3);
                            System.out.println("Mezcla Equilibrada Múltiple completada. Revisa 'ordenado.txt'");

                        }
                        case 4: {
                            // Método Polifásico
                            OrdenacionPolifasica.ordenar(entrada, salida, 3);
                            System.out.println("Ordenación Polifásica completada. Revisa 'ordenado.txt'");

                        }
                        case 5: {
                            // Versión simple con Collections.sort
                            OrdenacionExterna.ordenarArchivo(entrada, salida);
                            System.out.println("Archivo ordenado con Collections.sort (ordenado.txt):");
                            BufferedReader br = new BufferedReader(new FileReader(salida));
                            String linea;
                            while ((linea = br.readLine()) != null) {
                                System.out.println(linea);
                            }
                            br.close();
                        }
                        default:
                            System.out.println("Opción no válida.");
                    }
                } catch (IOException e) {
                    System.out.println("Error en la ordenación externa: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
        consola.close();
    }

}
