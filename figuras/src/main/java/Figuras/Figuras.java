package Figuras;
import java.util.*;
public abstract class Figuras implements Comparable <Figuras> {
    abstract public double getArea();
    public int compareTo(Figuras f){
        return (int)(this.getArea() - f.getArea());
    }

    public String toString() {
        return this.getClass().getSimpleName()+" "+this.getArea();
    }
}
