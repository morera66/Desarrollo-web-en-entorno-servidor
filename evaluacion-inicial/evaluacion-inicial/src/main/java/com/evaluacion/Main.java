package com.evaluacion;

import com.evaluacion.dao.ClienteDAO;
import com.evaluacion.dao.ClienteDAOImpl;
import com.evaluacion.modelo.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAOImpl();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar todos los clientes");
            System.out.println("2. Buscar cliente por número");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    List<Cliente> clientes = clienteDAO.listarTodos();
                    clientes.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Número de cliente: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Cliente c = clienteDAO.buscarPorId(id);
                    System.out.println(c != null ? c : "No encontrado");
                    break;
                case 0:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        sc.close();
    }
}