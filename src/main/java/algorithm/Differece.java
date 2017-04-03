package algorithm;

import Debug.DEBUG;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mjrt on 4/2/2017.
 */
public class Differece {
    int[] list;

    public Differece(int[] list) {
        this.list = list;
        int temp = list[0],next;
        for(int i = 1 ; i < list.length ; i++){
            next = list[i] - list[i-1];
            list[i-1] = temp;
            temp = next;
        }
        list[list.length-1] = temp;

    }

    public void update(int left,int right,int val){
        list[left] += val;
        if(++right < list.length)
            list[right] -= val;
    }

    public int[] getResult(){

        for(int i = 1 ; i < list.length ; i++)
            list[i] += list[i-1];
        return list;
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5};
        Differece differece = new Differece(list);
        differece.update(0,4,-1);
        differece.update(0,3,2);
        list = differece.getResult();


    }
}
