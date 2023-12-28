
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
        int girlName, boyName;
        girlName = boyName = 0;
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord csvRecord : parser){
            if(csvRecord.get(1).equals("F"))
                girlName++;
            else
                boyName++;
        }
        System.out.println("Total names in file = " + (girlName + boyName));
        System.out.println("Girl names: " + girlName);
        System.out.println("Boy names: " + boyName);
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
                currentRank = currentRank - girlRank;
                if( currentRank == rank && (csvRecord.get(1).equals(gender)) ){
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
    
    public int yearOfHighestRank(String name, String gender){  
        System.out.println("Checking year of highest rank for: " + name + " with gender: " + gender);
        int highestRank = -1;
        String fileName = null;
        int yearOfHighestRank = -1;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            int girl = 0;
            FileResource fr = new FileResource(file);
            CSVParser parser = fr.getCSVParser(false);
            for(CSVRecord csvRecord : parser){
                String currentName = csvRecord.get(0).toUpperCase();
                int currentRank = (int)csvRecord.getRecordNumber();     
                String currentGender = csvRecord.get(1);
                if(currentGender.equals("F"))
                    girl++;
                    
                if( currentName.equals(name.toUpperCase()) && currentGender.equals(gender)){
                    if(csvRecord.get(1).equals("M")){
                        currentRank = currentRank-girl;
                        if(highestRank == -1 || currentRank < highestRank){
                            highestRank = currentRank;
                            fileName = file.getName();
                        }
                    }else{
                        if(highestRank == -1 || currentRank < highestRank){
                            highestRank = currentRank;
                            fileName = file.getName();
                        }
                    }
                }
            }
        }
        
        //get the yearOfHighestRank integer from the name of the file
        if(fileName != null)
            yearOfHighestRank = Integer.parseInt(fileName.replaceAll("[\\D]", ""));
            
        return yearOfHighestRank;
    }
    
    public double getAverageRank(String name, String gender){
        System.out.println("Calculating avg rank for: " + name + " with gender: " + gender);
        double avgRank = -1;
        int fileNum = 0, totalRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            int girl = 0;
            fileNum++;
            FileResource fr = new FileResource(file);
            CSVParser parser = fr.getCSVParser(false);
            for(CSVRecord csvRecord : parser){
                String cName = csvRecord.get(0).toUpperCase();
                String cGend = csvRecord.get(1);
                int cRank = (int)csvRecord.getRecordNumber();     
                if(cGend.equals("F")){
                    girl++;
                }
                
                if( cName.equals(name.toUpperCase()) && cGend.equals(gender)){
                    if(csvRecord.get(1).equals("M")){
                        cRank = cRank-girl;
                        totalRank += cRank;
                    }else{
                        totalRank += cRank;
                    }
                }
            }
        }
        if(totalRank > 0)
            avgRank = (double)totalRank/fileNum;        
        return avgRank;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int girl = 0;
        int boy = 0;
        String fileName = "yob" + year + ".csv";
        String filePath = "us_babynames/us_babynames_by_year/"+fileName;
        System.out.println("Checking for " + name + " from " + filePath);
        
        FileResource fr = new FileResource(filePath);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord csvRecord : parser){
            String cName = csvRecord.get(0);
            String cGender = csvRecord.get(1);
            int cNum = Integer.parseInt(csvRecord.get(2));
            if(cName.equals(name) && cGender.equals(gender)){
                if(cGender.equals("F"))
                    return girl;
                else
                    return boy;
            }else{
                if(cGender.equals("F"))
                    girl += cNum;
                else
                    boy += cNum;
            }
        }
        return -1;
    }
    
    
    public void testGetAverageRank(){
        double avgRank = getAverageRank("Jacob", "M");
        System.out.println("Avg rank: " + avgRank);
    }
    
    public void testYearOfHighestRank(){
        int year = yearOfHighestRank("Genevieve", "F");
        System.out.println("Response: " + year);
    }
    
    public void testGetName(){
        String name = getName(2012, 232323, "M");
        System.out.println("Name: " + name);
    }
    
    public void testGetRank(){
        int rank = getRank(1960, "Emily", "F");
        System.out.println("Rank: " + rank);
    }
    
    public void testTotalBirth(){
        FileResource fr = new FileResource();
        totalBirth(fr);
    }
}
