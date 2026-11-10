import java.io.*;
import java.util.*;

// Code forces - https://codeforces.com/problemset/problem/1177/B
// public class DigitSequence {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     long k = sc.nextLong(); 
//     long digit = 1;
//     long pow = 1;
//     while (k > 9L * digit * pow) {
//       k -= 9L * digit * pow;
//       digit++;
//       pow *= 10;
//     }

//     long offset = k - 1;
//     String nNoToDelete = Long.toString(pow + offset / digit);
//     long nDigitToSkip = offset % digit;
//     System.out.println(nNoToDelete.charAt((int) nDigitToSkip) - '0');
//     sc.close();
//   }
// }

// CSES - https://cses.fi/problemset/task/2431/
public class DigitSequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int q = sc.nextInt();
    while(q-- > 0){
      long k = sc.nextLong();
      long digit = 1;
      long pow = 1;
      while (k > 9L * digit * pow) {
        k -= 9L * digit * pow;
        digit++;
        pow *= 10;
      }

      long offset = k - 1;
      String noToDelete = Long.toString(pow + offset / digit);
      long digitToSkip = offset % digit;
      System.out.println(noToDelete.charAt((int) digitToSkip) - '0');
    }
    sc.close();
  }
}
