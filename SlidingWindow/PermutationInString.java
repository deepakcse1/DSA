package SlidingWindow;

// import java.util.Arrays;

public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    if (m > n) return false;
    int[] freq = new int[26];

    for (char c : s1.toCharArray()) {
      freq[c - 'a']++;
    }

    // Brute force
    // for (int i = 0; i <= n - m; i++) {
    // int[] curr = new int[26];
    // for (int j = i; j < i + m; j++) {
    // curr[s2.charAt(j) - 'a']++;
    // }
    // if (Arrays.equals(freq, curr)) return true;
    // }
    // return false;

    int matched = 0;
    int left = 0;
    for (int right = 0; right < s2.length(); right++) {
      // expansion
      char key = s2.charAt(right);
      if (freq[key - 'a'] > 0) matched++;
      freq[key - 'a']--;

      // shrink if window > k
      if (right - left + 1 > s1.length()) {
        char leftKey = s2.charAt(left);
        freq[leftKey - 'a']++;
        if (freq[leftKey - 'a'] > 0) matched--;
        left++;
      }

      // check
      if (right - left + 1 == s1.length() && matched == s1.length()) return true;
    }
    return false;

  }
}
