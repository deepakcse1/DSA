package String;

public class LongestRepeatingCharacterReplacement {
  public static void main(String[] args) {
    
  }

  //Brute force
  public int characterReplacement(String s, int k) {
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
      int[] arr = new int[26];
      int maxFreq = 0;
      for (int j = i; j < s.length(); j++) {
        arr[s.charAt(j) - 'A']++;
        maxFreq = Math.max(maxFreq, arr[s.charAt(j) - 'A']);
        int change = (j - i + 1) - maxFreq;
        if (change <= k) {
          maxLen = Math.max(maxLen, j - i + 1);
        } else {
          break;
        }
      }
    }
    return maxLen;
  }

  //Optimized
  public int characterReplacement_Optimized(String s, int k) {
    int maxLength = 0;
    int count = 0;
    int left = 0;
    int[] freq = new int[26];
    for (int right = 0; right < s.length(); right++) {
      int index = s.charAt(right) - 'A';
      freq[index]++;
      count = Math.max(count, freq[index]);
    //if ((right - left + 1) - count > k) { //if - 12ms | while -  6ms
      while ((right - left + 1) - count > k) {
        freq[s.charAt(left) - 'A']--;
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }
}
