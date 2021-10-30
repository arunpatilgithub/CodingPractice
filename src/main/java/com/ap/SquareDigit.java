package com.ap;

public class SquareDigit {

  public static void main(String[] args) {
    System.out.println(squareDigits(9119));
  }

  public static int squareDigits(int n) {

  String retString = "";
    while (n % 10 != n) {

      int mod = n%10;

      retString = (mod * mod) + retString ;

      n = (n - mod) / 10;
    }

    return  Integer.parseInt((n * n) + retString);
  }

}
