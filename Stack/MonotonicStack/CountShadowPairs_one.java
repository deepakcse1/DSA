package Stack.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountShadowPairs_one {
  public long shadowPairs(int[] nums) {
    Deque<int[]> stack = new ArrayDeque<>();
    long finalAns = 0;
    int count = 0;
    for (int x : nums) {
      while (!stack.isEmpty() && stack.peek()[0] > x) count -= stack.pop()[1];
      if (stack.isEmpty()) {
        stack.push(new int[] { x, 1 });
        count++;
      } else if (stack.peek()[0] == x) {
        int[] top = stack.peek();
        int valid = count - top[1];
        finalAns += valid;
        top[1]++;
        count++;
      } else {
        finalAns += count;
        stack.push(new int[] { x, 1 });
        count++;
      }
    }
    return finalAns;
  }
  // public long shadowPairs(int[] nums) {
  //   int n = nums.length;
  //   long count = 0;
  //   int top = 0;
  //   int[] stack = new int[n];
  //   for (int i : nums) {
  //     // binary search
  //     int start = 0;
  //     int end = top;
  //     while (start < end) {
  //       int mid = start + (end - start) / 2;
  //       if (stack[mid] < i) start = mid + 1;
  //       else end = mid;
  //     }
  //     count += start;
  //     while (top > 0 && stack[top - 1] > i) top--;
  //     stack[top++] = i;
  //   }
  //   return count;
  // }
  // public long shadowPairs(int[] nums) {
  // int n = nums.length;
  // int count = 0;
  // for(int i = 0; i < n-1; i++){
  //   int min = nums[i];
  //   for(int j = i+1; j < n; j++){
  //     if(nums[i] < nums[j] && min == nums[i]) count++;
  //     min = Math.min(min, nums[j]);
  //   }
  // }
  // return count;
  // }
}
