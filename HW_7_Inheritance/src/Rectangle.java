import java.util.Objects;

public class Rectangle implements Shape {
    private Double width;
    private Double height;

    Rectangle(Double width, Double height) {
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
    public void paint(String color) {
        System.out.println("Painting the rectangle the color " + color);
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