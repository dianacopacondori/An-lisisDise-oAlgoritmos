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
public class tablaHashChaining {
     private LinkedList<Estudiante>[] tabla;
     
    public tablaHashChaining(int tamaño) {
        tabla = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }
    
    private int funcionHash(int clave) {
        return clave % tabla.length; 
    }
    
        public void insertar(Estudiante e) {
        int pos = funcionHash(e.id);
        tabla[pos].add(e); // chaining
    }
        
    public Estudiante buscar(int id) {
        int pos = funcionHash(id);
        for (Estudiante e : tabla[pos]) {
            if (e.id == id) return e;
        }
        return null;
    }
    
      public void mostrar() {
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("[" + i + "] -> " + tabla[i]);
            System.out.println();
        }
    }
}
