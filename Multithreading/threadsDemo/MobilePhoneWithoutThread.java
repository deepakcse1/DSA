package threadsDemo;

class SocialMediaWithoutThread {
   public void use(){
     System.out.println("Socia Media started");
     for(int i = 0; i < 5;i++){
        System.out.println("Using Social Media...");
     }
     System.out.println("Social Media ended");
   }
}

class MusicPlayerWithoutThread{
   public void play(){
     System.out.println("Music Player started");
     for(int i = 0; i < 5;i++){
        System.out.println("Playing Music...");
     }
     System.out.println("Music Player ended");
   }
}

class FileDownloaderWithoutThread{
   public void download(){
     System.out.println("File Downloader started");
     for(int i = 0; i < 5;i++){
        System.out.println("File Downloading...");
     }
     System.out.println("File Loader ended");
   }
}
public class MobilePhoneWithoutThread {
  public static void main(String[] args) {
    double startTime = System.nanoTime();
    SocialMediaWithoutThread socialMedia = new SocialMediaWithoutThread();
    MusicPlayerWithoutThread musicPlayer = new MusicPlayerWithoutThread();
    FileDownloaderWithoutThread fileDownloader = new FileDownloaderWithoutThread();
    socialMedia.use();
    musicPlayer.play();
    fileDownloader.download();
    double endTime = System.nanoTime();
    System.out.println("Total Time without Thread : "+ (endTime - startTime));
  }
}
