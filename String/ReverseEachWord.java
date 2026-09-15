package String;
// https://www.geeksforgeeks.org/problems/reverse-each-word-in-a-given-string1001/1
public class ReverseEachWord {
  public String reverseWords(String s) {
    int n = s.length();
    int i = 0;
    StringBuilder sb = new StringBuilder();
    while (i < n) {
      while (i < n && s.charAt(i) == ' ') i++;
      int start = i;
      while (i < n && s.charAt(i) != ' ') i++;
      StringBuilder curr = new StringBuilder(s.substring(start, i));
      sb.append(curr.reverse().toString() + " ");
    }
    return sb.substring(0, sb.length()).trim();
  }
    // public String reverseWords(String s) {
    //     String[] strArr = s.trim().split("\\s+");
    //     int n = strArr.length;
    //     Deque<String> stack = new ArrayDeque<>();
    //     for(int i = n-1; i >= 0; i--){
    //         StringBuilder sb = new StringBuilder(strArr[i]);
    //         stack.push(sb.reverse().toString());
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     while(!stack.isEmpty()){
    //         sb.append(stack.pop()+" ");
    //     }
        
    //     return sb.substring(0, sb.length() - 1);
    // }
}
