/*
 * Problem statement
You are given an array of ‘N’ distinct integers and an integer ‘X’ representing the target sum. You have to tell the minimum number of elements you have to take to reach the target sum ‘X’.

Note:
You have an infinite number of elements of each type.
For example
If N=3 and X=7 and array elements are [1,2,3]. 
Way 1 - You can take 4 elements  [2, 2, 2, 1] as 2 + 2 + 2 + 1 = 7.
Way 2 - You can take 3 elements  [3, 3, 1] as 3 + 3 + 1 = 7.
Here, you can see in Way 2 we have used 3 coins to reach the target sum of 7.
Hence the output is 3.
 */
package recursion;

public class MinimumElements {
  public static void main(String[] args) {
    int[] num = {1,2,3};
    int x = 3;
    System.out.println(minimumElements(num, x));
  }
  public static int minimumElements(int[] num, int x) {
    int n = num.length;
    int ans = helper(num, n-1, x);
    if(ans == Integer.MAX_VALUE) return -1;
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
  
  private static int helper(int[] num, int index, int target) {
    // base case
    if (target == 0) return 0;
    if (index < 0) return Integer.MAX_VALUE;
    // choices
    int notTake = helper(num, index - 1, target);
    int take = Integer.MAX_VALUE;
    if (num[index] <= target) {
      int subTake = helper(num, index, target - num[index]);
      if(subTake != Integer.MAX_VALUE){
        take = 1 + subTake;
      }
    }
    // optimal
    return Math.min(take, notTake);
  }
}
