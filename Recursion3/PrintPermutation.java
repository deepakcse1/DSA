public class PrintPermutation {

  public static void printPermutation(String input){
    printPermutationHelper(input, "");
  }
  
  public static void printPermutationHelper(String input, String stringTillNow) {
    if (input.length() == 1) {
      System.out.println(stringTillNow + input);
      return;
    }
    for(int i = 0; i < input.length(); i++){
      String newInput = input.substring(0, i)+input.substring(i+1);
      printPermutationHelper(newInput, stringTillNow+input.charAt(i));
    }
  }

  public static void main(String[] args) {
    printPermutation("abc");
  }

}
