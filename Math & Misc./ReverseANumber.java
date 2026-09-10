public class ReverseANumber {
  private static int reverse(int n){
    int res = 0;
    while(n != 0){
      res = res * 10 + n % 10;
      n /= 10;
    }
    return res;
  }
  public static void main(String[] args) {
    int n = 1234567890;
    System.out.println(reverse(n));
  }
}
