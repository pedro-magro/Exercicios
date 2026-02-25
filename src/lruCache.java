import java.util.HashMap;
import java.util.Map;

public class lruCache {
    private static class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value =v;
        }
    }

    private final Map<Integer, Node> map = new HashMap<>();
    private final int capacity;
    private final Node head, tail;

    public lruCache(int capacity){
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node n = map.get(key);
        if(n == null) return -1;
        moveNodeToHead(n);
        return n.value;
    }
    public void put(int k, int val){
        Node n = map.get(k);
        if(n != null){
            n.value = val;
            moveNodeToHead(n);
            return;
        }
        Node nn = new Node(k, val);
        map.put(k, nn);
        addAfterHead(nn);
        if(map.size() > capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);

        }
    }

    private void moveNodeToHead(Node node){
        remove(node);
        addAfterHead(node);
    }

    private void addAfterHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}
