package co.com.victorhernandez.model;

import java.util.ArrayList;
import java.util.List;

import co.com.victorhernandez.exception.EfectivoInsuficienteException;

public class Mesa {
    // asociaciones - 1 mesa cuenta con varios pedidos (una lista)
    private List<Pedido> pedidos;

    // Atributos
    private String numero;

    // Construcor
    public Mesa(String numero) {
        this.numero = numero;

        pedidos = new ArrayList<Pedido>(); // inicializo la lista de pedidos
    }

    // Metodos
    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido); // a la lista pedido, le adiciono el pedido
    }

    public Integer calcularValorPagar() {
        return pedidos.stream() // convierto los pedidos en un flujo de datos
                .filter(p -> p.getEstado() == EstadoPedido.PENDIENTE_COBRAR) // filtro los pedidos que tiene el estado
                                                                             // pendiente por cobrar
                .map(p -> p.calcularTotal()) // hago un map para calcular el valor a cobrar por esos pedidos
                .reduce((a, b) -> a + b) // lo reduzco sumando los valores
                .orElse(0); // obtengo el valor
    }

    public Integer pagar(Integer efectivo) throws EfectivoInsuficienteException {
        // Validar datos
        Integer total = calcularValorPagar();
        if (efectivo < total) {
            throw new EfectivoInsuficienteException("El efectivo entregado es insuficiente para completar el pago");
        }

        // limipar pedidos
        pedidos.clear();
        // retornar devuelta
        return efectivo - total;
    }

    // Getter
    public String getNumero() {
        return numero;
    }

}
