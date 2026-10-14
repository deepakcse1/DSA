package Implementation;

public class CircularDeque {
  static class ListNode {
    ListNode prev;
    ListNode next;
    int val;

    ListNode(int val) {
      this.val = val;
    }
  }

  static class MyCircularDeque {
    int size;
    int count;
    ListNode head;
    ListNode tail;

    MyCircularDeque(int k) {
      this.size = k;
      count = 0;

      head = new ListNode(-1);
      tail = new ListNode(-1);

      head.next = tail;
      tail.prev = head;
    }

    private boolean insertFront(int x) {
      if (isFull()) return false;

      ListNode node = new ListNode(x);
      node.prev = head;
      node.next = head.next;
      head.next.prev = node;
      head.next = node;

      count++;
      return true;
    }

    private boolean insertLast(int x) {
      if (isFull()) return false;

      ListNode node = new ListNode(x);
      node.next = tail;
      node.prev = tail.prev;
      tail.prev.next = node;
      tail.prev = node;

      count++;
      return true;
    }

    private boolean deleteFront() {
      if (isEmpty()) return false;

      ListNode node = head.next;
      head.next = node.next;
      node.next.prev = head;

      count--;
      return true;
    }

    private boolean deleteLast() {
      if (isEmpty()) return false;

      ListNode node = tail.prev;
      tail.prev = node.prev;
      node.prev.next = tail;

      count--;
      return true;
    }

    private int getFront() {
      return isEmpty() ? -1 : head.next.val;
    }

    private int getRear() {
      return isEmpty() ? -1 : tail.prev.val;
    }

    private boolean isEmpty() {
      return count == 0;
    }

    private boolean isFull() {
      return count == size;
    }
  }

  public static void main(String[] args) {
    MyCircularDeque mcdq = new MyCircularDeque(5);
    mcdq.insertFront(2);
    mcdq.insertLast(3);
    mcdq.deleteFront();
    mcdq.deleteLast();
    mcdq.getFront();
    mcdq.getRear();
  }
}
