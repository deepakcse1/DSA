package String;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {
  public static void main(String[] args) {
    List<String> strs = new ArrayList<>();
    strs.add("deepakkumar");
    strs.add("mandal");
    // strs.add("Geeks");
    String encodedOutput = encode(strs);
    System.out.println("encodedOutput : "+encodedOutput);
    
    List<String> decodedOutput = decode(encodedOutput);
    System.out.print("decodedOutput : ");
    for(String s : decodedOutput){
      System.out.print(s+" ");
    }
    System.out.println();
  }

  public static String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String st : strs) {
      sb.append(st.length()).append("#").append(st);
    }
    return sb.toString();
  }

  public static List<String> decode(String str) {
    List<String> list = new ArrayList<>();
    int index = 0;
    String digit = "";
    while (index != str.length()) {
      if (str.charAt(index) == '#') {
        String word = str.substring(index + 1, index + 1 + Integer.parseInt(digit));
        list.add(word);
        index += Integer.parseInt(digit) + 1;
        digit = "";
        continue;
      }
      digit += str.charAt(index);
      index++;
    }
    return list;
  }

  // https://neetcode.io/problems/string-encode-and-decode/question 
  /*
  1. convert strs to charArray[]
  2. keep track of int lenght variable
  3. loop i -> charArray.length
  4. for each i, 
      take a viriable num, and update it using while loop till is not #, update i++
  5. update length = Integer.parseInt(num) + num.length() + 1
  6. substring(i, len) and add to list
  7. update i = len - 1
  */
  // public static List<String> decode(String strs){
  //   List<String> outputDecodedList = new ArrayList<>();
  //   int len = 0;
  //   char[] charArr = strs.toCharArray();
  //   for(int i = 0; i < charArr.length; i++){
  //     String num = "";
  //     while (charArr[i] != '#' && i < strs.length()) {
  //        num += charArr[i++];
  //     }
  //     i++;
  //     len += Integer.parseInt(num) + num.length() + 1;
  //     System.out.println("len :"+len);
  //     outputDecodedList.add(strs.substring(i, len));
  //     i = len-1;
  //   }
  //   return outputDecodedList;
  // }

  //---------- OR ----------
  /* 
  public List<String> decode(String str) {
    List<String> list = new ArrayList<>();
    char[] ch = str.toCharArray();
    for (int i = 0; i < ch.length;) {
      String digit = "";
      while (ch[i] != '#') {
        digit += ch[i];
        i++;
      }
      i++;
      int len = Integer.parseInt(digit);
      String word = str.substring(i, i + len);
      list.add(word);
      i = i + len;
    }
    return list;
  }
  */
}
