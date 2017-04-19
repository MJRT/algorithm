package algorithm.geometry;

/**
 * Created by mjrt on 4/14/2017.
 */
public class Line {
    static final double EPS = 1e-8;

    Point s,e;

    public Line(Point s, Point e) {
        this.s = s;
        this.e = e;
    }

    public Vector getVector(){
        return (Vector) e.subtract(s);
    }

    public boolean equals(Line val) {
        return !(sgn(this.getVector().cross(val.getVector())) !=0 && sgn(val.getVector().cross(val.s.subtract(s))) == 0 );
    }

    public boolean isParallel(Line val){
        return sgn(s.subtract(e).cross(val.s.subtract(val.e))) == 0 &&
                sgn(s.subtract(val.e).cross(val.s.subtract(val.e))) != 0;
    }

    public boolean isCoincide(Line val){
        return sgn(s.subtract(e).cross(val.s.subtract(val.e))) == 0 &&
                sgn(s.subtract(val.e).cross(val.s.subtract(val.e))) != 0;
    }


    /**
     * 获得ax+by+c=0的参数
     * */
    public double getA(){
        return s.y-e.y;
    }
    public double getB(){
        return e.x-s.x;
    }
    public double getC(){
        return s.x*e.y-e.x*s.y;
    }

    /**
     * 根据精度判断x与0的大小
     * */
    protected int sgn(double x){
        return x < -EPS ? -1 : (x > EPS ? 1 : 0);
    }
}
