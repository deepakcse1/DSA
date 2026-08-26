package Stack;

import java.util.Stack;

public class RemoveKDigit {
  public String removeKdigits(String num, int k) {
    if (num.length() == k) return "0";
    Stack<Character> stack = new Stack<>();
    for (char ch : num.toCharArray()) {
      while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
        stack.pop();
        k--;
      }
      stack.push(ch);
    }
    while (k > 0 && !stack.isEmpty()) {
      stack.pop();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    for (char ch : stack) {
      sb.append(ch);
    }

    while (sb.length() > 0 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }

    return (sb.length() == 0) ? "0" : sb.toString();
  }
}
