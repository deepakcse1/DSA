package WeeklyContest;

public class WeightedSumOfATree {
  public long weightedSum(int[] parent, int[] nums) {
    int n = nums.length;
    int[] depth = new int[n];
    depth[0] = 1;
    long height = 1;
    for (int i = 0; i < n; i++) {
      if (depth[i] == 0) helper(i, parent, depth);
      height = Math.max(height, depth[i]);
    }

    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += 1L * nums[i] * (height - depth[i] + 1);
    }
    return sum;
  }

  private int helper(int node, int[] parent, int[] depth) {
    if (node == -1) return 1;
    if (depth[node] != 0) return depth[node];
    return depth[node] = helper(parent[node], parent, depth) + 1;
  }
    // public long weightedSum(int[] parent, int[] nums) {
    //     int n = nums.length;
    //     int[] depth = new int[n];
    //     depth[0] = 1;
    //     long height = 1;
        
    //     for(int i = 0; i < n; i++){
    //         if(depth[i] == 0) helper(i, parent, depth);
    //         height = Math.max(height, depth[i]);
    //     }
        
    //     long sum = 0;
    //     for(int i = 0; i < n; i++){
    //         sum += 1L * nums[i] * (height - depth[i] + 1);
    //     }
    //     return sum;
    // }
    // private int helper(int node, int[] parent, int[] depth){
    //     if(parent[node] == -1) return 1;
    //     if(depth[node] != 0) return depth[node];
    //     return depth[node] = helper(parent[node], parent, depth) + 1;
    // }
}
