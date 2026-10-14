public class RobotBoundedInCircle {
  public boolean isRobotBounded(String instructions) {
    int x = 0;
    int y = 0;
    int dir = 0; // 0 = N, 1 = E, 2 = S, 3 = W
    int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    for (char ch : instructions.toCharArray()) {
      if (ch == 'G') {
        x += DIRS[dir][0];
        y += DIRS[dir][1];
      } else if (ch == 'L') dir = (dir + 3) % 4;
      else dir = (dir + 1) % 4;
    }
    return (x == 0 && y == 0) || dir != 0;
  }
}
