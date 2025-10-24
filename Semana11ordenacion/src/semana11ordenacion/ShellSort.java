/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana11ordenacion;

/**
 *
 * @author cvdia
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        // Inicialmente, el salto es la mitad del tamaño del arreglo
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Recorremos el arreglo con el salto actual
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                // Inserción con el salto actual
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }
}
