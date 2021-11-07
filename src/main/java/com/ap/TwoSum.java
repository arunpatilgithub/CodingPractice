package com.ap;

public class TwoSum {

    public static void main(String[] args) {

        int[] input = new int[] {2,7,11,15};
        int target = 9;

        int[] result = twoSum(input, target);

        for (int k = 0; k < result.length; k++) {
            System.out.println(result[k]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {

        int low = 0;
        int high = numbers.length - 1;

        for (int i=1; i<= numbers.length; i++) {

            int sum = numbers[low] + numbers[high];

            if (sum == target) {
                return new int[]{low+1, high+1};
            }

            if (sum > target) {
                high --;
            } else {
                low ++;
            }
        }

        return new int[]{};
    }

}
