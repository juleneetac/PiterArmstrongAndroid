import java.util.LinkedList;
import java.util.List;

public class Pedido {
    public String idUserp;
    public List<LP> lps;
//preguntar sobre de donde se saca la lista de productos que existen
    public Pedido(String id) {
        idUserp = id;
        lps = new LinkedList<LP>();
    }
    public void addPed(int cantidad,String idproducto)//que hacer con cantidad
    {


    }



    public String getId() {
        return idUserp;
    }

    public void addLP(int i, String s) {
        this.lps.add(new LP(i, s));
    }

    public List<LP> getLPs() {
        return this.lps;
    }

    public class LP {
        private int q;
        private String producto;

        protected LP (int i, String s) {
            this.q = i;
            this.producto = s;
        }

        public String getProducto() {
            return producto;
        }
    }
}

