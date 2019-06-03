import java.awt.*;

public class Triangle implements Shape {
    private Point a;
    private Point b;
    private Point c;
    private Color color;
    public Triangle(Point a, Point b, Point c, Color color) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color c) {
        color = c;
    }
    public double getArea(){
       return Math.abs((a.getX()*(b.getY()-c.getY())+ b.getX()*(c.getY()-a.getY())+c.getX()*(a.getY()-b.getY()))/2);
    }
    public double getPerimeter(){
        double side1 = Math.sqrt(Math.pow(a.getX()-b.getX(), 2) + Math.pow(a.getY()-b.getY(), 2));
        double side2 = Math.sqrt(Math.pow(b.getX()-c.getX(), 2) + Math.pow(b.getY()-c.getY(), 2));
        double side3 = Math.sqrt(Math.pow(a.getX()-c.getX(), 2) + Math.pow(a.getY()-c.getY(), 2));
        return side1+side2+side3;
    }
    public void translate(Point p) {
        a = new Point((int)(p.getX() + a.getX()),(int)(p.getY() + a.getY()));
        b = new Point((int)(p.getX() + b.getX()), (int)(p.getY() + b.getY()));
        c = new Point((int)(p.getX() + c.getX()), (int)(p.getY() + c.getY()));
    }
    public Point getVertexA(){
        return a;
    }
    public Point getVertexB(){
        return b;
    }
    public Point getVertexC(){
        return c;
    }
    public boolean equals(Object obj){
        if(obj!= null) {
            if(obj.getClass() == this.getClass()){
                if(((Triangle)obj).getVertexA().equals(a)&& ((Triangle)obj).getVertexB().equals(b) && ((Triangle)obj).getVertexC().equals(c)
                && ((Triangle)obj).getColor().equals(color)){
                    return true;
                }
            }
        }
        return false;
    }
}
