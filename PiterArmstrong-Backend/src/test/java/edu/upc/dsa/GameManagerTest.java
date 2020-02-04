package edu.upc.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
public class GameManagerTest {

    private GameManger mm;

    @Before
    public void SetUp() throws Exception {
        mm = GameManagerImpl.getInstance();

        mm.addJugador("u1", "Julen", "vava");
        mm.addObjeto("espada", "u1");
        mm.addObjeto("martillo", "u1");
        mm.addObjeto("moneda", "u1");
    }



    @Test
    public void testAddObjeto() throws Exception {     //test para añadir un objeto asociado a un usuario
        mm.addObjeto("llave", "u1");
        Assert.assertEquals(4, mm.numerosObjetos("u1"));

        mm.addObjeto("vara", "u1");
        Assert.assertEquals(5, mm.numerosObjetos("u1"));
    }

    @Test
    public void testAddUser() throws Exception {   //test para añadir un usuario en el sistema
        mm.addJugador("r3", "nene", "tene");
        Assert.assertEquals(2, mm.sizeJugadores());

    }


    @After
    public void tearDown(){
        mm.clear();
    }
}
 */
