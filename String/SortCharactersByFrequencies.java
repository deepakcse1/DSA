package String;

// Observation : Instaed for thinking of sorting the freq array, 
// think of getting the max freq -> loop from max to 1 -> get the char and append it.
public class SortCharactersByFrequencies {
  public String frequencySort(String s) {
    int[] freq = new int[128];
    for (char ch : s.toCharArray()) {
      freq[ch]++;
    }
    int max = 0;
    for (int i : freq) {
      max = Math.max(max, i);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = max; i >= 1; i--) {
      for (int j = 0; j < 128; j++) {
        if (freq[j] == i) {
          char ch = (char) j;
          for (int x = 0; x < i; x++) {
            sb.append(ch);
          }
        }
      }
    }
    return sb.toString();
  }
}
