
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.*;

public class Main {

    void run(){
        System.out.println(40000000000L);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(0x07);
        BitSet bitSet;
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
