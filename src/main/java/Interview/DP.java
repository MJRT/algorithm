package Interview;
import static java.lang.Math.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

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

    public int minimumTotal(List<List<Integer>> triangle) {

        for(int i = triangle.size()-2 ; i >= 0  ; i--){
            for(int j = 0 ;  j < triangle.get(i+1).size()-1 ; j++){
                triangle.get(i).set(j,triangle.get(i).get(j)+min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    /*
    * leetcode 375. Guess Number Higher or Lower II
    *  单调队列优化dp
    *  原理: https://artofproblemsolving.com/community/c296841h1273742
    * */
    class Node{
        Integer value,index;
        Node(Integer x, Integer y ){
            this.value=x;
            this.index=y;
        }
    }
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];

        for(int j = 2 ; j <= n ; j++){
            int k = j-1 ;
            Deque<Node> deque = new ArrayDeque<>();
            for(int i = j-1 ; i > 0 ; i--){
                while(dp[i][k-1] > dp[k+1][j]){
                    if(!deque.isEmpty() && deque.peekFirst().index == k)
                        deque.removeFirst();
                    k--;
                }
                int value  = i + dp[i+1][j];
                while(!deque.isEmpty() && value < deque.peekLast().value)
                    deque.removeLast();
                deque.addLast(new Node(value,i));
                dp[i][j] = min(dp[i][k]+k+1 , deque.peekFirst().value);
            }
        }
        return dp[1][n];
    }
    public int getMoneyAmount3(int n) {
        int[][] dp = new int[n+1][n+1];

        for(int j = 2 ; j <= n ; j++){
            for(int i = j-1 ; i > 0 ; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k = i+1 ; k <= j-1 ; k++){
                    int localMax = k +max(dp[i][k-1],dp[k+1][j]);
                    globalMin = min(globalMin,localMax);
                }
                dp[i][j] = (i+1 == j ? i : globalMin);
            }
        }
        return dp[1][n];
    }
}
