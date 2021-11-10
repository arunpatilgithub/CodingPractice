package com.ap;

import java.util.*;

public class ThreeSum {

  public static void main(String[] args) {

    List<List<Integer>> output = threeSum(new int[] {-1,0,1,2,-1,-4});
    //List<List<Integer>> output = threeSum(new int[] {0,0,0,0});

    //List<List<Integer>> output = threeSum(new int[] {-1,0,1,0});

    for (List<Integer> individualList : output) {
      for (Integer i : individualList) {
        System.out.print(i + " ");
      }
      System.out.println("\n");
    }

  }

  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> returnArray = new ArrayList<>();


    Arrays.sort(nums);

    for (int i=0; i< nums.length; i++) {

      if (i == 0 || nums[i] != nums[i-1]) {
        twoSum(nums, i, returnArray);
      }

    }

    return returnArray;

  }

  private static void twoSum(int[] nums, int i, List<List<Integer>> returnArray) {

    int targetSum = -nums[i];
    int l = i + 1;
    int r = nums.length - 1;

    while (l < r) {

      int currentSum = nums[l] + nums[r];

      if (currentSum == targetSum) {

        System.out.println("Inside currentSum == targetSum");
        returnArray.add(Arrays.asList(nums[i], nums[l], nums[r]));

        //Below logic is needed because we do not want to calculate sum of two number starting with same number
        // twice since we want to avoid the duplicates.
        int temp = nums[l];
        l++;
        while (l < r && nums[l] == temp) {
          l++;
        }

        continue;

      } else if (currentSum > targetSum) {
        r --;
      } else {
        l++;
      }

    }


  }


}
