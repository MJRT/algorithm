package Interview;

import java.util.HashMap;

/**
 * Created by mjrt on 4/5/2017.
 */
public class LRUCache {

    class Node {
        Integer key;
        Integer value;
        Node prev;
        Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    HashMap<Integer, Node> map;
    Node front;
    Node rear;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        front = new Node(null, null);
        rear = new Node(null, null);
        front.next = rear;
        rear.prev = front;
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public Integer get(int key) {
        Node now = map.get(key);
        if (now == null)
            return -1;
        strip(now);
        Promotion(now);
        return now.value;
    }

    public void put(int key, int value) {
        Node ptr = map.get(key);
        if (ptr != null) {
            ptr.value = value;
            strip(ptr);
            Promotion(ptr);
        } else {
            while (size >= capacity)
                cacheGC();
            size++;
            ptr = new Node(key, value);
            Promotion(ptr);
            map.put(key, ptr);
        }
    }

    void cacheGC() {
        Node ptr = rear.prev;
        strip(ptr);
        map.remove(ptr.key);
        size--;
    }

    void Promotion(Node now) {
        now.prev = front;
        now.next = front.next;
        front.next.prev = now;
        front.next = now;
    }

    void strip(Node ptr) {
        ptr.prev.next = ptr.next;
        ptr.next.prev = ptr.prev;
    }
}
