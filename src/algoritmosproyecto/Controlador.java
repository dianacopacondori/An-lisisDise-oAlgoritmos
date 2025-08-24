/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosproyecto;

/**
 *
 * @author cvdia
 */
public class Controlador {
    
    // Implementación de Burbuja
    public static void ordenarburbuja(int[] arreglo1, int[] arreglo2, int[] arreglo3) {
        burbuja(arreglo1);
        burbuja(arreglo2);
        burbuja(arreglo3);
    }

    private static void burbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
        // Método de ordenación interna: SELECCIÓN
    public static void ordenarseleccion(int[] arreglo1, int[] arreglo2, int[] arreglo3) {
        seleccion(arreglo1);
        seleccion(arreglo2);
        seleccion(arreglo3);
    }

    private static void seleccion(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            // Encontrar el índice del mínimo en el resto del arreglo
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambiar el elemento actual con el mínimo encontrado
            int temp = arreglo[minIndex];
            arreglo[minIndex] = arreglo[i];
            arreglo[i] = temp;
        }
    }

     public boolean compararArreglos(int[] arreglo1, int[] arreglo2) {
        boolean sonIguales = true;

        for (int i = 0; i < arreglo1.length; i++) {
            if (arreglo1[i] != arreglo2[i]) {
                sonIguales = false;

                break;

            }

        }

        return sonIguales;

    }

    public void imprimeDistintos(int[] arreglo1, int[] arreglo2) {
        for (int i = 0; i < arreglo1.length; i++) {

            if (arreglo1[i] != arreglo2[i]) {
                System.out.println("[" + i + "]"
                        + arreglo1[i] + "->" + arreglo2[i]);

            }

        }

    }

  
}