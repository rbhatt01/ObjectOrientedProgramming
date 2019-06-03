import java.lang.Math;
public class Util{
    public static double perimeter(Circle c) {
        return Math.PI* 2 * c.getRadius();
    }

    public static double perimeter(Rectangle r) {
        Point top = r.getTopLeft();
        Point bottom = r.getBottomRight();
        double height = Math.abs(top.getY() - bottom.getY());
        double width = Math.abs(bottom.getX() - top.getX());
        return height*2 + width * 2;
    }

    public static double perimeter(Polygon p) {
        double ans = 0;
        for (int i = 0; i < p.getPoints().size(); i++) {
            if (i == p.getPoints().size() - 1) {
                ans += lengthOfTwoPoints(p.getPoints().get(i), p.getPoints().get(0));
            } else {
                ans += lengthOfTwoPoints(p.getPoints().get(i), p.getPoints().get(i + 1));
            }
        }
        return ans;
    }

    private static double lengthOfTwoPoints(Point one, Point two) {
        return Math.sqrt(Math.pow(two.getX() - one.getX(), 2) + Math.pow(two.getY() - one.getY(), 2));
    }
}