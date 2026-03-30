class LRUCache {

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    private Map<Integer, Node> cache;
    private int cap;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
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

    // 1 - new - right
    private void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.next = right;
        right.prev = node;
        node.prev = prev;
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

        if (cache.size() > cap) {
            Node lru = left.next;

            cache.remove(lru.key);
            remove(lru);
        }
    }
}
