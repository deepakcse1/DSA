package Stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
  public static void main(String[] args) {
    CarFleet cf = new CarFleet();
    int target = 12;
    int[] position = {10, 8, 0, 5, 3};
    int[] speed = {2, 4, 1, 1, 3};
    System.out.println(cf.carFleet(target, position, speed));
  }
  
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    Stack<Double> st = new Stack<>();
    int[][] sol = new int[n][2];
    for (int i = 0; i < n; i++) {
      sol[i][0] = position[i];
      sol[i][1] = speed[i];
    }
    Arrays.sort(sol, (a, b) -> b[0] - a[0]);
    for (int i = 0; i < n; i++) {
      double time = (double) (target - sol[i][0]) / sol[i][1];
      if (st.isEmpty() || time > st.peek()) {
        st.push(time);
      }
    }
    return st.size();
  }

  //-------------- Another Solution --------------
  public int carFlee_betterApproach(int target, int[] position, int[] speed) {
    int res = 0;
    double[] timeArr = new double[target];
    for (int i = 0; i < position.length; i++) {
      timeArr[position[i]] = (double) (target - position[i]) / speed[i];
    }
    double prev = 0.0;
    for (int i = target - 1; i >= 0; i--) {
      double cur = timeArr[i];
      if (cur > prev) {
        prev = cur;
        res++;
      }
    }
    return res;
  }
}
