import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static boolean LOCAL = System.getSecurityManager() == null;
    Scanner cin = new Scanner(System.in);

    void run(){


    }

    public static void main(String[] args) {
        if(LOCAL){
            try {
                System.setIn(new FileInputStream("in.txt"));
            } catch (FileNotFoundException e) {
                LOCAL = false;
            }
        }
        new Main().run();
    }
}
