package threadsDemo;

class AutoSave extends Thread{
  public void run(){
    System.out.println(Thread.currentThread().getName() +" : "+Thread.currentThread().getPriority());
    Thread.currentThread().setPriority(MAX_PRIORITY);
    for(int i = 0; i < 5; i++){
      try {
        Thread.sleep(3000);
        System.out.println("...Code Saved");
      } catch (Exception e) {

      }
    }
  }
}
public class CodeEditor {
  public static void main(String[] args) throws InterruptedException{
    //Although, this is at begining, OS will decide, when to execute, as OS already running MAIN THREAD
    //Newly created thread will added in between of MAIN THREAD and execute in parallel
    AutoSave as = new AutoSave(); 
    as.start();
    for(int i = 0; i < 10; i++){
      Thread.sleep(2000);
      System.out.println("Typing Code...");
    }
  }
}
