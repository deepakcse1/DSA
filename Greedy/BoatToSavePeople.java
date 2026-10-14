package Greedy;

import java.util.Arrays;

public class BoatToSavePeople {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int st = 0;
    int end = people.length - 1;
    int boat = 0;
    while (st <= end) {
      if (people[st] + people[end] <= limit) st++;
      boat++;
      end--;
    }
    return boat;
  }
}
