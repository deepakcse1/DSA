import java.util.PriorityQueue;

public class KthLargestElementInAStram {
  PriorityQueue<Integer> queue;
  int max;

  public void KthLargest(int k, int[] nums) {
    queue = new PriorityQueue<>((a, b) -> a - b);
    max = k;
    for (int i : nums) {
      queue.offer(i);
      if (queue.size() > max) queue.poll();
    }
  }

  public int add(int val) {
    queue.offer(val);
    if (queue.size() > max) queue.poll();
    return queue.peek();
  }
}
