import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivisions {
  class Pair {
    String key;
    double value;

    Pair(String key, double value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    List<List<String>> equations = new ArrayList<>();
    equations.add(List.of("a", "b"));
    equations.add(List.of("b", "c"));
    double[] values = { 2.0, 3.0 };
    List<List<String>> queries = new ArrayList<>();
    queries.add(List.of("a", "c"));
    queries.add(List.of("b", "a"));
    queries.add(List.of("a", "e"));
    queries.add(List.of("a", "a"));
    queries.add(List.of("x", "x"));
    EvaluateDivisions obj = new EvaluateDivisions();
    double[] ans = obj.calcEquation(equations, values, queries);
    for (double d : ans) {
      System.out.println(d);
    }
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    // DSU solution will be more optimized
    // here Im using DFS
    // 1. create Pair class and Adjecency List
    // 2. Loop through all queries and run DFS
    // 3. DFS will return result
    Map<String, List<Pair>> map = new HashMap<>();
    int n = equations.size();
    for (int i = 0; i < n; i++) {
      List<String> list = equations.get(i);
      String u = list.get(0);
      String v = list.get(1);
      double val = values[i];
      if (map.get(u) == null)
        map.put(u, new ArrayList<>());
      if (map.get(v) == null)
        map.put(v, new ArrayList<>());
      map.get(u).add(new Pair(v, val));
      map.get(v).add(new Pair(u, 1.0 / val));
    }
    int m = queries.size();
    double[] ans = new double[m];

    for (int i = 0; i < m; i++) {
      String s = queries.get(i).get(0);
      String d = queries.get(i).get(1);
      if (map.get(s) == null || map.get(d) == null) {
        ans[i] = -1.0; continue;
      }
      Set<String> visited = new HashSet<>();
      double res = dfs(s, d, map, visited);
      ans[i] = res;
    }
    return ans;
  }

  public double dfs(String s, String d, Map<String, List<Pair>> map, Set<String> visited) {
    if (s.equals(d)) return 1.0;
    visited.add(s);
    for (Pair p : map.get(s)) {
      if (visited.contains(p.key)) continue;
      double ans = dfs(p.key, d, map, visited);
      if (ans != -1.0) return p.value * ans;
    }
    return -1.0;
  }

}
