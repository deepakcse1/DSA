import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {
  public List<Integer> majorityElement(int[] nums) {
    Integer el1 = null, el2 = null;
    int count1 = 0, count2 = 0;
    for (int i : nums) {
      if (el1 != null && el1 == i) count1++;
      else if (el2 != null && el2 == i) count2++;
      else if (count1 == 0) {
        el1 = i;
        count1++;
      } else if (count2 == 0) {
        el2 = i;
        count2++;
      } else {
        count1--;
        count2--;
      }
    }
    List<Integer> list = new ArrayList<>();
    count1 = 0;
    count2 = 0;
    for (int i : nums) {
      if (el1 != null && i == el1) count1++;
      if (el2 != null && i == el2) count2++;
    }
    if (count1 > nums.length / 3) list.add(el1);
    if (count2 > nums.length / 3) list.add(el2);

    return list;
  }
}
