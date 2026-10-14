package Queue;
// learning source - https://www.youtube.com/watch?v=2dN4ktn6D1k

// import java.util.ArrayDeque;
// import java.util.Deque;

public class FindTheWinnerOfCircularGame {
  public int findTheWinner(int n, int k) {
    int ans = 0;
    for(int i = 2; i <= n; i++){
      ans = (ans + k) % i;
    }
    return ans + 1;
  }

    // ----------- METHOD - 2 --------------------
    // public int findTheWinner(int n, int k) {
    //     return helper(n, k) + 1;
    // }
    // private int helper(int n, int k){
    //     if(n == 1) return 0;
    //     int ans = helper(n-1, k);
    //     return (ans + k) % n;
    // }

    // ----------- METHOD - 1 --------------------
    // public int findTheWinner(int n, int k) {
    //     Deque<Integer> queue = new ArrayDeque<>();
    //     for(int i = 1; i <= n; i++){
    //         queue.offer(i);
    //     }
    //     int i = 1;
    //     while(queue.size() > 1){
    //         int top = queue.poll();
    //         if(i % k != 0) queue.offer(top);
    //         i++;
    //     }
    //     return queue.peek();
    // }
}
