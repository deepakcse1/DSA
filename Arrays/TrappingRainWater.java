public class TrappingRainWater {
  public static void main(String[] args) {
    
  }
  
  public int trap(int[] height) {
    int sum = 0;
    for (int i = 1; i < height.length - 1; i++) {
      int leftMax = 0;
      int rightMax = 0;
      for (int j = i; j >= 0; j--) {
        if (height[j] > leftMax) leftMax = height[j];
      }
      // if(leftMax == 0) continue; // no need to include
      for (int j = i; j < height.length; j++) {
        if (height[j] > rightMax) rightMax = height[j];
      }
      // if(rightMax == 0) continue; // no need to include
      sum += Math.min(rightMax, leftMax) - height[i];
    }
    return sum;
  }

  public int trap_Optimal(int[] height) {
    int sum = 0;
    int n = height.length - 1;
    int[] leftMax = new int[n + 1];
    int[] rightMax = new int[n + 1];
    leftMax[0] = height[0];
    rightMax[n] = height[n];

    for (int i = 1; i <= n; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }
    for (int i = n - 1; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }
    for (int i = 0; i <= n; i++) {
      sum += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    return sum;
  }

  public int trap_Optimized(int[] height) {
    int sum = 0;
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      if (leftMax < rightMax) {
        sum += leftMax - height[left];
        left++;
      } else {
        sum += rightMax - height[right];
        right--;
      }
    }
    return sum;
  }
}
