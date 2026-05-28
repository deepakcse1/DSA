package Intervals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
  public static void main(String[] args) {
     int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
     int[] newInterval = {4,8};
     int[][] ans = insert(intervals,newInterval );
     for(int[] i : ans){
      System.out.println(Arrays.toString(i));
     }
  }
  
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    List<int[]> ans = new ArrayList<>();
    int index = 0;
    while (index < n && intervals[index][1] < newInterval[0]) {
      ans.add(intervals[index]);
      index++;
    }
    while (index < n && intervals[index][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
      index++;
    }
    ans.add(newInterval);
    while (index < n) {
      ans.add(intervals[index]);
      index++;
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
