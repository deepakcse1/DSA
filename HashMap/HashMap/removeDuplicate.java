package HashMap;
import java.util.*;
import java.util.Map;


public class removeDuplicate {
  public static void main(String[] args) {
    int[] arr1 = {1,2,3,4,2};
    // ArrayList<Integer> ans = removeDuplicates(arr, arr.length);
    // System.out.println(ans);
    int[] arr2 = {1,6,2,2,3};
    // System.out.println(maxFrequencyNumber(arr2));
    printIntersection(arr1, arr2);
  }
  public static ArrayList<Integer> removeDuplicates(int[] arr, int size){
    ArrayList<Integer> output = new ArrayList<>();
    HashMap<Integer, Boolean> seen = new HashMap<>();
    for(int i = 0; i < size; i++){
      if(!seen.containsKey(arr[i])){
         seen.put(arr[i], true);
         output.add(arr[i]);
      }
    }
    return output;
  }

  public static int maxFrequencyNumber(int[] arr){ 
    // HashMap<Integer, Integer> map = new HashMap<>(); // not maintain any sequence
    // TreeMap<Integer, Integer> map = new TreeMap<>(); // maintain sorting
    Map<Integer, Integer> map = new LinkedHashMap<>();  //maintain incoming sequence
    for(int i : arr){
      if(map.containsKey(i)){         
         int x = map.get(i);
         x++;
         map.put(i, x);
      }else{
        map.put(i, 1);
      }
    }
    Set<Integer> keys = map.keySet();
    int maxNumber = -1;
    int maxCount = 0;
    for(Integer i : keys){
      System.out.println(i +" : "+map.get(i));
      if(map.get(i) > maxCount){
        maxCount = map.get(i);
        maxNumber = i;
      }
    }
    return maxNumber;
  }

  public static void printIntersection(int[] arr1, int[] arr2) {
    HashMap<Integer, Integer> map1 = new HashMap<>();
    for (int i : arr1) {
      if (map1.containsKey(i)) {
        int x = map1.get(i);
        x++;
        map1.put(i, x);
      } else {
        map1.put(i, 1);
      }
    }
    // print(map1);
    // System.out.println("----------------------------");
    for(int i = 0 ; i < arr2.length; i++){
      if(map1.containsKey(arr2[i])){
        int x = map1.get(arr2[i]);
        if(x > 0){
           System.out.println(arr2[i]);
           x--;
           map1.put(arr2[i], x);
        }
      }
    }
  }
  public static void print(Map<Integer, Integer> map){
      Set<Integer> keys = map.keySet();
      for(Integer i : keys){
         System.out.println(i+" : "+map.get(i));
      }
  }
}
