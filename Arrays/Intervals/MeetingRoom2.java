package Intervals;

import java.util.Arrays;
import java.util.List;

class Interval {
  public int start, end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class MeetingRoom2 {
  public static void main(String[] args) {
    
  }
  public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0, e = 0;
        int rooms = 0, maxRooms = 0;
        while(s < n){
            if(start[s] < end[e]){
                rooms++;
                s++;
            }else{
                rooms--;
                e++;
            }
            maxRooms = Math.max(maxRooms, rooms);
        }
        return maxRooms;
    }
}
