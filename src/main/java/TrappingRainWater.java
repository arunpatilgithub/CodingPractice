public class TrappingRainWater {

    public static void main(String[] args) {

        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));

    }

    public static int trap(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];

        int result = 0;

        while (l < r) {

            if (maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                result = result + maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                result = result + maxRight - height[r];
            }

        }

        return result;
    }
}
