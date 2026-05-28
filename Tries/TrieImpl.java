public class TrieImpl {
  public static void main(String[] args) {
    Trie tr = new Trie();
    tr.add("ABCDE");
    tr.add("AS");
    tr.add("ASS");
    tr.add("ASH");
    tr.add("FISH");
    tr.add("ARE");
    System.out.println(tr.search("ASS"));
    tr.delete("ASS");
    System.out.println(tr.search("ASS"));
    System.out.println(tr.search("AS"));
  }
}
