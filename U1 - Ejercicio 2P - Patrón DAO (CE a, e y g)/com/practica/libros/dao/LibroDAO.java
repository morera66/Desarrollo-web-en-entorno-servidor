package com.practica.libros.dao;

import com.practica.libros.modelo.Libro;

import java.util.List;

public interface LibroDAO {

    List<Libro> obtenerTodos();

    Libro obtenerPorId(int id);

    void agregar(Libro libro);

    void actualizar(Libro libro);

    void eliminar(int id);


}
