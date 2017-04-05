package Debug;

import java.util.List;
/**
 * Created by mjrt on 4/2/2017.
 */
public class DEBUG {

    public DEBUG() {
        System.out.println("sos!");
    }

    public static void showArray(int[] list ,int s,int l){
        for(int j = s ; j < list.length && j < l+s  ; j++){
            System.out.print(list[j]+" ");
        }
        System.out.println("");
    }

    public static void showArray(int[][] list,int s,int l,int h){
        for(int i = s ;i < list.length && i < h+s ; i++){
            for(int j = s ; j < list[i].length && j < l+s  ; j++){
                System.out.print(list[i][j]+"\t\t");
            }
            System.out.println("");
        }
    }

    public DEBUG(String[] list){
        System.out.print("list: ");
        for(int i = 0 ; i < list.length ; i++){
            System.out.print(list[i]+" ");
        }
        System.out.println("");
    }

    public DEBUG(int[] list){
        System.out.print("list: ");
        for(int i = 0 ; i < list.length ; i++){
            System.out.print(list[i]+" ");
        }
        System.out.println("");
    }

    public DEBUG(long[] list){
        System.out.print("list: ");
        for(int i = 0 ; i < list.length ; i++){
            System.out.print(list[i]+" ");
        }
        System.out.println("");
    }
    public DEBUG(double[] list){
        System.out.print("list: ");
        for(int i = 0 ; i < list.length ; i++){
            System.out.print(list[i]+" ");
        }
        System.out.println("");
    }
    public DEBUG(boolean[] list){
        System.out.print("list: ");
        for(int i = 0 ; i < list.length ; i++){
            System.out.print(list[i]+" ");
        }
        System.out.println("");
    }


}
