import java.util.Arrays;

public class H_Index {
  //----------O(n)----------------
  public int hIndex_optimized(int[] citations) {
    int n = citations.length;
    int[] count = new int[n + 1];
    for (int i : citations) {
      if (i >= n) count[n]++;
      else count[i]++;
    }
    int paper = 0;
    for (int h = n; h >= 0; h--) {
      paper += count[h];
      if (paper >= h) return h;
    }
    return 0;
  }

  //----------O(nLogn)----------------
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int n = citations.length;
    for (int i = 0; i < n; i++) {
      int papers = n - i;
      if (citations[i] >= papers) return papers;
    }
    return 0;
  }
}
