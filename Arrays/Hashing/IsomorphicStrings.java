package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    int n = s.length();
    if (n != t.length()) return false;
    Map<Character, Character> map = new HashMap<>();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      char key1 = s.charAt(i);
      char key2 = t.charAt(i);
      if (map.containsKey(key1)) {
        if (map.get(key1) != key2) return false;
      } else {
        if (set.contains(key2)) return false;
        set.add(key2);
        map.put(key1, key2);
      }

    }
    return true;
  }
}
