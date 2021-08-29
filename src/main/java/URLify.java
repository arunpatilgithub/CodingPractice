public class URLify {

  public static void main(String[] args) {

    System.out.println(urlfy("Mr John Smith    ", 13));

  }

  private static String urlfy(String input, int trueLength) {

    int countSpaces = 0;

    for (int i=0; i<trueLength - 1; i++) {
      if (input.charAt(i) == ' ') {
        countSpaces++;
      }
    }


    int j = trueLength - 1;
    int shiftSpaces = 2 * countSpaces;

    char[] inputArray = input.toCharArray();

    while (j != 0) {

      if (inputArray[j] == ' ') {
        inputArray[j + shiftSpaces] = '0';
        inputArray[j + shiftSpaces -1] = '2';
        inputArray[j + shiftSpaces -2] = '%';
        countSpaces --;
        shiftSpaces = 2 * countSpaces;
      } else {
          inputArray[j+shiftSpaces] = inputArray[j];

          if (countSpaces != 0) {
            inputArray[j] = ' ';
          }
        }

      j--;

    }

    return String.valueOf(inputArray);
  }

}
