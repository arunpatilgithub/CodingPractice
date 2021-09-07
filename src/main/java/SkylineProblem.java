import java.util.LinkedList;
import java.util.List;

public class SkylineProblem {

    public static void main(String[] args) {
        List<int[]> skyLine = getSkyline(new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});
        skyLine.forEach(arr -> {
            System.out.println(arr[0]+ "," + arr[1]);
        });
    }

    private static List<int[]> getSkyline(int[][] buildings) {
        return merge(buildings, 0, buildings.length-1);
    }

    private static LinkedList<int[]> merge(int[][] buildings, int lo, int hi) {
        LinkedList<int[]> res = new LinkedList<>();
        if(lo > hi) {
            return res;
        } else if(lo == hi) {
            res.add(new int[]{buildings[lo][0], buildings[lo][2]});
            res.add(new int[]{buildings[lo][1], 0});
            return res;
        }
        int mid = lo+(hi-lo)/2;
        LinkedList<int[]> left = merge(buildings, lo, mid);
        LinkedList<int[]> right = merge(buildings, mid+1, hi);
        int leftH = 0, rightH = 0;
        while(!left.isEmpty() || !right.isEmpty()) {
            long x1 = left.isEmpty()? Long.MAX_VALUE: left.peekFirst()[0];
            long x2 = right.isEmpty()? Long.MAX_VALUE: right.peekFirst()[0];
            int x = 0;
            if(x1 < x2) {
                int[] temp = left.pollFirst();
                x = temp[0];
                leftH = temp[1];
            } else if(x1 > x2) {
                int[] temp = right.pollFirst();
                x = temp[0];
                rightH = temp[1];
            } else {
                x = left.peekFirst()[0];
                leftH = left.pollFirst()[1];
                rightH = right.pollFirst()[1];
            }
            int h = Math.max(leftH, rightH);
            if(res.isEmpty() || h != res.peekLast()[1]) {
                res.add(new int[]{x, h});
            }
        }
        return res;
    }
}
