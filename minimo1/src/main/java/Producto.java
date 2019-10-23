import java.util.LinkedList;
import java.util.List;

public class Producto {
    private int idProducto;
    private String nomPro;
    private int numVentas;
    private int precio;
    private List<Producto> products = new LinkedList<Producto>();

    public Producto(int id, String nombre, int num, int prec) {
        idProducto = id;
        nomPro = nombre;
        numVentas = num;
        precio = prec;

    }
    //public void addProduct(int id, String name, int num, int prec){
        //products.add(new Producto(id, name, num, prec));

    public int getId() {
        return idProducto;
    }
    public String getNombre() {
        return nomPro;
    }
    public int getNumVentas() {
        return numVentas;
    }
    public int getPrecio() {
        return precio;
    }
}
