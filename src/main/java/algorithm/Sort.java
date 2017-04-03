package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mjrt on 3/5/2017.
 */
public class Sort {

    private static List<Integer> temp = new ArrayList<Integer>();

    public static List<Integer> QuickSort(List<Integer> list){

        int left = 0 , right = list.size()-1;
        if (left  <  right){
            Integer mark = list.get(left);

            while (left < right){
                while(left<right && mark <= list.get(right))
                    right--;
                if (left<right)
                    list.set(left++,list.get(right));

                while(left<right && mark >= list.get(left))
                    left++;
                if (left<right)
                    list.set(right--,list.get(left));
            }
            list.set(left,mark);
            QuickSort(list.subList(0,left));
            QuickSort(list.subList(left+1,list.size()));
        }

        return list;
    }


    public static List<Integer> MegerSort(List<Integer> list){



        return list;
    }

    public static void MegerArray(List<Integer> listA, List<Integer> listB){

        temp.clear();

        int i = 0 ,j = 0;
        while(i< listA.size() && j < listB.size()){
            if (listA.get(i) < listB.get(j)){
                temp.add(listA.get(i++));
            } else {
                temp.add(listB.get(j++));
            }
        }

        while (i< listA.size() )
            temp.add(listA.get(i++));
        while (j< listB.size() )
            temp.add(listB.get(j++));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays. asList(65465,121,484,12,0,51,2,54));
        List res = QuickSort(list);
        System.out.println(res);
    }
}
