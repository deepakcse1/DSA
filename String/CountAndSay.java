package String;

public class CountAndSay {
  //Iterative approach
  public String countAndSay(int n) {
    if (n == 1) return "1";
    StringBuilder result = new StringBuilder("1");
    for (int k = 2; k <= n; k++) {
      int i = 0;
      int len = result.length();
      StringBuilder curr = new StringBuilder();
      while (i < len) {
        int count = 1;
        char c = result.charAt(i);
        int j = i;
        while (j + 1 < len && result.charAt(j + 1) == c) {
          count++;
          j++;
        }
        curr.append(count);
        curr.append(c);
        i = j + 1;
      }
      result = curr;
    }
    return result.toString();
  }

  //recursive approach
  // public String countAndSay(int n) {
  //    return helper(n);
  // }
  // private String helper(int n){
    //     if(n == 1) return "1";
    //     String say = helper(n-1);
    //     int i = 0;
    //     int len = say.length();
    //     StringBuilder sb = new StringBuilder();
    //     while(i < len){
    //         int count = 1;
    //         char c = say.charAt(i);
    //         int j = i;
    //         while(j+1 < len && say.charAt(j+1) == c){
    //             count++;
    //             j++;
    //         }
    //         sb.append(count);
    //         sb.append(c);
    //         i = j+1;
    //     }
    //     return sb.toString();
    // }
}
