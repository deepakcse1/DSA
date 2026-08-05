package SlidingWindow;

import java.util.*;
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
public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    
  }
  //if map has the key && the key's index came after start,
  // move the start to key's index +1
  // normally, put the key and its index in the map
  // update the max length by comparing current max and (i - start +1)
    
  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    int start = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char key = s.charAt(i);
      if (map.containsKey(key) && map.get(key) >= start) {
        start = map.get(key) + 1;
      }
      map.put(key, i);
      max = Math.max(max, (i - start + 1));
    }
    return max;
  }
}
