//package algorithm;
//
//import com.sun.org.apache.xpath.internal.operations.Bool;
//
//import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.HashMap;
//
///**
// * Created by mjrt on 4/9/2017.
// */
//public class PrimeTable {//不能动态，必须指定ceiling？？
//    ArrayList<Integer> primes;
//    BitSet isNotPrime;
//    HashMap<Integer,Boolean> map;
//    int ceiling;
//    final int threshold = (int)1e8;
//
//    public PrimeTable() {
//        ceiling = 0;
//        map = null;
//        isNotPrime = new BitSet();
//        primes = new ArrayList<>();
//        isNotPrime.set(0,true);
//        isNotPrime.set(1,true);
//    }
//
//    private void filter(int i){
//        if(!isNotPrime.get(i))
//            primes.add(i);
//        for(int j = 0 ; j < primes.size() && i*primes.get(j) < ceiling ; j++){
//            isNotPrime.set(primes.get(j)*i,true);
//            if(i%primes.get(j)==0)
//                return;
//        }
//    }
//
//    private void resize(int x){
//        if (ceiling < x && ceiling != threshold){
//            x = Math.min(x,threshold);
//            for(int i = ceiling+1 ; i <= x ; i++)
//                filter(i);
//            ceiling = x;
//        }
//    }
//
//    private boolean overCalc(int number) {
//        resize(threshold);
//        for(Integer prime : primes){
//            if(number%prime == 0){
//                map.put(number,false);
//                return false;
//            }
//        }
//        map.put(number,true);
//        return true;
//    }
//
//    public boolean isPrime(int number){
//        if(number <= ceiling){
//            return !isNotPrime.get(number);
//        } else if(number <= threshold){
//            resize(number);
//            return !isNotPrime.get(number);
//        } else {
//            if(map == null)
//                map = new HashMap<>();
//            if(map.get(number)!=null)
//                return map.get(number);
//        }
//        return overCalc(number);
//    }
//
//    public Integer getPrimeAt(int index){
//        if(ceiling == threshold && index > primes.size())
//            return null;
//        if(index < primes.size())
//            return primes.get(index-1);
//
//        while(index >= primes.size() && ceiling != threshold)
//            resize(ceiling<<1);
//        return getPrimeAt(index);
//
//    }
//
//}
