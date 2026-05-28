package recursion;

public class CanPartition {
  public static void main(String[] args) {
    int[] arr = {5, 6, 5, 11, 6};
    System.out.println(canPartition(arr, arr.length));
  }
  public static boolean canPartition(int[] arr, int n) {
    int sum = 0;
    for(int num : arr){
      sum += num;
    }
    System.out.println("sum :"+sum);
    if(sum % 2 != 0) return false;
    return helper(arr, n-1, sum/2);
	}
  private static boolean helper(int[] arr, int n, int k){
    //base case
    if(k == 0) return true;
    if(n < 0) return false;
    //choices
    boolean take = false;
    boolean notTake = helper(arr, n-1, k);
    if(arr[n] <= k){
      take = helper(arr, n-1, k - arr[n]);
    }
    //optimal
    return take || notTake;
  }

}
