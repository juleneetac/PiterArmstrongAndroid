public class GestorProductosTest {
    GestorProductos g = null;
    public void setUp() {
        g = new GestorProductosImpl();
//        g.addProduct("COCA-ZERO", 2.5);
//        g.addProduct("CAFE-SOLO", 1);
//        g.addProduct("BOCATA-JAMON", 3);

//        g.addUser("28282X", "Toni");
    }



    public void testPedido() {
        Pedido p = new Pedido();
        //p.addUser("28282X");
        p.addLP(2, "COCA-ZERO");
        p.addLP(1, "BOCATA-JAMON");

        g.anotarPedido("28282X", p);
    }
}
