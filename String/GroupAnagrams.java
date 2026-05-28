package String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// import HashMap.Map; // Removed incorrect import
import java.util.Map;

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    List<List<String>> list = groupAnagrams_optimized(strs);
    for(List<String> group : list) {
      System.out.println(group);
    }
  }
  
  // Sorting → O(N * K log K)
  public static List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String word : strs) { // bat, eat, tea
      char[] ch = word.toCharArray(); // ['b','a','t'],['e','a','t'],['t','e','a']
      Arrays.sort(ch); // ['a','b','t'], ['a','e','t'],['a','e','t']
      String sortedWord = new String(ch); // abt,aet,aet
      if (!map.containsKey(sortedWord))
        map.put(sortedWord, new ArrayList<>());
      map.get(sortedWord).add(word); // abt : <bat>, aet : <eat,tea>
    }
    return new ArrayList<List<String>>(map.values());
  }

  // Frequency method → O(N * K)
  public static List<List<String>> groupAnagrams_optimized(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String key = sortString(str);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }
    for (List<String> list : map.values()) {
      ans.add(list);
    }
    return ans;
  }

  public static String sortString(String str) {
    int[] arr = new int[26];
    for (char c : str.toCharArray()) {
      arr[c - 'a']++;
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      while (arr[i] > 0) {
        ans.append((char) ('a' + i));
        arr[i]--;
      }
    }
    return ans.toString();
  }

}
