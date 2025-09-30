/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmobusqueda;
import java.util.*;
/**
 *
 * @author cvdia
 */
public class TablaHashChaining {
     private LinkedList<Nodo>[] tabla;
    
     // Clase interna para guardar par clave-valor
    private static class Nodo {
        int clave;          // la clave del registro
        Estudiante valor;   // el valor asociado (el objeto Estudiante)

        Nodo(int clave, Estudiante valor) {
            this.clave = clave;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return clave + " => " + valor;
        }
    }
    
    public TablaHashChaining(int tamaño) {
        tabla = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }
    
    private int funcionHash(int clave) {
        return clave % tabla.length; 
    }
    
     // Insertar clave-valor en la tabla
    public void insertar(int clave, Estudiante valor) {
        int indice = funcionHash(clave);  // calcula posición en la tabla
        tabla[indice].add(new Nodo(clave, valor)); // agrega nodo a la lista
    }
        
    // Buscar un estudiante por su clave
    public Estudiante buscar(int clave) {
        int indice = funcionHash(clave);  // calcula índice
        for (Nodo nodo : tabla[indice]) { // recorre lista en esa posición
            if (nodo.clave == clave) {
                return nodo.valor; // devuelve el estudiante encontrado
            }
        }
        return null; // si no lo encuentra, devuelve null
    }
    
      public void mostrar() {
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("[" + i + "] -> " + tabla[i]);
            System.out.println();
        }
    }
}
