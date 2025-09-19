/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosproyecto;
import java.io.* ;
import java.util.*;
/**
 *
 * @author cvdia
 */
public class DirectMergeSort {

    // Divide el archivo en corridas de tamaño fijo y las guarda en archivos temporales
    public static void dividirEnCorridas(File archivoEntrada, int tamBloque, List<File> corridas) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
        List<Integer> buffer = new ArrayList<>();
        String linea;
        int contador = 0;

        while ((linea = br.readLine()) != null) {
            buffer.add(Integer.parseInt(linea));
            if (buffer.size() == tamBloque) {
                guardarCorrida(buffer, corridas, contador++);
                buffer.clear();
            }
        }
        if (!buffer.isEmpty()) {
            guardarCorrida(buffer, corridas, contador++);
        }
        br.close();
    }

    private static void guardarCorrida(List<Integer> datos, List<File> corridas, int indice) throws IOException {
        Collections.sort(datos); // cada corrida se ordena
        File corrida = new File("corrida_" + indice + ".txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(corrida))) {
            for (int n : datos) {
                pw.println(n);
            }
        }
        corridas.add(corrida);
    }

    // Mezcla dos corridas ordenadas en un archivo de salida
    private static File mezclar(File f1, File f2, int indice) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(f1));
        BufferedReader br2 = new BufferedReader(new FileReader(f2));
        File salida = new File("mezcla_" + indice + ".txt");
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

    // Direct Merge Sort completo
    public static void ordenar(File archivoEntrada, File archivoSalida, int tamBloque) throws IOException {
        List<File> corridas = new ArrayList<>();
        dividirEnCorridas(archivoEntrada, tamBloque, corridas);

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

        // El último archivo resultante es el ordenado
        if (!corridas.isEmpty()) {
            File ordenado = corridas.get(0);
            copiarArchivo(ordenado, archivoSalida);
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

    // DEMO
    public static void main(String[] args) throws IOException {
        File entrada = new File("datos.txt");
        try (PrintWriter pw = new PrintWriter(entrada)) {
            pw.println(42);
            pw.println(5);
            pw.println(88);
            pw.println(12);
            pw.println(3);
            pw.println(54);
            pw.println(30);
        }

        File salida = new File("ordenado.txt");
        ordenar(entrada, salida, 2); // bloque de 2 elementos

        System.out.println("Archivo ordenado (Direct Merge Sort):");
        try (BufferedReader br = new BufferedReader(new FileReader(salida))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }


}
