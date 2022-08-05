package co.com.victorhernandez;

import co.com.victorhernandez.model.Adicional;
import co.com.victorhernandez.model.Bandeja;
import co.com.victorhernandez.model.Completo;
import co.com.victorhernandez.model.Mesa;
import co.com.victorhernandez.model.OpcionCarne;
import co.com.victorhernandez.model.OpcionEnsalada;
import co.com.victorhernandez.model.OpcionJugo;
import co.com.victorhernandez.model.OpcionPrincipio;
import co.com.victorhernandez.model.OpcionSopa;
import co.com.victorhernandez.model.Pedido;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        //  Creo la mesa
        var mesa = new Mesa("1");

        // Creo las opciones de pedidos
        var sopa = new OpcionSopa("Pasta");
        var principio = new OpcionPrincipio("Frijoles");
        var carne = new OpcionCarne("Cerdo asada");
        var ensalada = new OpcionEnsalada("Ensalada fria");
        var jugo = new OpcionJugo("Lulo");

        // Cliente y su opcion de pedido
        var victor = new Pedido("Victor");
        victor.setOpcion((new Completo(12_000, sopa, principio, carne, ensalada, jugo)));

        // Clente y su opcion de pedido 
        var manuel = new Pedido("Manuel");
        manuel.setOpcion(new Bandeja(10_000, principio, carne, ensalada, jugo));
        manuel.agregarAdicional(new Adicional("Huevo", 1_000));
        manuel.agregarAdicional(new Adicional("Papas fritas", 3_000));

        mesa.agregarPedido(victor);
        mesa.agregarPedido(manuel); 

        victor.entregar();
        manuel.entregar();

         
        // calculo el valor a pagar en la mesa
        var total = mesa.calcularValorPagar();
        System.out.printf("La mesa %s debe $%,d %n", mesa.getNumero(), total);

        // realizando el pago
        try {
            var efectivo = 100_000;
            var devuelta = mesa.pagar(efectivo); // el metodo pagar puede lanzar una excepcion
            System.out.printf("La mesa %s paga $%,d y recibe como devuelta $%,d %n", mesa.getNumero(), efectivo, devuelta);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
