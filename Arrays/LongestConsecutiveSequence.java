import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
  }

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    Set<Integer> set = new HashSet<>();
    for (int i : nums) set.add(i);

    int max = 0;
    for (int i : set) {
      if (!set.contains(i - 1)) {
        int num = i;
        int count = 1;
        while (set.contains(num + 1)) {
          num++;
          count++;
        }
        max = Math.max(max, count);
      }
    }
    return max;
  }
}
