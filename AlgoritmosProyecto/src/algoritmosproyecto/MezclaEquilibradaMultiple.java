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
public class MezclaEquilibradaMultiple {
    
    public static List<File> generarCorridas(File archivoEntrada, int tamBloque) throws IOException {
        List<File> corridas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));

        List<Integer> buffer = new ArrayList<>();
        String linea;

        while ((linea = br.readLine()) != null) {
            buffer.add(Integer.parseInt(linea));
            if (buffer.size() == tamBloque) {
                corridas.add(guardarCorrida(buffer));
                buffer.clear();
            }
        }
        // Si quedan datos sin guardar
        if (!buffer.isEmpty()) {
            corridas.add(guardarCorrida(buffer));
        }
        br.close();
        return corridas;
    }

    private static File guardarCorrida(List<Integer> datos) throws IOException {
        Collections.sort(datos);
        File corrida = File.createTempFile("corrida", ".tmp");
        corrida.deleteOnExit();
        PrintWriter pw = new PrintWriter(new FileWriter(corrida));
        for (int n : datos) pw.println(n);
        pw.close();
        return corrida;
    }

    public static void mezclarCorridas(List<File> corridas, File archivoSalida) throws IOException {
        // Usamos PriorityQueue para hacer mezcla equilibrada multiple
        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.valor));

        List<BufferedReader> lectores = new ArrayList<>();
        for (File corrida : corridas) {
            BufferedReader br = new BufferedReader(new FileReader(corrida));
            lectores.add(br);
            String linea = br.readLine();
            if (linea != null) {
                pq.offer(new Nodo(Integer.parseInt(linea), lectores.size() - 1));
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter(archivoSalida));
        while (!pq.isEmpty()) {
            Nodo nodo = pq.poll();
            pw.println(nodo.valor);

            BufferedReader br = lectores.get(nodo.indice);
            String linea = br.readLine();
            if (linea != null) {
                pq.offer(new Nodo(Integer.parseInt(linea), nodo.indice));
            }
        }
        pw.close();
        for (BufferedReader br : lectores) br.close();
    }

    private static class Nodo {
        int valor;
        int indice;
        Nodo(int valor, int indice) {
            this.valor = valor;
            this.indice = indice;
        }
    }

    public static void ordenar(File entrada, File salida, int tamBloque) throws IOException {
        List<File> corridas = generarCorridas(entrada, tamBloque);
        mezclarCorridas(corridas, salida);
    }
}
