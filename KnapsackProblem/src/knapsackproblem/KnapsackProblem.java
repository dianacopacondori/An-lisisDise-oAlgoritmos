/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package knapsackproblem;


public class KnapsackProblem {

    // Metodo que resuelve el problema de la mochila
    public static int knapsack(int capacidad, int[] pesos, int[] valores, int n) {

        // Matriz DP: dp[i][w] = maximo valor usando i objetos con capacidad w
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenado de la tabla
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacidad; w++) {

                // Si el peso del objeto actual es mayor que la capacidad disponible
                if (pesos[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];  // No se puede tomar el objeto
                } else {
                    // Elegir entre NO tomarlo o tomarlo
                    dp[i][w] = Math.max(
                            dp[i - 1][w],  // no tomar
                            valores[i - 1] + dp[i - 1][w - pesos[i - 1]] // tomarlo
                    );
                }
            }
        }

        return dp[n][capacidad];  // resultado
    }

    public static void main(String[] args) {
        int[] valores = {60, 100, 120};
        int[] pesos = {10, 20, 30};
        int capacidad = 50;

        int n = valores.length;

        int maxValor = knapsack(capacidad, pesos, valores, n);

        System.out.println("Maximo valor que puede llevar la mochila: " + maxValor);
    }
    
}
