package SlidingWindow;

import java.util.Scanner;

public class YetAnotherBrokenKeyboard {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    int k = sc.nextInt();
    String str = sc.next();
    long[] freq = new long[26];
    for (int i = 0; i < k; i++) {
      char input = (sc.next()).charAt(0);
      freq[input - 'a']++;
    }

    int len = 0;
    long count = 0;
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      if (freq[ch - 'a'] > 0) {
        len++;
        count += len;
      } else {
        len = 0;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
