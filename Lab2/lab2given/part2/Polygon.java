import java.util.List;
import java.lang.Math;
public class Polygon{
    private final List<Point> points;
    public Polygon(List<Point> pointList) {
        points = pointList;
    }

    public List<Point> getPoints() {
        return points;
    }

    public double perimeter() {
        double ans = 0;
        for (int i = 0; i < getPoints().size(); i++) {
            if (i == getPoints().size() - 1) {
                ans += lengthOfTwoPoints(getPoints().get(i), getPoints().get(0));
            } else {
                ans += lengthOfTwoPoints(getPoints().get(i), getPoints().get(i + 1));
            }
        }
        return ans;
    }

    private double lengthOfTwoPoints(Point one, Point two) {
        return Math.sqrt(Math.pow(two.getX() - one.getX(), 2) + Math.pow(two.getY() - one.getY(), 2));
    }
}