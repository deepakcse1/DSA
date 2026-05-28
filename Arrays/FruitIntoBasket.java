import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
  public static void main(String[] args) {
  }

  public int totalFruit(int[] fruits) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    int start = 0;
    for (int i = 0; i < fruits.length; i++) {
      map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

      if (map.size() > 2) {
        map.put(fruits[start], map.getOrDefault(fruits[start], 0) - 1);
        if (map.get(fruits[start]) == 0) {
          map.remove(fruits[start]);
        }
        start++;
      }
      
      max = Math.max(max, (i - start + 1));
    }
    return max;
  }
}
