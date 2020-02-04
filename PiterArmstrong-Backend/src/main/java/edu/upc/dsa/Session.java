package edu.upc.dsa;

import java.util.HashMap;
import java.util.List;

public interface Session<E> {  //estan en orden en el implement
    void save(Object entity);  //ok  esto es registrarse en verdad
    Object login(Class theClass, int ID);  //ok
    void update(Object object, int ID);    //ok
    void delete(Object object, int ID);     //ok
    Object get(Class theClass, int ID);    //ok
    List<Object> findAll(Class theClass);    //ok
    List<Object> findAllObjects(Class theClass, int ID); //ok
    int getIDverify(Class theClass, String username, String password); //ok
     int getIDObjeto(Class theClass, String nick);
    int getID(Class theClass, String username);  //ok
    void close();  //ok
    void SaveObject(Object entity);

    List<Object> findAll(Class theClass, HashMap params);   //supongo que esto es para que me de todos los usuarios en una lista
    List<Object> query(String query, Class theClass, HashMap params);  // ni idea que tiene que hacer esto
}
