package algorithm;

import java.util.Arrays;

/**
 * Created by mjrt on 4/2/2017.
 */
public class PrefixSum {
    int[] list;

    public PrefixSum(int[] arr) {
        this.list = new int[arr.length];
        this.list = arr.clone();
        int temp = list[0];
        for(int i = 1 ; i < list.length ; i++){
            list[i-1] = temp;
            temp = list[i] + list[i-1];
        }
        list[list.length-1] = temp;
    }
    public int getRegionSum(int left,int right){
        if(left > right){
            int t = right;
            right = left;
            left = t;
        }
        return list[right] - (left!=0?list[left-1]:0) ;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < list.length ; i++){
            builder.append(list[i]);
            builder.append(" ");
        }
        builder.append("\n");
        return builder.toString();
    }
}
