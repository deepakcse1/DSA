package Combinotorics;

import java.util.Scanner;

public class KthBeautifulString {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      long k = sc.nextLong(); //return kth string in lexicographical order 
      int b = 2;
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= n; i++) {
        long x; 
        if (b == 2){
          //if we put a at position i, then the number of strings that can be formed with the remaining b's is (n-i) choose 2
          x = (long) (n - i) * (n - i - 1) / 2;
        }
        else if (b == 1){
          //if we put a at position i, then the number of strings that can be formed with the remaining b's is (n-i) choose 1
          x = n - i;
        }
        else x = 0;
        if (k <= x || b == 0) { // if k is less than or equal to the number of strings that can be formed with the remaining b's, then we put a at position i
          sb.append("a");
        } else {
          sb.append("b"); // if k is greater than the number of strings that can be formed with the remaining b's, then we put b at position i
          b--;
          k -= x; // we subtract the number of strings that can be formed with the remaining b's from k, because we have already considered those strings
        }
      }
      System.out.println(sb.toString());
    }
    sc.close();
  }
}
