package Queue;

public class NumberOfStudentsUnableToEatLunch {
  public int countStudents(int[] students, int[] sandwiches) {
    int one = 0;
    int zero = 0;
    for (int i : students) {
      if (i == 0) zero++;
      else one++;
    }
    for (int i : sandwiches) {
      if (i == 0 && zero == 0) break;
      else if (i == 1 && one == 0) break;
      if (i == 0) zero--;
      else one--;
    }
    return one + zero;
  }
    // public int countStudents(int[] students, int[] sandwiches) {
    //     int n = sandwiches.length;
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     for(int i = n-1; i >= 0; i--){
    //         stack.push(sandwiches[i]);
    //     }
    //     Deque<Integer> queue = new ArrayDeque<>();
    //     for(int i : students){
    //         queue.offer(i);
    //     }
    //     int i = 0;
    //     while(i < stack.size()){
    //         if(queue.peek() == stack.peek()){
    //             queue.poll();
    //             stack.pop();
    //             i = 0;
    //         }else{
    //             queue.offer(queue.poll());
    //             i++;
    //         }
    //     }
    //     return queue.size();
    // }
}
