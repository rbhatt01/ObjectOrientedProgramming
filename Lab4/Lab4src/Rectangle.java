import org.w3c.dom.css.Rect;

import java.awt.*;

public class Rectangle implements Shape{
    private Color color;
    private Point topLeft;
    private double width;
    private double height;
    public Rectangle(double width, double height, Point topLeft, Color color) {
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color c) {
        color = c;
    }
    public double getArea(){
        return width * height;
    }
    public double getPerimeter(){
        return 2*width + 2*height;
    }
    public void translate(Point p){
        topLeft = new Point((int)(p.getX()+ topLeft.getX()), (int)(p.getY()+ topLeft.getY()));
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Point getTopLeft() {
        return topLeft;
    }
    public boolean equals(Object obj) {
        if (obj != null ) {
            if(obj.getClass() == this.getClass()) {
                if(((Rectangle)obj).getColor() == color && ((Rectangle)obj).getWidth() == width &&
                        ((Rectangle)obj).getHeight() == height && ((Rectangle)obj).getTopLeft().equals(topLeft)){
                    return true;
                }
            }
        }
        return false;
    }
}
