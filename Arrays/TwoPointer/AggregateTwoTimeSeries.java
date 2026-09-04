package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AggregateTwoTimeSeries {
  public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
    int i = 0, j = 0;
    int m = series1.length, n = series2.length;

    List<List<Integer>> ans = new ArrayList<>();
    while (i < m || j < n) {
      int t;
      //IF j is over or ...
      if (j == n || (i < m && series1[i][0] < series2[j][0])) t = series1[i][0];
      //IF is over or ...
      else if (i == m || series2[j][0] < series1[i][0]) t = series2[j][0];
      //ELSE both time are same
      else t = series1[i][0];

      while (i < m && series1[i][0] < t) i++;
      while (j < n && series2[j][0] < t) j++;

      int v1 = (i < m) ? series1[i][1] : 0;
      int v2 = (j < n) ? series2[j][1] : 0;

      ans.add(Arrays.asList(t, v1 + v2));

      if (i < m && series1[i][0] == t) i++;
      if (j < n && series2[j][0] == t) j++;
    }

    return ans;
  }
}
