
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
    
    public String getName(int year, int rank, String gender){
        int girlRank = 0, currentRank = 0;
        String name = "NO NAME";
        String fileName = "yob" + year + ".csv";
        String filePath = "us_babynames/us_babynames_by_year/"+fileName;
        
        System.out.println("Name seeking by rank on " + rank + "\'th from " + filePath);
        FileResource fr = new FileResource(filePath);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord csvRecord : parser){
            currentRank = (int)csvRecord.getRecordNumber();
            if(csvRecord.get(1).equals("M"))
            {
                if( (currentRank == (rank + girlRank)) && (csvRecord.get(1).equals(gender)) ){
                    name = csvRecord.get(0);
                    return name;
                }
            }else{
                girlRank++;
                if( currentRank == rank && csvRecord.get(1).equals(gender) ){
                    name = csvRecord.get(0);
                    return name;
                }
            }            
        }
        return name;
    }
    
    public void whatIsNameInYear(String name, int year,  int newYear, String gender){
        int rankInYear = getRank(year, name, gender);
        String nameInNewYear = getName(newYear, rankInYear, gender);
        String pronoun = "she";
        if(rankInYear!= -1 && nameInNewYear != "NO NAME"){
            if(gender.equals("M"))
                pronoun = "he";
            System.out.println(name + " born in "+year+" would be "+nameInNewYear+" if "+pronoun+" was born in "+newYear+".");   
        }else{
            System.out.println("unavailable");
        }
    }
    
    
    public void testGetName(){
        String name = getName(2012, 232323, "M");
        System.out.println("Name: " + name);
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
