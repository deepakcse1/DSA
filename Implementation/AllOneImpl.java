package Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class AllOneImpl {
  static class AllOne {
    Map<String, Integer> keyMap;
    TreeMap<Integer, TreeSet<String>> freqMap;

    AllOne() {
      keyMap = new HashMap<>();
      freqMap = new TreeMap<>();
    }

    private void inc(String key) {
      int oldFreq = keyMap.getOrDefault(key, 0);
      if (oldFreq > 0) {
        TreeSet<String> oldSet = freqMap.get(oldFreq);
        oldSet.remove(key);
        if (oldSet.isEmpty())
          freqMap.remove(oldFreq);
      }
      int newFreq = oldFreq + 1;
      keyMap.put(key, newFreq);
      freqMap.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(key);
    }

    private void dec(String key) {
      int oldFreq = keyMap.get(key);
      TreeSet<String> oldSet = freqMap.get(oldFreq);
      oldSet.remove(key);

      if (oldSet.isEmpty()) freqMap.remove(oldFreq);
      if (oldFreq == 1) keyMap.remove(key);

      else {
        int newFreq = oldFreq - 1;
        keyMap.put(key, newFreq);
        freqMap.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(key);
      }
    }

    private String getMaxKey() {
      if (freqMap.isEmpty()) return "";
      return freqMap.lastEntry().getValue().last();
    }

    private String getMinKey() {
      if (freqMap.isEmpty()) return "";
      return freqMap.firstEntry().getValue().last();
    }
  }

  public static void main(String[] args) {
    AllOne ao = new AllOne();
    ao.inc("");
    ao.dec("");
    ao.getMaxKey();
    ao.getMinKey();
  }  
}

