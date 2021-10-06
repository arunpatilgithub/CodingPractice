import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {

        int[][] result = kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 1);
        System.out.println(result);
    }

    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> topK = new PriorityQueue<>(k, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));

        for (int i=0; i< points.length; i++) {
            topK.add(points[i]);
        }

        int[][] retArray = new int[k][points[0].length];

        for (int m =0; m < k; m++) {
            retArray[m] = topK.poll();
        }

        return retArray;
    }

}
