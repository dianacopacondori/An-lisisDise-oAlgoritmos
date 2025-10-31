/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana11ordenacion;

import java.util.Arrays;
import java.util.Scanner;
import static semana11ordenacion.BusquedaBinaria.busquedaBinaria;

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
        System.out.println("Elige metodo de ordenacion:");
        System.out.println("1. Shell Sort");
        System.out.println("2. Quick Sort");
        int opcion = sc.nextInt();

        int[] datos = {64, 25, 12, 22, 11, 58, 2, 37, 83, 19, 41, 99};
        
        System.out.println("\nDATOS:");
        System.out.println(Arrays.toString(datos));

        boolean ordenado = false;
        
        switch (opcion) {
            case 1:
                ShellSort.shellSort(datos);
                ordenado =true;
                break;
            case 2:
                QuickSort.quickSort(datos, 0, datos.length - 1);
                ordenado = true;
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

        if (ordenado) {
            System.out.println("\nResultado ordenado:");
            for (int num : datos) {
                System.out.print(num + " ");
            }
            System.out.println();

            System.out.println("\nIngresa el numero a buscar:");
            int valor = sc.nextInt();

            int resultado = busquedaBinaria(datos, valor);

            if (resultado != -1) {
                System.out.println("El numero " + valor + " se encontro en la posicion: " + (resultado+1));
            } else {
                System.out.println("El numero " + valor + " no se encuentra en el arreglo");
            }
        } else {
            System.out.println("No se puede realizar la busqueda binaria porque el arreglo no esta ordenado");
        }

        sc.close();

    }

}
