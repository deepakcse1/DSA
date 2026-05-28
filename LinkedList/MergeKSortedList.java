package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedList {
  public static void main(String[] args) {
    
  }

  //---------------------------- Optimized ----------------------------------
  public static ListNode mergeKLists_optimized(ListNode[] lists) { //ListNode[] consists of head of each list
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) pq.add(lists[i]);
    }
    ListNode dummyNode = new ListNode(-1);
    ListNode temp = dummyNode;
    while (!pq.isEmpty()) {
      ListNode curr = pq.poll();
      if (curr.next != null) pq.add(curr.next);
      temp.next = curr;
      temp = temp.next;
    }
    return dummyNode.next;
  }
  //----------------------- Brute force ------------------------------------
  public static ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;
    if (n == 0) return null;
    ListNode first = lists[0];
    for (int i = 1; i < n; i++) {
      first = reverse(first, lists[i]);
    }
    return first;
  }

  public static ListNode reverse(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val <= l2.val) {
      l1.next = reverse(l1.next, l2);
      return l1;
    } else {
      l2.next = reverse(l1, l2.next);
      return l2;
    }
  }
}
