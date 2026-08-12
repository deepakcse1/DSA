package String;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
  private static List<String> result;

  public List<String> fullJustify(String[] words, int maxWidth) {
    result = new ArrayList<>();
    int n = words.length;
    int i = 0;
    while (i < n) {
      int letter = 0;
      int j = i;
      while (j < n && letter + words[j].length() + (j - i) <= maxWidth) {
        letter += words[j++].length();
      }
      int gaps = j - i - 1;
      if (gaps == 0 || j == n) {
        oneWordOrLastLine(i, j, words, maxWidth);
      } else {
        normalJustification(i, j, gaps, letter, words, maxWidth);
      }
      i = j;
    }
    return result;
  }

  private static void oneWordOrLastLine(int i, int j, String[] words, int maxWidth) {
    StringBuilder line = new StringBuilder();
    while (i < j) {
      line.append(words[i++]);
      if (line.length() < maxWidth)
        line.append(' ');
    }
    while (line.length() < maxWidth)
      line.append(' ');
    result.add(line.toString());
  }

  private static void normalJustification(int i, int j, int gaps, int letter, String[] words, int maxWidth) {
    StringBuilder line = new StringBuilder();
    int totalSpace = maxWidth - letter;
    int eachSpace = totalSpace / gaps;
    int extraSpace = totalSpace % gaps;
    while (i < j) {
      line.append(words[i++]);
      for (int k = 0; k < eachSpace && i < j; k++) {
        line.append(' ');
      }
      if (extraSpace > 0) {
        line.append(' ');
        extraSpace--;
      }
    }
    result.add(line.toString());
  }


  // public List<String> fullJustify(String[] words, int maxWidth) {
  //   List<String> result = new ArrayList<>();
  //   int i = 0;
  //   int n = words.length;
  //   while (i < n) {
  //     int j = i;
  //     int letters = 0;
  //     while (j < n && letters + words[j].length() + (j - i) <= maxWidth) {
  //       letters += words[j].length();
  //       j++;
  //     }

  //     int gaps = j - i - 1;
  //     StringBuilder line = new StringBuilder();
  //     // If last line or 1 word
  //     if (j == n || gaps == 0) {
  //       line = oneWordOrLastLine(i, j, line, words, maxWidth);
  //     }
  //     else {
  //       line = normalJustification(i, j, line, words, gaps, letters, maxWidth);
  //     }
  //     result.add(line.toString());
  //     i = j;
  //   }
  //   return result;
  // }

  // private StringBuilder oneWordOrLastLine(int i, int j, StringBuilder line, String[] words, int maxWidth) {
  //   for (int start = i; start < j; start++) {
  //     line.append(words[start]);
  //     if (start != j - 1) {
  //       line.append(' ');
  //     }
  //   }
  //   while (line.length() < maxWidth) line.append(' ');
  //   return line;
  // }

  // private StringBuilder normalJustification(int i, int j, StringBuilder line, String[] words, int gaps, int letters,
  //     int maxWidth) {
  //   int totalSpace = maxWidth - letters;
  //   int ecahGap = totalSpace / gaps;
  //   int extraGap = totalSpace % gaps;
  //   for (int start = i; start < j; start++) {
  //     line.append(words[start]);
  //     if (start == j - 1) continue;
  //     for (int s = 0; s < ecahGap; s++) {
  //       line.append(' ');
  //     }
  //     if (extraGap > 0) {
  //       line.append(' ');
  //       extraGap--;
  //     }
  //   }
  //   return line;
  // }
}
