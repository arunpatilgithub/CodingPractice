package com.ap;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        //int[][] response = merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        //int[][] response = merge(new int[][]{{1,4},{4,5}});
        //int[][] response = merge(new int[][]{{1,2},{2,3}, {3,4}, {4,5}, {5,6}});

        int[][] response = merge(new int[][]{{1,3},{2,6}, {8,10}});

        Arrays.sort(response, Comparator.comparingInt(a -> a[0]));

        for (int[] row : response) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> uniqueStack = new Stack<>();

        for (int i=0; i<intervals.length; i++) {

            if (uniqueStack.empty()) {
                uniqueStack.push(intervals[i]);
            } else {
                int[] temp = uniqueStack.peek();
                if (intervals[i][0] <= temp[1]) {
                    uniqueStack.pop();
                    uniqueStack.push(new int[] {temp[0], Math.max(intervals[i][1], temp[1])});
                } else {
                    uniqueStack.push(intervals[i]);
                }
            }
        }

        int[][] returnArray = new int[uniqueStack.size()][uniqueStack.peek().length];

        int length = uniqueStack.size();

        for (int i=0; i< length; i ++) {
            returnArray[i] = uniqueStack.pop();
        }

        Arrays.sort(returnArray, Comparator.comparingInt(a -> a[0]));

        return returnArray;
    }
}
