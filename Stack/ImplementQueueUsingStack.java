package Stack;

import java.util.Stack;

public class ImplementQueueUsingStack {
  public static void main(String[] args) {
    
  }
}

class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        peek();
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

// class MyQueue {
//   Stack<Integer> stack;

//   public MyQueue() {
//     stack = new Stack<>();
//   }

//   public void push(int x) {
//     stack.push(x);
//   }

//   public int pop() {
//     Stack<Integer> temp = new Stack<>();
//     while (!stack.isEmpty())
//       temp.push(stack.pop());
//     int deletedItem = temp.pop();
//     while (!temp.isEmpty())
//       stack.push(temp.pop());
//     return deletedItem;
//   }

//   public int peek() {
//     Stack<Integer> temp = new Stack<>();
//     while (!stack.isEmpty())
//       temp.push(stack.pop());
//     int topItem = temp.peek();
//     while (!temp.isEmpty())
//       stack.push(temp.pop());
//     return topItem;
//   }

//   public boolean empty() {
//     return stack.size() == 0;
//   }
// }
