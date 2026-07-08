public class Sqrt_x {
  public int mySqrt(int x) {
    int s = 1;
    int e = x;
    while (s <= e) {
      int m = s + (e - s) / 2;
      long sq = (long) m * m;
      if (sq == x) return m;
      else if (sq < x) s = m + 1;
      else e = m - 1;
    }
    return e;
  }
}
