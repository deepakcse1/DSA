
import java.util.ArrayList;
import java.util.List;

class DisjointSet{
  List<Integer> rank = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();
  public DisjointSet(int V){
    for(int i = 0; i < V; i++){ //0 based indexing
       rank.add(0);
       parent.add(i);
    }
  }
  public int findParent(int v){
    if(v == parent.get(v)) return v;
    int ultimateParent = findParent(parent.get(v));
    parent.set(v, ultimateParent); // path compression
    return parent.get(v);
  }

  public void unionByRank(int v1, int v2){
    int pV1 = findParent(v1);
    int pV2 = findParent(v2);
    if(pV1 == pV2) return;
    if(rank.get(pV1) < rank.get(pV2)){
      parent.set(pV1, pV2);
    }
    else if(rank.get(pV2) < rank.get(pV1)){
      parent.set(pV2, pV1);
    }else{
      parent.set(pV2, pV1);
      int x = rank.get(pV1);
      rank.set(pV1, x+1);
    }
  }
}
public class DSUbyRank {
  public static void main(String[] args) {
    int V = 7;
    DisjointSet ds = new DisjointSet(V);
    ds.unionByRank(0, 1);
    ds.unionByRank(1, 2);
    ds.unionByRank(3, 4);
    ds.unionByRank(5, 6);
    ds.unionByRank(4, 5);
    // Should print "not same"
    System.out.println(ds.findParent(2) == ds.findParent(6) ? "same" : "not same");

    ds.unionByRank(2,6);

    // Should print "same"
    System.out.println(ds.findParent(2) == ds.findParent(6) ? "same" : "not same");

  }
}
