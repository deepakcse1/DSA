import java.util.Arrays;

public class Candy {
  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] candyCount = new int[n];
    Arrays.fill(candyCount, 1);
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candyCount[i] = candyCount[i - 1] + 1;
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        candyCount[i] = Math.max(candyCount[i], candyCount[i + 1] + 1);
      }
    }
    int candies = 0;
    for (int i : candyCount) {
      candies += i;
    }
    return candies;
  }
}
