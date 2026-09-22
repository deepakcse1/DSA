package Heap;

public class MaxHeap {
  int heapSize;
  int[] heap;
  int capacity;
  public MaxHeap(int[] arr){
    heap = arr;
    heapSize = arr.length;
    capacity = arr.length; // to increase the limit of heap when size exceeds -> capacity *= 2;
  }

  private void swap(int i, int j){
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }
  private void heapify(int index){
    int largest = index;
    int leftChildIdx = 2 * index + 1;
    int rightChildIdx = 2 * index + 2;
    if(leftChildIdx < heapSize && heap[leftChildIdx] > heap[largest]) largest = leftChildIdx;
    if(rightChildIdx < heapSize && heap[rightChildIdx] > heap[largest]) largest = rightChildIdx;
    if(largest != index) {
      swap(largest, index);
      heapify(largest);
    }
  }

  private void buildTree(){
    // leaf node ranges from N/2 to N-1
    // non leaf node ranges from 0 to (n/2 - 1)
    for(int i = heapSize/2 - 1; i >= 0; i--){
      heapify(i);
    }
  }

  private void printTree(){
    for(int i : heap){
      System.out.print(i+" ");
    }
    System.out.println();
  }

  private int poll(){
    if(heapSize == 0){
      System.out.println("Heap is Empty");
      return -1;
    }
    int max = heap[0];
    heap[0] = heap[heapSize - 1];
    heapSize--;
    heapify(0);
    return max;
  }

  private void increaseCapacity(){
    capacity *= 2;
    int[] newHeap = new int[capacity];
    for(int i = 0; i < heapSize; i++){
      newHeap[i] = heap[i];
    }
    heap = newHeap;
  }

  private void offer(int value){
    if(heapSize + 1 >= capacity)  increaseCapacity();
    heapSize += 1;
    int index = heapSize - 1;
    heap[index] = value;
    int parent = (int) (Math.ceil(index / 2.0) - 1);
    while (index > 0 && heap[index] > heap[parent]) { // index mean child here
      swap(index, parent);
      index = parent;
    }
  }

  private void increaseKey(int index, int value){
    if(index < 0 || index >= heapSize || heap[index] >= value){
      System.out.println("wrong operation");
      return ;
    }
    heap[index] = value;
    int parent = (int) (Math.ceil(index / 2.0) - 1);
    while (index > 0 && heap[index] > heap[parent]) { // index mean child here
      swap(index, parent);
      index = parent;
    }
  }

  private void decreaseKey(int index, int value){
    if(index < 0 || index >= heapSize || heap[index] <= value){
      System.out.println("wrong operation");
      return ;
    }
    heap[index] = value;
    heapify(index);
  }
  public static void main(String[] args) {
    int[] arr = {5,3,7,8,6,1};
    MaxHeap heap = new MaxHeap(arr);
    heap.buildTree();  
    heap.printTree();
    // int popedEl = heap.pop();
    // System.out.println(popedEl);
    heap.increaseKey(1, 15);
    heap.printTree();
    heap.decreaseKey(3, 2);
    heap.printTree();
    heap.offer(5);
  }
}
