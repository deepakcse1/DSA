package String;

public class ReverseWordsInString {
  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    int i = s.length() - 1;
    while (i >= 0) {
      while (i >= 0 && s.charAt(i) == ' ') i--;
      if (i < 0) break;
      int end = i;
      while (i >= 0 && s.charAt(i) != ' ') i--;
      if (sb.length() > 0) sb.append(" ");
      sb.append(s.substring(i + 1, end + 1));
    }
    return sb.toString();
  }

    // public String reverseWords(String s) {
    //     String[] stArray = s.trim().split("\\s+");
    //     int start = 0;
    //     int n = stArray.length;
    //     int end = n - 1;
    //     reverse(start, end, stArray);
    //     StringBuilder sb = new StringBuilder();
    //     for(int i = 0; i < n; i++){
    //         if(i > 0) sb.append(" ");
    //         sb.append(stArray[i]);
    //     }
    //     return sb.toString();
    // }
    // private void reverse(int start, int end, String[] stArray){
    //     while(start < end){
    //         String temp = stArray[start];
    //         stArray[start] = stArray[end];
    //         stArray[end] = temp;
    //         start++;
    //         end--;
    //     }
    // }
}
