package Figuras;

public abstract class Figuras implements Comparable <Figuras> {
    abstract public double area();
    public int Compareto(Figura f){
        return(this.area() - f.area);
    }
}
