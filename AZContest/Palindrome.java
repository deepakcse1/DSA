package AZContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://maang.in/contests/attempts/113340?problem_id=21710&returnUrl=[%22/contests/B16-Phase-1-Contest-1704?returnUrl=[%22/cohorts/AZ-Premium-Cohort-16-84?tab=contests%22]
public class Palindrome {
  static class FastScanner {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String[] tokens;
    private int index = 0;

    String next() throws IOException {
      while (tokens == null || index >= tokens.length) {
        tokens = br.readLine().trim().split("\\s+");
        index = 0;
      }
      return tokens[index++];
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    String nextLine() throws IOException {
      return br.readLine();
    }
  }

  private static String helper(String st) {
    int[] freq = new int[26];
    for (char ch : st.toCharArray()) {
      freq[ch - 'a']++;
    }
    StringBuilder left = new StringBuilder();
    StringBuilder middle = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (freq[i] > 0) {
        for (int x = 0; x < freq[i] / 2; x++) {
          left.append((char) (i + 'a'));
        }
        if (freq[i] % 2 != 0 && middle.length() == 0) middle.append((char) (i + 'a'));
      }
    }
    return left.toString() + middle.toString() + left.reverse();
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      String input = fs.next();
      String res = helper(input);
      System.out.println(res);
    }
  }
}
