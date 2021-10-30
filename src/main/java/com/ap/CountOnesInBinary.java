package com.ap;

public class CountOnesInBinary {

  public static void main(String[] args) {
    System.out.println(getOnesInBinary(55));
    System.out.println(countSetBits(55));
  }

  private static int getOnesInBinary(int n) {

    String binary = Integer.toBinaryString(n);

    System.out.println("Binary: "+ binary);

    int onesCount = 0;
    for (char c : binary.toCharArray()) {
      if (c == '1') {
        onesCount++;
      }
    }

    return onesCount;
  }

  static int countSetBits(int n)
  {
    int count = 0;
    while (n > 0) {
      count += n & 1;
      n >>= 1;
    }
    return count;
  }
}
