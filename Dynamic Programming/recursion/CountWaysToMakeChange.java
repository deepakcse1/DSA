package recursion;

public class CountWaysToMakeChange {
  public static void main(String[] args) {
    int[] arr = {1,2,5};
    int target = 11;
    System.out.println(countWaysToMakeChange(arr,target));
  }
  public static long countWaysToMakeChange(int denominations[], int value){
     return helper(denominations, denominations.length-1, value);
	}
  private static long helper(int[] arr, int n, int target){
    if(target == 0) return 1L;
    if(n < 0) return 0;
    long notTake = helper(arr, n-1, target);
    long take = 0;
    if(arr[n] <= target){
      take = helper(arr, n, target - arr[n]);
    }
    return take + notTake;
  }
}
