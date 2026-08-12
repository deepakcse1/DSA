package SlidingWindow;

public class MaximumNumberOfVowelsInASubstring {
  public int maxVowels(String s, int k) {
    int n = s.length();
    int maxCount = 0;
    int count = 0;
    int left = 0;
    for (int right = 0; right < n; right++) {
      char key = s.charAt(right);
      if (key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u')
        count++;

      while (right - left + 1 > k) {
        char leftKey = s.charAt(left);
        if (leftKey == 'a' || leftKey == 'e' || leftKey == 'i' || leftKey == 'o' || leftKey == 'u')
          count--;
        left++;
      }
      maxCount = Math.max(maxCount, count);
    }
    return maxCount;
  }
    // public int maxVowels(String s, int k) {
    //     int n = s.length();
    //     int maxCount = 0;
    //     for(int i = 0; i <= n - k; i++){
    //         int count = 0;
    //         for(int j = i; j < i + k; j++){
    //             char key = s.charAt(j);
    //             if(key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u'){
    //                 count++;
    //             }
    //             maxCount = Math.max(maxCount, count);
    //         }
    //     }
    //     return maxCount;
    // }
}
