package Stack.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPriceWithSpecialDiscount {
  public int[] finalPrices(int[] prices) {
    int n = prices.length;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
        prices[stack.peek()] -= prices[i];
        stack.pop();
      }
      stack.push(i);
    }
    return prices;
  }
    // public int[] finalPrices(int[] prices) {
    //     int n = prices.length;
    //     int[] res = new int[n];
    //     for(int i = 0; i < n; i++){
    //         int idx = -1;
    //         int nsp = 0;
    //         for(int j = i+1; j < n; j++){
    //             if(prices[j] <= prices[i]){
    //                 idx = j;
    //                 nsp = prices[j];
    //                 break;
    //             }
    //         }
    //         if(idx != -1){
    //             res[i] = prices[i] - nsp;
    //         }else{
    //             res[i] = prices[i];
    //         }
    //     }
    //     return res;
    // }
}
