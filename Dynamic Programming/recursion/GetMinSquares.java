package recursion;

public class GetMinSquares {
  public static void main(String[] args) {
    int n = 13;
    System.out.println(minSquares(n));
  }
  public static int minSquares(int n){
    if(n == 0) return 0;
    int minCount = Integer.MAX_VALUE;
    for(int i = 1; i*i <= n; i++){
      int square = i*i;
      int count = 1 + minSquares(n - square);
      minCount = Math.min(minCount, count);
    }
    return minCount;
  }
}
