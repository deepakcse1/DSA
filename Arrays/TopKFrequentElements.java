import java.util.*;

public class TopKFrequentElements {
  public static void main(String[] args) {  
    int[] nums = {1};
    int k = 1;
    System.out.println(Arrays.toString(topKFrequentOptimized(nums,k)));
  }
  
  //Min-Heap Top-K (Most Efficient for Large n, Small k)
  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    // initializing map with frequencies
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    // Defining Priority Queue
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

    // add values to Priority Queue
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      pq.add(e);
      if (pq.size() > k) pq.poll();
    }

    // Final Array
    int[] ans = new int[k];
    int index = 0;
    while (!pq.isEmpty()) {
      ans[index++] = pq.poll().getKey();
    }
    return ans;
  }

  //Bucket Sort (True O(n) Time, No Extra Log Factor)
  public static int[] topKFrequentOptimized(int[] nums, int k) {
    // step 1
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
       map.put(i, map.getOrDefault(i, 0) + 1);
    }

    // step 2
    List<List<Integer>> bucket = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      bucket.add(new ArrayList<>());
    }

    for (Map.Entry<Integer, Integer> node : map.entrySet()) { //[1:3,2:2,3:1]
      bucket.get(node.getValue()).add(node.getKey());
    }

    int[] res = new int[k];
    int index = 0;
    for (int i = bucket.size() - 1; i >= 0 && index < k; i--) {
      for (int el : bucket.get(i)) {
        res[index++] = el;
        if (index == k) break;
      }
    }
    return res;
  }
}
