package tabulation;

import java.util.ArrayList;

public class MaximumProduct {
  public static void main(String[] args) {
    int[] arr = {1,0,-1,2,3,-5,-2};
    int n = arr.length;
    ArrayList<Integer> res = new ArrayList<>();
    for(int i = 0; i < n; i++){
      res.add(arr[i]);
    }
    System.out.println(maximumProduct(res, n));
  }

  public static int maximumProduct(ArrayList<Integer> arr, int n) {
		int max = Integer.MIN_VALUE;
    int prefix = 1, suffix = 1;
    for(int i = 0; i < n; i++){
      if(prefix == 0) prefix = 1;
      if(suffix == 0) suffix = 1;
      prefix *= arr.get(i);
      suffix *= arr.get(n-i-1);
      max = Math.max(max, Math.max(prefix, suffix));
    }
    return max;
	}
}
