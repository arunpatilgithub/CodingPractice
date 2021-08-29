import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayContainsDuplicate {

  public static void main(String[] args) {

    System.out.println(containsDuplicate(new int[] {1,1,2,3}));
  }

  private static boolean containsDuplicate(int[] nums) {

    if (nums.length <=1) {
      return false;
    }

    Set<Integer> duplicatesRecords = new HashSet<>();
    for (int num : nums) {

      if (duplicatesRecords.contains(num)) {
        return true;
      } else {
        duplicatesRecords.add(num);
      }

    }

    return false;
  }

}
