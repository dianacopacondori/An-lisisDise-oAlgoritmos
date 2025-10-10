/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmobusqueda;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cvdia
 */
public class AlgoritmoBusqueda {

    public static void demoInvertedIndex(Scanner sc) {
    InvertedIndex idx = new InvertedIndex();

    // Simular documentos predefinidos (puedes hacerlo interactivo si quieres)
    String[][] documentos = {
        {"el", "gato", "come", "pescado"},
        {"el", "perro", "come", "carne"},
        {"los", "peces", "nadan", "en", "el", "agua"}
    };

    for (int i = 0; i < documentos.length; i++) {
        for (String palabra : documentos[i]) {
            idx.addWordToDocument(palabra, i + 1); // IDs de documento: 1, 2, 3...
        }
    }

    System.out.println("\n=== LISTA INVERTIDA ===");
    idx.printIndex();

    System.out.print("\nIngresa una palabra para buscar: ");
    String palabra = sc.nextLine().trim().toLowerCase();
    Set<Integer> docs = idx.getDocuments(palabra);
    if (docs.isEmpty()) {
        System.out.println("La palabra '" + palabra + "' no se encontró.");
    } else {
        System.out.println("Aparece en los documentos: " + docs);
    }
    }
public static void demoMultilist(Scanner sc) {
    Multilist ml = new Multilist();

    // Agregar empleados predefinidos
    ml.addEmployee(new Employee(1, "Ana", "IT", "Developer"));
    ml.addEmployee(new Employee(2, "Luis", "IT", "Manager"));
    ml.addEmployee(new Employee(3, "Carlos", "HR", "Developer"));
    ml.addEmployee(new Employee(4, "María", "HR", "Manager"));

    System.out.println("\n=== MULTILISTA (Empleados) ===");
    System.out.println("Empleados por departamento:");
    System.out.println("IT: " + ml.getEmployeesByDepartment("IT"));
    System.out.println("HR: " + ml.getEmployeesByDepartment("HR"));

    System.out.println("\nEmpleados por rol:");
    System.out.println("Developer: " + ml.getEmployeesByRole("Developer"));
    System.out.println("Manager: " + ml.getEmployeesByRole("Manager"));

    System.out.print("\n¿Quieres buscar por departamento? (s/n): ");
    if (sc.nextLine().trim().equalsIgnoreCase("s")) {
        System.out.print("Ingresa el departamento (ej. IT, HR): ");
        String dept = sc.nextLine().trim();
        List<Employee> empDept = ml.getEmployeesByDepartment(dept);
        System.out.println(empDept.isEmpty() ? "No hay empleados en ese depto." : empDept);
    }

    System.out.print("¿Quieres buscar por rol? (s/n): ");
    if (sc.nextLine().trim().equalsIgnoreCase("s")) {
        System.out.print("Ingresa el rol (ej. Developer, Manager): ");
        String rol = sc.nextLine().trim();
        List<Employee> empRol = ml.getEmployeesByRole(rol);
        System.out.println(empRol.isEmpty() ? "No hay empleados con ese rol." : empRol);
    }
}
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
                    hash.insertar(new Estudiante(8, "Sofía", ""));
                    hash.insertar(new Estudiante(15, "Diego", ""));
                    System.out.println("\n Hash con Linear Probing:");
                    hash.mostrar();
                    System.out.println("Buscar ID 15: " + hash.buscar(15));
                    hash.eliminar(15);
                    System.out.println("Después de eliminar ID 15:");
                    hash.mostrar();
                    break;
                }
                case 3: {
                    HashOpenAddressing hash = new HashOpenAddressing(7, "quadratic");
                    hash.insertar(new Estudiante(1, "Marta", ""));
                    hash.insertar(new Estudiante(8, "Andrés", ""));
                    hash.insertar(new Estudiante(15, "Clara", ""));
                    System.out.println("\n Hash con Quadratic Probing:");
                    hash.mostrar();
                    System.out.println("Buscar ID 8: " + hash.buscar(8));
                    hash.eliminar(8);
                    System.out.println("Después de eliminar ID 8:");
                    hash.mostrar();
                    break;
                }
                case 4:
                    salir = true;
                default:
                    System.out.println(" Opción no válida.");
            }

        }
    }
}
