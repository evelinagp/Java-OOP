package PolymorphismShapesLab01;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle(13);
        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());
    }
}
