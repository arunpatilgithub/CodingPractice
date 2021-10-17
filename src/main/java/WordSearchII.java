import java.util.List;

public class WordSearchII {

    static TrieNode root;

    static class TrieNode {
        //boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[128];
        }
    }

    public WordSearchII() {
        root = new TrieNode();
    }

    public static TrieNode insert(TrieNode node, char c) {

        TrieNode crawler = node;
        if (crawler.children[c] == null) {
            crawler.children[c] = new TrieNode();
        }

        return crawler.children[c];
    }

    public static void main(String[] args) {

        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        findWords(board, words).stream().forEach(System.out::println);
    }

    public static List<String> findWords(char[][] board, String[] words) {

        root = new TrieNode();
        boolean[][] markerGrid = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                generateTrie(root, i, j, board, markerGrid);
            }
        }

        return null;
    }

    private static void generateTrie(TrieNode trieNode, int i, int j, char[][] board, boolean[][] markerGrid) {

        if (i >=0 && j >= 0 && i < board.length && j < board[i].length && !markerGrid[i][j]) {
            TrieNode trie = insert(trieNode,board[i][j]);
            generateTrie(trie, i , j + 1, board, markerGrid);
            generateTrie(trieNode, i + 1, j, board, markerGrid);
        }

    }
}
