package algorithm;

/**
 * Created by mjrt on 4/3/2017.
 */
public abstract class TireTree {
    class Node{
        int count;
        boolean isWord;
        Node[] next;
        public Node() {
            count = 1;
            isWord = false;
            next = new Node[domianNumber];
            for(Node node : next)
                node = null;
        }
    }

    int domianNumber;
    Node root;

    public TireTree(int domianNumber) {
        this.domianNumber = domianNumber;
        this.root = new Node();
    }

    public abstract int getIndex(char x);

    public void add(String word){
        Node ptr = root;
        for(int i = 0 ; i < word.length(); i ++){
            if(ptr.next[getIndex(word.charAt(i))] == null)
                ptr.next[getIndex(word.charAt(i))] = new Node();
            else
                ptr.next[getIndex(word.charAt(i))].count++;
            ptr = ptr.next[getIndex(word.charAt(i))];
        }
        ptr.isWord = true;
    }

    public boolean isExist(String word){
        Node ptr = root;
        for(int i = 0 ; i < word.length() ; i++) {
            ptr = ptr.next[getIndex(word.charAt(i))];
            if (ptr == null)
                return false;
        }
        return ptr.isWord;
    }

    public int getPrefixNumber(String word){
        Node ptr = root;
        for(int i = 0 ; i < word.length() ; i++) {
            ptr = ptr.next[getIndex(word.charAt(i))];
            if (ptr == null)
                return 0;
        }
        return ptr.count;
    }
}
