public class PrintSubsequence {

  public static void printSubsequence(String str){
    printSubsequenceHelper(str, "");
  }

  public static void printSubsequenceHelper(String str, String strSoFar) {
     if (str.equals("")) {
      System.out.println(strSoFar);
      return;
     }
     printSubsequenceHelper(str.substring(1), strSoFar);
     printSubsequenceHelper(str.substring(1), strSoFar+str.charAt(0));
  }

  

  public static void main(String[] args) {
    printSubsequence("ab");
  }
}
