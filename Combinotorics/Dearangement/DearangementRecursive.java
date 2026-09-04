package Combinotorics.Dearangement;

public class DearangementRecursive {
  private static long helper(int n){
    if(n == 1) return 0;
    if(n == 2) return 1;
    return (n-1) * (helper(n-1) + helper(n-2));
  }
  public static void main(String[] args) {
    System.out.println(helper(5));
  }
}
