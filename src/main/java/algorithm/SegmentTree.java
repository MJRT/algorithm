package algorithm;

import java.util.ArrayList;

/**
 * Created by mjrt on 4/3/2017.
 */
public abstract class SegmentTree {
    int[] tree;
    int MID,n;
    int initVal; // sum-> 0 , min/max-> Integer.MIN_VALUE/ Integer.MAX_VALUE

    public SegmentTree(ArrayList<Integer> values,int initVal) {
        n = values.size();
        tree = new int[n<<2+2];
        this.initVal = initVal;
        for(MID=1 ; MID<n+2; MID<<=1)
            ;
        for(int i = 0 ; i < n ; i++)
            put(i+1,values.get(i));
    }

    private void pushUp(int index){
        tree[index] = operator(tree[index<<1],tree[index<<1|1]);
    }

    protected abstract int operator(int x, int y);

    public void put(int index ,int value){
        tree[index+=MID] = (initVal == 0 ? operator(tree[index],value) : value);
        for (index>>=1 ; index!=0 ; index>>=1)
            pushUp(index);
    }

    public int get(int left,int right){
        int result = initVal;
        for(left+=MID-1 , right+=MID+1 ; (left^right^1) != 0; left>>=1 , right>>=1){
            if ((~left&1) != 0)     result = operator(result,tree[left^1]);
            if ((right&1) != 0)     result = operator(result,tree[right^1]);
        }
        return result;
    }
}