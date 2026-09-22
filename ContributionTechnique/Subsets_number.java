package ContributionTechnique;

public class Subsets_number {
  public static void main(String[] args) {
    System.out.println("hii");
  }
}

// For Numbers - Total subset will be 2^n - 1 (excluding empty)
class Subsets {
    
  // Find the sum of all subsets, we have 2 choices for an element, take or not take -> That is horizontally
  // We can also check contribution of each element in the subarray -> that will be 2^(n-1)
  // 2 * 2^(n-1) + 3 * 2^(n-1) + 5 * 2^(n-1)
    public static void main(String[] args) {
      int[] arr = {2, 3, 5};
      int sum = 0;
      for(int i : arr){
        sum += i;
      }
      int n = arr.length;
      int power2 = 1;
      for(int i = 0; i < n-1; i++){
        power2 *= 2; // 2 * 2 * 2
      }
      System.out.println(sum * power2);
    }
}