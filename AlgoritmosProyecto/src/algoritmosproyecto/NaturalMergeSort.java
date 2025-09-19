/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosproyecto;
import java.io.*;
import java.util.* ;

/**
 *
 * @author cvdia
 */
public class NaturalMergeSort {
    public static List<File> detectarCorridas(File archivoEntrada) throws IOException {
        List<File> corridas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));

        List<Integer> corridaActual = new ArrayList<>();
        String linea;
        Integer previo = null;

        while ((linea = br.readLine()) != null) {
            int actual = Integer.parseInt(linea);

            if (previo != null && actual < previo) {
                corridas.add(guardarCorrida(corridaActual, corridas.size()));
                corridaActual.clear();
            }
            corridaActual.add(actual);
            previo = actual;
        }

        if (!corridaActual.isEmpty()) {
            corridas.add(guardarCorrida(corridaActual, corridas.size()));
        }

        br.close();
        return corridas;
    }

    // Guardar en un archivo temporal
    private static File guardarCorrida(List<Integer> datos, int indice) throws IOException {
        File corrida = new File("corrida_nat_" + indice + ".txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(corrida))) {
            for (int n : datos) pw.println(n);
        }
        return corrida;
    }

    private static File mezclar(File f1, File f2, int indice) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(f1));
        BufferedReader br2 = new BufferedReader(new FileReader(f2));
        File salida = new File("mezcla_nat_" + indice + ".txt");
        PrintWriter pw = new PrintWriter(new FileWriter(salida));

        String linea1 = br1.readLine();
        String linea2 = br2.readLine();

        while (linea1 != null && linea2 != null) {
            int n1 = Integer.parseInt(linea1);
            int n2 = Integer.parseInt(linea2);

            if (n1 <= n2) {
                pw.println(n1);
                linea1 = br1.readLine();
            } else {
                pw.println(n2);
                linea2 = br2.readLine();
            }
        }
        while (linea1 != null) {
            pw.println(linea1);
            linea1 = br1.readLine();
        }
        while (linea2 != null) {
            pw.println(linea2);
            linea2 = br2.readLine();
        }

        br1.close();
        br2.close();
        pw.close();
        return salida;
    }

    // Natural Merge Sort completo
    public static void ordenar(File archivoEntrada, File archivoSalida) throws IOException {
        List<File> corridas = detectarCorridas(archivoEntrada);

        int paso = 0;
        while (corridas.size() > 1) {
            List<File> nuevasCorridas = new ArrayList<>();
            for (int i = 0; i < corridas.size(); i += 2) {
                if (i + 1 < corridas.size()) {
                    File mezcla = mezclar(corridas.get(i), corridas.get(i + 1), paso++);
                    nuevasCorridas.add(mezcla);
                } else {
                    nuevasCorridas.add(corridas.get(i));
                }
            }
            corridas = nuevasCorridas;
        }
        
        if (!corridas.isEmpty()) {
            copiarArchivo(corridas.get(0), archivoSalida);
        }
    }

    private static void copiarArchivo(File origen, File destino) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             PrintWriter pw = new PrintWriter(new FileWriter(destino))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                pw.println(linea);
            }
        }
    }
}
