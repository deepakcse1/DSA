package String;

public class StringCompression {
  public int compress(char[] chars) {
    int n = chars.length;
    int read = 0;
    int write = 0;
    while (read < n) {
      char curr = chars[read];
      int count = 0;
      while (read < n && chars[read] == curr) {
        read++;
        count++;
      }
      chars[write] = curr;
      write++;
      if (count > 1) {
        String freq = String.valueOf(count);
        for (char digit : freq.toCharArray()) {
          chars[write] = digit;
          write++;
        }
      }
    }
    return write;
  }
}
