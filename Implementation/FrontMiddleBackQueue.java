package Implementation;

import java.util.*;

public class FrontMiddleBackQueue {
  static class FrontMiddleBack {
  Deque<Integer> first;
  Deque<Integer> second;

  FrontMiddleBack() {
    first = new ArrayDeque<>();
    second = new ArrayDeque<>();
  }

  private void balance() {
    // first can have at most one extra element than second OR 
    if (first.size() > second.size() + 1) second.offerFirst(first.pollLast());
    else if (first.size() < second.size()) first.offerLast(second.pollFirst());
  }

  private void pushFront(int val) {
    first.offerFirst(val);
    balance();
  }

  private void pushMiddle(int val) {
    if (first.size() > second.size()) second.offerFirst(first.pollLast());
    first.offerLast(val);
  }

  private void pushBack(int val) {
    second.offerLast(val);
    balance();
  }

  private int popFront() {
    if (first.isEmpty() && second.isEmpty()) return -1;
    int ans = first.pollFirst();
    balance();
    return ans;
  }

  private int popMiddle() {
    if (first.isEmpty() && second.isEmpty()) return -1;
    int ans = first.pollLast();
    balance();
    return ans;
  }

  private int popBack() {
    if (first.isEmpty() && second.isEmpty()) return -1;
    int ans;
    if (!second.isEmpty()) ans = second.pollLast();
    else ans = first.pollLast();
    balance();
    return ans;
  }
}
  public static void main(String[] args) {
    FrontMiddleBack fmb = new FrontMiddleBack();
    fmb.pushFront(2);
    fmb.pushMiddle(2);
    fmb.pushBack(2);
    fmb.popFront();
    fmb.popMiddle();
    fmb.popBack();
  }
}
