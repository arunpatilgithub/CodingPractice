package com.ap;

public class UniqueCharactersString {

  public static void main(String[] args) {

    String input = "arun";

//    char[] inputArr = input.toCharArray();
//
//    for (int i=0; i< inputArr.length; i++) {
//      for (int j=i+1; j< inputArr.length; j++) {
//        if (i != j && String.valueOf(inputArr[i]).toUpperCase().equals(String.valueOf(inputArr[j]).toUpperCase())) {
//
//          System.out.println("Not unique string");
//
//          return;
//        }
//      }
//    }
//
//    System.out.println("Unique String!!");


    int[] posCheck = new int[128];

    for (int i=0; i<input.toCharArray().length; i++) {
      if (posCheck[input.charAt(i)] == 1) {
        System.out.println("Not unique string");
        return;
      }

      posCheck[input.charAt(i)] = 1;
    }

    System.out.println("Its a unique string!!");

  }

}
