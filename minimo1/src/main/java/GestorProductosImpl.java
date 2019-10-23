import java.util.*;

public class GestorProductosImpl implements GestorProductos {
    private HashMap<String, User> users;
    private List<Producto> productos;
    private Queue<Pedido> pedidos;


    private GestorProductosImpl(){
        this.productos = new ArrayList<Producto>();
        this.pedidos = new LinkedList<Pedido>();
        this.users = new HashMap<>();
    }

    public List<Producto> productOrdPrecio() { //1
        //We create a copy of the list
        List<Producto> ret = this.productos;
        ret.addAll(this.productos);

        //We have to tell to the sort method, which criteria we want to apply
        Collections.sort(ret, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                //Ascending order
                return (int) (o1.getPrecio() - o2.getPrecio());
            }
        });
        return ret;
    }

    public void anotarPedido (String id, Pedido c){ //2 //ID ALOMEJOR INNECESARIO
        LinkedList<Pedido> pedidos = null;
        User theUser = this.users.get(id);

        if(theUser!=null){
            pedidos = theUser.Pedido(); //CAMBIAR TIPO Y SE VA ERROR?
            pedidos.add(c);
        }
        else{
            this.users.put(id, new User(id, this.pedidos));
            pedidos.add(c);
        }

    }
    public void servirPedido(){ //3

    }
    public List<Producto> productOrdVentas(){ //4
        //We create a copy of the list
        List<Producto> ret = this.productos;
        ret.addAll(this.productos);

        //We have to tell to the sort method, which criteria we want to apply
        Collections.sort(ret, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                //Descending order
                return (-1)*(o1.getNumVentas()-o2.getNumVentas());
            }
        });

        return ret;

    }
    public Queue<Pedido> pedidosPorUsuario(){ //5
        Queue<Pedido> pedidos = null;

        //We want to find the given user
        User theUser = this.users.get(users);//preguntar sobre hashmap

        if(theUser!=null){
            pedidos = theUser.Pedido();
        }
        else throw new UserNotFoundException();

        return pedidos;

    }
}

