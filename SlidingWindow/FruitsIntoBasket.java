package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
  public int totalFruit(int[] fruits) {
    int n = fruits.length;
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0;
    for (int right = 0; right < n; right++) {
      // expand
      map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

      // shrink if Invalid
      while (map.size() > 2) {
        map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
        if (map.get(fruits[left]) == 0) map.remove(fruits[left]);
        left++;
      }
      // update
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
    // public int totalFruit(int[] fruits) {
    //     int n = fruits.length;
    //     int max = 0;
    //     for(int i = 0; i < n; i++){
    //         Map<Integer, Integer> map = new HashMap<>();
    //         for(int j = i; j < n; j++){
    //             map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

    //             if(map.size() > 2) break;

    //             max = Math.max(max, j - i + 1);
    //         }
    //     }
    //     return max;
    // }
}
