class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndWord = false;
    }
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isEndWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isEndWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
