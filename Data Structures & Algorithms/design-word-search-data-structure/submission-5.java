class TrieNode {
    TrieNode[] children;
    boolean endWord;

    public TrieNode() {
        children = new TrieNode[26];
        endWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char w : word.toCharArray()) {
            if (cur.children[w - 'a'] == null) {
                cur.children[w - 'a'] = new TrieNode();
            }

            cur = cur.children[w - 'a'];
        }

        cur.endWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        return dfs(cur, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int i) {
        if (node == null) {
            return false;
        }

        

        for (int j = i; j < word.length(); j++) {
            char w = word.charAt(j);
            if (w == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && dfs(child, word, j + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.children[w - 'a'] == null) {
                    return false;
                }

                node = node.children[w - 'a'];
            }
        }
        return node.endWord;
    }    
}
