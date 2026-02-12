package model;

public class Articulos {
    private String nombre;
    private int cantidad;    // MODIFICADO: Quitada palabra 'static'
    private double precioUnitario;   // MODIFICADO: Quitada palabra 'static'

    // Constructor del artículo con validación de parámetros
    public Articulos(String nombre, int cantidad, double precioUnitario) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del artículo no puede estar vacío");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }
        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.nombre = nombre.trim();
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // MODIFICADO: Quitada palabra 'static' para que calcule el total de ESTE artículo
    public double subtotal() {
        return cantidad * precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Método para actualizar el nombre con validación
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del artículo no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    // Método para actualizar la cantidad con validación
    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0");
        }
        this.cantidad = cantidad;
    }

    // Método para actualizar el precio unitario con validación
    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precioUnitario = precioUnitario;
    }

    // Método para obtener una representación formateada del artículo
    public String toString() {
        return String.format("%s %dx - $%.2f€/u (Subtotal: %.2f€)",
                            nombre, cantidad, precioUnitario, subtotal());
    }
}
