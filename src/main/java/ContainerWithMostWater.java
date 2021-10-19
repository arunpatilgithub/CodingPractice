public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
    }

    public static int maxArea(int[] height) {

        int maxArea = -1;

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (leftPointer < rightPointer) {

            int minHeight = Math.min(height[leftPointer], height[rightPointer]) ;

            if (maxArea < minHeight * minHeight) {
                maxArea = minHeight * minHeight;
            }

            if (leftPointer <= rightPointer) {
                leftPointer ++;
            } else {
                rightPointer --;
            }
        }

        return maxArea;

    }

}
