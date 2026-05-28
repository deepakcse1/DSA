public class ContainerWithMostWater {
  public static void main(String[] args) {
    int[] height = {1,8,6,2,5,4,8,3,7};
    System.out.println(maxAreaOptimized(height));
  }
  
  public int maxArea(int[] height) {
    int max = 0;
    int n = height.length;
    for (int i = 0; i < n - 1; i++) {
      int count = 0;
      int size = 1;
      for (int j = i + 1; j < n; j++) {
        int minHeight = Math.min(height[i], height[j]);
        count = minHeight * size++;
        max = Math.max(max, count);
      }
    }
    return max;
  }
  
  //optimal
  public static int maxAreaOptimized(int[] height) {
    int max = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int ht = Math.min(height[left], height[right]);
      int wdth = right - left;
      int amnt = ht * wdth;
      max = Math.max(max, amnt);
      if (height[left] < height[right]) left++;
      else right--;
    }
    return max;
  }

  // public int maxArea(int[] height) {
  //   int max = 0;
  //   int start = 0;
  //   int end = height.length - 1;
  //   while (start < end) {
  //     if (height[start] < height[end]) {
  //       if (height[start] * (end - start) > max)
  //         max = Math.max(max, height[start] * (end - start));
  //         start++;
  //     } else {
  //       max = Math.max(max, height[end] * (end - start));
  //       end--;
  //     }
  //   }
  //   return max;
  // }
}
