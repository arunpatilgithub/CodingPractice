package com.ap;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] input = new int[]{3,8,6,2,5,7,1,4};
        mergeSort(input, 0, input.length - 1);

        Arrays.stream(input).asLongStream().forEach(System.out::println);

    }

    private static void mergeSort(int arr[], int l, int r) {

        int mid = (l + r) / 2;

        if (l < r) {
            mergeSort(arr, l , mid);
            mergeSort(arr, mid + 1 , r);
            merge(arr, l,mid,r);
        }
    }

    private static void merge(int arr[], int l, int mid, int r) {

        int[] tempArray = new int[r-l+1];

        int k=0;

        int i = l;
        int j = mid+1;

        while (i <= mid && j <= r) {

            if (arr[i] < arr[j]) {
                tempArray[k] = arr[i];
                k++;
                i++;
            } else {
                tempArray[k] = arr[j];
                k++;
                j++;
            }

        }

        while (i <= mid) {
            tempArray[k] = arr[i];
            k++;
            i++;
        }

        while (j <= r) {
            tempArray[k] = arr[j];
            k++;
            j++;
        }

        for (int a = l; a <= r; a++) {
            arr[a] = tempArray[a - l];
        }

    }
}
