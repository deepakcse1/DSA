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
  // public int lengthOfLongestSubstring(String s) {
  //   int maxSub = 0;
  //   int n = s.length();
  //   Set<Character> set = new HashSet<>();
  //   int left = 0;
  //   for (int right = 0; right < n; right++) {
  //     char key = s.charAt(right);
  //     while (set.contains(key)) {
  //       set.remove(s.charAt(left));
  //       left++;
  //     }
  //     set.add(key);
  //     maxSub = Math.max(maxSub, right - left + 1);
  //   }
  //   return maxSub;
  // }
  // public int lengthOfLongestSubstring(String s) {
    //     int maxSub = 0;
    //     int n = s.length();
    //     for(int i = 0; i < n; i++){
    //         Set<Character> set = new HashSet<>();
    //         for(int j = i; j < n; j++){
    //             char key = s.charAt(j);
    //             if(!set.contains(key)){
    //                 set.add(key);
    //                 if(set.size() > maxSub) maxSub = set.size();
    //             }
    //             else break;
    //         }
    //     }
    //     return maxSub;
    // }

    //---------------- Anothe Approach ---------------------------
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for(int right = left; right < n; right++){
            char key = s.charAt(right);
            if(map.containsKey(key) && map.get(key) >= left){
                left = map.get(key) + 1;
            }
            map.put(key, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    //---------- Brute Force -------------------
    // public int lengthOfLongestSubstring(String s) {
    //     int n = s.length();
    //     int max = 0;
    //     for(int i = 0; i < n; i++){
    //         Map<Character, Integer> map = new HashMap<>();
    //         for(int j = i; j < n; j++){
    //             char key = s.charAt(j);
    //             if(map.containsKey(key)) break;
    //             map.put(key, j);
    //             max = Math.max(max, j - i + 1);
    //         }
    //     }
    //     return max;
    // }
}
