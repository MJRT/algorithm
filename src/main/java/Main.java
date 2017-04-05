

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
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
    final int N = 500+5;
    final int INF = 0x3f3f3f3f;

    int[] a = new int[N];
    int[][] dp = new int[N][N];
    void run(){
        int Case = cin.nextInt();
        int tot = 1;
        while(Case-- != 0){
            int n = cin.nextInt();
            for(int i = 1 ; i <= n ; i++)
                a[i] =  cin.nextInt();
            for(int i = 0 ; i <= n ; i++)
                Arrays.fill(dp[i],0);
            PrefixSum prefixSum = new PrefixSum(a);
            for(int i = 0; i < n ; i++){
                for(int j = 1 ; j <= n-i ; j++){
                    dp[j][j+i] = Math.max(
                            prefixSum.getRegionSum(j,j+i-1)-dp[j][j+i-1]+a[j+i],
                            prefixSum.getRegionSum(j+1,j+i)-dp[j+1][j+i]+a[j]);
                }
            }
            System.out.printf("Case #%d: %d %d\n",tot++,dp[1][n],prefixSum.getRegionSum(1,n)-dp[1][n]);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
    private Scanner cin;
    public Main() {
        try{
            String path = Main.class.getClassLoader().getResource("in.txt").getPath();
            cin = new Scanner(new FileInputStream(path));
        } catch (NullPointerException e){
            cin = new Scanner(System.in);
        } catch (FileNotFoundException e) {
            cin = new Scanner(System.in);
        }
    }
}
