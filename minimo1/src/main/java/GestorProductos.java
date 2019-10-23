import java.util.List;
import java.util.Queue;

public interface GestorProductos {
    public List<Producto> productOrdPrecio();
    public void anotarPedido (String id, Pedido c);
    public void servirPedido();
    public List<Producto> productOrdVentas();
    public Queue<Pedido> pedidosPorUsuario();



}
