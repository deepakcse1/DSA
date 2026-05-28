
class TrieNode{
   char data;
   boolean isTerminal;
   TrieNode children[];
   int childCount;

   public TrieNode(char data){
      this.data = data;
      isTerminal = false;
      children = new TrieNode[26];
      childCount = 0;
   }
}

public class Trie {

  private static TrieNode root;

  public Trie(){
    root = new TrieNode('\0');
  }

  public void add(String word){
     addHelper(root, word);
  }
  
  private static void addHelper(TrieNode root, String word) {
    if (word.length() == 0) {
      root.isTerminal = true;
      return;
    }
    int childIndex = word.charAt(0) - 'A';
    TrieNode child = root.children[childIndex];
    if (child == null) {
      child = new TrieNode(word.charAt(0));
      root.children[childIndex] = child;
      root.childCount++;
    }
    addHelper(child, word.substring(1));
  }

  public boolean search(String word){
     return searchHelper(root, word);
  }  

  private static boolean searchHelper(TrieNode root, String word){
    if(word.length() == 0) return root.isTerminal;
    int childIndex = word.charAt(0) - 'A';
    TrieNode child = root.children[childIndex];
    if(child == null) return false;
    return searchHelper(child, word.substring(1 ));
  }

  public void delete(String word){
    deleteHelper( root,  word);
  }

  private static void deleteHelper(TrieNode root, String word){
    if(word.length() == 0){
      root.isTerminal = false;
      return;
    } 
    int childIndex = word.charAt(0) - 'A';
    TrieNode child = root.children[childIndex];
    if(child == null){
     return;
    }
    deleteHelper(child, word.substring(1));    
    if(!child.isTerminal && child.childCount == 0){
      root.children[childIndex] = null;
      root.childCount--;
    }
  }

  
}
