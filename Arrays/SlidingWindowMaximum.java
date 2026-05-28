import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
  public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;
    int[] result = maxSlidingWindow_Optimized(nums, k);
    for (int num : result) {
      System.out.print(num + " ");  
    }
  }
  
  //brute force
  public static  int[] maxSlidingWindow(int[] nums, int k) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i <= nums.length - k; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < (i + k); j++) {
        if (max < nums[j]) max = nums[j];
      }
      list.add(max);
    }
    int[] ans = new int[list.size()];
    for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
    return ans;
  }

  public static int[] maxSlidingWindow_Optimized(int[] nums, int k) {
    int n = nums.length;
    int[] ans = new int[n - k + 1];
    Deque<Integer> dq = new LinkedList<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      // 1) Remove elements out of window
      if (dq.size() > 0 && dq.peekFirst() <= i - k) {
        dq.pollFirst();
      }
      
      // 2) Remove smaller elements
      while (dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
        dq.pollLast();
      }

      // 3) Add current element index
      dq.offerLast(i);

      // 4) Start recording max after first window
      if(i >= k - 1) {
        ans[count++] = nums[dq.peekFirst()];
      }
    }
    return ans;
  }
}
