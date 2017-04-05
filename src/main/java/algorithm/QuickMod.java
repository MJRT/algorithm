package algorithm;

/**
 * Created by mjrt on 4/3/2017.
 */
public class QuickMod {
    public static long powerMod(long x,long n,long mod){
        long res = 1;
        for(x %= mod ; n!=0 ; n >>= 1){
            if((n&1) != 0)  res = (res*x) % mod;
            x = (x*x) % mod;
        }
        return res;
    }
    public static long multiMod(long x,long n,long mod){
        long res = 1;
        for(x %= mod ; n!=0 ; n >>= 1){
            if((n&1) != 0)  res = (res+x) % mod;
            x = (x+x) % mod;
        }
        return res;
    }

}
