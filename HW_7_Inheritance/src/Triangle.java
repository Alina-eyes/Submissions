import java.util.Objects;

public class Triangle implements Shape {
    private Point p1;
    private Point p2;
    private Point p3;

    Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public Double calculateArea() {
        // https://en.wikipedia.org/wiki/Heron%27s_formula
        Double a = this.distance(p1, p2);
        Double b = this.distance(p2, p3);
        Double c = this.distance(p3, p1);
        Double s = (a + b + c) * 0.5;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private Double distance(Point p1, Point p2) {
        // Pythagoras
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    @Override
    public Double calculatePerimeter() {
        Double a = this.distance(p1, p2);
        Double b = this.distance(p2, p3);
        Double c = this.distance(p3, p1);
        return a + b + c;
    }

    @Override
    public void paint(String color) {
        System.out.println("Painting the triangle the color " + color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Triangle other = ((Triangle) obj);
        return this.p1.equals(other.p1) && this.p2.equals(other.p2) && this.p3.equals(other.p3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, p3);
    }
}