import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
  public static void main(String[] args) {
    new PalindromePartitioning().partition("aab").forEach(System.out::println);
  }

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    helper(s, new ArrayList<>(), result);
    return result;
  }

  public void helper(String s, List<String> curr, List<List<String>> result) {
    if (s.length() == 0) {
      result.add(new ArrayList<>(curr));
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      String str = s.substring(0, i + 1);
      if (isPalindrome(str)) {
        curr.add(str);
        helper(s.substring(i + 1), curr, result);
        curr.remove(curr.size() - 1);
      }
    }
  }

    public boolean isPalindrome(String str) {
      int left = 0;
      int right = str.length() - 1;
      while (left <= right) {
        if (str.charAt(left) != str.charAt(right)) {
          return false;
        }
        left++;
        right--;
      }
      return true;
    }
}
