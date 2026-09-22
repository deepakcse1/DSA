import java.util.Arrays;
import java.util.PriorityQueue;

public class IntersectingIntervalPair_two {
  public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        long count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals){
            int start = interval[0];
            while(!pq.isEmpty() && pq.peek() < start) pq.poll();
            count += pq.size();
            pq.offer(interval[1]);
        }
        return count;
    }
}
