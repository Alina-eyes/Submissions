import java.util.Objects;

public class Rectangle extends Shape {
    private Double width;
    private Double height;

    Rectangle(Double width, Double height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public Double calculateArea() {
        return this.width * this.height;
    }

    @Override
    public Double calculatePerimeter() {
        return this.width * 2 + this.height * 2;
    }

    @Override
    protected String getTypeName() {
        return "rectangle";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(width, rectangle.width) && Objects.equals(height, rectangle.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}