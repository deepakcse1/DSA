package Queue;

public class TimeNeededToBuyTickets {
  public int timeRequiredToBuy(int[] tickets, int k) {
    int count = 0;
    for (int i = 0; i < tickets.length; i++) {
      if (i <= k) {
        count += Math.min(tickets[i], tickets[k]);
      } else {
        count += Math.min(tickets[i], tickets[k] - 1);
      }
    }
    return count;
  }
    // public int timeRequiredToBuy(int[] tickets, int k) {
    //     Deque<Integer> q = new ArrayDeque<>();
    //     for(int i = 0; i < tickets.length; i++){
    //         q.offer(i);
    //     }
    //     int count = 0;
    //     while(tickets[k] != 0){
    //         int idx = q.poll();
    //         tickets[idx]--;
    //         count++;
    //         if(tickets[idx] > 0) q.offer(idx);
    //     }
    //     return count;
    // }
}
