package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
  class Node {
    Node next, prev;
    int key, value, freq;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.freq = 1;
    }
  }

  class DoubleyLinkedList {
    Node head, tail;
    int size;

    DoubleyLinkedList() {
      head = new Node(-1, -1);
      tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
    }

    // Add to BACK = Most Recently Used
    private void add(Node node) {
      node.prev = tail.prev;
      tail.prev = node;
      node.prev.next = node;
      node.next = tail;
    }

    // Remove any node
    private void remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      node.prev = null;
      node.next = null;
    }

    // Remove from FRONT = Least Recently Used
    private Node removeFirst() {
      if (isEmpty()) return null;
      Node node = head.next;
      remove(node);
      return node;
    }

    private boolean isEmpty() {
      return head.next == tail;
    }
  }

  int capacity;
  int minFreq;
  Map<Integer, Node> map;
  Map<Integer, DoubleyLinkedList> freqMap;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    freqMap = new HashMap<>();
    minFreq = 0;
  }

  public int get(int key) {
    if (!map.containsKey(key)) return -1;
    Node node = map.get(key);
    increaseFrequencey(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;
      increaseFrequencey(node);
      return;
    }
    if (map.size() == capacity) {
      DoubleyLinkedList list = freqMap.get(minFreq);
      Node node = list.removeFirst();
      map.remove(node.key);
      if (list.isEmpty()) freqMap.remove(minFreq);
    }
    Node node = new Node(key, value);
    map.put(key, node);
    freqMap.computeIfAbsent(1, f -> new DoubleyLinkedList()).add(node);
    minFreq = 1;
  }

  private void increaseFrequencey(Node node) {
    int oldFreq = node.freq;
    DoubleyLinkedList oldList = freqMap.get(oldFreq);
    oldList.remove(node);
    if (oldFreq == minFreq && oldList.isEmpty()) {
      freqMap.remove(oldFreq);
      minFreq++;
    }
    node.freq++;
    freqMap.computeIfAbsent(node.freq, f -> new DoubleyLinkedList()).add(node);
  }
}
