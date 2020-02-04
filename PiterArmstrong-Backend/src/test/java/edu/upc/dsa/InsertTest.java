package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertTest {
    @Test
    public void testQueryINSERT() {

       // Assert.assertEquals("INSERT INTO User (ID, nickname, password, vida, defensa, ataque, dinero) VALUES (?, ?, ?, ?, ?, ?, ?)",
         //       QueryHelper.createQueryINSERT(new User("Julen", "1234", 100, 100, 100, 100 )));
    }


    private UserDAO usr;
    @Before
    public void SetUp(){
        this.usr = UserDAOImpl.getInstance();
        }

    @Test
    public void insertUserTest(){
        //User user = new User("Roger","1234");
        this.usr.addUser("Julen", "1234");
        //this.btr.addEmployee("Laia","Munoz",9000);
        //this.btr.clear();
    }
    @Test
    public void getusertest(){

        Assert.assertEquals("Pepe",usr.getUser("Pepe").getUsername());  //test de getuser

    }
    @Test
    public void InsertObjectTest() {

        this.usr.addObjectToUser("Pepe","Casco");
    }
    @Test
    public void GetObjectosTest() {
        List<Objeto> lista= new ArrayList<>();

             lista=   (List<Objeto>) this.usr.getUserObjects("Pepe");

        Assert.assertEquals("Casco",lista.get(0).getNombre());
    }
}
