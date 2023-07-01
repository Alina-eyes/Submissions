import java.util.Objects;

public class Circle extends Shape {
    private Double radius;

    Circle(Double radius, Color color) {
        super(color);
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
    protected String getTypeName() {
        return "circle";
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