import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionaryBFS_KAHN_ALGO {
  public static void main(String[] args) {

  }

  public String foreignDictionary(String[] words) {
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();

    // initialization
    for (String word : words) {
      for (char c : word.toCharArray()) {
        graph.putIfAbsent(c, new ArrayList<>());
        indegree.putIfAbsent(c, 0);
      }
    }

    // build graph
    for (int i = 0; i < words.length - 1; i++) {
      String first = words[i];
      String second = words[i + 1];
      if (first.length() > second.length() && first.startsWith(second)) return "";
      int len = Math.min(first.length(), second.length());
      for (int j = 0; j < len; j++) {
        if (first.charAt(j) != second.charAt(j)) {
          char u = first.charAt(j);
          char v = second.charAt(j);
          if (!graph.get(u).contains(v)) {
            graph.get(u).add(v);
            indegree.put(v, indegree.get(v) + 1);
          }
          break;
        }
      }
    }

    Queue<Character> q = new LinkedList<>();
    for (char c : indegree.keySet()) {
      if (indegree.get(c) == 0) q.offer(c);
    }
    
    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      char c = q.poll();
      sb.append(c);
      for (char curr : graph.get(c)) {
        indegree.put(curr, indegree.get(curr) - 1);
        if (indegree.get(curr) == 0) q.offer(curr);
      }
    }
    if (sb.length() != indegree.size())return "";
    return sb.toString();
  }
}
