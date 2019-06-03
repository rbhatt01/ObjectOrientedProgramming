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
}