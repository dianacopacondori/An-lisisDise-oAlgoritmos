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

    public static void main(String[] args) {
        int[] vector1 = {2, 5, 6, 8, 9, 4, 3};
        int[] vector2 = {2, 5, 9, 0, 1, 4, 3};
        int[] vector3 = {2, 5, 6, 8, 9, 4, 3};

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número del método de ordenación:");
        System.out.println("1. Burbuja\n2. Selección\n3. Inserción\n4. Ordenación externa");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                Controlador.ordenarBurbuja(vector1, vector2, vector3);
                System.out.println("Método elegido: BURBUJA");
                break;
            case 2:
                Controlador.ordenarSelecion(vector1, vector2, vector3);
                System.out.println("Método elegido: SELECCIÓN");
                break;
            case 3:
                Controlador.ordenarInserccion(vector1, vector2, vector3);
                System.out.println("Método elegido: INSERCIÓN");
                break;
            case 4:
                try {
                    File archivoEntrada = new File("datos.txt");
                    File archivoSalida = new File("resultado.txt");

                    // Crear archivo de ejemplo con números desordenados
                    PrintWriter pw = new PrintWriter(archivoEntrada);
                    pw.println("50");
                    pw.println("12");
                    pw.println("75");
                    pw.println("30");
                    pw.println("4");
                    pw.close();

                    // Llamar al método de ordenación externa
                    OrdenacionExterna.ordenarArchivo(archivoEntrada, archivoSalida);

                    // Leer archivo ordenado
                    System.out.println("Archivo ordenado (ordenado.txt):");
                    BufferedReader br = new BufferedReader(new FileReader(archivoSalida));
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                    br.close();

                } catch (IOException e) {
                    System.out.println("Error en la ordenación externa: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
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
    }

}
