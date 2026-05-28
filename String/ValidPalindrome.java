package String;

public class ValidPalindrome {
  public static void main(String[] args) {

    System.out.println(1 + "+" + 1);
    // String s = " ";
    // s = s.toLowerCase().replaceAll("[^a-z0-9]","");
    // int start = 0; int end = s.length()-1;
    // while(start <= end){
    //    if(s.charAt(start) != s.charAt(end)){
    //      System.out.println(false);
    //      return;
    //    }else{
    //      start++;end--;
    //    }
    // }
    // System.out.println(true);
  }

  //optimized
  public boolean isPalindrome(String s) {
    if (s.length() == 1) return true;
    int start = 0;
    int end = s.length() - 1;
    while (start <= end) {
      while (start <= end && !Character.isLetterOrDigit(s.charAt(start))) start++;
      while (start <= end && !Character.isLetterOrDigit(s.charAt(end))) end--;
      if (start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
      start++;
      end--;
    }
    return true;
  }
}
