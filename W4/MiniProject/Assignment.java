
/**
 * Write a description of Assignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

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
    
    public int getRank(int year, String name, String gender){
        String fileName = "yob" + year + ".csv";
        String filePath = "us_babynames/us_babynames_by_year/"+fileName;
        int rank = -1;
        int girls = 0;
        
        System.out.println("Rank seeking for " + name + " from " + filePath);
        FileResource fr = new FileResource(filePath);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord csvRecord : parser){
            if(csvRecord.get(1).equals("F"))
                girls++;
            String currentName = csvRecord.get(0).toUpperCase();
            String currentGender = csvRecord.get(1).toUpperCase();
            if( currentName.equals(name.toUpperCase()) && currentGender.equals(gender.toUpperCase())){
                rank = (int)csvRecord.getRecordNumber();
                if(gender.equals("M"))
                    return rank-girls;
                return rank;
            }
        }
        return rank;
    }
    
    public void testGetRank(){
        int rank = getRank(2012, "Mason", "M");
        System.out.println("Rank: " + rank);
    }
    
    public void test(){
        FileResource fr = new FileResource();
        totalBirth(fr);
    }
}
