package WeeklyContest;

public class MinimizeTheMaximumWaitingTime {
  public int minPenalty(int period, int[] lights, int[] arrivalTime) {
    int maxGreen = 0;
    for (int light : lights) {
      maxGreen = Math.max(maxGreen, light);
    }

    int maxValue = 0;
    for (int time : arrivalTime) {
      int r = time % period;
      if (r >= maxGreen) {
        maxValue = Math.max(maxValue, period - r);
      }
    }
    return maxValue;
  }
}
