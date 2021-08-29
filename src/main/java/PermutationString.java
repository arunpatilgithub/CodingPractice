public class PermutationString {

  public static void main(String[] args) {

    System.out.println(isPermutation("arun", "tuna"));

  }

  private static boolean isPermutation(String first, String second) {

    if (first.length() != second.length()) {
      return false;
    }

    int[] fArray = new int[128];

    for (int i=0; i<first.length(); i++) {
      fArray[first.charAt(i)] = 1;
    }

    for (int j=0; j<second.length(); j++) {

      if (fArray[second.charAt(j)] != 1) {
        return false;
      }

    }

    return true;

  }

}
