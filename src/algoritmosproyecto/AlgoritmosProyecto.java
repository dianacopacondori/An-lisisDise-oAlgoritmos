/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosproyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AlgoritmosProyecto {

    public static void main(String[] args) throws IOException {
        int[] vector1 = {2, 5, 6, 8, 9, 4, 3, 11};
        int[] vector2 = {2, 5, 9, 0, 1, 4, 3, 10, 12};
        int[] vector3 = {2, 5, 6, 8, 9, 4, 3, 11};

        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese el numero del metodo de ordenacion:");
        System.out.println("1. Burbuja\n2. Seleccion\n3. Insercion\n4. Ordenacion externa");
        int opcion = consola.nextInt();

        switch (opcion) {
            case 1:
                Controlador.ordenarBurbuja(vector1, vector2, vector3);
                System.out.println("Metodo elegido: BURBUJA");
                break;
            case 2:
                Controlador.ordenarSeleccion(vector1, vector2, vector3);
                System.out.println("Metodo elegido: SELECCIÓN");
                break;
            case 3:
                Controlador.ordenarInserccion(vector1, vector2, vector3);
                System.out.println("Metodo elegido: INSERCIÓN");
                break;
            case 4:
                try {
                    File archivoEntrada = new File("datos.txt");
                    File archivoSalida = new File("ordenado.txt");

                    // Crear archivo de ejemplo con números desordenados
                    PrintWriter pw = new PrintWriter(archivoEntrada);
                    pw.println("50");
                    pw.println("12");
                    pw.println("75");
                    pw.println("30");
                    pw.println("42");
                    pw.println("88");
                    pw.println("7");
                    pw.println("61");
                    pw.println("27");
                    pw.println("92");
                    pw.println("14");
                    pw.println("59");
                    pw.println("70");
                    pw.println("21");
                    pw.println("44");
                    pw.println("99");
                    pw.println("78");
                    pw.println("57");
                    pw.println("1");
                    pw.println("4");
                    pw.println("43");
                    pw.close();

                    OrdenacionExterna.ordenarArchivo(archivoEntrada, archivoSalida);

                    System.out.println("Archivo ordenado (ordenado.txt):");
                    BufferedReader br = new BufferedReader(new FileReader(archivoSalida));
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                    br.close();

                } catch (IOException e) {
                    System.out.println("Error en la ordenacion externa: " + e.getMessage());
                }
                break;
            case 5:
                MezclaEquilibradaMultiple.ordenar(new File("datos.txt"), new File("ordenado.txt"), 3);
                break;
            case 6:
                OrdenacionPolifasica.ordenar(new File("datos.txt"), new File("ordenado.txt"), 3);
                System.out.println("Ordenación polifásica completada.");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        if (opcion != 4) {
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
        }
        consola.close();
    }

}
