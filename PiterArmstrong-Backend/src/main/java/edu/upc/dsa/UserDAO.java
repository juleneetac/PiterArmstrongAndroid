package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.User;
//import edu.upc.eetac.dsa.model.User;

import java.util.List;

public interface UserDAO {
    public int addUser(String nick, String password);  // ok //vendría siendo el registrarse
    public User login(User user);
    public User getUser(String nick);   //ok
    public List<User> getUsers();  //ok
    public int updateUser(String usrname, User usr); //ok //actualiza al usuario, por ejemplo le quita vida, le da mas dinero... TAMBIÉN CAMBIAR CONTRASEÑA
    public int deleteUser(String nick, String password);  //ok
    public String getUserScreen(String username);
    public List<Objeto> getUserObjects(String nick);
    public int addObjectToUser(String nick, String nomobjeto);
}
