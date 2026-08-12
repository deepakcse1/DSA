package BitManupulation;

public class BinaryToDecimal {
  private static int binaryToDecimal(String binary) {
    int n = binary.length();
    int p2 = 1;
    int ans = 0;
    for(int i = n-1; i >= 0; i--){
      if(binary.charAt(i) == '1') ans += p2;
      p2 *= 2;
    }
    return ans;
  }
  public static void main(String[] args) { 
    System.out.println(binaryToDecimal("1101"));
  }
}
