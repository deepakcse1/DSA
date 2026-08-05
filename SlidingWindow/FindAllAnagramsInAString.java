package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 1. Fixed Window(Find All Anagrams, Permutation in String, Maximum Average Subarray, Maximum Vowels)
// Expand
//    ↓
// Shrink if window > K
//    ↓
// Check
//------------------------------------
// 2. Variable Window (Longest, Fruit Into Baskets)
// Expand
//    ↓
// While invalid -> Shrink
//    ↓
// Update answer
//----------------------------------
// 3. Variable Window (Minimum)
// Expand
//    ↓
// While valid -> Update answer
//    ↓
// Shrink

public class FindAllAnagramsInAString {
  public List<Integer> findAnagrams(String s, String p) {
    int m = s.length();
    int n = p.length();
    int[] freq = new int[26];
    for (char ch : p.toCharArray()) {
      freq[ch - 'a']++;
    }
    int matched = 0;
    int left = 0;
    List<Integer> result = new ArrayList<>();
    for (int right = 0; right < m; right++) {
      //Expansion---------------------------------------------------
      char key = s.charAt(right);
      if (freq[key - 'a'] > 0) matched++;
      freq[key - 'a']--;

      //Shrink if window > n ---------------------------------------------------
      if (right - left + 1 > n) {
        char leftKey = s.charAt(left);
        freq[leftKey - 'a']++;
        if (freq[leftKey - 'a'] > 0) matched--;
        left++;
      }

      //Check ---------------------------------------------------
      if ((right - left + 1 == n) && matched == n) {
        result.add(left);
      }
    }
    return result;
  }

  //Brute Force O(n*m)
  // public List<Integer> findAnagrams(String s, String p) {
  //   List<Integer> result = new ArrayList<>();
  //   int m = s.length();
  //   int n = p.length();
  //   if (m < n) return result;
  //   int[] freq = new int[26];
  //   for (char c : p.toCharArray()) {
  //     freq[c - 'a']++;
  //   }

  //   for (int i = 0; i <= m - n; i++) {
  //     int[] curr = new int[26];
  //     for (int j = i; j < i + n; j++) {
  //       curr[s.charAt(j) - 'a']++;
  //     }
  //     if (Arrays.equals(freq, curr)) result.add(i);
  //   }
  //   return result;
  // }
}
