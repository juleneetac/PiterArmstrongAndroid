package Figuras;
import java.util.*;
public class Circulo extends Figuras {
    private double radio;
    private double diametro;

    public Circulo(double radio1){
        radio = radio1;
        diametro = radio1*2;
    }
    public double getArea(){
        return Math.PI*(radio*radio);
    }
}
