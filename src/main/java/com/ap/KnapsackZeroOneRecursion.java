package com.ap;

/**
 * I found a below video explanation better.
 * https://www.youtube.com/watch?v=mGfK-j9gAQA&ab_channel=TECHDOSE
 */
public class KnapsackZeroOneRecursion {

    public static void main(String[] args) {

        int[] weights = {1,2,3};
        int[] profits = {10,15,40};
        int capacity = 5;
        int n = 3;

        int maxProfit = knapsack(weights, profits, capacity, n);

        System.out.println("Max profit is : " +maxProfit);
    }

    private static int knapsack(int[] weights, int[] profits, int capacity, int n) {

        //Base condition.
        if (n == 0 || capacity <=0 ) {
            return 0;
        }

        //If, after adding current item the total capacity remaining is zero or less, then exclude this item.
        if (weights[n-1] > capacity) {
            return knapsack(weights, profits, capacity, n - 1);
        } else {
            //If after adding this item, we still have capacity left, we have two choice.
            //We need to calculate profit by including the item. But we also need to calculate profit by excluding
            // the item. This is because, by excluding, we can find other item with better profit
            // and are within weight capacity/
            return Math.max(profits[n-1] + knapsack(weights, profits, capacity - weights[n-1], n-1),
                    knapsack(weights, profits, capacity, n - 1));
        }

    }

}
