import java.util.HashMap;
import java.util.Map;

public class FindOdd {

  public static void main(String[] args) {
    System.out.println(findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
    System.out.println(getOddOccurrence(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
  }

  public static int findIt(int[] a) {

    Map<Integer, Integer> records = new HashMap();

    for (int i=0; i<a.length; i++) {
      if (records.containsKey(a[i])) {
        records.put(a[i], records.get(a[i]) + 1);
      } else {
        records.put(a[i], 1);
      }
    }

    return records.entrySet().stream().filter(entry -> entry.getValue() % 2 != 0).map(Map.Entry::getKey).findFirst().get();

  }

  private static int getOddOccurrence(int a[]) {
    for (int i = 0; i < a.length; i++) {
      int count = 0;
      for (int j = 0; j < a.length; j++) {
        if (a[i] == a[j])
          count++;
      }
      if (count % 2 != 0)
        return a[i];
    }
    return -1;
  }

}