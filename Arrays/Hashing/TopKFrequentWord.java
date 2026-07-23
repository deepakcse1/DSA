package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWord {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
      if (map.get(a).equals(map.get(b))) {
        return b.compareTo(a);
      }
      return map.get(a) - map.get(b);
    });
    for (String st : map.keySet()) {
      pq.offer(st);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(0, pq.poll()); //adding at 0th index to avoid reversing the list at the end
    }
    // Collections.reverse(result);
    return result;
  }
}
