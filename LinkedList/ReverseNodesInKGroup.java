package LinkedList;

public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(-1);
    ListNode prevGroup = dummy;
    ListNode groupStart = head;
    ListNode groupEnd = head;
    ListNode nextGroup = null;
    prevGroup.next = groupStart;
    while (groupEnd != null) {
      groupEnd = handleGroupEnd(groupEnd, k);
      if (groupEnd == null) break;
      nextGroup = groupEnd.next;
      groupEnd.next = null;
      ListNode currHead = reverse(groupStart);
      prevGroup.next = currHead;
      groupStart.next = nextGroup;
      prevGroup = groupStart;
      groupStart = nextGroup;
      groupEnd = groupStart;
    }
    return dummy.next;
  }

  private ListNode handleGroupEnd(ListNode groupEnd, int k) {
    int count = 1;
    while (count < k && groupEnd != null) {
      groupEnd = groupEnd.next;
      count++;
    }
    return groupEnd;
  }

  private ListNode reverse(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
    // if(head == null || head.next == null) return head;
    // ListNode newHead = reverse(head.next);
    // head.next.next = head;
    // head.next = null;
    // return newHead;
  }

  //-------------------------------------------------------------------------
  // public ListNode reverseKGroup(ListNode head, int k) {
  //   if (head == null || head.next == null || k <= 1) return head;
  //   ListNode dummy = new ListNode(-1);
  //   dummy.next = head;
  //   ListNode prev = dummy;
  //   ListNode curr = head;

  //   while (curr != null) {
  //     ListNode tail = curr;
  //     for (int i = 0; i < k; i++) {
  //       if (tail == null) return dummy.next;
  //       tail = tail.next;
  //     }

  //     ListNode nextGroupHead = tail;
  //     // reverse the current group
  //     ListNode prevNode = nextGroupHead;
  //     ListNode currNode = curr;
  //     for (int i = 0; i < k; i++) {
  //       ListNode nextNode = currNode.next;
  //       currNode.next = prevNode;
  //       prevNode = currNode;
  //       currNode = nextNode;
  //     }
  //     // connect the previous group with the reversed current group
  //     prev.next = prevNode;
  //     // move prev and curr to the next group
  //     prev = curr;
  //     curr = nextGroupHead;
  //   }
  //   return dummy.next;
  // }
  
}
