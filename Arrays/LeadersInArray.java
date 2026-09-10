import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
  public List<Integer> leaders(int[] nums) {
    List<Integer> list = new ArrayList<>();
    int n = nums.length;
    int currLeader = nums[n - 1];
    list.add(currLeader);
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] > currLeader) {
        currLeader = nums[i];
        list.add(currLeader);
      }
    }
    Collections.reverse(list);
    return list;
  }
}
