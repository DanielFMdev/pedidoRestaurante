package model;

import controller.EstadoPedido;

public class Pedidos {
    private static final int MAX_ARTICULOS = 5; // Límite máximo de artículos por pedido
    private static int contador = 1; // Contador para generar ID
    private int id;
    private Clientes cliente; // MODIFICADO: Para integrar clase Clientes
    private Articulos[] articulo;
    private EstadoPedido estado;
    private int numeroArticulos;

    // Constructor del pedido
    public Pedidos(Clientes cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El pedido debe tener un cliente válido");
        }

        this.id = contador++;
        this.cliente = cliente; // MODIFICADO: Para integrar tu clase Clientes
        this.articulo = new Articulos[MAX_ARTICULOS];
        this.numeroArticulos = 0;
        this.estado = EstadoPedido.EN_PREPARACION;
    }

    // Método para agregar un artículo al pedido
    public boolean agregarArticulos(Articulos articulo) {
        if (articulo == null) {
            throw new IllegalArgumentException("El artículo no puede ser null");
        }

        if (numeroArticulos >= MAX_ARTICULOS) {
            System.out.println("No se pueden añadir más artículos. Número máximo de artículos alcanzado: " + MAX_ARTICULOS);
            return false;
        }

        this.articulo[numeroArticulos] = articulo;
        numeroArticulos++;
        System.out.println("Artículo añadido: " + articulo.getNombre());
        return true;
    }

    // Sobrecarga del método para agregar artículos directamente con parámetros
    public boolean agregarArticulos(String nombre, int cantidad, double precioUnitario) {
        Articulos articulo = new Articulos(nombre, cantidad, precioUnitario);
        return agregarArticulos(articulo);
    }

    // Método para calcular el impuesto IGIC (7%)
    public double impuesto() {
        double subtotalPedido = 0;
        for (int i = 0; i < numeroArticulos; i++) {
            subtotalPedido += articulo[i].subtotal(); // Suma el subtotal de cada artículo para obtener el subtotal del pedido
        }
        double igic = subtotalPedido * 0.07; // 7% de IGIC
        return igic;
    }

    // Método para calcular el total del pedido
    public double total() {
        double total = 0;
        for (int i = 0; i < numeroArticulos; i++) {
            total += articulo[i].subtotal(); // MODIFICADO: llamada a método de instancia
        }
        return total + impuesto();
    }

    // Método para cambiar el estado del pedido
    public boolean cambiarEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("El nuevo estado no puede ser null");
        }

        // Validación de estados
        // Solo se permite avanzar al siguiente estado o permanecer en el mismo
        if (!estado.puedeAvanzarA(nuevoEstado)) {
            System.out.println("No se puede cambiar al estado " + nuevoEstado.getDescripcion() + " desde " + estado.getDescripcion());
            return false;
        }

        // Cambio de estado
        EstadoPedido estadoAnterior = this.estado;
        this.estado = nuevoEstado;
        System.out.println("Estado cambiado de " +
                estadoAnterior.getDescripcion() + " a " + nuevoEstado.getDescripcion());
        return true;
    }

    // Resumen del pedido
    public void resumen() {
        System.out.println("=".repeat(50));
        System.out.println("Número de pedido: #" + id);
        System.out.println("Cliente: " + cliente.getNombre() + " | DNI: " + cliente.getDni()); // MODIFICADO: Para integrar clase Clientes
        System.out.println("Estado: " + estado.getDescripcion());
        System.out.println("Artículos:");

        // Detalle de cada artículo
        for (int i = 0; i < numeroArticulos; i++) {
            Articulos a = articulo[i];
            System.out.println("· " + a.getNombre() + " x" + a.getCantidad() + " -> " +
                    a.getPrecioUnitario() + "€ = " + a.subtotal() + "€");
        }

        System.out.printf("Total: %.2f€%n", total());
        System.out.println("=".repeat(50));
    }

    public String toString() {
        return String.format("Pedido #%d - %s (%s) - %.2f€",
                            id, cliente, estado.getDescripcion(), total());
    }

    public int getId() {
        return id;
    }

    public Clientes getNombreCliente() {
        return cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public int getNumeroArticulos() {
        return numeroArticulos;
    }

    public int getMaxArticulos() {
        return MAX_ARTICULOS;
    }

    // Método para obtener un artículo por su índice
    public Articulos getArticulo(int index) {
        if (index < 0 || index >= numeroArticulos) {
            throw new IndexOutOfBoundsException("Índice de artículo fuera de rango");
        }
        return articulo[index];
    }

    public void setNombreCliente(Clientes cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }
        this.cliente = cliente;
    }

    public int getSiguienteId() {
        return contador;
    }

    public boolean completo() {
        return numeroArticulos == MAX_ARTICULOS;
    }

    public boolean vacio() {
        return numeroArticulos == 0;
    }
}