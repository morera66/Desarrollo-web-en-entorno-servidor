    package com.practica.libros.dao;


    import com.practica.libros.modelo.Libro;

    import java.util.List;

    import java.util.ArrayList;

    import com.practica.libros.excepcion.LibroNoEncontradoException;

    public class LibroDAOImpl implements LibroDAO{

        private List<Libro> libros = new ArrayList<>();

        @Override
        public List<Libro> obtenerTodos(){
            return libros;
        }


        @Override
        public void agregar(Libro libro) {
            libros.add(libro);
        }

        @Override
        public Libro obtenerPorId(int id) {
            for (Libro libro : libros) {
                if (libro.getId() == id) {
                    return libro;
                }
            }
            throw new LibroNoEncontradoException("No existe un libro con ID " + id);
        }

        @Override
        public void actualizar(Libro libro) {
            Libro existente = obtenerPorId(libro.getId());
            existente.setTitulo(libro.getTitulo());
            existente.setAutor(libro.getAutor());
            existente.setAnioPublicacion(libro.getAnioPublicacion());
        }

        @Override
        public void eliminar(int id) {
            Libro existente = obtenerPorId(id);
            libros.remove(existente);
        }



    }
