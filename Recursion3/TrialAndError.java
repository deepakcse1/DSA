import java.util.ArrayList;

public class TrialAndError {
  
  public static void main(String[] args) {
    // String input = "1123";
    System.out.println('1'-'0');
    // ArrayList<String> outputString = new ArrayList<>();
    // System.out.println(getCode(array, 0, outputString, ""));
  }

  public static String getStringChar(int num){
    return String.valueOf((char) ('a'+num-1));
  }

  // public static ArrayList<String> getCode(int[] initialArray,int startIndex, ArrayList<String> outputString, String strSoFar) {
  //   if (startIndex == initialArray.length) {
  //     outputString.add(strSoFar);
  //     return outputString;
  //   }
  //   return getCode(initialArray, startIndex+1, outputString, strSoFar+getStringChar(initialArray[startIndex]));
  // }
}
