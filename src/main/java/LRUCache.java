import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DLinkedNode head = new DLinkedNode();
    DLinkedNode tail = new DLinkedNode();

    int capacity;

    Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void deleteDLinkedNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addDLinkedNode(DLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {

        DLinkedNode cacheNode = cache.get(key);
        if (cacheNode == null) {
            return -1;
        }

        //Move to head position since this is the recently used key.
        deleteDLinkedNode(cacheNode);
        addDLinkedNode(cacheNode);

        return cacheNode.val;
    }

    private int evict() {
        DLinkedNode node = tail.prev;
        deleteDLinkedNode(node);
        return node.key;
    }

    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);

        if (node != null) {
            node.val = value;
            deleteDLinkedNode(node);
        } else {
            node = new DLinkedNode(key, value);
            cache.put(key,node);

        }
        addDLinkedNode(node);

        if (cache.size() > capacity) {
            cache.remove(evict());
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        System.out.println("last val: " + cache.get(2));

    }
}
