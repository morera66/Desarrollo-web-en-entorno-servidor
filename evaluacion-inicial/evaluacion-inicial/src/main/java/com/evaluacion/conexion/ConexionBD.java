package com.evaluacion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static ConexionBD instancia;
    private Connection conexion;

    private static final String URL = "jdbc:mariadb://127.0.0.1:3336/classicmodels";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "root1234";

    // Constructor privado: nadie fuera de esta clase puede crear instancias
    private ConexionBD() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Único punto de acceso a la instancia
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}