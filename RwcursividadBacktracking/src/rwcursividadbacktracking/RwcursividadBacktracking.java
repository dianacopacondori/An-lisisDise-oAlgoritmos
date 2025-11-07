/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rwcursividadbacktracking;

import java.util.Scanner;
import static rwcursividadbacktracking.Backtracking.resolverLaberinto;
import static rwcursividadbacktracking.Recursividad.factorial;

/**
 *
 * @author cvdia
 */
public class RwcursividadBacktracking {

  
    public static void main(String[] args) {
        int opcion;
        Scanner consola = new Scanner (System.in);
        
            System.out.println("\n=== MENU RECURSIVIDAD Y BACKTRACKING ===");
            System.out.println("1. Factorial (Recursividad)");
            System.out.println("2. Laberinto (Backtracking)");
            System.out.print("Elige una opción: ");
            opcion = consola.nextInt();

            switch (opcion) {
                case 1 : {
                    System.out.print("Ingresa un número: ");
                    int n = consola.nextInt();
                    System.out.println("El factorial de " + n + " es: " + factorial(n));
                    break;
                }
                case 2 : {
                    int[][] laberinto = {
                        {1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}
                    };
                    System.out.println("Resolviendo laberinto...");
                    resolverLaberinto(laberinto);
                    break;
                }
                default :
                    System.out.println("Opción no válida.");
                    break;
            }

    }
    
}
