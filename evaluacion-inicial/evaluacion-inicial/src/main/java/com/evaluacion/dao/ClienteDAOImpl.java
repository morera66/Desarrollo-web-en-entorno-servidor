package com.evaluacion.dao;

import com.evaluacion.conexion.ConexionBD;
import com.evaluacion.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT customerNumber, customerName, contactLastName, " +
                     "contactFirstName, phone, city, country FROM customers";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("customerNumber"),
                        rs.getString("customerName"),
                        rs.getString("contactLastName"),
                        rs.getString("contactFirstName"),
                        rs.getString("phone"),
                        rs.getString("city"),
                        rs.getString("country")
                );
                clientes.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    @Override
    public Cliente buscarPorId(int customerNumber) {
        String sql = "SELECT customerNumber, customerName, contactLastName, " +
                     "contactFirstName, phone, city, country FROM customers " +
                     "WHERE customerNumber = ?";

        Connection conexion = ConexionBD.getInstancia().getConexion();
        Cliente cliente = null;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, customerNumber);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(
                            rs.getInt("customerNumber"),
                            rs.getString("customerName"),
                            rs.getString("contactLastName"),
                            rs.getString("contactFirstName"),
                            rs.getString("phone"),
                            rs.getString("city"),
                            rs.getString("country")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
}