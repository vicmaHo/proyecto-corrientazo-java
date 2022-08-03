package co.com.victorhernandez.model;

import java.util.ArrayList;
import java.util.List;

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
        return 0;
    }

    public Integer pagar(Integer efectivo) {
        return 0;
    }

    // Getter
    public String getNumero() {
        return numero;
    }


    
}
