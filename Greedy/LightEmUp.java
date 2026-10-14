package Greedy;

public class LightEmUp {
  public static void main(String[] args) {
    int[] arr = {1,2,3};
    int k = 1;
    long operation = minOperation(arr, k);
    System.out.println(operation);
  }

  private static long minOperation(int[] bulbs, int k) {
    if (k == 0) {
      for (int bulb : bulbs) {
        if (bulb == 0) return -1;
      }
      return 0;
    }
    int n = bulbs.length;
    int[] diff = new int[n + 1];
    int flipCount = 0;
    int operation = 0;
    for (int i = 0; i < n; i++) {
      flipCount += diff[i];
      int current = bulbs[i];
      if (flipCount % 2 == 1) current ^= 1;
      if (current == 1) continue;
      if (i + k > n) return -1;
      flipCount++;
      operation++;
      diff[i + k]--;
    }
    return operation;
  }
}
