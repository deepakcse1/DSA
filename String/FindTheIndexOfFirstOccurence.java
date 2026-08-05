package String;

public class FindTheIndexOfFirstOccurence {
  private int[] buildLPS(char[] pattern) {
    int len = 0;
    int i = 1;
    int n = pattern.length;
    int[] lps = new int[n];
    while (i < n) {
      if (pattern[len] == pattern[i]) {
        len++;
        // lps[i] stores the length of the longest proper prefix which is also a suffix for the substring patter [0...i]
        lps[i] = len; 
        i++;
      } else {
        if (len == 0) i++;
        else len = lps[len - 1];
      }
    }
    return lps;
  }

  public int strStr(String haystack, String needle) {
    // KMP - Knuth-Morris-Pratt algo
    // 1. build LPS
    int[] lps = buildLPS(needle.toCharArray());
    // 2. Perform KMP search using LPS array
    int i = 0; // haystack
    int j = 0; // needle
    int m = haystack.length();
    int n = needle.length();
    while (i < m) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
        if (j == n) return i - n; // whole pattern is matched
      } else {
        if (j == 0) i++;
        else j = lps[j - 1];
      }
    }
    return -1;
  }

    //Brute Force O(n*m)
    //public int strStr(String haystack, String needle) {
    //     int m = haystack.length();
    //     int n = needle.length();
    //     if(n > m) return -1;
    //     int startIdx = -1;
    //     for(int i = 0; i <= m-n; i++){
    //         if(haystack.charAt(i) == needle.charAt(0)){
    //             int j = 0;
    //             while(j < n){
    //                 if(haystack.charAt(i + j) != needle.charAt(j)) break; 
    //                 j++;
    //             }
    //             if(j == n) return i;
    //         }
    //     }
    //     return startIdx;
    // }
}
