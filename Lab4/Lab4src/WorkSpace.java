import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WorkSpace {
    private List<Shape> shapes;
    public WorkSpace(){
        shapes = new ArrayList<Shape>();
    }
    public void add(Shape shape){
        shapes.add(shape);
    }
    public Shape get(int index) {
        Shape shape = shapes.get(index);
        if(shape instanceof Circle){
            return (Circle)shape;
        } else if(shape instanceof Rectangle){
            return (Rectangle)shape;
        }else if(shape instanceof Triangle){
            return (Triangle)shape;
        } else{
            return shape;
        }
    }
    public ArrayList<Circle> getCircles(){
        ArrayList<Circle> ans = new ArrayList<>();
        for(Shape shape : shapes){
            if(shape instanceof Circle){
                ans.add((Circle)shape);
            }
        }
        return ans;
    }
    public ArrayList<Rectangle> getRectangles(){
        ArrayList<Rectangle>ans = new ArrayList<>();
        for(Shape shape: shapes){
            if(shape instanceof Rectangle){
                ans.add((Rectangle)shape);
            }
        }
        return ans;
    }

    public ArrayList<Triangle> getTriangles(){
        ArrayList<Triangle>ans = new ArrayList<>();
        for(Shape shape: shapes){
            if(shape instanceof Triangle){
                ans.add((Triangle)shape);
            }
        }
        return ans;
    }

    public ArrayList<Shape> getShapesByColor(Color color){
        ArrayList<Shape> ans = new ArrayList<>();
        for(Shape shape: shapes){
            if(shape.getColor().equals(color)){
                ans.add(shape);
            }
        }
        return ans;
    }

    public double getAreaOfAllShapes(){
        double ans = 0;
        for(Shape shape: shapes){
            ans += shape.getArea();
        }
        return ans;
    }

    public double getPerimeterOfAllShapes(){
        double ans= 0;
        for(Shape shape: shapes){
            ans += shape.getPerimeter();
        }
        return ans; 
    }

    public int size() {
        return shapes.size();
    }

}
