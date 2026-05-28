package recursion;

public class ShortestSupersequence {
  public static void main(String[] args) {
    String a = "brute";
    String b = "groot";
    System.out.println(shortestSupersequence(a,b));
  }
  public static String shortestSupersequence(String a, String b) {
    int i = a.length();
    int j = b.length();
    return helper(a,b,i-1,j-1);
  }
  private static String helper(String a, String b, int i, int j){
    //base case
    if( i < 0) return b.substring(0, j+1);
    if( j < 0) return a.substring(0, i+1);

    //choices
    if(a.charAt(i) == b.charAt(j)){
      return helper(a, b, i-1, j-1) + a.charAt(i);
    }else{
      String op1 = helper(a, b, i-1, j) +  a.charAt(i);
      String op2 = helper(a, b, i, j-1) + b.charAt(j);
      return op1.length() < op2.length() ? op1 : op2;
    }
  }
 
}
