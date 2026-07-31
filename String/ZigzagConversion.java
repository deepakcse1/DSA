package String;

public class ZigzagConversion {
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    StringBuilder[] rows = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      rows[i] = new StringBuilder();
    }
    int curRow = 0;
    int direction = 1; // down, -1 -> up
    for (char c : s.toCharArray()) {
      if (curRow == 0) direction = 1;
      else if (curRow == numRows - 1) direction = -1;
      rows[curRow].append(c);
      curRow += direction;
    }
    StringBuilder ans = new StringBuilder();
    for (StringBuilder sb : rows) {
      ans.append(sb);
    }
    return ans.toString();
  }
}
