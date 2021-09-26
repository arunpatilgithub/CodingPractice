import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(ladderLength(beginWord, endWord,wordList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> uniqueWordList = new HashSet<>(wordList);

        if (!uniqueWordList.contains(endWord)) {
            return 0;
        }

        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(beginWord);

        int level = 0;
        while (!bfsQueue.isEmpty()) {

            level ++;
            int queueSize = bfsQueue.size();

            for (int i=0; i<queueSize; i++) {
                String currentWord = bfsQueue.poll();

                if (currentWord.equals(endWord)) {
                    return level;
                }

                List<String> children = getChildren(currentWord);

                for (String child : children) {
                    if (uniqueWordList.contains(child)) {
                        bfsQueue.add(child);
                        uniqueWordList.remove(child);
                    }
                }
            }

        }

        return 0;
    }

    private static List<String> getChildren(String currentWord) {

        char[] currentWordArray = currentWord.toCharArray();
        List<String> children = new ArrayList<>();

        for (int i = 0; i < currentWordArray.length; i++) {

            char temp = currentWordArray[i];

            for (char c = 'a' ; c <= 'z'; c++) {
                currentWordArray[i] = c;
                children.add(new String(currentWordArray));
            }
            currentWordArray[i] = temp;
        }

        return children;

    }

}
