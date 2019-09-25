package java;

import Figuras.Rectangulo;
import Figuras.Triangulo;
import Figuras.Cuadrado;
import Figuras.Figuras;
import Figuras.Circulo;

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
        r = GestorFiguras.sum(l);
        assertEquals(152.09733552923257, r);
    }
}
