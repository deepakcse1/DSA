
import java.util.ArrayList;
import java.util.List;

class DisjointSetBySize{
  List<Integer> size = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();
  public DisjointSetBySize(int V){
    for(int i = 0; i < V; i++){ //0 based indexing
       size.add(1);
       parent.add(i);
    }
  }
  public int findParent(int v){
    if(v == parent.get(v)) return v;
    int ultimateParent = findParent(parent.get(v));
    parent.set(v, ultimateParent); // path compression
    return parent.get(v);
  }

  public void unionBySize(int v1, int v2){
    int pV1 = findParent(v1);
    int pV2 = findParent(v2);
    if(pV1 == pV2) return;
    if(size.get(pV1) < size.get(pV2)){
      parent.set(pV1, pV2);
      size.set(pV2, size.get(pV1) + size.get(pV2));
    }
    else{
      parent.set(pV2, pV1);
      size.set(pV1, size.get(pV1) + size.get(pV2));
    }
  }
}

public class DSUbySize {
  public static void main(String[] args) {
    int V = 7;
    DisjointSetBySize ds = new DisjointSetBySize(V);
    ds.unionBySize(0, 1);
    ds.unionBySize(1, 2);
    ds.unionBySize(3, 4);
    ds.unionBySize(5, 6);
    ds.unionBySize(4, 5);
    // Should print "not same"
    System.out.println(ds.findParent(2) == ds.findParent(6) ? "same" : "not same");

    ds.unionBySize(2,6);

    // Should print "same"
    System.out.println(ds.findParent(2) == ds.findParent(6) ? "same" : "not same");
  }
}
