package controller;

import model.Pedidos;
import java.util.ArrayList;

public class GestionPedidos {
    // Lista dinámica para almacenar todos los pedidos del sistema
    private ArrayList<Pedidos> listaPedidos;

    public GestionPedidos() {
        this.listaPedidos = new ArrayList<>();
    }

    // Método para registrar un nuevo pedido
    public void registrarPedido(Pedidos pedido) {

        if (pedido == null) {
            throw new IllegalArgumentException("No se puede registrar un pedido nulo.");
        }
        listaPedidos.add(pedido);
    }

    // Método para buscar un pedido por su ID
    public Pedidos buscarPedidoPorId(int id) {
        for (Pedidos p : listaPedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("No se encontró ningún pedido con el ID: " + id); // Si no encuentra ningún pedido
    }

    // Método para mostrar todos los pedidos
    public void mostrarTodosLosPedidos() {
        if (listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("--- LISTADO GLOBAL DE PEDIDOS ---");
            for (Pedidos p : listaPedidos) {
                // Usamos el toString que definimos en la clase Pedidos
                System.out.println(p.toString());
            }
        }
    }

    
    public ArrayList<Pedidos> getListaPedidos() {
        return listaPedidos;
    }
}