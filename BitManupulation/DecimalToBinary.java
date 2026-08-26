package BitManupulation;

public class DecimalToBinary {
  private static String decimalToBinary(int n){
    StringBuilder sb = new StringBuilder();
    while(n > 0){
      sb.append(n % 2);
      n /= 2;
    }
    return sb.reverse().toString();
  }
  public static void main(String[] args) {
    System.out.println(decimalToBinary(43261596));
  }
}
