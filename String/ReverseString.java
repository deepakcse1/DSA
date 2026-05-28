package String;

public class ReverseString {
  //Two pointer Approach
  public static void main(String[] args) {
    // System.out.println(usingRecursion("abcdefgh"));
  }

  public static void reverseString(char[] s) {
    int start = 0;
    int end = s.length - 1;
    while (start < end) {
      char temp = s[start];
      s[start] = s[end];
      s[end] = temp;
      start++;
      end--;
    }
  }
}
