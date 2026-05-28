package Stack;

import java.util.Stack;

public class ValidParanthesis {
  public static void main(String[] args) {
    
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.size() == 0)
          return false;
        if ((stack.peek() == '(' && c == ')') ||
            (stack.peek() == '{' && c == '}') ||
            (stack.peek() == '[' && c == ']')) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.size() == 0;
  }
}
