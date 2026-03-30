class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        prev = null;
        next = null;
    }
}

class LRUCache {

    private Map<Integer, Node> cache;
    private int capacity;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        right.prev = node;
        node.prev = prev;
        node.next = right;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            Node lru = left.next;

            cache.remove(lru.key);
            remove(lru);
        }
    }
}
