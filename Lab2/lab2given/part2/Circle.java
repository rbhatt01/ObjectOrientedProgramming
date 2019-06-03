public class Circle {
    private final Point point;
    private final double radius;
    public Circle(Point p, double rad) {
        point = p;
        radius = rad;
    }

    public Point getCenter() {
        return point;
    }

    public double getRadius() {
        return radius;
    }

    public double perimeter() {
        return Math.PI* 2 * getRadius();
    }
}