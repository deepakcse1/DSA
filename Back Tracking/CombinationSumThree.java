import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
    helper(1, k, n, new ArrayList<>());
    return result;
  }

  public void helper(int start, int k, int n, List<Integer> curr) {
    if (k == 0) {
      if (n == 0) {
        result.add(new ArrayList<>(curr));
      }
      return;
    }
    for (int i = start; i < 10; i++) {
      if (i > n) break;
      curr.add(i);
      helper(i + 1, k - 1, n - i, curr);
      curr.remove(curr.size() - 1);
    }
  }
}
