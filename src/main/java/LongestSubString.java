public class LongestSubString {

  public static void main(String[] args) {

    String input = "pwwkew";

   // System.out.println("Longest substring: " + lengthOfLongestSubstring(input));
    System.out.println("Longest substring: " + lengthOfLongestSubstringShiftingWindow(input));
  }

  private static int lengthOfLongestSubstringShiftingWindow(String s) {

    Integer[] chars = new Integer[128];

    int left = 0;
    int right = 0;

    int res = 0;
    while (right < s.length()) {
      char r = s.charAt(right);

      Integer index = chars[r];
      if (index != null && index >= left && index < right) {
        left = index + 1;
      }

      res = Math.max(res, right - left + 1);

      chars[r] = right;
      right++;
    }

    return res;

  }

  private static int lengthOfLongestSubstring(String s) {

    if (s == null || s.isEmpty()) {
      return 0;
    }

    int longestLength = 0;

    for (int i=0; i<s.length(); i++) {

      if (longestLength >= (s.length() - i) ) {
        break;
      }

      int length = 1;
      int[] chars = new int[128];

      chars[s.charAt(i)] = 1;

      for (int j=i + 1; j<s.length(); j++) {

        if (chars[s.charAt(j)] != 1) {
          chars[s.charAt(j)] = 1;
          length ++;
        } else {
          break;
        }
      }

      longestLength = Math.max(length, longestLength);
    }

    return longestLength;
  }


}
