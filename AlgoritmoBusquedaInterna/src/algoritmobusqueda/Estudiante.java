/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmobusqueda;

/**
 *
 * @author cvdia
 */
public class Estudiante {
    int id;
    private String nombres;
    private String apellidos;

    public Estudiante(int id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    public String toString(){
        return id + " - " + nombres + " "+apellidos;
    }
}
