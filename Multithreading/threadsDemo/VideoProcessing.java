package threadsDemo;
class VideoProssessingTask{
  private final String videoFile;
  public VideoProssessingTask(String videoFile) {
    this.videoFile = videoFile;
  }
  public void process() {
    System.out.println("Processing video file: " + videoFile+ " on : " + Thread.currentThread().getName());
    try {
      Thread.sleep(2000); // Simulate time-consuming processing
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Finished processing video file: " + videoFile);
  }  
}
public class VideoProcessing {
  public static void main(String[] args) {
    String[] videoFiles = {"video1.mp4", "video2.mp4", "video3.mp4", "video4.mp4", "video5.mp4"};
    long startTime = System.currentTimeMillis();
    for (String videoFile : videoFiles) {
      VideoProssessingTask task = new VideoProssessingTask(videoFile);
      task.process();
      // Thread thread = new Thread(new VideoEncoder(videoFile));
      // thread.start();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Total time taken: " + (endTime - startTime) + " ms");
  }
}
