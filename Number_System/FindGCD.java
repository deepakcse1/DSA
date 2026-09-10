package Number_System;

public class FindGCD {
  private static int gcd(int a, int b){
    if(a == 0) return b;
    return gcd(b%a , a);
  }

  private static int gcd_iterative(int a, int b){
    while(b != 0){
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }
  public static void main(String[] args) {
    int a = 20, b = 15;
    System.out.println(gcd_iterative(a, b));
  }
}
