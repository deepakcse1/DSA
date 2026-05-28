package Stack;

import java.util.Stack;

public class SimplifyPath {
  public static void main(String[] args) {
    // String path = "/a/./b/../../c/";
    // String path = "/home/";
    // String path = "/home//foo/";
    // String path = "/home/user/Documents/../Pictures";
    String path = "/../";
    // String path = "/.../a/../b/c/../d/./";
    System.out.println(simplifyPath(path));
  }

  public  static String simplifyPath(String path) {
    String[] arr = path.split("/");
    Stack<String> stack = new Stack<>();
    for (String s : arr) {
      if (s.equals("..") && !stack.isEmpty())
        stack.pop();
      else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
        stack.push(s);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (String s : stack) {
      sb.append("/");
      sb.append(s);
    }
    return (sb.length() == 0) ? "/" : sb.toString();
  }
}
