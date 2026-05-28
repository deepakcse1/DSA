package LinkedList;

import java.util.HashMap;

import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return helper(head, map);
    }

    public Node helper(Node head, Map<Node, Node> map) {
        if (head == null) return null;
        Node clone = new Node(head.val);
        map.put(head, clone);
        clone.next = helper(head.next, map);
        clone.random = map.get(head.random);
        return clone;
    }
}
