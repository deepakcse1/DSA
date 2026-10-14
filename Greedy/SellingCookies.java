package Greedy;

import java.util.Arrays;

public class SellingCookies {
  public static void main(String[] args) {
    int n = 3; //fs.nextInt();
    int[] arr = new int[n];
    long total = 0L;
    for (int i = 0; i < n; i++) {
      arr[i] = 1; //fs.nextInt();
      total += arr[i];
    }
    Arrays.sort(arr);
    total = total - arr[n - 1];
    if (arr[n - 1] >= total) {
      total = arr[n - 1] - total;
    } else {
      total -= arr[n - 1];
      total = total % 2;
    }
    System.out.println(total);
  }
}
