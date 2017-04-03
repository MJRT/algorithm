package Debug;

import java.util.List;
/**
 * Created by mjrt on 4/2/2017.
 */
public class DEBUG {
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
