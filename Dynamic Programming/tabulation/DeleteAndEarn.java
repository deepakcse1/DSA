package tabulation;

public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    int max = 0;
    for (int i : nums) {
      if (max < i) max = i;
    }
    int[] points = new int[max + 1];
    for (int i : nums) {
      points[i] += i;
    }
    int i_1 = 0; //i-1
    int i_2 = 0; //i-2
    for (int i = 1; i <= max; i++) { //i is the current number
      int curr = Math.max(i_1, i_2 + points[i]);
      i_2 = i_1;
      i_1 = curr;
    }
    return i_1;
  }
}
