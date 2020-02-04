package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.util.ObjectHelper;
import edu.upc.dsa.util.QueryHelper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {  //seria como registrarse porque usa el INSERT en el comando sql
        String insertQuery = QueryHelper.createQueryINSERT(entity); // tambien sirve para añadir un objeto a la tabla de objetos
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);   //la i es la posición de los interrogantes y la o el valor que le pone
            int i = 2;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void SaveObject(Object entity) {  //añade un objeto a un user en la tabla de UserObject
        String insertobjQuery = QueryHelper.createQueryINSERTOBJ(entity);     //NO TENGO CLARO QUE ESTE BIEN

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(insertobjQuery);
            //pstm.setObject(1, 0);   //la i es la posición de los interrogantes y la 0 el valor que le pone
            int i = 1;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public Object login(Class theClass, int ID) {
        String selectQuery = QueryHelper.createQuerySELECT(theClass);

        Object entity = null;
        try {
            entity = theClass.getDeclaredConstructor().newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {   //para el getDeclaredConstructor()
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1,ID);
            rs = pstm.executeQuery();


            while(rs.next()){
                Field[] fields = theClass.getDeclaredFields();
                rs.getString(1);
                for (int i = 0; i<fields.length; i++){
                    String fieldName = this.getNameCampo(i+2, rs);
                    ObjectHelper.setter(entity, fieldName, rs.getObject(i + 2));
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public void update(Object object, int ID) {
        String updateQuery = QueryHelper.createQueryUPDATE(object);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(updateQuery);
            int i = 1;
            for (String field : ObjectHelper.getFields(object)) {
                pstm.setObject(i++, ObjectHelper.getter(object, field));
            }
            pstm.setObject(i, ID);   // probablemente redunante  // la "i" es 1 porque no le afecta lo del for
            pstm.executeUpdate(); //executeUpdate method execute sql statements that insert/update/delete data at the database.
                                   //This method return int value representing number of records affected; Returns 0 if the query returns nothing
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void delete(Object object, int ID) {    //borra un usuario o objeto el cual le pasamos id como parametro
        String deleteQuery = QueryHelper.createQueryDELETE(object);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(deleteQuery);
            pstm.setObject(1, ID);

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Object get(Class theClass, int ID) {   //lo daba el profe pero no lo utilizamos alfinal
        String selectQuery = QueryHelper.createQuerySELECT(theClass);
        Object entity = null;
        try {
            entity = theClass.getDeclaredConstructor().newInstance();   //esto es nuevo antes era newInstance solo
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {   //excepción para el getDeclaredConstructor
            e.printStackTrace();
        }
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1,ID);
            rs = pstm.executeQuery();  //execute statements that returns a result set by fetching some data from the database.


            while(rs.next()){
                Field[] fields = theClass.getDeclaredFields();
                rs.getString(1);
                for (int i = 0; i<fields.length; i++){
                    String campoName = this.getNameCampo(i+2, rs);  //quiere decir que coge la columna i y le suma 2
                    ObjectHelper.setter(entity, campoName, rs.getObject(i + 2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return entity;
    }


    public List<Object> findAll(Class theClass) {      //obtiene todos los datos de una tabla
        String findAllQuery = QueryHelper.createQuerySELECTall(theClass);

        Object entity = null;
        List<Object> listOfObjects = new ArrayList<Object>();

        try {
            entity = theClass.getDeclaredConstructor().newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {  //excepcion para newInstance
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {   //excepción para el getDeclaredConstructor
            e.printStackTrace();
        }
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(findAllQuery);
            rs = pstm.executeQuery();

            while(rs.next()){   //recorre cada fila
                Field[] fields = theClass.getDeclaredFields();
                rs.getString(1);     //te da el id que esta en la columna 1
                for (int i = 0; i<fields.length; i++){
                    ObjectHelper.setter(entity, fields[i].getName(), rs.getObject(i + 2));   // "i" lo hemos inicializado a 0
                }                                                                             // por tanto ponemos i +2 que sera la siquiente columna 2, 3, ...
                listOfObjects.add(entity);
                entity = theClass.getDeclaredConstructor().newInstance();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listOfObjects;
    }
    public List<Objeto> findAllObjects(Class theClass, int ID) {    //principalmente sera para obtener los objetos de un jugador
        String findAllQuery = QueryHelper.createQuerySELECTIDuserRelacion(theClass);     //que devolvera una lista con los id de los objetos que tiene
        Object entity = null;                                              //un user que pasamos su id como parametro
        List<Object> listOfObjects = new ArrayList<Object>();
List<Integer> numeros= new ArrayList<Integer>();
        try {
            entity = theClass.getDeclaredConstructor().newInstance();       //ACABAR TODO LO QUE DERIVA DE ESTO
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(findAllQuery);
            pstm.setObject(1, ID);
            rs = pstm.executeQuery();

            while(rs.next()){
                Field[] fields = theClass.getDeclaredFields();  //fields--> obtener campos declarados en esta clase:name, address, id
                //rs.getString(1);
              numeros.add( rs.getInt(2)); //me devuelve la columna 2
               // entity = theClass.getDeclaredConstructor().newInstance();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        int i=0;
        List<Objeto> objetos= new ArrayList<>();


            String selectQuery = QueryHelper.createQuerySELECT(Objeto.class);

            Objeto entity2 = new Objeto();
int buscar;
        while (i<numeros.size()) {

           buscar= numeros.get(i);
            ResultSet rs2 = null;
            PreparedStatement pstm2 = null;

            try {
                pstm2 = conn.prepareStatement(selectQuery);
                pstm2.setObject(1,buscar);
                rs2 = pstm2.executeQuery();


                while(rs2.next()){
                    Field[] fields = theClass.getDeclaredFields();
                    rs2.getString(1);
                    for (int j = 0; j<fields.length; j++){
                        String fieldName = this.getNameCampo(i+2, rs2);
                        ObjectHelper.setter(entity2, fieldName, rs2.getObject(i + 2));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            objetos.add(entity2);
            i++;
        }




        return objetos;
    }
/**
    public List<Object> findAllObjects(Class theClass, String nickname) {    //obtiene todos los datos de una tabla la cual
        String findAllQuery = QueryHelper.createQuerySELECTUser(theClass);    //le paso el nickname de un usuario
        Object entity = null;
        List<Object> listOfObjects = new ArrayList<Object>();
        try {
            entity = theClass.getDeclaredConstructor().newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(findAllQuery);
            pstm.setObject(1, nickname);
            rs = pstm.executeQuery();

            while(rs.next()){
                Field[] fields = theClass.getDeclaredFields();  //fields--> obtener campos declarados en esta clase:name, address, id
                rs.getString(1);
                for (int i = 0; i<fields.length; i++){  //lo ejecuto el numero de veces de filas que tenga en la tabla
                    ObjectHelper.setter(entity, fields[i].getName(), rs.getObject(i + 2));
                }

                listOfObjects.add(entity);
                entity = theClass.getDeclaredConstructor().newInstance();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listOfObjects;
    }
*/



    public int getIDverify(Class theClass, String nick, String password) //Obtiene id de la base de datos de un usuario pero verificado con su password
    {                                   //principalmente para login y para borrar un user se tendrá que verificar
        String selectQuery = QueryHelper.createQuerySELECTIDverify(theClass);
        ResultSet rs;
        PreparedStatement pstm;
        int id = 0; // lo pongo a 0
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, nick);   //en el primer interrogante va el nickname
            pstm.setObject(2, password);   // en el segundo va el password
            rs = pstm.executeQuery(); //cambiar para que haga algo si no lo encuentra
            rs.next();
            id = rs.getInt(1);  //obtiene el ID encontrado
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new UserNotFoundException();

        }

        return id;   // si no lo encuentra  el id es 0 y si lo encuentra pues devuelve el id que tiene
    }


    public int getID(Class theClass, String nick) //obtiene id de un usuario sin necesidad de verificar
    {                                 ////principalmente para obtener datos del user y para modificar su atributos
        String selectQuery = QueryHelper.createQuerySELECTID(theClass);

        ResultSet rs;
        PreparedStatement pstm;

        int id = 0;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, nick);
            rs = pstm.executeQuery();

            rs.next();

            id = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            //throw new UserNotFoundException();
        }
        return id;
    }
    public int getIDObjeto(Class theClass, String nick) //obtiene id de un usuario sin necesidad de verificar
    {                                 ////principalmente para obtener datos del user y para modificar su atributos
        String selectQuery = QueryHelper.createQuerySELECTIDOBJETO(theClass);

        ResultSet rs;
        PreparedStatement pstm;

        int id = 0;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, nick);
            rs = pstm.executeQuery();

            rs.next();

            id = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            //throw new UserNotFoundException();
        }
        return id;
    }
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> findAll(Class theClass, HashMap params) {    //es como la de arriba pero le paso ya el username directo
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {  // no entiendo que debe dar aqui
        return null;
        // SElect * from usuarios WHERE provincia='Barcelona' AND edad>17
    }

    private String getNameCampo(int i, ResultSet rs) throws SQLException {   //metodo privado para darme el nombre de un campo
        ResultSetMetaData rsmd = rs.getMetaData();    // viene de "public interface ResultSetMetaData extends Wrapper" que es de java.sql
        String name = rsmd.getColumnName(i);
        return name;
    }

}
/**
 public static void main(String[] args) {

 SessionImpl s= new SessionImpl();
 HashMap params = new HashMap();
 params.put(new Condition("=","provincia", "Barcelona");
 params.put(new Condition(">","edad", "25"");

 s.findAll(User.class, params);

 }
 */
