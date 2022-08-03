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
        //this(cliente, null);
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

    public void agregarAdicional (Adicional adicional) {
        this.adicionales.add(adicional);
    }

    public Integer calcularTotal() {
        return 0;
    }

}
