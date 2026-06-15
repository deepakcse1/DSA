// import java.util.Map;

public class MajorityElements {
  //Boyer-Moore Voting Algorithm
  public int majorityElement(int[] nums) {
    int candidate = 0;
    int count = 0;
    for (int num : nums) {
      if (count == 0) candidate = num;
      if (num == candidate) count++;
      else count--;
    }
    return candidate;
  }
  // public int majorityElement(int[] nums) {
  //   int n = nums.length;
  //   int majorityCount = n/2;
  //   Map<Integer, Integer> map = new HashMap<>();
  //   for(int i : nums){
  //     map.put(i, map.getOrDefault(i, 0)+1);
  //   }
  //   for(Integer el : map.keySet()){
  //     if(map.get(el) > majorityCount) return el;
  //   }
  //   return -1;
  // }
}
