package recursion;

import java.util.List;

public class WordBreak {
  public static void main(String[] args) {

  }

  public boolean wordBreak(String s, List<String> wordDict) {
    return helper(0, s, wordDict);
  }

  public boolean helper(int index, String s, List<String> wordDict) {
    if (index == s.length()) return true;
    for (String word : wordDict) {
      if (index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word)) {
        if (helper(index + word.length(), s, wordDict)) return true;
      }
    }
    return false;
  }
}
