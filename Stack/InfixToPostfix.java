package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix {
  private static int priority(char ch) {
    if (ch == '^') return 3;
    else if (ch == '*' || ch == '/') return 2;
    else if (ch == '+' || ch == '-') return 1;
    return -1;
  }

  // Algoithm
  // if ch == 'a' - 'z' || 'A' - 'Z' || '0' - '9' -> add is SB
  // if ch == '(' -> push in stack
  // if ch == ')' -> take out all stored operator from stack and add in SB, and at last, pop '(' as well
  // other wise, while proirity of stored operator is greater than curr operator, take out all the the greater operator and add in SB, and at last, add current operator in stack
  // At last, take out all the stored operator from stack and add in SB
  public static void main(String[] args) throws Exception {
    // FastScanner fs = new FastScanner();
    int t = 1; // fs.nextInt();
    while (t-- > 0) {
      String str = "(a*b)+c"; // fs.next();
      Deque<Character> stack = new ArrayDeque<>();
      StringBuilder sb = new StringBuilder();
      for (char ch : str.toCharArray()) {
        if (ch >= 'a' && ch <= 'z') sb.append(ch);
        else if (ch == '(') stack.push(ch);
        else if (ch == ')') {
          while (!stack.isEmpty() && stack.peek() != '(') {
            sb.append(stack.pop());
          }
          stack.pop();
        } else {
          //If proirity of stored operator is greater than curr than mark that op. evaluated
          while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
            sb.append(stack.pop());
          }
          stack.push(ch);
        }
      }
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      System.out.println(sb.toString());
    }
  }
}
