
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class GrayScaleConverter {
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
    
    public void testMakeGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
}
