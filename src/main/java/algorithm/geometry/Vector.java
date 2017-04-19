package algorithm.geometry;

/**
 * Created by mjrt on 4/14/2017.
 */
public class Vector extends Point {

    public Vector(double x, double y) {
        super(x,y);
    }

    /**
     * 向量长度
     * */
    public double getLength(){
        return Math.sqrt(x*x+y*y);
    }

    /**
     * 向量夹角
     * */
    public double getIncludedAngle(Vector val){
        return Math.acos( this.dot(val) /this.getLength() / val.getLength());
    }
    /**
     * 向量的法线
     * */
    public Vector getNormal(){
        return new Vector(-y/getLength(),x/getLength());
    }

    /**
     * 绕pole点旋转angle角度后的值
     * */
    public Vector getRotateValue(Point pole,double angle){
        double dx = x-pole.x , dy = y - pole.y;
        return new Vector(dx*Math.cos(angle) - dy * Math.sin(angle),
                dx*Math.sin(angle)+dy*Math.cos(angle));
    }
    /**
     * 判断是否平行
     * */
    public boolean isParallel(Vector val){
        return sgn(this.cross(val)) == 0 ;
    }

    /**
     * 判断是否同向
     * */
    public boolean isCocurrent(Vector val){
        return sgn(x/val.x) == 1;
    }

    /**
     * 判断是否是法线
     * */
    public boolean isNormal(Vector val){
        return sgn(this.dot(val)) == 0;
    }

}
