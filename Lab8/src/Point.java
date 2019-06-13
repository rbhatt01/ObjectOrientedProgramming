import java.lang.Math;
class Point {
    private double xPos;
    private double yPos;
    private double zPos;
    public Point(double x, double y, double z) {
        xPos = x;
        yPos = y;
        zPos = z;
    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    public double getZ() {
        return zPos;
    }

    public Point scale(double scaleFactor){

        return new Point(scaleFactor*this.getX(), scaleFactor*this.getY(), scaleFactor*this.getZ());
    }

    public Point translate(Point translater)
    {
        xPos = xPos + translater.getX();
        yPos = yPos + translater.getY();
        zPos = zPos + translater.getZ();
        return this;
    }


}