public class ReachDestination {
  public static void main(String[] args) {
    System.out.println(reachDestination(3, 40, 356, 2942));
  }

  private static boolean reachDestination(int sx, int sy, int dx, int dy) {
    // if(sx == dx && sy == dy) return true;
    // if(sx > dx || sy > dy) return false;
    // //move in x direction
    // boolean x = reachDestination(sx, sx+sy, dx, dy);
    // boolean y = reachDestination(sx+sy, sy, dx, dy);
    // return x || y;
    if(dx < sx || dy < sy) return false;
    if(sx == dx && sy == dy) return true;
    return reachDestination(sx, sy, dx, dy-dx) || reachDestination(sx, sy, dx-dy, dy);
  }
}
