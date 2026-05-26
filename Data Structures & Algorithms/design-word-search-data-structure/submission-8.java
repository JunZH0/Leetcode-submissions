class TrieNode {
    TrieNode[] children;
    boolean isEndWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c - 'a'];
        }
        curr.isEndWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(curr, word, 0);
    }

    private boolean dfs(TrieNode node , String word, int i) {
        if (node == null) {
            return false;
        }

        for (int j = i; j < word.length(); j++) {
            char curChar = word.charAt(j);

            if ('.' == curChar) {
                for (TrieNode child : node.children) {
                    if (child != null && dfs(child, word, j + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.children[curChar - 'a'] == null) {
                    return false;
                }

                node = node.children[curChar - 'a'];
            }
        }
        return node.isEndWord;
    }
}
