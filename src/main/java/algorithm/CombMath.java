package algorithm;

/**
 * Created by mjrt on 4/9/2017.
 */
public class CombMath {
    Long comb(long low,long up){
        long x = 1,y = 1,len;
        if(up == 0 || low == up)    return 1L;
        if(up == 1)                 return low;
        if (low < up)               return 0L;

        if(up > low/2)  len = y = x-y;
        else            len = y;

        while(len-- != 0){
            x*=low--;
            y*=up--;
        }
        return x/y;
    }
}
