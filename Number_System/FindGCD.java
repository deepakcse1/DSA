package Number_System;

public class FindGCD {
  private static int gcd(int a, int b){
    if(a == 0) return b;
    return gcd(b%a , a);
  }

  private static int gcd_iterative(int a, int b){
    while(a != 0){
      int temp = b % a;
      b = a;
      a = temp;
    }
    return b;
  }
  public static void main(String[] args) {
    int a = 16, b = 32;
    System.out.println(gcd_iterative(a, b));
  }
}
