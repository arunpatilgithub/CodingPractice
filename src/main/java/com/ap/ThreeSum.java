package com.ap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {

    List<List<Integer>> output = threeSum(new int[] {-1,0,1,2,-1,-4});

    output.stream().forEach(outer -> {
        outer.stream().forEach(inner -> {
          System.out.printf(inner + "-");
        });

      System.out.println("\n");
    });

  }

  private static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> returnArray = new ArrayList<>();

    for (int i=0; i< nums.length; i++) {

    }

    return returnArray;

  }

}
