public class TowerOfHanoi {
  public static void main(String[] args) {
    int n = 3;
    int from = 1, to = 3, aux = 2;
    // towerOfHanoiPrint(n, from, to, aux);
    int moves = towerOfHanoiCountStep(n, from, to, aux);
    System.out.println("Total moves: " + moves);
  }

  public static int towerOfHanoiCountStep(int n, int from, int to, int aux) {
    return helperFunction(n, from, aux, to);
  }
  public static int helperFunction(int n, int source, int helper, int dest) {
    if (n == 1) return 1;
    // move n-1 disk from source to helper using destination_As_Helper
    int step1 = helperFunction(n - 1, source, dest, helper);
    // move 1(last) disk from source to destination using helper
    int step2 = helperFunction(1, source, helper, dest);
    // move remaining n-1 disk which is in helper to dest using source_As_Helper
    int step3 = helperFunction(n - 1, helper, source, dest);

    return step1 + step2 + step3;
  }

  public static void towerOfHanoiPrint(int n, int from, int to, int aux) {
      helper(n, from, aux, to);
  }
  public static void helper(int n, int from, int aux, int to) {
    if (n == 1) {
      System.out.println("move disk "+n+" from rod "+from+" to rod "+to);
      return;
    }
    helper(n-1, from, to, aux);
    System.out.println("move disk "+n+" from rod "+from+" to rod "+to);
    helper(n-1, aux, from, to);
  }
}
