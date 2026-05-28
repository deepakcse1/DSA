package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public static void main(String[] args) {
    System.out.println('b' - 'a');
    System.out.println(isAnagram("anagram", "nagaram"));
  }

  //time complexity = O(NLogN)
  public static boolean isAnagram(String s, String t) {
    char[] ch1 = s.toCharArray();
    Arrays.sort(ch1);
    char[] ch2 = t.toCharArray();
    Arrays.sort(ch2);
    return Arrays.equals(ch1, ch2);
  }

  //time complexity = O(n)
  public boolean isAnagram_N(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
      freq[t.charAt(i) - 'a']--;
    }
    for (int i : freq) {
      if (i != 0) return false;
    }
    return true;
  }

  //Unicode-safe version (supports all characters)
  public boolean isAnagramForAllUnicode(String s, String t) {
      if(s.length() != t.length()) return false;
      Map<Character, Integer> freq = new HashMap<>();
      for(char c : s.toCharArray()){
        freq.put(c, freq.getOrDefault(c,0)+1);
      }
      for(char c : t.toCharArray()){
        if(!freq.containsKey(c)) return false;
        freq.put(c,freq.get(c)-1);
        if(freq.get(c) == 0) freq.remove(c);
      }
      return freq.isEmpty();
    }

}
