package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SnapShotArray {
  static class FastScanner {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String[] tokens;
    private int index = 0;

    String next() throws IOException {
      while (tokens == null || index >= tokens.length) {
        tokens = br.readLine().trim().split("\\s+");
        index = 0;
      }
      return tokens[index++];
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    String nextLine() throws IOException {
      return br.readLine();
    }
  }

  // try{ }
  // catch(Exception e) System.out.println(e)
  static class Pair {
    int snapIdx;
    int val;

    Pair(int snapIdx, int val) {
      this.snapIdx = snapIdx;
      this.val = val;
    }
  }

  static class SnapshotArray {
    int snap;
    Map<Integer, List<Pair>> map;

    SnapshotArray(int length) {
      snap = 0;
      map = new HashMap<>();
    }

    private void set(int index, int val) {// both can 10^9
      List<Pair> list = map.computeIfAbsent(index, f -> new ArrayList<>());
      if (!list.isEmpty() && list.get(list.size() - 1).snapIdx == snap)
        list.get(list.size() - 1).val = val;
      else
        list.add(new Pair(snap, val));
    }

    private int snap() {
      return snap++;
    }

    private int get(int index, int snap_id) {
      List<Pair> list = map.get(index);
      if (list == null)
        return 0;
      int start = 0;
      int end = list.size() - 1;
      int ans = -1;
      while (start <= end) {
        int mid = start + (end - start) / 2;
        if (list.get(mid).snapIdx <= snap_id) {
          ans = mid;
          start = mid + 1;
        } else
          end = mid - 1;
      }
      return (ans == -1) ? 0 : list.get(ans).val;
    }
  }

  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    int n = fs.nextInt();
    SnapshotArray sa = new SnapshotArray(n);
    while (t-- > 0) {
      String type = fs.next();
      if (type.equals("set")) {
        int index = fs.nextInt();
        int val = fs.nextInt();
        sa.set(index, val);
      } else if (type.equals("snap")) {
        int ans = sa.snap();
        System.out.println(ans);
      } else if (type.equals("get")) {
        int index = fs.nextInt();
        int snap_id = fs.nextInt();
        int ans = sa.get(index, snap_id);
        System.out.println(ans);
      }
    }
  }
}
