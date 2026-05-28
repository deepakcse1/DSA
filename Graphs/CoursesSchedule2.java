import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CoursesSchedule2 {
  public static void main(String[] args) {
    
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int[] el : prerequisites){
            list.get(el[1]).add(el[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];

        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                boolean isCycle = hasCycleDFS(i, list, visited, recPath, st);
                if(isCycle) return new int[]{};
            }
        }
        int[] ans = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }

    public boolean hasCycleDFS(int curr, List<List<Integer>> list, boolean[] visited, 
      boolean[] recPath, Deque<Integer> st){
        visited[curr] = true;
        recPath[curr] = true;
        for(int i : list.get(curr)){
            if(!visited[i]){
                if(hasCycleDFS(i, list, visited, recPath, st)) return true;
            }else if(recPath[i]) return true;
        }
        recPath[curr] = false;
        st.push(curr);
        return false;
    }

    //---------------------BFS Topological Sort( Kahn’s Algorithm )--------------------------------------------
    // public int[] findOrder(int numCourses, int[][] prerequisites) {

    //     List<List<Integer>> graph = new ArrayList<>();
    //     int[] indegree = new int[numCourses];

    //     for (int i = 0; i < numCourses; i++) {
    //         graph.add(new ArrayList<>());
    //     }

    //     // Build graph + indegree
    //     for (int[] pre : prerequisites) {
    //         graph.get(pre[1]).add(pre[0]);
    //         indegree[pre[0]]++;
    //     }

    //     Queue<Integer> q = new LinkedList<>();

    //     // Add all nodes with indegree 0
    //     for (int i = 0; i < numCourses; i++) {
    //         if (indegree[i] == 0) {
    //             q.offer(i);
    //         }
    //     }

    //     int[] ans = new int[numCourses];
    //     int index = 0;

    //     // BFS
    //     while (!q.isEmpty()) {
    //         int curr = q.poll();
    //         ans[index] = curr;
    //.        index++;
    //         for (int nei : graph.get(curr)) {
    //             indegree[nei]--;
    //             if (indegree[nei] == 0) {
    //                 q.offer(nei);
    //             }
    //         }
    //     }

    //     // Cycle check
    //     if (index != numCourses) return new int[]{};

    //     return ans;
    // }
}
