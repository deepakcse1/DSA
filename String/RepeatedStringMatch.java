package String;

public class RepeatedStringMatch {
  public int repeatedStringMatch(String a, String b) {
    StringBuilder sb = new StringBuilder(a);
    int count = 1;
    while(sb.length() < b.length()){
      sb.append(a);
      count++;
    }
    if(sb.indexOf(b) != -1) return count;
    // Why do we need that extra copy?
    // Because b can start near the end of one repetition of a and continue into the next repetition.
    sb.append(a);
    count++;
    if(sb.indexOf(b) != -1) return count;
    return -1;
  }
}
