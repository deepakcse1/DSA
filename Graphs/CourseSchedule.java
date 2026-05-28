import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
  public static void main(String[] args) {

  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      list.add(new ArrayList<>());
    }
    for (int[] pre : prerequisites) {
      list.get(pre[1]).add(pre[0]);
    }
    boolean[] visited = new boolean[numCourses];
    boolean[] resPath = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (!visited[i]) {
        if (isCycleDFS(i, visited, resPath, list)) {
          return false;
        }
      }
    }
    return true;

  }

  public boolean isCycleDFS(int curr, boolean[] visited, boolean[] resPath, List<List<Integer>> list) {
    visited[curr] = true;
    resPath[curr] = true;
    for (int el : list.get(curr)) {
      if (!visited[el]) {
        if (isCycleDFS(el, visited, resPath, list))
          return true;
      } else if (resPath[el])
        return true;
    }
    resPath[curr] = false;
    return false;
  }
}
