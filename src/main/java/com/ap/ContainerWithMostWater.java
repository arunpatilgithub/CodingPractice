package com.ap;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        //int[] input = {1,2,1};
        System.out.println(maxArea(input));
    }

    public static int maxArea(int[] height) {

        int maxArea = -1;

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (leftPointer <= rightPointer) {

            int minHeight = Math.min(height[leftPointer], height[rightPointer]) ;

            if (maxArea < minHeight * (rightPointer - leftPointer)) {
                maxArea = minHeight * (rightPointer - leftPointer);
            }

            if (height[leftPointer] <= height[rightPointer]) {
                leftPointer ++;
            } else {
                rightPointer --;
            }
        }

        return maxArea;

    }

}
