package com.evaluacion.dao;

import com.evaluacion.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    List<Cliente> listarTodos();
    Cliente buscarPorId(int customerNumber);
}