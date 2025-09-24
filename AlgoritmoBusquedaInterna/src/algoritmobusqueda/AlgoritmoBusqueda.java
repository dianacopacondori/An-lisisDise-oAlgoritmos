/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmobusqueda;

import java.util.Scanner;

/**
 *
 * @author cvdia
 */
public class AlgoritmoBusqueda {
    public static void main(String[] args) {
       TablaHashChaining tabla = new TablaHashChaining(5);
       Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ TABLAS HASH ===");
            System.out.println("1. Chaining");
            System.out.println("2. Open Addressing (Linear Probing)");
            System.out.println("3. Open Addressing (Quadratic Probing)");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
                 switch (opcion) {
                case 1: {
                    TablaHashChaining hash = new TablaHashChaining(5);
                    hash.insertar(new Estudiante(1, "Ana",""));
                    hash.insertar(new Estudiante(6, "Luis",""));
                    hash.insertar(new Estudiante(11, "Carla",""));
                    System.out.println("\n📌 Hash con Chaining:");
                    hash.mostrar();
                    System.out.println("Buscar ID 6: " + hash.buscar(6));
     
                    hash.mostrar();
                }
                default:
                    System.out.println("⚠ Opción no válida.");
            }
        tabla.insertar(new Estudiante(1, "Andre Alexandro", "Barrera Carranza"));
        tabla.insertar(new Estudiante(6, "Cesar Andres", "Orizabal Gonzales"));
        tabla.insertar(new Estudiante(11, "Julio Alejandro", "Estrada Sotto"));
        tabla.insertar(new Estudiante(2, "Madelaine Giselle", "Villatoro Martinez"));
        tabla.insertar(new Estudiante(7, "Jose Javier", "Jimenez de la Cruz"));

        tabla.mostrar();

        System.out.println("\nBuscar ID 6: " + tabla.buscar(6));
        System.out.println("Buscar ID 15: " + tabla.buscar(15));
        System.out.println("Buscar ID 11: "+ tabla.buscar(11));
    }  
}
}
