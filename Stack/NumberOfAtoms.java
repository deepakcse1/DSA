package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class NumberOfAtoms {
  public String countOfAtoms(String formula) {
    int n = formula.length();
    Deque<TreeMap<String, Integer>> stack = new ArrayDeque<>();
    stack.push(new TreeMap<>());
    for (int i = 0; i < n; i++) {
      char ch = formula.charAt(i);
      // System.out.println(ch);
      if (ch == '(') {
        stack.push(new TreeMap<>());
      } else if (ch == ')') {
        TreeMap<String, Integer> map = stack.pop();
        int digit = 0;
        while (i + 1 < n && Character.isDigit(formula.charAt(i + 1))) {
          digit = digit * 10 + formula.charAt(++i) - '0';
        }
        TreeMap<String, Integer> stableMap = stack.peek();
        digit = digit > 0 ? digit : 1;
        for (String key : map.keySet()) {
          int newFreq = map.get(key) * digit;
          stableMap.put(key, stableMap.getOrDefault(key, 0) + newFreq);
        }
      } else {
        StringBuilder atom = new StringBuilder();
        atom.append(ch);
        while (i + 1 < n && Character.isLowerCase(formula.charAt(i + 1))) {
          // atom.append(formula.charAt(i+1));
          // i++;
          atom.append(formula.charAt(++i));
        }
        int digit = 0;
        while (i + 1 < n && Character.isDigit(formula.charAt(i + 1))) {
          digit = digit * 10 + formula.charAt(++i) - '0';
        }
        TreeMap<String, Integer> map = stack.peek();
        digit = digit > 0 ? digit : 1;
        System.out.println("atom : " + atom.toString() + " digit : " + digit);
        map.put(atom.toString(), map.getOrDefault(atom.toString(), 0) + digit);
      }
    }
    StringBuilder output = new StringBuilder();
    TreeMap<String, Integer> map = stack.pop();
    for (String key : map.keySet()) {
      output.append(key);
      int digit = map.get(key);
      if (digit > 1) output.append(digit);
    }
    return output.toString();
  }
}
