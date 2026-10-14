package Greedy;

import java.util.Arrays;

public class BagOfTokens {
  public int bagOfTokensScore(int[] tokens, int power) {
    int n = tokens.length;
    Arrays.sort(tokens);
    int start = 0;
    int end = n - 1;
    int score = 0;
    int maxScore = 0;
    while (start <= end) {
      if (tokens[start] <= power) {
        power -= tokens[start];
        score++;
        start++;
        maxScore = Math.max(maxScore, score);
      } else if (score > 0) {
        power += tokens[end];
        score--;
        end--;
      } else return maxScore;
    }
    return maxScore;
  }
}
