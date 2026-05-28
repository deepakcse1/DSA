import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderBFS {
  public static void main(String[] args) {

  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord)) return 0;
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    int level = 1;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String curr = q.poll();
        if (curr.equals(endWord)) return level;
        char[] arr = curr.toCharArray();
        for (int j = 0; j < arr.length; j++) {
          char orgChar = arr[j];
          for (char c = 'a'; c <= 'z'; c++) {
            arr[j] = c;
            String next = new String(arr);
            if (set.contains(next)) {
              q.offer(next);
              set.remove(next);
            }
          }
          arr[j] = orgChar;
        }
      }
      level++;
    }
    return 0;
  }
}
