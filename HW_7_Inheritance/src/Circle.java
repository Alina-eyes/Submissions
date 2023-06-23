import java.util.Objects;

public class Circle implements Shape {
    private Double radius;

    Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public Double calculatePerimeter() {
        return Math.PI * 2 * this.radius;
    }

    @Override
    public void paint(String color) {
        System.out.println("Painting the circle the color " + color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Objects.equals(radius, circle.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}