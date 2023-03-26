package Polimorphism5.Lab.PolimorphismShapesLab02;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }
    public final Double getRadius() {
        return radius;
    }
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    //TODO: Finish encapsulation
    //TODO: Override calculate Area and Perimeter
    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    public void calculateArea() {
        setPerimeter(Math.PI * radius * radius);
    }
}

