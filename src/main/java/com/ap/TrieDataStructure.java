package com.ap;

public class TrieDataStructure {

    private static TrieNode root;

    public TrieDataStructure() {
        this.root = new TrieNode();
    }

    static class TrieNode {

        private static final int MAX_CHILDREN = 26;
        private boolean isWord;
        private TrieNode[] children;

        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[MAX_CHILDREN];
        }

    }

    private static void insert(String word) {

        TrieNode crawlerNode = root;

        for (int i=0; i<word.length(); i++) {
            if (crawlerNode.children[word.charAt(i) - 'a'] == null) {
                crawlerNode.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            crawlerNode = crawlerNode.children[word.charAt(i) - 'a'];
        }
        crawlerNode.isWord = true;
    }

    private static boolean search(String word) {

        TrieNode crawlerNode = root;

        for (int i=0; i<word.length(); i++) {
            TrieNode crawlerChildrenNode = crawlerNode.children[word.charAt(i) - 'a'];
            if (crawlerChildrenNode == null) {
                return false;
            }
            crawlerNode = crawlerChildrenNode;
        }

        return crawlerNode.isWord;
    }

    private static boolean startsWith(String prefix) {
        TrieNode crawlerNode = root;

        for (int i=0; i<prefix.length(); i++) {
            TrieNode childNode = crawlerNode.children[prefix.charAt(i) - 'a'];
            if (childNode == null) {
                return false;
            }
            crawlerNode = childNode;
        }
        return true;
    }

    public static void main(String[] args) {

        TrieDataStructure trie = new TrieDataStructure();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

    }

}
