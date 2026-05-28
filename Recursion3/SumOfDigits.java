public class SumOfDigits {
  public static void main(String[] args) {
    System.out.println(sumOfDigits(123));
  }

  // public static int sumOfDigits(int n){
  //   if(n == 0) return 0;
  //   int sm = sumOfDigits(n/10);
  //   return sm + n%10;
  // }
  
  public static int sumOfDigits(int n){
    if(n == 0) return 0;
    return n%10 + sumOfDigits(n/10);
  }
}
