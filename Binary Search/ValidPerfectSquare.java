public class ValidPerfectSquare {

  public boolean isPerfectSquare(int num) {
    int st = 1;
    int end = num;
    while (st <= end) {
      int mid = st + (end - st) / 2;
      if (mid == num / mid && num % mid == 0) return true;
      else if (mid < num / mid) st = mid + 1;
      else end = mid - 1;
    }
    return false;
  }

  // public boolean isPerfectSquare(int num) {
  //   if (num == 1)
  //     return true;
  //   int st = 1;
  //   int end = num / 2;
  //   while (st <= end) {
  //     int mid = st + (end - st) / 2;
  //     long sqr = (long) mid * mid;
  //     if (sqr == num) return true;
  //     else if (sqr < num) st = mid + 1;
  //     else end = mid - 1;
  //   }
  //   return false;
  // }
}
