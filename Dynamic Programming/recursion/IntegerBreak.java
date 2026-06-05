package recursion;

public class IntegerBreak {
  public static void main(String[] args) {

  }

  public int integerBreak(int n) {
    if (n == 1) return 1;
    int max = 0;
    for (int i = 1; i < n; i++) {
      int ans = i * Math.max(n - i, integerBreak(n - i));
      max = Math.max(max, ans);
    }
    return max;
  }
}
