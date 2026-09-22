package Stack.ConversionProblems;

import java.util.ArrayDeque;
import java.util.Deque;

// 1. Iterate the String
// 2. If operand, push to Stack
// 3. If operand, take top 2 out, add operand at first, so -> opearnd+top2+top1, push back
// 4. return top
public class PostfixToPrefix {
  static String postToPre(String s) {
    // code here
    Deque<String> stack = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
      if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
        stack.push(ch + "");
      } else {
        String t1 = stack.pop();
        String t2 = stack.pop();
        String curr = ch + t2 + t1;
        stack.push(curr);
      }
    }
    return stack.peek();
  }
}
