package model;

public enum EstadoPedido {
    EN_PREPARACION("En preparación"),
    LISTO_PARA_ENTREGAR("Listo para entregar"),
    ENTREGADO("Entregado");

    // Descripción legible del estado
    private final String descripcion;

    // Constructor privado del enum
    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para obtener la descripción del estado
    public String getDescripcion() {
        return descripcion;
    }

    // Método para verificar si el cambio de estado es válido (no retrocede)
    public boolean puedeAvanzarA(EstadoPedido nuevoEstado) {
        return nuevoEstado.ordinal() >= this.ordinal();
    }

}
