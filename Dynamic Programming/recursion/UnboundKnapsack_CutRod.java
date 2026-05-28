package recursion;

public class UnboundKnapsack_CutRod {
  public static void main(String[] args) {
    int[] price = {3, 5, 6, 7, 10, 12};
    int n = price.length;
    System.out.println(cutRod(price, n));
  }
  public static int cutRod(int price[], int n) {
     return helper(price,n-1, n);
	}
  private static int helper(int[] price, int index, int length){
    //base case
    if(index == 0) return length * price[0];

    //choices
    int take = Integer.MIN_VALUE, notTake;
    notTake = helper(price, index-1, length);
    int currentLength = index + 1;
    if(currentLength <= length){
      take = price[index] + helper(price, index, length - currentLength);
    }

    //optimal
    return Math.max(take,notTake);
  }
}
