import java.util.*;

class Pair {
  int node, weight;
  Pair(int node, int weight) {
    this.node = node;
    this.weight = weight;
  }
}

public class DijkstraAlgorithmOptimized {
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter number of vertices :");
    int V = s.nextInt();
    System.out.println("Enter number of edges :");
    int E = s.nextInt();
    List<List<Pair>> list = new ArrayList<>();
    for (int i = 0; i < V; i++) list.add(new ArrayList<>());

    for (int i = 0; i < E; i++) {
      System.out.println("Enter edge "+(i+1)+" (v1 v2 dist) :");
      int v1 = s.nextInt();
      int v2 = s.nextInt();
      int dist = s.nextInt();
      list.get(v1).add(new Pair(v2, dist));
      list.get(v2).add(new Pair(v1, dist));
    }
    dijkstraAlgorithm(list, V);
  }

  public static void dijkstraAlgorithm(List<List<Pair>> list, int V){
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
    pq.offer(new Pair(0,0));
    while(!pq.isEmpty()){
      Pair curr = pq.poll();
      int u = curr.node;
      if (curr.weight > dist[u]) continue; //Since Java PQ doesn’t support decrease-key, we insert multiple entries and skip outdated ones using this condition
      for(Pair el : list.get(u)){
        int v = el.node;
        int weight = el.weight;
        //Edge Relaxation
        if(dist[v] > dist[u] + weight){
          dist[v] = dist[u] + weight;
          pq.offer(new Pair(v, dist[v]));
        }
      }
    }
    System.out.println("Shortest distances from source vertex 0 :");
    for(int i = 0; i < V; i++){
      System.out.println("Vertex "+i+" : "+dist[i]);  
    }  
  }
}
