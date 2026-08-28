package Modulo;

public class Factorial {
  private static long fact(int n){
    if(n == 1) return 1;
    return n * fact(n - 1);
  }
  private static long factIterative(int start, int end){
    long ans = 1;
    for(int i = start; i <= end; i++){
      ans *= i;
    }
    return ans;
    }
  
  public static void main(String[] args) {
    // System.out.println(fact(26));
    System.out.println(factIterative(8, 16) - fact(5) - fact(4));
  }
}

