import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
  class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
  }

  List<String> list = new ArrayList<>();

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = buildTrie(words);
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(i, j, root, board);
      }
    }
    return list;
  }

  public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode curr = root;
      for (char c : word.toCharArray()) {
        int index = c - 'a';
        if (curr.children[index] == null) {
          curr.children[index] = new TrieNode();
        }
        curr = curr.children[index];
      }
      curr.word = word;
    }
    return root;
  }

  public void dfs(int row, int col, TrieNode node, char[][] board) {
    int m = board.length;
    int n = board[0].length;
    if (row < 0 || row == m || col < 0 || col == n) return;
    char ch = board[row][col];
    if (ch == '#') return;
    if (node.children[ch - 'a'] == null) return;
    node = node.children[ch - 'a'];
    if (node.word != null) {
      list.add(node.word);
      node.word = null;
    }
    board[row][col] = '#';
    dfs(row + 0, col - 1, node, board);
    dfs(row - 1, col + 0, node, board);
    dfs(row + 0, col + 1, node, board);
    dfs(row + 1, col + 0, node, board);
    board[row][col] = ch;
  }
}
