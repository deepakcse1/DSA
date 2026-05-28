public class BSTtoLL {
    private ListNode head = null;
    private ListNode tail = null;

    public ListNode bstToSortedLL(TreeNode<Integer> root) {
        inOrderTraversal(root);
        return head;
    }
    private void inOrderTraversal(TreeNode<Integer> node) {
        if (node == null) return;

        inOrderTraversal(node.left);

        // Create new linked list node
        ListNode newNode = new ListNode(node.data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        inOrderTraversal(node.right);
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}