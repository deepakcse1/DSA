package threadsDemo;

class SocialMedia implements Runnable {
   public void run(){
     System.out.println("Socia Media started");
     for(int i = 0; i < 5;i++){
        System.out.println("Using Social Media...");
     }
     System.out.println("Social Media ended");
   }
}

class MusicPlayer implements Runnable{
   public void run(){
     System.out.println("Music Player started");
     for(int i = 0; i < 5;i++){
        System.out.println("Playing Music...");
     }
     System.out.println("Music Player ended");
   }
}

class FileDownloader implements Runnable{
   public void run(){
     System.out.println("File Downloader started");
     for(int i = 0; i < 5;i++){
        System.out.println("File Downloading...");
     }
     System.out.println("File Loader ended");
   }
}

public class MobilePhone {
  public static void main(String[] args) {
    double startTime = System.nanoTime();
    SocialMedia socialMedia = new SocialMedia();
    MusicPlayer musicPlayer = new MusicPlayer();
    FileDownloader fileDownloader = new FileDownloader();

    Thread socialThread = new Thread(socialMedia);
    Thread musicThread = new Thread(musicPlayer);
    Thread fileDownloadThread = new Thread(fileDownloader);

    socialThread.start();
    musicThread.start();
    fileDownloadThread.start();
    double endTime = System.nanoTime();
    System.out.println("Total Time with Thread : "+ (endTime - startTime));
  }
}
