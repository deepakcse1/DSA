package Stack;

public class DecodeString {
   private int i;

  public String decodeString(String s) {
    i = 0;
    return helper(s);
  }

  private String helper(String s) {
    StringBuilder res = new StringBuilder();
    int num = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = num * 10 + (c - '0');
        i++;
      } else if (c == '[') {
        i++;
        String st = helper(s);
        for (int k = 0; k < num; k++) {
          res.append(st);
        }
        num = 0;
      } else if (c == ']') {
        i++;
        return res.toString();
      } else {
        res.append(c);
        i++;
      }
    }
    return res.toString();
  }
    // public String decodeString(String s) {
    //     Deque<Integer> countStack = new ArrayDeque<>();
    //     Deque<StringBuilder> stringStack = new ArrayDeque<>();
    //     StringBuilder currentString = new StringBuilder();
    //     int k = 0;
    //     for(char c : s.toCharArray()){
    //         if(Character.isDigit(c)){
    //             k = (k * 10 ) + (c - '0');
    //         }else if(c == '['){
    //             countStack.push(k);
    //             stringStack.push(currentString);
    //             currentString = new StringBuilder();
    //             k = 0;
    //         }else if(c == ']'){
    //             StringBuilder decoded = stringStack.pop();
    //             int digit = countStack.pop();
    //             for(int currK = 0; currK < digit; currK++){
    //                 decoded.append(currentString);
    //             }
    //             currentString = decoded;
    //             System.out.println(currentString);
    //         }else{
    //             currentString.append(c);
    //         }
    //     }
    //     return currentString.toString();
    // }
    // public String decodeString(String s) {
    //     Deque<Character> st = new ArrayDeque<>();
    //     int n = s.length();
    //     for(int i = 0; i < n; i++){
    //         char key = s.charAt(i);
    //         if(key == ']'){
    //             StringBuilder sb = new StringBuilder();
    //             while(st.peek() != '['){
    //                 sb.append(st.pop());
    //             }
    //             st.pop();
    //             int base = 1;
    //             int digit = 0;
    //             while(!st.isEmpty() && Character.isDigit(st.peek())){
    //                 digit += base * (st.pop() - '0');
    //                 base = base * 10;
    //             }
    //             String word = sb.toString();
    //             for(int k = 0; k < digit; k++){
    //                 for(int c = word.length() - 1; c >= 0; c--){
    //                     st.push(word.charAt(c));
    //                 }
    //             }
    //         }else{
    //             st.push(key);
    //         }
    //     }
    //     StringBuilder ans = new StringBuilder();
    //     while(!st.isEmpty()){
    //         ans.append(st.poll());
    //     }
    //     return (ans.reverse()).toString();
    // }
}
