package Combinotorics.nCR;
//this code only work for n <= 40
//For nCr with n≤40 and r≤n, We know that, till 40 we can save all factorials as long, more than that it will overflow
public class NcR_mathodThree {
  // static final long MOD = 1_000_000_007L;

  private static long nCr(int n, int r){
    long res = 1;
    for(int i = 1; i <= r; i++){
      res = res * (n - i + 1);
      res = res / i;
    }
    return res;
  }
  public static void main(String[] args) {
    long res = nCr(6, 3);
    System.out.println(res);
  }
}
