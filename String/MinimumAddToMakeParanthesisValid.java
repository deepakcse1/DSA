package String;

public class MinimumAddToMakeParanthesisValid {
  public int minAddToMakeValid(String s) {
    int openBracket = 0;
    int closeBracket = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') openBracket++;
      else {
        if (openBracket > 0) openBracket--;
        else closeBracket++;
      }
    }
    return openBracket + closeBracket;
  }
    // public int minAddToMakeValid(String s) {
    //     int missing = 0;
    //     Stack<Character> stack = new Stack();
    //     for(char ch : s.toCharArray()){
    //         if(ch == '('){
    //             stack.push(ch);
    //         }
    //         else{
    //             if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
    //             else missing++;
    //         }
    //     }
    //     return missing + stack.size();
    // }
}
