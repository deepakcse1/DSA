package Implementation;

import java.util.Map;

public class SumPair {
  static class SUMPAIR {
    int[] A;
    int[] B;
    Map<Integer, Integer> freqMap;
    int n;

    SUMPAIR(int[] A, int[] B, Map<Integer, Integer> freqMap) {
      this.A = A;
      this.B = B;
      this.freqMap = freqMap;
      n = A.length;
    }

    private void add(int idx, int val) {
      int currVal = B[idx];
      int newValue = currVal + val;
      freqMap.put(currVal, freqMap.getOrDefault(currVal, 0) - 1);
      freqMap.put(newValue, freqMap.getOrDefault(newValue, 0) + 1);
      B[idx] = newValue;
    }

    private int count(int total) {
      int pair = 0;
      for (int i = 0; i < n; i++) {
        int rem = total - A[i];
        if (freqMap.containsKey(rem)) {
          pair += freqMap.get(rem);
        }
      }
      return pair;
    }
  }

  public static void main(String[] args) throws Exception {
    // SUMPAIR sp = new SUMPAIR(A, B, freqMap);
  }
}
