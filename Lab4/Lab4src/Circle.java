import java.awt.*;

public class Circle implements  Shape{
    private Color color;
    private double radius;
    private Point center;
    public Circle(double radius, Point center, Color color) {
        this.center = center;
        this.color = color;
        this.radius = radius;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color c) {
        color = c;
    }
    public double getArea() {
        return Math.PI* Math.pow(radius, 2);
    }
    public double getPerimeter(){
        return Math.PI* 2* radius;
    }
    public void translate(Point p) {
        center = new Point((int)(p.getX()+ center.getX()), (int)(p.getY() + center.getY()));
    }
    public Point getCenter(){
        return center;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public boolean equals(Object obj){
        if(obj != null) {
            if (obj.getClass() == this.getClass()){
                if(((Circle)obj).radius == radius && ((Circle)obj).color == color && ((Circle)obj).getCenter().equals(center)) {
                    return true;
                }
            }
        }
        return false;
    }
}
