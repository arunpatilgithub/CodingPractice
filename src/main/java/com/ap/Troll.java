package com.ap;

import java.util.HashSet;
import java.util.Set;

public class Troll {

  public static void main(String[] args) {
    String str = "This website is for losers LOL!";
    System.out.println(disemvowel(str));
  }

  public static String disemvowelnew(String str) {

    Set<Character> vowels = new HashSet<Character>(){{
      add('a');
      add('e');
      add('i');
      add('o');
      add('u');
      add('A');
      add('E');
      add('I');
      add('O');
      add('U');
    }};

    char[] stringChars = str.toCharArray();
    char[] returnVal = new char[stringChars.length];
    int j=0;
    for (int i=0; i< stringChars.length; i++) {
      if (!vowels.contains(stringChars[i])) {
        returnVal[j] = stringChars[i];
        j++;
      }
    }

    return String.valueOf(returnVal);
  }

  public static String disemvowel(String str) {
    return str.replaceAll("[AEIOUaeiou]", "");

  }

}
