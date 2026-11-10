package AZContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://maang.in/contests/attempts/113340?problem_id=21707&returnUrl=[%22/contests/B16-Phase-1-Contest-1704?returnUrl=[%22/cohorts/AZ-Premium-Cohort-16-84?tab=contests%22]
public class TeamRankings {
  static class FastScanner {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String[] tokens;
    private int index = 0;

    String next() throws IOException {
      while (tokens == null || index >= tokens.length) {
        tokens = br.readLine().trim().split("\\s+");
        index = 0;
      }
      return tokens[index++];
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    String nextLine() throws IOException {
      return br.readLine();
    }
  }

  static class Pair {
    int index;
    int wins;
    int draws;
    int scored;
    int conceded;

    Pair(int index, int wins, int draws, int scored, int conceded) {
      this.index = index;
      this.wins = wins;
      this.draws = draws;
      this.scored = scored;
      this.conceded = conceded;
    }
  }

  // Input
  // 1
  // 4
  // 3 1 2 2
  // 1 5 4 4
  // 30 10 20 40
  // 32 13 18 37
  public static void main(String[] args) throws Exception {
    // Scanner fs = new Scanner(System.in);
    FastScanner fs = new FastScanner();
    int t = fs.nextInt();
    while (t-- > 0) {
      int n = fs.nextInt();
      int[] wins = new int[n];
      for (int i = 0; i < n; i++) {
        wins[i] = fs.nextInt();
      }
      int[] draws = new int[n];
      for (int i = 0; i < n; i++) {
        draws[i] = fs.nextInt();
      }
      int[] scored = new int[n];
      for (int i = 0; i < n; i++) {
        scored[i] = fs.nextInt();
      }
      int[] conceded = new int[n];
      for (int i = 0; i < n; i++) {
        conceded[i] = fs.nextInt();
      }

      Pair[] pairs = helper(n, wins, draws, scored, conceded);
      System.out.println(pairs[0].index + " " + pairs[1].index);
    }
  }

  private static Pair[] helper(int n, int[] wins, int[] draws, int[] scored, int[] conceded) {
    Pair[] pairs = new Pair[n];
    for (int i = 0; i < n; i++) {
      pairs[i] = new Pair(i, wins[i], draws[i], scored[i], conceded[i]);
    }

    Arrays.sort(pairs, (a, b) -> {
      int teamA = 3 * a.wins + a.draws;
      int teamB = 3 * b.wins + b.draws;
      int goalDiffA = a.scored - a.conceded;
      int goalDiffB = b.scored - b.conceded;
      if (teamA != teamB) return Integer.compare(teamB, teamA);
      if (goalDiffA != goalDiffB) return Integer.compare(goalDiffB, goalDiffA);
      return Integer.compare(a.index, b.index);
    });
    return pairs;
  }
}
