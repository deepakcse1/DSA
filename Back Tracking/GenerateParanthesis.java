import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
  public static void main(String[] args) {
    generateParenthesis(3);
  }
  
  public static List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    helper(n, "", 0, 0, list);
    return list;
  }

  public static void helper(int n, String curr, int open, int close, List<String> list) {
    if (open == n && close == n) {
      list.add(curr);
      return;
    }
    if (open < n) helper(n, curr + "(", open + 1, close, list);
    if (close < open) helper(n, curr + ")", open, close + 1, list);
  }
}
