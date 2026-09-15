package String;

public class ShortestPalindrome {
  // ----------------------METHOD 1-------------------------
  private int[] build_lps(char[] pattern) {
    int m = pattern.length;
    int j = 0, i = 1;
    int[] lps = new int[m];
    while (i < m) {
      if (pattern[i] == pattern[j]) {
        j++;
        lps[i++] = j;
      } else {
        if (j == 0) i++;
        else j = lps[j - 1];
      }
    }
    return lps;
  }
    public String shortestPalindrome(String s) {
      String rev = new StringBuilder(s).reverse().toString();
      String lpsString = s + "#" + rev;
      int[] lps = build_lps(lpsString.toCharArray());
      return rev.substring(0, rev.length() - lps[lps.length - 1]) + s;
    }

    //----------------------METHOD 2-------------------------
    // public String shortestPalindrome(String s) {
    //     String rev = new StringBuilder(s).reverse().toString();
    //     int n = s.length();
    //     for(int i = 0; i < n; i++){
    //         if(s.substring(0, n-i).equals(rev.substring(i))){
    //             return rev.substring(0,i) + s;
    //         }
    //     }
    //     return rev + s;
    // }

    //----------------------METHOD 3-------------------------
    // public String shortestPalindrome(String s) {
    //     StringBuilder sb = new StringBuilder(s);
    //     int i = 0;
    //     int j = s.length() - 1;
    //     while(i < j){
    //         if(isPalin(sb.substring(i, j+1))){
    //             break;
    //         }else{
    //             sb.insert(i, sb.charAt(j));
    //             i++;
    //         }
    //     }
    //     return sb.toString();
    // }
    // private boolean isPalin(String s){
    //     int left = 0;
    //     int right = s.length()-1;
    //     while(left < right){
    //         if(s.charAt(left) != s.charAt(right)) return false;
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
}
