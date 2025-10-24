/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana11ordenacion;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cvdia
 */
public class Semana11ordenacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige método de ordenación:");
        System.out.println("1. Shell Sort");
        System.out.println("2. Quick Sort");
        int opcion = sc.nextInt();

        int[] datos = {64, 25, 12, 22, 11, 58, 2, 37, 83, 19, 41, 99};
        
        System.out.println("\nDATOS:");
        System.out.println(Arrays.toString(datos));

        switch (opcion) {
            case 1:
                ShellSort.shellSort(datos);
                break;
            case 2:
                QuickSort.quickSort(datos, 0, datos.length - 1);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        System.out.println("\nResultado ordenado:");
        for (int num : datos) {
            System.out.print(num + " ");
        }
    }

}
