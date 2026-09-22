package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StrongElement {
  public static void main(String[] args) {
    int[] arr = {4, 5, -6, 7, -4};
    int n = arr.length;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      int el = arr[i]; //fs.nextInt();
      boolean isDestroyed = false;
      while (!stack.isEmpty() && stack.peek() > 0 && el < 0) {
        int top = stack.peek();
        int incomingSize = Math.abs(el);
        if (top < incomingSize) {
          stack.pop();
        } else if (top == incomingSize) {
          stack.pop();
          isDestroyed = true;
          break;
        } else {
          isDestroyed = true;
          break;
        }
      }
      if (!isDestroyed)
        stack.push(el);
    }
    System.out.println(stack.size());
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.removeLast() + " ");
    }
    System.out.println(sb.toString());
  }
}
