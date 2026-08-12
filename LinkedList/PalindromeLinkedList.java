package LinkedList;

class ListNode {
  int val;
  ListNode next;
  ListNode() {
  }
  ListNode(int val) {
    this.val = val;
  }
  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode prev = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) {
      prev = slow;
      slow = slow.next;
    }
    while (slow != null && slow.next != null) {
      ListNode next = slow.next;
      slow.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }

    ListNode first = head;
    ListNode second = prev.next;
    while (second != null) {
      if (first.val != second.val)
        return false;
      first = first.next;
      second = second.next;
    }
    return true;
  }
  // public boolean isPalindrome(ListNode head) {
  //   ListNode fast = head;
  //   ListNode slow = head;
  //   while (fast != null && fast.next != null) {
  //     fast = fast.next.next;
  //     slow = slow.next;
  //   }
  //   if (fast != null) slow = slow.next;

  //   // ListNode newHead = reverse(slow); // uses O(n) call-stack space - recursive approach
  //   ListNode newHead = reverse_iterative(slow); // uses O(1) space - iterative approach
  //   while (newHead != null) {
  //     if (head.val != newHead.val) return false;
  //     head = head.next;
  //     newHead = newHead.next;
  //   }
  //   return true;
  // }

  // public ListNode reverse(ListNode head) {
  //   if (head == null || head.next == null) return head;
  //   ListNode newHead = reverse(head.next);
  //   head.next.next = head;
  //   head.next = null;
  //   return newHead;
  // }

  // // Follow up: Could you do it in O(n) time and O(1) space?
  // public ListNode reverse_iterative(ListNode head) {
  //   ListNode prev = null;
  //   ListNode curr = head;
  //   while (curr != null) {
  //     ListNode temp = curr.next;
  //     curr.next = prev;
  //     prev = curr;
  //     curr = temp;
  //   }
  //   return prev;
  // }
}
