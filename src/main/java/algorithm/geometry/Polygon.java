package algorithm.geometry;

import java.util.ArrayList;

/**
 * Created by mjrt on 4/14/2017.
 */
public class Polygon {
    static final double EPS = 1e-8;
    ArrayList<Point> vertexs;

    public Polygon(ArrayList<Point> vertexs) {
        this.vertexs = new ArrayList<>(vertexs);
    }

    public Point getVertex(int index) {
        return vertexs.get((index + vertexs.size()) % vertexs.size());
    }

    public double getArea() {
        double res = 0;
        for (int i = 0; i < vertexs.size(); i++)
            res += getVertex(i).cross(getVertex(i + 1));
        return Math.abs(res / 2.0);
    }

    public boolean inConvexPolygon(Point val) {
        for (int i = 0; i < vertexs.size(); i++)
            if (sgn(getVertex(i).subtract(val).cross(getVertex(i + 1).subtract(val))) < 0)
                return false;
        return true;
    }

    protected int sgn(double x) {
        return x < -EPS ? -1 : (x > EPS ? 1 : 0);
    }
}