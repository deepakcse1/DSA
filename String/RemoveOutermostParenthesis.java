package String;

public class RemoveOutermostParenthesis {
  public String removeOuterParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    int level = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        level++;
        if (level > 1) sb.append("(");
      } else if (ch == ')') {
        level--;
        if (level > 0) sb.append(")");
      }
    }
    return sb.toString();
  }
}
