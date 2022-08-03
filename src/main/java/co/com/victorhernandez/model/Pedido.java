package co.com.victorhernandez.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // Asociaciones
    private EstadoPedido estado;
    private List<Adicional> adicionales;
    private OpcionPedido opcion;
    // Atributos
    private String cliente;

    // Construtores
    public Pedido(String cliente) {
        // this(cliente, null);
        this.cliente = cliente;

        this.estado = EstadoPedido.PENDIENTE_ENTREGAR;
        this.adicionales = new ArrayList<Adicional>();
    }

    public Pedido(String cliente, OpcionPedido opcion) {
        this.opcion = opcion;
        this.cliente = cliente;

        this.estado = EstadoPedido.PENDIENTE_ENTREGAR;
        this.adicionales = new ArrayList<Adicional>();
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public String getCliente() {
        return cliente;
    }

    public OpcionPedido getOpcion() {
        return opcion;
    }

    public void setOpcion(OpcionPedido opcion) {
        this.opcion = opcion;
    }

    // Metodos
    public void entregar() {
        this.estado = EstadoPedido.PENDIENTE_COBRAR;
    }

    public void agregarAdicional(Adicional adicional) {
        this.adicionales.add(adicional);
    }

    public Integer calcularTotal() {
        return opcion.getPrecio()
                + adicionales.stream() // convertimos la liista a un flujo de datos
                        .map(a -> a.getPrecio()) // recorremos la lista obteniedno el precio con un map
                        .reduce((a, b) -> a + b) // reducimos la lista sumando sus precios
                        .orElse(0); // obtenemos el valor total de esa lista, si no existe valor devuelva un 0
    }

}
