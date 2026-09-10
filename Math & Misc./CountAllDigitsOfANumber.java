public class CountAllDigitsOfANumber {
  public static void main(String[] args) {
    int n = 123456789;
    System.out.println("Brute : "+countDigits(n));
    System.out.println("Optimized : "+countDigitsOptimized(n));
  }

  public static int countDigitsOptimized(int n){ // O(1)
    if(n == 0) return 1;
    return (int) (Math.log10(n) + 1);
  }
  public static int countDigits(int n) { //O(log n)
    if(n == 0) return 1;
    int count = 0;
    while(n != 0){
      n /= 10;
      count++;
    }
    return count;
  }
}
