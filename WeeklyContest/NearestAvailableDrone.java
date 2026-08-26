package WeeklyContest;

public class NearestAvailableDrone {
  public int nearestDrone(int[][] drones, int[] target) {
    int n = drones.length;
    int minIdx = Integer.MAX_VALUE;
    int minValue = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int[] drone = drones[i];
      int x = Math.abs(drone[0] - target[0]);
      int y = Math.abs(drone[1] - target[1]);
      int distance = x + y;
      if (distance <= drone[2]) {
        if (minValue > distance) {
          minValue = distance;
          minIdx = i;
        }
      }
    }
    return (minIdx == Integer.MAX_VALUE) ? -1 : minIdx;
  }
}
