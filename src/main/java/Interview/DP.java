package Interview;

/**
 * Created by mjrt on 4/10/2017.
 */
public class DP {
    /*
    * leetcode 121. Best Time to Buy and Sell Stock
    */
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        if(prices.length != 0)
            min[0] = prices[0];
        for(int i = 1 ; i < prices.length ; i++)
            min[i] = Math.min(min[i-1],prices[i]);
        int res = 0;
        for(int i  = 0 ; i < prices.length ; i++){
            res = Math.max(res,prices[i]-min[i]);
        }
        return res;
    }
    /*
    * leetcode 70. Climbing Stairs
    */
    public int climbStairs(int n) {
        return 0;
    }

}
