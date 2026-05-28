class Subsequence{

  public static String[] substring(String st) {
    if (st.isEmpty()) {
      String[] output = new String[1];
      output[0] = "";
      return output;
      //  return [""];
    }
    String[] smalllOutput = substring(st.substring(1));
    String[] output = new String[2 * smalllOutput.length];
    int i = 0;
    for (String s : smalllOutput) {
      output[i] = s;
      i++;
      output[i] = st.charAt(0) + s;
      i++;
    }
    return output;
  }

  public static void main(String[] args){
    String str = "abc";
    // String[] output = substring(str);
    // subSequence(str, "");
    // System.out.println("Length :"+output.length);
    // for(String st : output){
    //   System.out.print(st+" ");
    // }
  }

  public static void subSequence(String str, String curr){
    if(str.equals("")){
      System.out.println(curr);
      return;
    }
    subSequence(str.substring(1), curr);
    subSequence(str.substring(1), curr+str.charAt(0));
  }
}