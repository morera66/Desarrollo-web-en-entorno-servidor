package com.practica.libros;

import com.practica.libros.dao.LibroDAO;
import com.practica.libros.dao.LibroDAOImpl;
import com.practica.libros.modelo.Libro;
import com.practica.libros.excepcion.LibroNoEncontradoException;

public class Main {

    public static void main(String[] args) {
        LibroDAO dao = new LibroDAOImpl();

        dao.agregar(new Libro(1, "Cien años de soledad", "por Gabriel García Márquez", 1967));
        dao.agregar(new Libro(2, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605));

        System.out.println("Todos los libros:");
        dao.obtenerTodos().forEach(System.out::println);

        System.out.println("\nLibro con ID 1:");
        System.out.println(dao.obtenerPorId(1));

        System.out.println("\nActualizando libro con ID 1...");
        dao.actualizar(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", 1969));
        System.out.println("Libro actualizado con éxito.");

        System.out.println("\nTodos los libros después de actualizar:");
        dao.obtenerTodos().forEach(System.out::println);

        System.out.println("\nEliminando libro con ID 2...");
        dao.eliminar(2);
        System.out.println("Libro eliminado con éxito.");

        System.out.println("\nTodos los libros después de eliminar:");
        dao.obtenerTodos().forEach(System.out::println);

        System.out.println("\nProbando eliminar ID inexistente (99)...");
        try {
            dao.eliminar(99);
        } catch (LibroNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
