
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.URLResource;

public class Part4 {
    public static void findYouTubeLinks() {
        URLResource url = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        // Using words() get this url
        // href="http://www.youtube.com/watch?v=oPRfDC8kTqM">
        for(String word : url.words()){         
            int youtubeIndex = word.toLowerCase().indexOf("youtube.com");
             if(youtubeIndex != -1){
                int startUrl = word.lastIndexOf("\"", youtubeIndex);
                int endUrl = word.indexOf("\"", startUrl + 1);
                String youtubeUrl = word.substring(startUrl + 1, endUrl);
                System.out.println(youtubeUrl);
            } 
        }
        
    }

    public static void main() {
        findYouTubeLinks();
    }
}
