package Number_System;

public class Armstrong {
  private static int armstrong(int n){
    int k = String.valueOf(n).length();
    int sum = 0;
    while(n != 0){
      int temp = n%10;
      sum += Math.pow(temp, k);
      n /= 10;
    }
    return sum;
  }
  public static void main(String[] args) {
    int n = 153;
    System.out.println(n == armstrong(n));
  }
}
