/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodalgoritmos;

public class Controlador {

    public boolean compararArreglos(int[] arreglo1, int[] arreglo2) {
        boolean sonIguales = true;

        for (int i = 0; i < arreglo1.length; i++) {
            if (arreglo1[i] != arreglo2[i]) {
                sonIguales = false;

                break;

            }

        }

        return sonIguales;

    }

    public void imprimeDistintos(int[] arreglo1, int[] arreglo2) {
        for (int i = 0; i < arreglo1.length; i++) {

            if (arreglo1[i] != arreglo2[i]) {
                System.out.println("[" + i + "]"
                        + arreglo1[i] + "->" + arreglo2[i]);

            }

        }

    }

}
