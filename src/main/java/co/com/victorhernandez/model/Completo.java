package co.com.victorhernandez.model;

public class Completo extends OpcionPedido {
    // asociacion
    private OpcionSopa sopa;


    public Completo(Integer precio) {
        super(precio);
    }

    public Completo(Integer precio, OpcionSopa sopa, OpcionPrincipio principio, OpcionCarne carne, OpcionJugo jugo) {
        super(precio, principio, carne, jugo);
        this.sopa = sopa;
    }

    public Completo(Integer precio, OpcionSopa sopa, OpcionPrincipio principio, OpcionCarne carne, OpcionEnsalada ensalada,
            OpcionJugo jugo) {
        super(precio, principio, carne, ensalada, jugo);
        this.sopa = sopa;
    }

    public OpcionSopa getSopa() {
        return sopa;
    }

    public void setSopa(OpcionSopa sopa) {
        this.sopa = sopa;
    }
    
}
