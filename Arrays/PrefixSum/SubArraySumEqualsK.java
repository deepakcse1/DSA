import java.util.HashMap;

public class SubArraySumEqualsK {
  public static void main(String[] args) {
    
  }
  //n^2
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) count++;
      }
    }
    return count;
  }

  //using Prefix sum approach
  public int subarraySumOptimized(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    int prefix = 0;
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      prefix += nums[i];
      int rem = prefix - k;
      if (map.containsKey(rem)) {
        count += map.get(rem);
      }
      map.put(prefix, map.getOrDefault(prefix, 0) + 1);
    }
    return count;
  }
}
