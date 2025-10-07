/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosproyecto;

import java.io.*;
import java.util.*;

public class BusquedaExterna {

     // Supone que el archivo binario contiene enteros, ordenados
    public static boolean busquedaBinariaExterna(File archivo, int clave) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "r")) {
            long tamanoArchivo = raf.length();
            if (tamanoArchivo == 0) return false;

            int numRegistros = (int) (tamanoArchivo / 4); // 4 bytes por int
            int inicio = 0;
            int fin = numRegistros - 1;

            while (inicio <= fin) {
                int medio = inicio + (fin - inicio) / 2;
                raf.seek(medio * 4L); // Saltar a la posición del medio
                int valor = raf.readInt();

                if (valor == clave) {
                    return true;
                } else if (valor < clave) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            }
        }
        return false;
    }
}
