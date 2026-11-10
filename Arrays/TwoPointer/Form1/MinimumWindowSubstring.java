package TwoPointer.Form1;

public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    int m = s.length();
    int n = t.length();
    int[] freq = new int[128];
    for (char ch : t.toCharArray()) {
      freq[ch]++;
    }
    int head = -1;
    int tail = 0;
    String ans = "";
    int matched = 0;
    while (tail < m) {
      while (head < m - 1 && matched < n) {
        head++;
        char headKey = s.charAt(head);
        if (freq[headKey] > 0) matched++;
        freq[headKey]--;
      }

      String curr = s.substring(tail, head + 1);

      if (matched == n && ans.length() == 0) ans = curr;
      else if (matched == n && curr.length() < ans.length()) ans = curr;

      if (tail <= head) {
        char tailKey = s.charAt(tail);
        freq[tailKey]++;
        if (freq[tailKey] > 0) matched--;
        tail++;
      } else {
        tail++;
        head = tail - 1;
      }
    }
    return ans;
  }
}
