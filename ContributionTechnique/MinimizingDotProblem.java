package ContributionTechnique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimizingDotProblem {
  public static void main(String[] args) throws Exception {
    int n = 5; // fs.nextInt();
    List<Integer> v = new ArrayList<>();
    List<Integer> w = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      // v.add(fs.nextInt());
    }
    Collections.sort(v);
    for (int i = 0; i < n; i++) {
      // w.add(fs.nextInt());
    }
    Collections.sort(w, Collections.reverseOrder());
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans += (long) v.get(i) * w.get(i);
    }
    System.out.println(ans);
  }
}
