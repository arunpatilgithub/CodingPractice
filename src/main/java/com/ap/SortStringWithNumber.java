package com.ap;

public class SortStringWithNumber {


  public static void main(String[] args) {
    System.out.print(order("4of Fo1r pe6ople g3ood th5e the2"));
  }

  public static String order(String words) {

    if (words == null || words.isEmpty()) {
      return "";
    }

    String[] wordsArray = words.split(" ");
    String[] finalWordsArray = new String[wordsArray.length];

    for (String word : wordsArray) {

      char[] chars = word.toCharArray();

      for (char c : chars) {
        if (c >= 48 && c <=57) {
          finalWordsArray[Character.getNumericValue(c) - 1] = word;
          break;
        }
      }

    }

    String retVal = "";
    for (String eachWord : finalWordsArray) {
      retVal = retVal + " " + eachWord;
    }

    return retVal.trim();
  }

}
