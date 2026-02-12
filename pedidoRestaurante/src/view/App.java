package view;

import model.Articulos;
import model.Clientes;
import model.Pedidos;
import controller.GestionPedidos;
import controller.EstadoPedido;

public class App {
    public static void main(String[] args) {
        System.out.println("=== INICIO DEL SISTEMA DE PEDIDOS ===");

        // Instanciamos el controlador general
        GestionPedidos gestion = new GestionPedidos();

        try {
            // Creación de un Cliente (Probando clase Clientes)
            // Usamos datos válidos para la prueba
            System.out.println("\n> Creando cliente...");
            Clientes cliente1 = new Clientes("12345678Z", "Ana García", "ana.garcia@email.com", "666777888");
            System.out.println("Cliente creado: " + cliente1.getNombre());

            // Creación de un Pedido asociado al cliente
            System.out.println("\n> Creando pedido...");
            Pedidos pedido1 = new Pedidos(cliente1);

            // Creación y adición de Artículos
            Articulos portatil = new Articulos("Portátil Gaming", 1, 1200.50);
            Articulos raton = new Articulos("Ratón USB", 2, 15.00); // 2 unidades a 15€
            Articulos teclado = new Articulos("Teclado Mecánico", 1, 45.99);

            // Añadimos al pedido
            pedido1.agregarArticulos(portatil);
            pedido1.agregarArticulos(raton);
            pedido1.agregarArticulos(teclado);

            // Registramos el pedido en el controlador
            gestion.registrarPedido(pedido1);

            // Mostramos el resultado final
            System.out.println("\n> Listando todos los pedidos del sistema:");
            gestion.mostrarTodosLosPedidos();

            // Prueba de cambio de estado (Extra)
            System.out.println("\n> Actualizando estado del pedido...");
            pedido1.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
            System.out.println("Nuevo estado: " + pedido1.getEstado().getDescripcion());
            
            // Visualizar resumen detallado del pedido
            pedido1.resumen();

        } catch (IllegalArgumentException e) {
            System.err.println("ERROR DE VALIDACIÓN: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERROR INESPERADO: " + e.getMessage());
            e.printStackTrace();
        }

        // ---- PRUEBA DE ERROR ----
        System.out.println("\n--- PRUEBA DE VALIDACIÓN (DNI INCORRECTO) ---");
        try {
            Clientes clienteMalo = new Clientes("123", "Pepe", "pepe@mail.com", "600000000");
        } catch (IllegalArgumentException e) {
            System.out.println("Validación capturada correctamente: " + e.getMessage());
        }
    }
}