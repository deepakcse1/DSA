public class GuessNumberHigherOrLower {
  public int guessNumber(int n) {
    int st = 1;
    int end = n;
    while (st <= end) {
      int mid = st + (end - st) / 2;
      int ans = guess(mid); 
      if (ans == 0) return mid;
      else if (ans == 1) st = mid + 1;
      else end = mid;
    }
    return -1;
  }

  // given by code
  int guess(int num){
    return 0;
  }
}
