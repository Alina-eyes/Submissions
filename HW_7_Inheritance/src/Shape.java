public abstract class Shape {
    public abstract Double calculateArea();

    public abstract Double calculatePerimeter();

    public void paint() {
        Color color = this.getColor();
        System.out.println(
            "Painting the " + this.getTypeName() + " the color " + color.toString() + " with hex color: " + color.getHexCode()
        );
    };

    protected abstract String getTypeName();

    private Color color;

    Color getColor() {
        return this.color;
    }

    Shape(Color color) {
        this.color = color;
    }
}
