import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Candy {
  public int candy(int[] ratings) {
    int n = ratings.length;
    int candy = n; // each children get 1 candy
    int i = 1;
    while (i < n) {
      if (ratings[i] == ratings[i - 1]) {
        i++;
        continue;
      }

      // Increasing Slope
      int peak = 0;
      while (ratings[i] > ratings[i - 1]) {
        peak++;
        candy += peak;
        i++;
        if (i == n)
          return candy;
      }

      // Decreasing Slope
      int dip = 0;
      while (i < n && ratings[i] < ratings[i - 1]) {
        dip++;
        candy += dip;
        i++;
      }

      candy -= Math.min(peak, dip); // Keep only the higher peak
    }
    return candy;
  }

  // public int candy(int[] ratings) {
  // int n = ratings.length;
  // int[] candyCount = new int[n];
  // Arrays.fill(candyCount, 1);
  // for (int i = 1; i < n; i++) {
  // if (ratings[i] > ratings[i - 1]) {
  // candyCount[i] = candyCount[i - 1] + 1;
  // }
  // }
  // for (int i = n - 2; i >= 0; i--) {
  // if (ratings[i] > ratings[i + 1]) {
  // candyCount[i] = Math.max(candyCount[i], candyCount[i + 1] + 1);
  // }
  // }
  // int candies = 0;
  // for (int i : candyCount) {
  // candies += i;
  // }
  // return candies;
  // }
}
