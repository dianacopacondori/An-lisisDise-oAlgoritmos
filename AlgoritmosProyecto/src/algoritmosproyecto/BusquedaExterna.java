/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosproyecto;

import java.io.*;
import java.util.*;

/**
 *
 * @author cvdia
 */
public class BusquedaExterna {

    // Búsqueda secuencial en archivo
    public static boolean busquedaSecuencial(File archivo, int clave) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int valor = Integer.parseInt(linea);
                if (valor == clave) {
                    br.close();
                    return true; // encontrado
                }
            }
        }
        return false;
    }

    // Búsqueda binaria en archivo ordenado (si el archivo está ordenado previamente)
    public static boolean busquedaBinaria(File archivo, int clave) throws IOException {
        List<Integer> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(Integer.valueOf(linea));
            }
        }

        // Buscar en la lista con búsqueda binaria
        int inicio = 0, fin = datos.size() - 1;
        while (inicio <= fin) {
            int mid = (inicio + fin) / 2;
            if (datos.get(mid) == clave) return true;
            else if (datos.get(mid) < clave) inicio = mid + 1;
            else fin = mid - 1;
        }
        return false;
    }

}
