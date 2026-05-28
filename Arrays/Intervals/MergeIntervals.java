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
}
