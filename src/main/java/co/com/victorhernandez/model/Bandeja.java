package co.com.victorhernandez.model;

public class Bandeja extends OpcionPedido{

    public Bandeja(Integer precio) {
        super(precio);
    }

    public Bandeja(Integer precio, OpcionPrincipio principio, OpcionCarne carne, OpcionJugo jugo) {
        super(precio, principio, carne, jugo);
    }

    public Bandeja(Integer precio, OpcionPrincipio principio, OpcionCarne carne, OpcionEnsalada ensalada,
            OpcionJugo jugo) {
        super(precio, principio, carne, ensalada, jugo);
    }





    
}
