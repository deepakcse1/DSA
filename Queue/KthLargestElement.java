package Queue;

import java.util.PriorityQueue;

public class KthLargestElement {
  public static void main(String[] args) {
    
  }
  
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    for (int i : nums) {
      pq.offer(i);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.peek();
  }

    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    //     for(int i : nums){
    //         pq.offer(i);
    //     }
    //     int res = 0;
    //     for(int i = 0; i < k; i++){
    //         if(pq.isEmpty()) break;
    //         res = pq.poll();
    //     }
    //     return res;
    // }
}
