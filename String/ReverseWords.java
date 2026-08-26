package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReverseWords {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    StringBuilder sbInput = new StringBuilder();
    String line;
    while ((line = br.readLine()) != null) {
      sbInput.append(line).append(" ");
    }
    String input = sbInput.toString().trim();
    String[] words = input.split("\\s+"); // (" ");
    boolean addSpace = false;
    for (String word : words) {
      StringBuilder curr = new StringBuilder(word);
      curr.reverse();
      if (addSpace) {
        out.print(" ");
      }
      out.print(curr.toString());
      addSpace = true;
    }
    out.flush();
    out.close();
  }
}
