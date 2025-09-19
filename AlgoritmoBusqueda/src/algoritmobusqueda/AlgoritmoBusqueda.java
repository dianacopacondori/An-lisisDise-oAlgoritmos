/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmobusqueda;

/**
 *
 * @author cvdia
 */
public class AlgoritmoBusqueda {
    public static void main(String[] args) {
       tablaHashChaining tabla = new tablaHashChaining(5);
       
        tabla.insertar(new Estudiante(1, "Andre Alexandro", "Barrera Carranza"));
        tabla.insertar(new Estudiante(6, "Cesar Andres", "Orizabal Gonzales"));
        tabla.insertar(new Estudiante(11, "Julio Alejandro", "Estrada Sotto"));
        tabla.insertar(new Estudiante(2, "Madelaine Giselle", "Villatoro Martinez"));
        tabla.insertar(new Estudiante(7, "Jose Javier", "Jimenez de la Cruz"));

        tabla.mostrar();

        System.out.println("\nBuscar ID 6: " + tabla.buscar(6));
        System.out.println("Buscar ID 15: " + tabla.buscar(15));
        System.out.println("Buscar ID 11: "+ tabla.buscar(11));
    }  
}
