import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    class Pair{
        int val;
        int delta;
        Pair(int val, int delta){
            this.val = val;
            this.delta = delta;
        }
    }
    public long countIntersectingIntervals_LineSweep(int[][] intervals) {
        int n = intervals.length;
        List<Pair> list = new ArrayList<>();
        for(int[] interval : intervals){
            list.add(new Pair(interval[0] , 1));
            list.add(new Pair(interval[1] , -1));
        }
        list.sort((a,b) -> {
            if(a.val != b.val) return Integer.compare(a.val,b.val);
            return Integer.compare(b.delta,a.delta);
        });
        long active = 0L;
        long pairs = 0L;
        for(Pair p : list){
            if(p.delta == 1){
                pairs += active;
                active++;
            }
            else active--;
        }
        return pairs;
    }
}
