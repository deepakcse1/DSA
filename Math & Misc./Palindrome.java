public class Palindrome {
  private static int isPalindrome(int n){
    int newNumber = 0;
    while(n != 0){
      newNumber = newNumber * 10 + n%10;
      n /= 10;
    }
    return newNumber;
  }
  public static void main(String[] args) {
    int n = 1223;
    System.out.println(n == isPalindrome(n));
  }
}
