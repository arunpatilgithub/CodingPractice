public class AreSame {

  public static void main(String[] args) {
    int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
    int[] b = {121, 14641, 20736, 36100, 25921, 361, 20736, 361};

    System.out.println(comp(a, b));

  }

  public static boolean comp(int[] a, int[] b) {

    if  (a == null || b == null || a.length != b.length) {
      return false;
    }

    boolean returnValue;
    for (int outer : b) {
      returnValue = false;
      for (int inner : a) {

        if ( outer == (inner * inner)) {
          returnValue = true;
          break;
        }
      }

      if (!returnValue) {
        return false;
      }
    }

    return true;
  }

}
