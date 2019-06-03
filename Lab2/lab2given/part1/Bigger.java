import java.lang.Math;
public class Bigger {
    public static double whichIsBigger(Circle c, Rectangle r, Polygon p) {
        double circ = Util.perimeter(c);
        double rect = Util.perimeter(r);
        double polygon = Util.perimeter(p);
        double bigger = Math.max(circ, rect);
        return Math.max(bigger, polygon);
    }
}