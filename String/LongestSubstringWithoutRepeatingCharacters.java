package String;

import java.util.*;
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
