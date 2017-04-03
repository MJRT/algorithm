package algorithm;

/**
 * Created by mjrt on 4/2/2017.
 */
public class PrefixSum {
    int[] list;

    public PrefixSum(int[] list) {
        this.list = list;
        int temp = list[0];
        for(int i = 1 ; i < list.length ; i++){
            list[i-1] = temp;
            temp = list[i] + list[i-1];
        }
        list[list.length-1] = temp;
    }
    public int getRegionSum(int left,int right){
        return list[right] - (left!=0?list[left-1]:0) ;
    }

}
