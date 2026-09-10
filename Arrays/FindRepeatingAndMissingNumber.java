public class FindRepeatingAndMissingNumber {
  public int[] findMissingRepeatingNumbers(int[] nums) {
    int n = nums.length;
    long actualSum = 0;
    long actualSquareSum = 0;
    for (int num : nums) {
        actualSum += num;
        actualSquareSum += (long) num * num;
    }

    long expectedSum = (long) n * (n + 1) / 2;
    long expectedSquareSum = (long) n * (n + 1) * (2L * n + 1) / 6;

    // A - B
    long diff = actualSum - expectedSum;

    // A² - B²
    long squareDiff = actualSquareSum - expectedSquareSum;

    // A + B
    long sum = squareDiff / diff;

    // A = ((A-B) + (A+B)) / 2
    long duplicate = (diff + sum) / 2;

    // B = A - (A-B)
    long missing = duplicate - diff;

    return new int[]{(int) duplicate, (int) missing};
}
  public static void main(String[] args) {
    
  }
}
