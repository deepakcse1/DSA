package Combinotorics.nCR;

// Calculate nCr modulo 10^9 with n <= 1000 and r <= n
// Since Mod is not prime, We can not do divison/inverse, but we can still perform additon
// here we use Take and NotTake formula
// nCr => n-1(C)r-1 + n-1(C)r
// This formula leads to the formation of Pascal's triangle
public class NcR_mathodFour {
  static final long MOD = 1_000_000_007L;
  static long[][] nCr = new long[1001][1001];
  
  private static long nCr_random_modulo(int n, int r) {
    nCr[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) nCr[i][j] = nCr[i - 1][j];
        else nCr[i][j] = nCr[i - 1][j - 1] + nCr[i - 1][j];
      }
    }
    return nCr[n][r];
  }

  public static void main(String[] args) {
    nCr = new long[1001][1001];
    long res = nCr_random_modulo(6, 3);
    System.out.println(res);
  }
}
