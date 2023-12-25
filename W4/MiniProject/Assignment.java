
/**
 * Write a description of Assignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Assignment {
    public void totalBirth(FileResource fr){
        int totalBirths ,girls , boys, num;
        totalBirths = girls = boys = 0;
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord csvRecord : parser){
            num = Integer.parseInt(csvRecord.get(2));
            totalBirths += num;
            if(csvRecord.get(1).equals("F"))
                girls += num;
            else if(csvRecord.get(1).equals("M"))
                boys += num;
        }
        System.out.println("Total births: " + totalBirths);
        System.out.println("Girl names: " + girls);
        System.out.println("Boy names: " + boys);
    }
    
    public void test(){
        FileResource fr = new FileResource();
        totalBirth(fr);
    }
}
