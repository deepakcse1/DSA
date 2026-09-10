package Intervals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public static void main(String[] args) {
    int[][] matrix = {{2,6},{1,4},{2,4}};
    // Arrays.sort(matrix, new Comparator<int[]>() {
    //    @Override
    //    public int compare(int[] a, int[] b){
    //       if(a[0] == b[0]){
    //         return Integer.compare(a[1], b[1]);
    //       }
    //       return Integer.compare(a[0], b[0]);
    //    }
    // });
    merge(matrix);
  }

  public int[][] merge_better(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    int index = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[index][1] >= intervals[i][0]) {
        intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
      } else {
        index++;
        intervals[index] = intervals[i];
      }
    }
    return Arrays.copyOf(intervals, index + 1);
  }
  
  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> ans = new ArrayList<>();
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      int curStart = intervals[i][0];
      int curEnd = intervals[i][1];
      if (curStart <= end) {
        if(curEnd > end) end = curEnd;
      } else {
        ans.add(new int[] { start, end });
        start = curStart;
        end = curEnd;
      }
    }
    ans.add(new int[] { start, end });
    return ans.toArray(new int[ans.size()][]);
  }

  public int[][] merge_method2(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    int n = intervals.length;
    List<int[]> list = new ArrayList<>();
    list.add(intervals[0]);
    for (int i = 1; i < n; i++) {
      int[] prevInterval = list.get(list.size() - 1);
      int[] currInterval = intervals[i];
      if (prevInterval[1] >= currInterval[0]) {
        list.get(list.size() - 1)[1] = Math.max(prevInterval[1], currInterval[1]);
      } else {
        list.add(currInterval);
      }
    }
    int[][] res = new int[list.size()][1];
    int i = 0;
    for (int[] arr : list) {
      res[i++] = arr;
    }
    return res;
  }
}
