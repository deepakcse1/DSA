import java.util.ArrayList;
import java.util.List;

public class GetCode {
  public static void main(String[] args) {
    // "1123"
    // "1 1 2 3" : aabc
    // "11 2 3" : kbc
    // "1 12 3" : alc
    // "1 1 23" : aaw
    // "11 23" : kw
    getCode("1123");
  }

  public static  String[] getCode(String input){
    List<String> list = new ArrayList<>();
		list = getCodeHelper(input, 0, "",  list);
    String[] str = new String[list.size()];

    for(int i = 0; i < list.size(); i++){
      str[i] = list.get(i);
      System.out.println(str[i]);
    }
		return str;
	}
  public static List<String> getCodeHelper(String input, int index, String strSoFar, List<String> list){
    if(index == input.length()){
      list.add(strSoFar);
      return list;
    }

    //find single Digit
    int singleDigit = input.charAt(index) - '0';
    if(singleDigit >= 1 && singleDigit <= 26){
      getCodeHelper(input, index+1, strSoFar+getChar(singleDigit), list);
    }

    if(index+1 < input.length()){
      int doubleDigit = Integer.parseInt(input.substring(index, index+2));
      if(doubleDigit >= 1 && doubleDigit <= 26){
        getCodeHelper(input, index+2, strSoFar+getChar(doubleDigit), list);
      }
    }
    return list;
  }

  public static char getChar(int num){
    return (char)('a' + num -1);
  }

}
