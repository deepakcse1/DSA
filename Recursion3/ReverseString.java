public class ReverseString {
  public static void main(String[] args) {
    System.out.println(reverseString_optimized("abc"));
  }

  
  //O(n) time complexity
  public static String reverseString_optimized(String str){
    if(str == null || str.length() == 0) return str;
    char[] charArr = str.toCharArray();
    int left = 0;
    int right = charArr.length - 1;
    reverseString_opt(charArr, left, right);
    return new String(charArr);
  }

  public static void reverseString_opt(char[] charArr, int left, int right){
    if(left >= right) return;
    char temp = charArr[right];
    charArr[right] = charArr[left];
    charArr[left] = temp;
    reverseString_opt(charArr, left+1, right-1);
  }
  
  //O(n^2) time complexity
  public static String reverseString(String str){
    if(str == null || str.length() <= 1) return str;
    String result = reverseString(str.substring(1));
    return result + str.charAt(0);
  }
  
}
