import java.util.PriorityQueue;

public class InbuiltPQ {
  public static void main(String[] args) {
    int[] arr = {3,5,1,2,9,8,6,4,7};
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0; i < arr.length; i++){
      pq.add(arr[i]);
    }
    while (!pq.isEmpty()) {
      System.out.println(pq.peek());
      pq.poll(); //Retrieves and removes the head of this queue, or returns null if this queue is empty.
      // pq.remove(); //Retrieves and removes the head of this queue. This method differs from poll only in that it throws an exception if this queue is empty.
    }
  }
}
