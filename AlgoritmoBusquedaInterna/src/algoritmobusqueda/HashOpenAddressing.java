/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmobusqueda;

/**
 *
 * @author cvdia
 */
public class HashOpenAddressing {
    private Estudiante[] tabla;
    private int tamaño;
    private String metodo; // "linear" o "quadratic"
    private final Estudiante DELETED = new Estudiante(-1, "DELETED", "DELETED");

    public HashOpenAddressing(int tamaño, String metodo) {
        this.tamaño = tamaño;
        this.tabla = new Estudiante[tamaño];
        this.metodo = metodo.toLowerCase();
    }

    private int funcionHash(int clave) {
        return clave % tamaño;
    }

    private int sondeo(int hash, int intento) {
        if (metodo.equals("linear")) {
            return (hash + intento) % tamaño;
        } else {
            return (hash + intento * intento) % tamaño;
        }
    }

    public void insertar(Estudiante e) {
        int hash = funcionHash(e.id);
        for (int i = 0; i < tamaño; i++) {
            int pos = sondeo(hash, i);
            if (tabla[pos] == null || tabla[pos] == DELETED) {
                tabla[pos] = e;
                return;
            }
        }
        System.out.println("⚠ Tabla llena, no se pudo insertar: " + e);
    }

    public Estudiante buscar(int id) {
        int hash = funcionHash(id);
        for (int i = 0; i < tamaño; i++) {
            int pos = sondeo(hash, i);
            if (tabla[pos] == null) return null;
            if (tabla[pos] != DELETED && tabla[pos].id == id) return tabla[pos];
        }
        return null;
    }

    public void eliminar(int id) {
        int hash = funcionHash(id);
        for (int i = 0; i < tamaño; i++) {
            int pos = sondeo(hash, i);
            if (tabla[pos] == null) return;
            if (tabla[pos] != DELETED && tabla[pos].id == id) {
                tabla[pos] = DELETED;
                return;
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print("[" + i + "] -> ");
            if (tabla[i] == null) {
                System.out.println("VACÍO");
            } else if (tabla[i] == DELETED) {
                System.out.println("ELIMINADO");
            } else {
                System.out.println(tabla[i]);
            }
        }
    }
}


