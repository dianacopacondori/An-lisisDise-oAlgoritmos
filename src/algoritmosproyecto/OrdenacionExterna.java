/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosproyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cvdia
 */
public class OrdenacionExterna {
    public static void ordenarArchivo(File archivoEntrada, File archivoSalida) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
        List<Integer> numeros = new ArrayList<>();

        String linea;
        while ((linea = br.readLine()) != null) {
            numeros.add(Integer.parseInt(linea));
        }
        br.close();

        // Ordenar en memoria (ordenación externa simple)
        Collections.sort(numeros);

        PrintWriter pw = new PrintWriter(new FileWriter(archivoSalida));
        for (int num : numeros) {
            pw.println(num);
        }
        pw.close();
    }

    static void mezclaDirecta(File entrada, File salida) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
