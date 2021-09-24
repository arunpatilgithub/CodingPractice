import javax.swing.tree.TreeNode;

public class Trie {

    private static final int SUPPORTED_CHARACTERS_LENGTH = 26;
    static TrieNode root = new TrieNode();

    static class TrieNode {

        TrieNode[] children = new TrieNode[SUPPORTED_CHARACTERS_LENGTH];
        boolean isAWord;

        public TrieNode() {
            for (int i=0; i<SUPPORTED_CHARACTERS_LENGTH; i ++) {
                children[i] = null;
            }
        }
    }

    static void insert(String key) {

        TrieNode crawlerNode = root;

        for (int j=0; j< key.length(); j++) {
            if (crawlerNode.children[key.charAt(j) - 'a'] == null) {
                crawlerNode.children[key.charAt(j) - 'a'] = new TrieNode();
            }
            crawlerNode = crawlerNode.children[key.charAt(j) - 'a'];
        }
        crawlerNode.isAWord = true;
    }

    static boolean search(String key)
    {
        TrieNode crawlerNode = root;

        for (int i = 0; i < key.length(); i++)
        {
            if (crawlerNode.children[key.charAt(i) - 'a'] == null) {
                return false;
            }
            crawlerNode = crawlerNode.children[key.charAt(i) - 'a'];
        }
        return (crawlerNode.isAWord);
    }

    public static void main(String[] args) {

        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        for (int i = 0; i < keys.length ; i++) {
            insert(keys[i]);
        }

        if(search("the") == true) {
            System.out.println("the --- found");
        } else {
            System.out.println("the --- not found");
        }
    }

}
