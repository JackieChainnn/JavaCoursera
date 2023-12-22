
/**
 * Write a description of CSVParserWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class CSVParserWeatherData {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSoFar = null;
        for(CSVRecord csvRecord : parser){
            Double currentTemp = Double.parseDouble(csvRecord.get("TemperatureF"));
            if(coldestSoFar == null || currentTemp < Double.parseDouble(coldestSoFar.get("TemperatureF"))){
                coldestSoFar = csvRecord;
            }
        }
        return coldestSoFar;
    }
    
    public String fileWithColdestTemperature(){
        String result = null;
        Double coldestTemp = null;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            CSVParser parser = fr.getCSVParser();
            CSVRecord current = coldestHourInFile(parser);
            Double currentTemp = Double.parseDouble(current.get("TemperatureF"));
            if(coldestTemp == null || currentTemp < coldestTemp){
                coldestTemp = currentTemp;
                result = file.getPath();
            }
        }
        return result;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumidityRecord = null;
            for(CSVRecord csvRecord : parser){
                try{
                    Integer currentH = Integer.parseInt(csvRecord.get("Humidity"));
                    if(lowestHumidityRecord == null || currentH < Integer.parseInt(lowestHumidityRecord.get("Humidity"))){
                        lowestHumidityRecord = csvRecord;
                    }
                }catch(NumberFormatException e){
                    System.out.println("Invalid input: not a valid number in " + csvRecord.getRecordNumber());
                }
            }
        return lowestHumidityRecord;
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHumidityRecord = null;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            CSVParser parser = fr.getCSVParser();
            for(CSVRecord csvRecord : parser){
                try{
                    Integer currentH = Integer.parseInt(csvRecord.get("Humidity"));
                    if(lowestHumidityRecord == null || currentH < Integer.parseInt(lowestHumidityRecord.get("Humidity"))){
                        lowestHumidityRecord = csvRecord;
                    }
                }catch(NumberFormatException e){
                    System.out.println("Invalid input: not a valid number in " + file.getName() + " at " + csvRecord.getRecordNumber());
                }
            }
        }
        return lowestHumidityRecord;
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv= lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public void testFileWithColdestTemperature(){
        String coldestInFile = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coldestInFile);
        FileResource fr = new FileResource(coldestInFile);
        CSVRecord current = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temp on that day was " + current.get("TemperatureF"));
        System.out.println("All the Temps on the coldest day were: ");
        for(CSVRecord csvRecord : fr.getCSVParser()){
            System.out.println(csvRecord.get("DateUTC") + ": " + csvRecord.get("TemperatureF"));
        }
    }
    
    public void testColdestHourInFile(){
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
            System.out.println("From: "+ file.getName() +"| coldest temp: " + coldest.get("TemperatureF") + " at: " + coldest.get("DateUTC"));
        }
    }

}
