import java.lang.Math;
class Point {
    private double xPos;
    private double yPos;
    public Point(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    public double getRadius() {
        double x = xPos * xPos;
        double y = yPos * yPos;
        return Math.sqrt(x + y);
    }

    public double getAngle() {
        return Math.atan(yPos/xPos);
    }

    public Point rotate90(){
        double newY = getX();
        double newX = getY() * -1;
        return new Point(newX, newY);
    }
}