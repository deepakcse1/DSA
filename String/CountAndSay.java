package String;

public class CountAndSay {
  //Iterative approach
  public String countAndSay(int n) {
    StringBuilder res = new StringBuilder("1");
    for (int k = 2; k <= n; k++) {
      int left = 0;
      int len = res.length();
      StringBuilder say = new StringBuilder();
      while (left < len) {
        char currChar = res.charAt(left);
        int count = 0;
        int right = left;
        while (right < len && res.charAt(right) == currChar) {
          count++;
          right++;
        }
        say.append(count);
        say.append(currChar);
        left = right;
      }
      res = say;
    }
    return res.toString();
  }

  //recursive approach
  // public String countAndSay(int n) {
  //   if (n == 1) return "1";
  //   String say = countAndSay(n - 1);
  //   int left = 0;
  //   int len = say.length();
  //   StringBuilder ans = new StringBuilder();
  //   while (left < len) {
  //     int count = 0;
  //     char currChar = say.charAt(left);
  //     int right = left;
  //     while (right < len && say.charAt(right) == currChar) {
  //       count++;
  //       right++;
  //     }
  //     ans.append(count);
  //     ans.append(currChar);
  //     left = right;
  //   }
  //   return ans.toString();
  // }
}
