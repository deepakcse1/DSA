import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
  public static void main(String[] args) {
    restoreIpAddresses("25525511135").forEach(System.out::println);
  }

  public static List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    backtrack(s, 0, 0, new StringBuilder(), result);
    return result;
  }

  private static void backtrack(String s, int pos, int part, StringBuilder current, List<String> result) {
    // prune using remaining length
    int remaining = s.length() - pos;
    int remainingParts = 4 - part;
    if (remaining < remainingParts || remaining > remainingParts * 3) return;
    if (part == 4 && pos == s.length()) {
      result.add(current.substring(0, current.length() - 1));
      return;
    }

    int num = 0;
    int len = current.length();
    for (int i = pos; i < Math.min(pos + 3, s.length()); i++) {
      num = num * 10 + (s.charAt(i) - '0');
      if (num > 255) break;
      if (i > pos && s.charAt(pos) == '0') break; // leading zero

      current.append(num).append('.');
      backtrack(s, i + 1, part + 1, current, result);
      current.setLength(len); // backtrack
    }
  }
}
