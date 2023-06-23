public class Main {
    public static void main(String[] args) {
        Shape[] arrayOfShapes = {
                new Circle(3.0),
                new Rectangle(1.0, 1.0),
                new Rectangle(1.0, 1.0),
                new Rectangle(1.0, 1.0),
                new Triangle(
                    new Point(3.0, 1.0),
                    new Point (2.0, 2.3),
                    new Point (1.5, 2.5)
                ),
                new Triangle(
                    new Point(0.0, 0.0),
                    new Point (1.0, 0.0),
                    new Point (0.0, 1.0)
                ),
        };

        for (Shape shape : arrayOfShapes) {
            System.out.println("The area of the shape is: " + shape.calculateArea());
            System.out.println("The perimeter of the shape is: " + shape.calculatePerimeter());
            shape.paint("green");
        }
    }
}
