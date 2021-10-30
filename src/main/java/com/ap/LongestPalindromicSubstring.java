package com.ap;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {

    String input = "abb";
    System.out.println(longestPalindrome(input));

  }

  private static String longestPalindrome(String s) {

    String returnVal = "";

    if (s == null || s.isEmpty()) {
      return returnVal;
    }

    int l ;
    int r ;

    for (int i=1; i< s.length(); i++) {

      //even condition.
      l = i -1;
      r = i;

      while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

        if (returnVal.length() < (r - l + 1)) {
          returnVal = s.substring(l, r+1);
        }

        l --;
        r++;
      }

      //odd condition.
      l = i - 1;
      r = i + 1;

      while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

        if (returnVal.length() < (r - l + 1)) {
          returnVal = s.substring(l, r+1);
        }

        l --;
        r++;
      }

    }


    if (returnVal.isEmpty()) {
      returnVal = s.substring(0,1);
    }

    return returnVal;
  }


  private static String longestPalindromeON2(String s) {

    String returnVal = "";

    if (s == null || s.isEmpty()) {
      return returnVal;
    }

    int l = 0;
    int r = 0;
    while (r < s.length()) {

      char lChar = s.charAt(l);
      char rChar = s.charAt(r);

      if (lChar == rChar) {
        int tempL = l;
        int tempR = r;

        while (tempL <= tempR) {

          if (s.charAt(tempL) != s.charAt(tempR)) {
            break;
          }
          tempL++;
          tempR--;
        }
        if (returnVal.length() < (r+1 - l)) {
          returnVal = s.substring(l, r+1);
          System.out.println("New longest String : " + returnVal);
        }

        r++;
      } else {
        if (r == s.length() -1 && l < r) {
          l ++;
          r = l + 1;
        } else {
          r++;
        }

      }

    }

    return returnVal;
  }

}
