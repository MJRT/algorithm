
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import static java.lang.Math.*;

public class Main {



    void run(){
        Solution s = new Solution();
        System.out.println(s.getMoneyAmount(2));
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
