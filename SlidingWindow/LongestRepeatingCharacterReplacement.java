package SlidingWindow;

public class LongestRepeatingCharacterReplacement {
// 1. Fixed Window(Find All Anagrams, Permutation in String, Maximum Average Subarray, Maximum Vowels)
// Expand
//    ↓
// Shrink if window>K
//    ↓
// Check
//------------------------------------
// 2. Variable Window (Longest, Fruit Into Baskets)
//  expand
//  update frequency

//  while(window invalid){
//      shrink
//  }

//  answer = max(answer, window size)

//----------------------------------
// 3. Variable Window (Minimum)
// Expand
//    ↓
// While valid -> Update answer
//    ↓
// Shrink
  public static void main(String[] args) {
    
  }

  //Brute force
  public int characterReplacement(String s, int k) {
    int n = s.length();
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      int[] freq = new int[26];
      int count = 0;
      for (int j = i; j < n; j++) {
        freq[s.charAt(j) - 'A']++;
        count = Math.max(count, freq[s.charAt(j) - 'A']);
        if ((j - i + 1) - count <= k) {
          maxLen = Math.max(maxLen, (j - i + 1));
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
      //expansion
      int index = s.charAt(right) - 'A';
      freq[index]++;
      count = Math.max(count, freq[index]);

      //While invalid -> Shrink
      while ((right - left + 1) - count > k) {
        freq[s.charAt(left) - 'A']--;
        left++;
      }
      
      //update
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }
}

