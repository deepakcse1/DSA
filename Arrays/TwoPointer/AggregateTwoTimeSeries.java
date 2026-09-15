package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AggregateTwoTimeSeries {
  public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
    List<List<Integer>> list = new ArrayList<>();
    int m = series1.length;
    int n = series2.length;
    int i = 0, j = 0;
    while (i < m && j < n) {
      int sum = series1[i][1] + series2[j][1];
      if (series1[i][0] == series2[j][0]) {
        list.add(Arrays.asList(series1[i][0], sum));
        i++; j++;
      } else if (series1[i][0] < series2[j][0]) {
        list.add(Arrays.asList(series1[i++][0], sum));
      } else {
        list.add(Arrays.asList(series2[j++][0], sum));
      }
    }
    while (i < m) {
      int sum = series1[i][1];
      list.add(Arrays.asList(series1[i++][0], sum));
    }
    while (j < n) {
      int sum = series2[j][1];
      list.add(Arrays.asList(series2[j++][0], sum));
    }
    return list;
  }
}
