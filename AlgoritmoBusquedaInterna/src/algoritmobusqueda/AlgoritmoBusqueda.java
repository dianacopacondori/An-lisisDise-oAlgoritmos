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
            System.out.println("\n=== MENU TABLAS HASH ===");
            System.out.println("1. Chaining");
            System.out.println("2. Open Addressing (Linear Probing)");
            System.out.println("3. Open Addressing (Quadratic Probing)");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
                 switch (opcion) {
                case 1: {
                    TablaHashChaining hash = new TablaHashChaining(5);
                    hash.insertar(1, new Estudiante(1, "Ana", "Pérez"));
                    hash.insertar(6, new Estudiante(6, "Luis", "García"));
                    hash.insertar(11, new Estudiante(11, "Carla", "Martínez"));
                    System.out.println("\n Hash con Chaining:");
                    hash.mostrar();
                    System.out.println("Buscar ID 6: " + hash.buscar(6));
     
                    hash.mostrar();
                    break;
                }
                case 2: {
                    HashOpenAddressing hash = new HashOpenAddressing(7, "linear");
                    hash.insertar(new Estudiante(1, "Pedro", ""));
                    hash.insertar(new Estudiante(8, "Sofía",""));
                    hash.insertar(new Estudiante(15, "Diego",""));
                    System.out.println("\n📌 Hash con Linear Probing:");
                    hash.mostrar();
                    System.out.println("Buscar ID 15: " + hash.buscar(15));
                    hash.eliminar(15);
                    System.out.println("Después de eliminar ID 15:");
                    hash.mostrar();
                    break;
                }
                case 3: {
                    HashOpenAddressing hash = new HashOpenAddressing(7, "quadratic");
                    hash.insertar(new Estudiante(1, "Marta",""));
                    hash.insertar(new Estudiante(8, "Andrés",""));
                    hash.insertar(new Estudiante(15, "Clara",""));
                    System.out.println("\n📌 Hash con Quadratic Probing:");
                    hash.mostrar();
                    System.out.println("Buscar ID 8: " + hash.buscar(8));
                    hash.eliminar(8);
                    System.out.println("Después de eliminar ID 8:");
                    hash.mostrar();
                    break;
                }
                case 4: salir = true;
                break;
                default:
                    System.out.println(" Opción no válida.");
            }
        
    }  
}
}
