import java.util.Arrays;

public class IntersectingIntervalPair_one {
  public int countIntersectingIntervals(int[][] intervals) {
    int n = intervals.length;
    int count = 0;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int[] current = intervals[i];
        int[] future = intervals[j];
        if (future[0] <= current[1]) count++;
      }
    }
    return count;
  }
}
