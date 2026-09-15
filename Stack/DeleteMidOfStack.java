package Stack;

import java.util.Stack;

public class DeleteMidOfStack {
  public void deleteMid(Stack<Integer> s) {
      int n = s.size();
      int middle = (n + 1) /2;
      helper(s, n, middle);
    }
    private void helper(Stack<Integer> s, int size, int middle){
      if(size == 0) return;
      int el = s.pop();
      helper(s, size - 1, middle);
      if(size != middle) s.push(el);
    }
    // public void deleteMid(Stack<Integer> s) {
    //     // code here
    //     int n = s.size();
    //     int[] arr = new int[n/2];
    //     for(int i = 0; i < n/2; i++){
    //         arr[i] = s.pop();
    //     }
    //     s.pop();
    //     for(int i = n/2 - 1; i >= 0; i--){
    //         s.push(arr[i]);
    //     }
    // }
}
