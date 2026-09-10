import java.util.*;

public class CountSubarrayWithGivenXOR_k {
  public static int subarraysWithXorK(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0;
    int prefixXor = 0;
    for(int i : nums){
      prefixXor = prefixXor ^ i;
      //say, total = xor
      //first k ele = x
      //xor - x = k so; 
      // (x ^ k) = xor => (x ^ k ^ k) = (xor ^ k) (add ^k both side) => x = (xor ^ k)
      int rem = prefixXor ^ k;
      if(map.containsKey(rem)){
        count += map.get(rem);
      }
      map.put(prefixXor, map.getOrDefault(prefixXor, 0)+1);
    }
    return count;
  }
  // public static int subarraysWithXorK(int[] nums, int k) {
  //   int n = nums.length;
  //   int count = 0;
  //   for (int i = 0; i < n; i++) {
  //     int xor = 0;
  //     for (int j = i; j < n; j++) {
  //       xor = xor ^ nums[j];
  //       if (xor == k) count++;
  //     }
  //   }
  //   return count;
  // }
  public static void main(String[] args) {
    int[] nums = {5, 6, 7, 8, 9};
    int k = 5;
    int count = subarraysWithXorK(nums, k);
    System.out.println("count :"+ count);
  }
}
