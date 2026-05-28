public class PrintKeypadCombination {

  public static void main(String[] args) {
    printKeypad(234);
  }
  public static void printKeypad(int number){
     printKeypadHelper(number, "");
  }

  public static void printKeypadHelper(int number, String str){
    if(number == 0){
      System.out.println(str);
      return;
    }
    int lastDigit = number%10;
    String combination = getCombination(lastDigit);
    for(int i = 0; i < combination.length(); i++){
      printKeypadHelper(number/10,combination.charAt(i)+str);
    }
  }

  public static String getCombination(int number){
    String[] str = {"", ".", "abc","def","ghi", "jkl","mno","pqrs", "tuv","wxyz"};
    return str[number];
  }
}
