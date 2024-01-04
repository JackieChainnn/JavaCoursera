
/**
 * Write a description of Assigment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;

public class Assigment {
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel p : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(p.getX(), p.getY());
            int avg = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            p.setRed(avg);
            p.setBlue(avg);
            p.setGreen(avg);
        }
        return outImage;
    }
    
    public ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel p : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(p.getX(), p.getY());
            p.setRed(255 - inPixel.getRed());
            p.setBlue(255 - inPixel.getBlue());
            p.setGreen(255 - inPixel.getGreen());
        }
        return outImage;
    }
    
    public void testMakeGray(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            String fName = "inverted-" + inImage.getFileName();
            gray.setFileName(fName);
            gray.save();
            gray.draw();
        }
    }
    
    public void testMakeInversion(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource inverted = makeInversion(inImage);
            String fName = "gray-" + inImage.getFileName();
            inverted.setFileName(fName);
            inverted.save();
            inverted.draw();
        }
    }
}
