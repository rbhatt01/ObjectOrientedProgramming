public class Rectangle {
    private final Point topLeft;
    private final Point bottomRight;
    public Rectangle(Point top, Point bottom) {
        topLeft = top;
        bottomRight = bottom;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public double perimeter() {
        Point top = getTopLeft();
        Point bottom = getBottomRight();
        double height = Math.abs(top.getY() - bottom.getY());
        double width = Math.abs(bottom.getX() - top.getX());
        return height*2 + width * 2;
    }
}