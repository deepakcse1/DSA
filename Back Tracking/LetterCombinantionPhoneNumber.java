import java.util.ArrayList;
import java.util.List;

public class LetterCombinantionPhoneNumber {
  public static void main(String[] args) {
    letterCombinations("23");
  }

  public static List<String> letterCombinations(String digits) {
    List<String> list = new ArrayList<>();
    String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    helper(digits, 0, "", list, arr);
    return list;
  }

    public static void helper(String digits, int index, String curr, List<String> list, String[] arr) {
      if (curr.length() == digits.length()) {
        list.add(curr);
        return;
      }
      int in = digits.charAt(index) - '0';
      for (char c : arr[in].toCharArray()) {
        helper(digits, index + 1, curr + c, list, arr);
      }
    }
}
