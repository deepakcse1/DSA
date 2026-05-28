package LinkedList;

public class AddTwoNumbers {
  public static void main(String[] args) {
    
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = (l1.val + l2.val) % 10;
    int carry = (l1.val + l2.val) / 10;
    ListNode newHead = new ListNode(sum);
    ListNode temp1 = l1.next;
    ListNode temp2 = l2.next;
    ListNode curr = newHead;
    while (temp1 != null || temp2 != null) {
      sum = carry;
      if (temp1 != null) sum += temp1.val;
      if (temp2 != null) sum += temp2.val;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      if (temp1 != null) temp1 = temp1.next;
      if (temp2 != null) temp2 = temp2.next;
      curr = curr.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
      curr = curr.next;
    }
    return newHead;
  }
}

// while(temp1 != null && temp2 != null){
    // sum = (temp1.val + temp2.val + carry)%10;
    // carry = (temp1.val + temp2.val + carry)/10;
    // curr.next = new ListNode(sum);
    // temp1 = temp1.next;
    // temp2 = temp2.next;
    // curr = curr.next;
    // }
    // while(temp1 != null){
    // sum = (temp1.val + carry)%10;
    // carry = (temp1.val + carry)/10;
    // curr.next = new ListNode(sum);
    // temp1 = temp1.next;
    // curr = curr.next;
    // }
    // while(temp2 != null){
    // sum = (temp2.val + carry)%10;
    // carry = (temp2.val + carry)/10;
    // curr.next = new ListNode(sum);
    // temp2 = temp2.next;
    // curr = curr.next;
    // }
