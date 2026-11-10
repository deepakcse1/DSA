package TwoPointer.Form1;

public class NumberOfSubstringContainingAllThreeCharacters {
  public int numberOfSubstrings(String s) {
    String t = "abc";
    int m = s.length();
    int n = t.length();
    int[] freq = new int[128];
    for (char ch : t.toCharArray()) {
      freq[ch]++;
    }
    int head = -1;
    int tail = 0;
    int count = 0;
    int matched = 0;
    while (tail < m) {
      while (head < m - 1 && matched < n) {
        head++;
        char headKey = s.charAt(head);
        if (freq[headKey] > 0)
          matched++;
        freq[headKey]--;
      }

      if (matched == n)
        count += m - head;

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
    return count;
  }
}
