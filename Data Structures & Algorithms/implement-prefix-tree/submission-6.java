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

        for (char w : word.toCharArray()) {
            if (!cur.children.containsKey(w)) {
                cur.children.put(w, new TrieNode());
            }
            cur = cur.children.get(w);
        }
        cur.isEndWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        for (char w : word.toCharArray()) {
            if (!cur.children.containsKey(w)) {
                return false;
            }
            cur = cur.children.get(w);
        }
        return cur.isEndWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for (char p : prefix.toCharArray()) {
            if (!cur.children.containsKey(p)) {
                return false;
            }
            cur = cur.children.get(p);
        }
        return true;
    }
}
