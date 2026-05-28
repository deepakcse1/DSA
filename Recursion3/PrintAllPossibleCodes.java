public class PrintAllPossibleCodes {
  public static void main(String[] args) {
    printAllPossibleCodes("1123");
  }

  public static void printAllPossibleCodes(String input) {
		// Write your code here
     printAllPossibleCodeshelper(input, 0, "");
	}

    public static void printAllPossibleCodeshelper(String input, int index, String strSoFar) {
      if (index == input.length()) {
        System.out.println(strSoFar);
        return;
      }

      int singleDigit = input.charAt(index) - '0';
      if (singleDigit >= 1 && singleDigit <= 26) {
        printAllPossibleCodeshelper(input, index + 1, strSoFar + getChar(singleDigit));
      }

      if (index + 1 < input.length()) {
        int doubleDigit = Integer.parseInt(input.substring(index, index + 2));
        if (doubleDigit >= 1 && doubleDigit <= 26) {
          printAllPossibleCodeshelper(input, index + 2, strSoFar + getChar(doubleDigit));
        }
      }
    }

  public static char getChar(int num){
    return (char) ('a' + num-1);
  }
}
