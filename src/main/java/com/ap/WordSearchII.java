package com.ap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchII {

    static class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[128];
        }
    }

    public static void insert(String word, TrieNode root) {

        TrieNode crawler = root;

        for (int i=0; i<word.length(); i++) {
            if (crawler.children[word.charAt(i) - 'a'] == null) {
                crawler.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            crawler = crawler.children[word.charAt(i) - 'a'];
        }
        crawler.isWord = true;

    }

    public static boolean isWordPresent(String word, TrieNode root) {

        TrieNode crawler = root;
        for (int i=0; i<word.length(); i++) {
            if (crawler.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            crawler = crawler.children[word.charAt(i) - 'a'];
        }
        return crawler.isWord;

    }

    public static boolean wordStartsWith(String word, TrieNode root) {

        TrieNode crawler = root;

        for (int i=0; i<word.length(); i++) {
            if (crawler.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            crawler = crawler.children[word.charAt(i) - 'a'];
        }
        return true;

    }

    public static void main(String[] args) {

//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};

//        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};

//        String[] words = {"oa", "oaa"};

        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"};
        
        List<String> searchedWords = findWords(board, words);

        System.out.println("*****Words in grid*****");
        searchedWords.forEach(System.out::println);
    }

    public static List<String> findWords(char[][] board, String[] words) {

         TrieNode root = new TrieNode();
        List<String> searchedWords = new ArrayList<>();

        for(String word : words) {
            insert(word, root);
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                boolean[][] markerGrid = new boolean[board.length][board[0].length];
                dfs(board, markerGrid, "",i, j, searchedWords, root);
            }
        }
        return searchedWords;
    }

    private static void dfs(char[][] board, boolean[][] markerGrid, String subString, int row, int column, List<String> searchedWords,
                            TrieNode root) {

        if (row < 0 || row > board.length - 1 || column < 0 || column > board[row].length - 1 || markerGrid[row][column]) {
            return;
        }

        subString = subString + board[row][column];

        if ("" != subString && !wordStartsWith(subString, root)) {
            return;
        }

        if (isWordPresent(subString, root) && !searchedWords.contains(subString)) {
            searchedWords.add(subString);
        }

        markerGrid[row][column] = true;

        dfs(board, markerGrid, subString, row + 1, column, searchedWords, root);
        dfs(board, markerGrid, subString, row, column + 1, searchedWords, root);
        dfs(board, markerGrid, subString, row - 1, column, searchedWords, root);
        dfs(board, markerGrid, subString, row, column - 1, searchedWords, root);

        markerGrid[row][column] = false;
    }

}
