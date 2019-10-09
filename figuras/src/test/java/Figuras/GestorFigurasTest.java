package Figuras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GestorFigurasTest {
    Figuras[] l;

    @Before
    public void setUp(){
        l = new Figuras[4];
        l[0] = new Cuadrado(1);
        l[1] = new Rectangulo(5, 6);
        l[2] = new Triangulo(2,8);
        l[3] = new Circulo(6);
    }

    @Test
    public void testSuma(){
        GestorFiguras gestor = new GestorFigurasImpl();
        double r = gestor.sum(l);
        Assert.assertEquals("suma",152.09, r,0.25);
    }
}
