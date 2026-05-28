package Stack;

import java.util.Stack;

public class DailyTemperature {
  public static void main(String[] args) {
    // Input: temperatures = [73,74,75,71,69,72,76,73]
    // Output: [1,1,4,2,1,1,0,0]
  }
  
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> st = new Stack<>();
    int n = temperatures.length;
    int[] ans = new int[n];
    for (int i = n - 1; i >= 0; i--) {

      while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) 
          st.pop();

      if (!st.isEmpty()) ans[i] = st.peek() - i;

      st.push(i);
    }
    return ans;
  }
}
