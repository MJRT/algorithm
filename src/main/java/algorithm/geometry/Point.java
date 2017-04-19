package algorithm.geometry;

/**
 * Created by mjrt on 4/13/2017.
 */
public class Point {
    static final double EPS = 1e-8;

    public double x,y;
    public Point() {}
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 点 -点 = 向量
     * */
    public Point subtract(Point val){
        return new Point(x-val.x,y-val.y);
    }
    /**
     * 点 + 向量 = 点
     * 向量+ 向量 = 向量
     * */
    public Point add(Point val){
        return new Point(x+val.x,y+val.y);
    }

    /**
     * 向量 * 数 = 向量
     * */
    public Point multiply(double val){
        return new Point(x*val,y*val);
    }

    /**
     * 向量 / 数 = 向量
     * */
    public Point divide(double val){
       return new Point(x/val,y/val);
    }

    public boolean equals(Point val) {
        return sgn(x-val.x) == 0 && sgn(y-val.y) == 0;
    }

    /**
     * 叉积
     *  1.判断向量方向
     *      若 a x b >  0 表示a在b的顺时针方向上
     *      若 a x b <  0 表示a在b的逆时针方向上
     *      若 a x b == 0 表示a在b共线，但不确定方向是否相同
     *  2.求面积
     *      叉积的长度 |a×b| 可以解释成以a和b为邻边的平行四边形的面积
     * */
    public double cross(Point val){
        return x*val.y - y*val.x;
    }

    /**
     * 点积
     *  1.定义a*b = |a|*|b|*cos<a,b> (0<= (<a,b>) <= PI)
     *  2.判断垂直 a*b == 0 ，a,b相互垂直
     * */
    public double dot(Point val){
        return x*val.x + y*val.y;
    }

    /**
    * 两点距离
    * */
    public double getDistance(Point val){
        return Math.sqrt(this.subtract(val).dot(this.subtract(val)));
    }

    /**
     * 极角
     * */
    public double getPolarAngle(){
        return Math.atan2(y,x);
    }

    /**
     * 根据精度判断x与0的大小
     * */
    protected int sgn(double x){
        return x < -EPS ? -1 : (x > EPS ? 1 : 0);
    }





}
