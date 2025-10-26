/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana11ordenacion;

/**
 *
 * @author cvdia
 */
public class QuickSort {
 public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    /**
     * Implementación recursiva optimizada de QuickSort.
     * Usa recursión solo en la parte más pequeña del arreglo para
     * limitar la profundidad de la pila a O(log n).
     */
    private static void quickSortRecursive(int[] arr, int inicio, int fin) {
        while (inicio < fin) {
            // Elegir un buen pivote usando mediana de tres
            elegirPivoteMedianaDeTres(arr, inicio, fin);
            
            int pivoteIndex = particion(arr, inicio, fin);

            // Recursión en la subparte más pequeña, iteración en la más grande
            if (pivoteIndex - inicio < fin - pivoteIndex) {
                quickSortRecursive(arr, inicio, pivoteIndex - 1);
                inicio = pivoteIndex + 1;
            } else {
                quickSortRecursive(arr, pivoteIndex + 1, fin);
                fin = pivoteIndex - 1;
            }
        }
    }

    /**
     * Coloca la mediana entre arr[inicio], arr[medio] y arr[fin]
     * en la posición 'fin', para usarla como pivote.
     */
    private static void elegirPivoteMedianaDeTres(int[] arr, int inicio, int fin) {
        int medio = inicio + (fin - inicio) / 2;

        // Ordenar los tres elementos: inicio, medio, fin
        if (arr[medio] < arr[inicio]) swap(arr, inicio, medio);
        if (arr[fin] < arr[inicio]) swap(arr, inicio, fin);
        if (arr[fin] < arr[medio]) swap(arr, medio, fin);

        // Ahora la mediana está en arr[fin] → será el pivote
    }

    /**
     * Particiona el arreglo alrededor del pivote (ubicado en arr[fin]).
     * Todos los elementos <= pivote quedan a la izquierda.
     *
     * @return la posición final del pivote
     */
    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int indiceMenor = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                indiceMenor++;
                swap(arr, indiceMenor, j);
            }
        }

        swap(arr, indiceMenor + 1, fin);
        return indiceMenor + 1;
    }

    /**
     * Intercambia dos elementos en el arreglo.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
