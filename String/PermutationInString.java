package String;

import java.util.Arrays;

public class PermutationInString {
  public static void main(String[] args) {
  
    PermutationInString pis = new PermutationInString();
    System.out.println(pis.checkInclusion("ab", "eidbaooo")); // true
    System.out.println(pis.checkInclusion("ab", "eidboaoo")); // false
  }

  //s1 = "ab", s2 = "eidbaooo"
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];

    for (char c : s1.toCharArray()) {
      freq1[c - 'a']++;
    }

    int window = s1.length();
    for (int i = 0; i < s2.length(); i++) {
      freq2[s2.charAt(i) - 'a']++;
      if (i >= window) freq2[s2.charAt(i - window) - 'a']--;
      if (Arrays.equals(freq1, freq2)) return true;
    }
    return false;
  }
}
