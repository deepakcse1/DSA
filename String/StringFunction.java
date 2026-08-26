package String;

// public class StringFunction {

// }
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int q = sc.nextInt();
    String st = sc.next();
    while (q-- > 0) {
      String token = sc.next();
      if (token.equals("substr")) {
        int low = sc.nextInt();
        int high = sc.nextInt();
        if (low > high) {
          low = low ^ high;
          high = low ^ high;
          low = low ^ high;
        }
        System.out.println(st.substring(low - 1, high));
      } else if (token.equals("sort")) {
        int low = sc.nextInt();
        int high = sc.nextInt();
        if (low > high) {
          low = low ^ high;
          high = low ^ high;
          low = low ^ high;
        }
        char[] chArr = st.substring(low - 1, high).toCharArray();
        Arrays.sort(chArr);
        st = st.substring(0, low - 1) + new String(chArr) + st.substring(high);
      } else if (token.equals("pop_back")) {
        st = st.substring(0, st.length() - 1);
      } else if (token.equals("front")) {
        System.out.println(st.charAt(0));
      } else if (token.equals("back")) {
        System.out.println(st.charAt(st.length() - 1));
      } else if (token.equals("reverse")) {
        int low = sc.nextInt();
        int high = sc.nextInt();
        if (low > high) {
          low = low ^ high;
          high = low ^ high;
          low = low ^ high;
        }
        String reverse = new StringBuilder(st.substring(low - 1, high)).reverse().toString();
        st = st.substring(0, low - 1) + reverse + st.substring(high);
      } else if (token.equals("print")) {
        int pos = sc.nextInt();
        System.out.println(st.charAt(pos - 1));
      } else if (token.equals("push_back")) {
        char c = sc.next().charAt(0);
        st = st + c;
      }

    }
    sc.close();
  }
}
