package BitManupulation;

public class ReverseBits {
  public int reverseBits(int n) {
    // get rightmost bit -> n & 1
    // extract last bit -> ans << 1
    // append bit -> | bit
    // removing rightmost element -> n >>>= 1
    // >> → preserve sign
    // >>> → insert 0
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      int bit = n & 1; // (OR) int bit = n % 2;
      ans = (ans << 1) | bit; // (OR) ans = (ans * 2) + bit;
      n = n >>> 1;
    }
    return ans;
  }
}
