package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
  public static void main(String[] args) {
    evalRPN(new String[]{"2","1","+","3","*"});
  }

  public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens){
            if(s.equals("+")) stack.push(stack.pop() + stack.pop());
            else if(s.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            }
            else if(s.equals("*")) stack.push(stack.pop() * stack.pop());
            else if(s.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            }
            else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
    
}
