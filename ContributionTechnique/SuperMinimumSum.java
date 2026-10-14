package ContributionTechnique;

import java.util.ArrayDeque;
import java.util.Deque;

public class SuperMinimumSum {
  public static void main(String[] args) throws Exception {
    int n = 3;
    int[] arr = { 1, 2, 3 };
    int[] left = new int[n];
    int[] right = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
      left[i] = (stack.isEmpty()) ? -1 : stack.peek();
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
      right[i] = (stack.isEmpty()) ? n : stack.peek();
      stack.push(i);
    }
    long ans = 0L;
    for (int i = 0; i < n; i++) {
      long leftChoice = i - left[i];
      long rigtChoice = right[i] - i;
      ans += arr[i] * leftChoice * rigtChoice;
    }
    System.out.println(ans);
  }
}
