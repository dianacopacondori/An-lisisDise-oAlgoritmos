/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rwcursividadbacktracking;

/**
 *
 * @author cvdia
 */
public class Backtracking {
    static int N = 4;

    static void imprimirSolucion(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }

    // Verifica si es válido moverse a la celda (x, y)
    static boolean esSeguro(int laberinto[][], int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && laberinto[x][y] == 1);
    }

    static boolean resolverLaberinto(int laberinto[][]) {
        int sol[][] = new int[N][N];

        if (!resolverLaberintoUtil(laberinto, 0, 0, sol)) {
            System.out.println("No existe solución.");
            return false;
        }

        System.out.println("Camino encontrado:");
        imprimirSolucion(sol);
        return true;
    }

    // Función recursiva que prueba caminos
    static boolean resolverLaberintoUtil(int laberinto[][], int x, int y, int sol[][]) {
        // Caso base: llegó al destino
        if (x == N - 1 && y == N - 1 && laberinto[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Verifica si (x, y) es un paso válido
        if (esSeguro(laberinto, x, y)) {
            sol[x][y] = 1;

            // Moverse hacia adelante (derecha)
            if (resolverLaberintoUtil(laberinto, x + 1, y, sol))
                return true;

            // Moverse hacia abajo
            if (resolverLaberintoUtil(laberinto, x, y + 1, sol))
                return true;

            // Si ninguno sirve, retrocede
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

}
