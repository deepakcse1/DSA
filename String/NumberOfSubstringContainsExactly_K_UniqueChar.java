package String;

public class NumberOfSubstringContainsExactly_K_UniqueChar {
  private static int slidingWindow(String s, int k) {
    int[] freq = new int[26];
    int left = 0;
    int distinct = 0;
    int total = 0;
    for (int right = 0; right < s.length(); right++) {
      char ch = s.charAt(right);
      if (freq[ch - 'a'] == 0) distinct++;
      freq[ch - 'a']++;
      while (distinct > k) {
        char leftch = s.charAt(left);
        freq[leftch - 'a']--;
        if (freq[leftch - 'a'] == 0) distinct--;
        left++;
      }
      total += (right - left + 1);
    }
    return total;
  }
  public static void main(String[] args) {
    String s = "abcbaa";
    int k = 3;
    if(k == 0){
      System.out.println("No Substring found with 0 unique characters !!");
      return;
    }
    int count = slidingWindow(s, k) - slidingWindow(s, k-1);
    System.out.println("String " +s+ " having "+count+" subarrays with exactly "+k+" distinct characters");
  }
}
