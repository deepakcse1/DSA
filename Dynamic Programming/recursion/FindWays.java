/*Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
Since the number of ways can be very large, print it modulo 10 ^ 9 + 7 (1000000007)
Example:
Input: 'arr' = [1, 1, 4, 5], target = 5
Output: 3
Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently. */
package recursion; 

public class FindWays {
  public static void main(String[] args) {
    int[] num =  {0,1,3};
    int tar = 4;
    System.out.println(findWays(num, tar));
  }
  public static int findWays(int num[], int tar) {
    return helper(num, tar, num.length -1);
  }
  private static int helper(int[] num, int tar, int n){
    //base case
    if(tar == 0) return 1;
    if(n < 0 || tar < 0) return 0;

    //choices
    int notTake = helper(num, tar, n-1);
    int take = 0;
    if(num[n] <= tar){
      take = helper(num, tar - num[n], n-1);
    }
    //optimal
    return (take + notTake) % 1000000007;
  } 
}
