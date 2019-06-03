import java.lang.Math;
public class Bigger {
    public static double whichIsBigger(Circle c, Rectangle r, Polygon p) {
        double circ = c.perimeter();
        double rect = r.perimeter();
        double polygon = p.perimeter();
        double bigger = Math.max(circ, rect);
        return Math.max(bigger, polygon);
    }
}