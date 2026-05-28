public class KokoEatingBanana {
  public static void main(String[] args) {
    System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
  }

  public static int minEatingSpeed(int[] piles, int h) {
    int end = 0;
    for (int i : piles) {
      if (end < i) end = i;
    }
    int start = 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      long hours = eatingHours(piles, mid);
      if (hours <= h) end = mid - 1;
      else start = mid + 1;
    }
    return start;
  }

  static long eatingHours(int[] piles, int speed) {
    long hour = 0;
    for (int i : piles) {
      hour += (int) ((i + speed - 1) / speed);
    }
    return hour;
  }
}
