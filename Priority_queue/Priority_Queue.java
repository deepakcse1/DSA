import java.util.ArrayList;

public class Priority_Queue<T> {
  private ArrayList<ElementNode<T>> heap;
  
  public Priority_Queue(){
    heap = new ArrayList<>();
  }

  public int size(){
     return heap.size();
  }

  public boolean isEmpty(){
     return heap.size() == 0;
  }

  public void insertMin(T value, int priority) {
    ElementNode<T> element = new ElementNode<>(value, priority);
    heap.add(element);
    int childIndex = heap.size() - 1;
    int parentIndex = (childIndex - 1) / 2;
    while (childIndex > 0) {
      if (heap.get(parentIndex).priority > heap.get(childIndex).priority) {
        ElementNode<T> temp = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(childIndex));
        heap.set(childIndex, temp);
        childIndex = parentIndex;
        parentIndex = (childIndex - 1) / 2;
      } else {
        return;
      }
    }
  }

  public T removeMin() throws PriorityQueueException {
    if (heap.size() == 0) {
      throw new PriorityQueueException();
    }
    int parentIndex = 0;
    ElementNode<T> parent = heap.get(parentIndex);
    heap.set(parentIndex, heap.get(heap.size() - 1));
    heap.remove(heap.size() - 1);
    int leftChildIndex = (parentIndex * 2) + 1;
    int rightChildIndex = (parentIndex * 2) + 2;
    while (leftChildIndex < heap.size()) {
      int minIndex = parentIndex;
      if (heap.get(minIndex).priority > heap.get(leftChildIndex).priority) {
        minIndex = leftChildIndex;
      }
      if (rightChildIndex < heap.size() && (heap.get(minIndex).priority > heap.get(rightChildIndex).priority)) {
        minIndex = rightChildIndex;
      }
      if (minIndex == parentIndex) {
        break;
      }
      ElementNode<T> temp = heap.get(minIndex);
      heap.set(minIndex, heap.get(parentIndex));
      heap.set(parentIndex, temp);
      parentIndex = minIndex;
      leftChildIndex = (parentIndex * 2) + 1;
      rightChildIndex = (parentIndex * 2) + 2;
    }
    return parent.value;
  }
  
  public T getMin() throws PriorityQueueException{
     if(heap.size() == 0) throw new PriorityQueueException();
     return heap.get(0).value;
  }

  public void insertMax(T value, int priority) {
    ElementNode<T> element = new ElementNode<>(value, priority);
    heap.add(element);
    int childIndex = heap.size() - 1;
    int parentIndex = (childIndex - 1) / 2;
    while (childIndex > 0) {
      if (heap.get(parentIndex).priority < heap.get(childIndex).priority) {
        ElementNode<T> temp = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(childIndex));
        heap.set(childIndex, temp);
        childIndex = parentIndex;
        parentIndex = (childIndex - 1) / 2;
      } else {
        return;
      }
    }
  }

  public T removeMax() throws PriorityQueueException{
    if(heap.size() == 0) throw new PriorityQueueException();
		int parentIndex = 0;
		T deletedElement = heap.get(parentIndex).value;
		heap.set(parentIndex, heap.get(heap.size()-1));
		heap.remove(heap.size() - 1);
		int leftIndex= (parentIndex*2)+1;
		int rightIndex = (parentIndex*2)+2;
		while(leftIndex < heap.size()){
			int maxIndex = parentIndex;
			if(heap.get(leftIndex).priority > heap.get(parentIndex).priority){
				maxIndex = leftIndex;
			}
			if(rightIndex < heap.size() && (heap.get(rightIndex).priority > heap.get(maxIndex).priority)){
				maxIndex = rightIndex;
			}
			if(parentIndex == maxIndex){
				break;
			}
			ElementNode<T> temp = heap.get(maxIndex);
			heap.set(maxIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			parentIndex = maxIndex;
			leftIndex= (parentIndex*2)+1;
		  rightIndex = (parentIndex*2)+2;
		}
		return deletedElement;
	}

  public T getMax()throws PriorityQueueException {
		if(heap.size() == 0) throw new PriorityQueueException();
    return heap.get(0).value;
	}

}
