package recursion;

public class SubsetSumToK {
  public static void main(String[] args) {
    int[] arr = {2, 5, 1, 6, 7};
    int k = 4;
    int n = arr.length;
    System.out.println(subsetSumToK(n, k, arr));
  }
  public static boolean subsetSumToK(int n, int k, int arr[]){
     //base case
     if(k == 0) return true;
     if(n == 0) return false;

     //choices
     boolean take = false;
     boolean notTake = subsetSumToK(n-1, k, arr);
     if(arr[n-1] <= k){
      take = subsetSumToK(n-1, k - arr[n-1], arr);
     }

     //optimal
     return take || notTake;
  }
}
