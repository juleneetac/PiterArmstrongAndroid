package Figuras;

public class Triangulo extends Figuras {
    private double base;
    private double altura;

    public Triangulo(double base1, double altura1){
        base = base1;
        altura = altura1;
    }
    public double area(){
        return base*altura;
    }
}
