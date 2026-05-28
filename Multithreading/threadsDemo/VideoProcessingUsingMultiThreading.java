package threadsDemo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

// class VideoProssessingTaskWithMultiThreading implements Runnable{
class VideoProssessingTaskWithMultiThreading extends RecursiveAction{
  private final String videoFile;
  public VideoProssessingTaskWithMultiThreading(String videoFile) {
    this.videoFile = videoFile;
  }

  @Override
  public void compute() {
  // public void run() {
    System.out.println("Processing video file: " + videoFile+ " on : " + Thread.currentThread().getName());
    try {
      Thread.sleep(2000); // Simulate time-consuming processing
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Finished processing video file: " + videoFile);
  }  
}
public class VideoProcessingUsingMultiThreading {
  public static void main(String[] args) throws InterruptedException {
    String[] videoFiles = {"video1.mp4", "video2.mp4", "video3.mp4", "video4.mp4", "video5.mp4"};
    long startTime = System.currentTimeMillis();
    // Thread[] threads = new Thread[videoFiles.length];
    // for (int i = 0; i < videoFiles.length; i++) {
    //   VideoProssessingTaskWithMultiThreading task = new VideoProssessingTaskWithMultiThreading(videoFiles[i]);
    //   threads[i] = new Thread(task);
    //   threads[i].start();
    // }
    // for(Thread thread : threads){
    //   try {
    //     thread.join();
    //   } catch (InterruptedException e) {
    //     e.printStackTrace();
    //   }
    // }

    ForkJoinPool pool = new ForkJoinPool();
    for(String videoFile : videoFiles){
      pool.execute(new VideoProssessingTaskWithMultiThreading(videoFile));
    }
    pool.shutdown();
    pool.awaitTermination(10, TimeUnit.SECONDS);
    long endTime = System.currentTimeMillis();
    System.out.println("Total time taken: " + (endTime - startTime) + " ms");
  }
}
