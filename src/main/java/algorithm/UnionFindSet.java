package algorithm;

import java.util.Arrays;

/**
 * Created by mjrt on 4/3/2017.
 */
public class UnionFindSet {
    private int[] pre;
    private int[] rank;
    private int blockNumber;

    public UnionFindSet(int size) {
        size++;
        pre = new int[size];
        for (int i = 0 ; i < size ; i++)
            pre[i] = i;
        rank = new int[size];
        Arrays.fill(rank,0);
        blockNumber = size-1;
    }

    public int find(int x){
        return (x == pre[x])?x:(pre[x]=find(pre[x]));
    }

    public boolean same(int x,int y){
        return find(x) == find(y);
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void union(int x, int y){
        int fx = find(x),fy = find(y);
        if(fx != fy){
            if(rank[fx] > rank[fy])     pre[fy] = fx;
            else                        pre[fx] = fy;
            if(rank[fx] == rank[fy])    rank[fy]++;
            blockNumber--;
        }
    }
}
