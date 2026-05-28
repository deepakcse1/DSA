
public class Edge implements Comparable<Edge> {
  int v1, v2, weight;
  Edge(int v1, int v2, int weight){
    this.v1 = v1;
    this.v2 = v2;
    this.weight = weight;
  }
  @Override
  public int compareTo(Edge o) {
    if (o == null) {
      throw new NullPointerException();
    }
    return this.weight - o.weight;
  }
}
