package Hashing;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
  public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pToW = new HashMap<>();
        Map<String, Character> wToP = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(pToW.containsKey(ch)){
                if(!pToW.get(ch).equals(word)) return false;
            }
            pToW.put(ch, word);

            if(wToP.containsKey(word)){
                if(wToP.get(word) != ch) return false;
            }
            wToP.put(word, ch);
        }
        return true;
    }
}
