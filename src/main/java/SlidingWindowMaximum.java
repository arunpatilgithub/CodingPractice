import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        //Arrays.stream(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)).forEach(System.out::println);
        Arrays.stream(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)).forEach(System.out::println);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        //Initialize the max heap.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        //Number of windows will be always N-K + 1;
        int[] slidingWindows = new int[nums.length - k + 1];

        //Counter to maintain the next element position for the result array;
        int slidingWindowCounter = 0;

        //Put first k element to begin with.
        for (int i=0; i<k; i++) {
            maxHeap.add(nums[i]);
        }

        //Get the max of first K elements in the max heap.
        slidingWindows[slidingWindowCounter] = maxHeap.peek();

        //Moving the window slider counter.
        slidingWindowCounter++;

        //Now remove the first element from the max heap to move on the next window.
        maxHeap.remove(nums[0]);

        //Repeat the above process for remaining elements in the array.
        for (int j=k; j<nums.length; j++) {
            maxHeap.add(nums[j]);
            slidingWindows[slidingWindowCounter] = maxHeap.peek();
            slidingWindowCounter++;

            //Generalizing the element to be removed from the max heap.
            maxHeap.remove(nums[j-k+1]);
        }

        return slidingWindows;

    }

}
