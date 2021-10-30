package com.ap;

public class MaxSubArray {

    public static void main(String[] args) {

        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(getMaxSubArray(input, 0, input.length - 1));
        System.out.println(maxSubArraySum(input));

    }

    private static int getMaxSubArray(int[] input, int l, int r) {

        if (l == r) {
            return input[l];
        }

        int mid = (l + r) / 2;

        int maxLeft = getMaxSubArray(input, l , mid);
        int maxRight = getMaxSubArray(input, mid + 1, r);
        int maxCrossingMid = getMaxCrossingMid(input, l, mid, r); 
        
        return Math.max(maxLeft, Math.max(maxRight, maxCrossingMid));
        
    }

    private static int getMaxCrossingMid(int[] input, int l, int mid, int r) {

        int leftSum = Integer.MIN_VALUE;
        int rightRum = Integer.MIN_VALUE;

        int i = mid;
        int tempSum = 0;

        while (i >= l) {
            tempSum = tempSum + input[i];
            if (tempSum > leftSum) {
                leftSum = tempSum;
            }
            i--;
        }

        int j = mid + 1;
        tempSum = 0;

        while (j <= r) {
            tempSum = tempSum + input[j];
            if (tempSum > rightRum) {
                rightRum = tempSum;
            }
            j++;
        }

        return leftSum + rightRum;

    }


    //Another approach,
    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < size; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
}
