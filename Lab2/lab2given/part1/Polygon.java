import java.util.*;
public class Polygon{
    private final List<Point> points;
    public Polygon(List<Point> pointList) {
        points = pointList;
    }

    public List<Point> getPoints() {
        return points;
    }
}