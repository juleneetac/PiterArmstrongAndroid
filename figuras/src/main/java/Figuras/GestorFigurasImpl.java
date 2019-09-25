package Figuras;
import java.util.*;

public class GestorFigurasImpl implements GestorFiguras {

    public double sum(Figuras[] l){
        double ret = 0;
        for (Figuras f : l) {
            ret += f.getArea();
        }
        return ret;
    }
    public void sort(Figuras[] l){
        Arrays.sort(l);
    }

    public static void main(String[] args) {
        //Figuras rectangulo = new Rectangulo(6, 5);
        //Figuras cuadrado = new Cuadrado(5);
        //Figuras triangulo = new Triangulo(2, 8);
        //Figuras circulo = new Circulo(6);
        Figuras[] l = new Figuras[4];
        l[0] = new Cuadrado(1);
        l[1] = new Rectangulo(5, 6);
        l[2] = new Triangulo(2,8);
        l[3] = new Circulo(6);
        //System.out.println(rectangulo.getClass());
        //System.out.println("Area: "+rectangulo.getArea());

        //Figuras[]  figuras = {rectangulo, cuadrado, circulo, triangulo};

        GestorFiguras gf = new GestorFigurasImpl();
        double suma = gf.sum(l);
        System.out.println("Suma de Areas: "+suma);

        gf.sort(l);

        System.out.println(Arrays.asList(l));

    }
}
