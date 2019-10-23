import java.util.LinkedList;
import java.util.List;

public class Pedido {
    public String idUserp;
    public List<Producto> productos;
//preguntar sobre de donde se saca la lista de productos que existen
    public Pedido(String id) {
        idUserp = id;
        productos = new LinkedList<Producto>();
    }
    public void addPed(int cantidad,String idproducto)//que hacer con cantidad
    {


    }
    public String getId() {
        return idUserp;
    }
}

