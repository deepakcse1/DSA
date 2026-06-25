import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItenary {
  // optimized solution
  public List<String> findItinerary_optimized(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    for (List<String> ticket : tickets) {
      String src = ticket.get(0);
      String dest = ticket.get(1);
      graph.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dest);
    }
    LinkedList<String> result = new LinkedList<>();
    dfs("JFK", graph, result);
    return result;
  }

  public void dfs(String src, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
    while (graph.containsKey(src) && !graph.get(src).isEmpty()) {
      String next = graph.get(src).poll();
      dfs(next, graph, result);
    }
    result.addFirst(src);
  }
  // ----------------------Not optimal solution----------------------
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < tickets.size(); i++) {
      List<String> ticket = tickets.get(i);
      String source = ticket.get(0);
      if (!map.containsKey(source)) {
        map.put(source, new ArrayList<>());
      }
      map.get(source).add(i);
    }
    for (List<Integer> list : map.values()) {
      list.sort((a, b) -> tickets.get(a).get(1).compareTo(tickets.get(b).get(1)));
    }

    boolean[] used = new boolean[tickets.size()];
    List<String> path = new ArrayList<>();
    path.add("JFK");
    dfs("JFK", used, path, tickets, map);
    return path;
  }

  public boolean dfs(String src, boolean[] used, List<String> path, List<List<String>> tickets,
      Map<String, List<Integer>> map) {
    if (path.size() == tickets.size() + 1)
      return true;
    for (Integer idx : map.getOrDefault(src, new ArrayList<>())) {
      if (used[idx])
        continue;
      used[idx] = true;
      String dest = tickets.get(idx).get(1);
      path.add(dest);
      if (dfs(dest, used, path, tickets, map))
        return true;
      used[idx] = false;
      path.remove(path.size() - 1);
    }
    return false;
  }
}
