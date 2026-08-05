package SlidingWindow;

public class MinimumWindowSubstring {
// 1. Fixed Window(Find All Anagrams, Permutation in String, Maximum Average Subarray, Maximum Vowels)
// Expand
//    ↓
// Shrink if window>K
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
  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }

  public static  String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";
    int[] freq = new int[128];
    for (char c : t.toCharArray()) {
      freq[c]++;
    }
    int left = 0;
    int minLen = Integer.MAX_VALUE;
    int count = 0;
    int stIndex = -1;
    for (int i = 0; i < s.length(); i++) {
      if (freq[s.charAt(i)] > 0) count++; //increase count
      freq[s.charAt(i)]--;
      
      while (count == t.length()) {
        if ((i - left + 1) < minLen) {
          minLen = i - left + 1;
          stIndex = left;
        }
        freq[s.charAt(left)]++;
        if (freq[s.charAt(left)] > 0) count--;
        left++;
      }
    }
    return (stIndex == -1) ? "" : s.substring(stIndex, stIndex + minLen);
  }
}
