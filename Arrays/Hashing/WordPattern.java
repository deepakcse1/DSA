package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] words = s.split(" ");
        if (n != words.length) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char key = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(key)) {
                if (!map.get(key).equals(word)) return false;
            } else {
                if (set.contains(word)) return false;
                set.add(word);
                map.put(key, words[i]);
            }
        }
        return true;
    }
}
