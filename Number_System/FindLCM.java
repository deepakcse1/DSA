package Number_System;

public class FindLCM {
  private static int gcd(int a, int b){
    if(a == 0) return b;
    return gcd(b % a, a);
  }
  public static void main(String[] args) {
    int a = 4, b = 8;
    int res = (a * b) / gcd(a, b);
    System.out.println(res);
  }
}
